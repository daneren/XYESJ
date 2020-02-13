package esj.back.control.authoritie.service;

import esj.publicdoc.bean.AdminsBean;


public interface AdminService {
	
	public int addAdmin(AdminsBean adminsBean);
	
	
	public int updateAdminById(AdminsBean adminsBean);
	
	
	public int deleteAdminById(AdminsBean adminsBean);
}
