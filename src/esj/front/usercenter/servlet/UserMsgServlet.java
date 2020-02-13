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
import esj.front.usercenter.service.PUsersBeanService;
import esj.front.usercenter.service.impl.PTagsBeanServiceimpl;
import esj.front.usercenter.service.impl.PUsersBeanServiceimpl;
import esj.front.util.LoadPhoto;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UsersBean;
import esj.publicdoc.service.ProductsBeanService;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.util.DateHelper;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-29 下午7:57:59
 * @最后修改时间 2016-6-29 下午7:57:59
 * @描述：
 * @version 1.0
 */
public class UserMsgServlet extends HttpServlet {

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
		//判断是否登陆
//		if(request.getSession().getAttribute("user") == null){
//			return;
//		}
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
        	
			UsersBean usersBean = new UsersBean();
			String bdate = "";
			String endate = "";
			String path = "";
        	//把请求的参数返回list集合
        	try {
        		List<FileItem> fileItems = upload.parseRequest(request);				
				for(FileItem item : fileItems){
					//普通文本
					if(item.isFormField()){
						
						String tagName = item.getFieldName();							
						String tagValue = item.getString();
						tagValue = LoadPhoto.chineseEncode(tagValue);						
						
						if(tagName.equals("userName")){
							usersBean.setUserName(tagValue.trim());
						}else if(tagName.equals("sex")){
							usersBean.setSex(tagValue.trim());
						}else if(tagName.equals("eDatey")){
							bdate +=tagValue.trim();
						}else if(tagName.equals("eDatem") ||tagName.equals("eDated")){
							bdate +="-"+tagValue.trim();
						}else if(tagName.equals("school")){
							usersBean.setSchool(tagValue.trim());
						}else if(tagName.equals("depart")){
							usersBean.setDepartment(tagValue.trim());
						}else if(tagName.equals("major")){
							usersBean.setMajor(tagValue.trim());
						}else if(tagName.equals("endy")){
							endate +=tagValue;
						}else if(tagName.equals("endm")||tagName.equals("endd")){
							endate += "-"+tagValue;
						}else if(tagName.equals("iconAddr")){
							path = tagValue;//原头像的路径
						}
						
					}else{ //file  上传表单
						String name = "";
						if(!item.getName().equals("")){
							if(path.trim().equals("") || path==null){
								//获取文件上传的路径
								path = this.getServletContext().getRealPath("/images/pro_Imgs");
								//截取文件名，第一次上传使用新文件名
								name = LoadPhoto.getPhotoName(item.getName());
							}else{
								//使用原文件名
								name = path.substring(path.lastIndexOf('/')+1, path.length());
							}
							//创建File文件
							File file = new File(path, name);
							try {								
								//上传
								item.write(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
			}        
        	usersBean.setUserId(((UsersBean)request.getSession().getAttribute("user")).getUserId());
        	PUsersBeanService pBeanService = new PUsersBeanServiceimpl();
        	int count = pBeanService.updateUserMsg(usersBean);
			//保存信息
			try {
				if(count>0){
					response.sendRedirect("person_msg.jsp");
				}else{
					response.sendRedirect("person_msg.jsp");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
	}

}
