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
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-29 ����7:57:59
 * @����޸�ʱ�� 2016-6-29 ����7:57:59
 * @������
 * @version 1.0
 */
public class UserMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ƿ��½
//		if(request.getSession().getAttribute("user") == null){
//			return;
//		}else{
//			
//		}
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ƿ��½
//		if(request.getSession().getAttribute("user") == null){
//			return;
//		}
		//1.��������
		FileItemFactory factory = new DiskFileItemFactory();
		
		//2.�ļ��ϴ��ĺ��Ĺ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(10*1024*1024);    // �����ļ���С����
	    upload.setSizeMax(50*1024*1024);        // ���ļ���С����
	    //request.setCharacterEncoding("UTF-8");
	    upload.setHeaderEncoding("UTF-8");      // �������ļ����봦��
       
        //�ж��Ƿ����ļ��ϴ��ı���������ǾͲ�������
        if(upload.isMultipartContent(request)){
        	
			UsersBean usersBean = new UsersBean();
			String bdate = "";
			String endate = "";
			String path = "";
        	//������Ĳ�������list����
        	try {
        		List<FileItem> fileItems = upload.parseRequest(request);				
				for(FileItem item : fileItems){
					//��ͨ�ı�
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
							path = tagValue;//ԭͷ���·��
						}
						
					}else{ //file  �ϴ���
						String name = "";
						if(!item.getName().equals("")){
							if(path.trim().equals("") || path==null){
								//��ȡ�ļ��ϴ���·��
								path = this.getServletContext().getRealPath("/images/pro_Imgs");
								//��ȡ�ļ�������һ���ϴ�ʹ�����ļ���
								name = LoadPhoto.getPhotoName(item.getName());
							}else{
								//ʹ��ԭ�ļ���
								name = path.substring(path.lastIndexOf('/')+1, path.length());
							}
							//����File�ļ�
							File file = new File(path, name);
							try {								
								//�ϴ�
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
			//������Ϣ
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
