package esj.front.usercenter.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import esj.front.usercenter.service.PTagsBeanService;
import esj.front.usercenter.service.impl.PTagsBeanServiceimpl;
import esj.front.util.LoadPhoto;
import esj.front.util.LogsFileUtil;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ProductsBeanService;
import esj.publicdoc.service.UserdemandsBeanService;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
import esj.util.DateHelper;
import esj.util.GetIpAddr;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-29 下午6:23:28
 * @最后修改时间 2016-6-29 下午6:23:28
 * @描述：
 * @version 1.0
 */
public class FabuUNeedServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//判断是否登陆
//		if(request.getSession().getAttribute("user") == null){
//			return;
//		}else{
//			
//		}
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
			UserdemandsBean userdemandsBean = new UserdemandsBean();
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
							userdemandsBean.setTitle(tagValue);
						}else if(tagName.equals("details")){
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
								typeId = tagValue.split("/")[0];
								if(tagValue.split("/").length>1){
									tags = tagValue.split("/")[1];	
								}
								userdemandsBean.setTagName(tags);
								userdemandsBean.setTypeId(Integer.parseInt(typeId));
								//System.out.println(tagValue);
								PTagsBeanService tagsBeanService = new PTagsBeanServiceimpl();								
								tagsBeanService.updateTags(Integer.parseInt(typeId), tags, "启用", 1);//更新标签信息
							}
						}
						
				//		System.out.println(tagName+":"+tagValue);
						
					}else{ //file  上传表单
						if(!item.getName().equals("")){
							//System.out.println(item.getName());
							//获取文件上传的路径
							String path = this.getServletContext().getRealPath("/images/pro_Imgs");
							//截取文件名
							String name = LoadPhoto.getPhotoName(item.getName());
							//System.out.println(name);
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
        	userdemandsBean.setPhotoAddr(paddr);
        	userdemandsBean.setBdate(DateHelper.getDateTimeFormatDuan());
        	userdemandsBean.setState("待解决");
			
        	userdemandsBean.setUserId(((UsersBean)request.getSession().getAttribute("user")).getUserId());
	
        	UserdemandsBeanService beanService = new UserdemandsBeanServiceImpl();
        	int count =  beanService.saveUserdemands(userdemandsBean);//保存需求信息
        	String userlogAddr = (String) request.getSession().getAttribute("userlogAddr");//获得日志文件路径
			//向日志文件中插入一条记录
			LogsFileUtil.saveUserLogs(userlogAddr, "["+GetIpAddr.getIpAddr(request)+" "+DateHelper.getDateTimeFormat()+"] 发布需求---"+userdemandsBean.getTitle());
			
			try {
				if(count>0){
					response.sendRedirect("XUserLookDemands");
				}else{
					response.getWriter().write("上传失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

}
