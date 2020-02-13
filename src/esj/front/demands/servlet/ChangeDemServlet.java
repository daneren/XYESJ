package esj.front.demands.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import esj.front.demands.service.PUserDemandService;
import esj.front.demands.service.impl.PUserDemandServiceimpl;
import esj.front.usercenter.service.PTagsBeanService;
import esj.front.usercenter.service.impl.PTagsBeanServiceimpl;
import esj.front.util.LoadPhoto;
import esj.publicdoc.bean.UserdemandsBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-18 上午8:44:49
 * @最后修改时间 2016-7-18 上午8:44:49
 * @描述：
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ChangeDemServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.工厂对象
		FileItemFactory factory = new DiskFileItemFactory();
		//2.文件上传的核心工具类
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(10*1024*1024);    // 单个文件大小限制
	    upload.setSizeMax(50*1024*1024);        // 总文件大小限制
	  //request.setCharacterEncoding("UTF-8");
	    upload.setHeaderEncoding("UTF-8");      // 对中文文件编码处理
        
	    //判断是否是文件上传的表单，如果不是就不做处理
        if(upload.isMultipartContent(request)){
        	
			UserdemandsBean userdemandsBean = new UserdemandsBean();
			String date = "";
			String paddr = "";
			String tags = "";
			String typeId = "";
			String imgindex = "";
			String imgaddr = "";
			List<String> l2 = null;
        	//把请求的参数返回list集合
        	try {
        		@SuppressWarnings("unchecked")
				List<FileItem> fileItems = upload.parseRequest(request);
        		for(FileItem item : fileItems){
					//普通文本
					if(item.isFormField()){
						
						String tagName = item.getFieldName();							
						String tagValue = item.getString();
						tagValue = LoadPhoto.chineseEncode(tagValue);
						if(tagName.equals("details")){
							userdemandsBean.setDetails(tagValue);
						}else if(tagName.equals("eDatey")){
							date +=tagValue;
						}else if(tagName.equals("eDatem")){
							date += "-"+tagValue;
						}else if(tagName.equals("eDated")){
							date += "-"+tagValue;
							userdemandsBean.setEdate(date);
						}else if(tagName.equals("typetag")){
							if(!tagValue.trim().equals("") && tagValue != null){
								
								if(tagValue.split("/").length>1){
									typeId= tagValue.split("/")[0];
									tags = tagValue.split("/")[1];	
									if(tagValue.split("/").length>2){
										imgindex = tagValue.split("/")[2];
										if(imgindex.lastIndexOf(",")>0){
											imgindex =imgindex.substring(0, imgindex.lastIndexOf(","));
										}
									}
									
								}
								userdemandsBean.setTagName(tags);
								PTagsBeanService tagsBeanService = new PTagsBeanServiceimpl();								
								tagsBeanService.updateTags(Integer.parseInt(typeId), tags, "已启用", 1);//更新标签信息

							}
						}else if(tagName.equals("imgaddr") && tagValue != null){
							imgaddr = tagValue;
							l2 = new ArrayList<String>();
							if(imgaddr.lastIndexOf(",")>0){
								String[] sl2 = imgaddr.split(",");
								for(int z=0;z<sl2.length;z++){
									l2.add(sl2[z]);
								}
							}else{
								l2.add(imgaddr);
							}
							if(!"".equals(imgindex)){
								String[] s = imgindex.split(",");
								List<String> l1 = new ArrayList<String>();
								for(String ss:s){
										if(ss != null && !"".equals(ss.trim())){
											ss = ss.substring(3);
											int index = Integer.parseInt(ss);
											paddr += l2.get(index)+",";
											l1.add(l2.get(index));
											
										}else{
											paddr += imgaddr+",";
										}
								}
								l2.removeAll(l1);
							}
							
						}
					}else{ //file  上传表单
						if(!item.getName().equals("")){
							File file = null;
							//获取文件上传的路径
							String path = this.getServletContext().getRealPath("/images/pro_Imgs");
							String name = "";
							if(l2!= null && l2.size()>0){
								name = l2.get(0).substring(l2.get(0).lastIndexOf("/")+1);
								l2.remove(0);
							}else{
								name = LoadPhoto.getPhotoName(item.getName());
								
							}
							paddr +=request.getContextPath()+"/images/pro_Imgs"+"/"+name+",";
							
							file = new File(path, name);	
							try {								
								//上传
								item.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}	
			}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(paddr.indexOf(",")>0){
        		paddr = paddr.substring(0, paddr.lastIndexOf(","));
        	} 
        	userdemandsBean.setPhotoAddr(paddr);
        	userdemandsBean.setDemandId(request.getParameter("id"));
        	PUserDemandService pDemandService = new PUserDemandServiceimpl();
			int count =  pDemandService.updateDemand(userdemandsBean);//保存商品信息
			try {
				if(count>0){
					response.sendRedirect(request.getContextPath()+"/person_center/XUserLookDemands");
					//request.getRequestDispatcher(request.getContextPath()+"/person_center/SoldProServlet?op=1");
				}else{
					response.getWriter().write("上传失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
