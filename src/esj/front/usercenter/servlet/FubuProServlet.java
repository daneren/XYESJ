package esj.front.usercenter.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import esj.front.usercenter.service.PProtypesBeanService;
import esj.front.usercenter.service.PTagsBeanService;
import esj.front.usercenter.service.impl.PProtypesBeanServiceimpl;
import esj.front.usercenter.service.impl.PTagsBeanServiceimpl;
import esj.front.util.LoadPhoto;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ProductsBeanService;
import esj.publicdoc.service.ProtypesBeanService;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.ProtypesBeanServiceimpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-6 上午11:13:25
 * @最后修改时间 2016-7-6 上午11:13:25
 * @描述：
 * @version 1.0
 */
public class FubuProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
        	
			ProductsBean productsBean = new ProductsBean();
			String date = "";
			String paddr = "";
			String tags = "";
			String typeId = "";
        	//把请求的参数返回list集合
        	try {
        		List<FileItem> fileItems = upload.parseRequest(request);
        		//<input type="text" name="userName">  封装成  FileItem 类
        		
				
				for(FileItem item : fileItems){
					//普通文本
					if(item.isFormField()){
						
						String tagName = item.getFieldName();							
						String tagValue = item.getString();
						tagValue = LoadPhoto.chineseEncode(tagValue);
						
						if(tagName.equals("protitle")){
							productsBean.setTitle(tagValue);
						}else if(tagName.equals("details")){
							productsBean.setDetails(tagValue);
						}else if(tagName.equals("dprice")){
							if(!tagValue.trim().equals("") && tagValue!=null){
								productsBean.setDprice(Float.parseFloat(tagValue.trim()));
							}else{
								productsBean.setDprice(productsBean.getCprice());
							}
							
						}else if(tagName.equals("cprice")){
							productsBean.setCprice(Float.parseFloat(tagValue.trim()));
						}else if(tagName.equals("oprice")){
							productsBean.setOprice(Float.parseFloat(tagValue.trim()));
						}else if(tagName.equals("eDatey")){
							date +=tagValue;
						}else if(tagName.equals("eDatem")){
							date += "-"+tagValue;
						}else if(tagName.equals("eDated")){
							date += "-"+tagValue;
							productsBean.setEdate(date);
						}else if(tagName.equals("typetag")){
							if(!tagValue.trim().equals("") && tagValue != null){
								typeId = tagValue.split("/")[0];
								if(tagValue.split("/").length>1){
									tags = tagValue.split("/")[1];	
								}
								productsBean.setTagName(tags);
								productsBean.setTypeId(Integer.parseInt(typeId));
								PTagsBeanService tagsBeanService = new PTagsBeanServiceimpl();								
								tagsBeanService.updateTags(Integer.parseInt(typeId), tags, "已启用", 1);//更新标签信息

							}
						}
					}else{ //file  上传表单
						if(!item.getName().equals("")){
							//System.out.println(item.getName());
							//获取文件上传的路径
							String path = this.getServletContext().getRealPath("/images/pro_Imgs");
							//截取文件名
							String name = LoadPhoto.getPhotoName(item.getName());
							//System.out.println(item.getName());
							//创建File文件
							paddr +=request.getContextPath()+"/images/pro_Imgs"+"/"+name+",";
							File file = new File(path, name);
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
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	if(paddr.indexOf(",")>0){
        		paddr = paddr.substring(0, paddr.lastIndexOf(","));
        	} 
			productsBean.setPhotoAddr(paddr);
			productsBean.setBdate(DateHelper.getDateTimeFormatDuan());
			productsBean.setState("出售中");
			
			productsBean.setUserId(((UsersBean)request.getSession().getAttribute("user")).getUserId());
			productsBean.setNcount(0);
			productsBean.setPcount(0);
			productsBean.setVcount(0);

		
			
			ProductsBeanService pservice = new ProductsBeanServiceImpl();
			int count =  pservice.saveProducts(productsBean);//保存商品信息
			String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
			//向日志文件中插入一条记录
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 发布商品---"+productsBean.getTitle());
			
			try {
				if(count>0){
					response.sendRedirect("SoldProServlet?op=1");
				}else{
					response.getWriter().write("上传失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
	}

}
