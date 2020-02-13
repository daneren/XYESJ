package esj.back.control.authoritie.dao;

import esj.publicdoc.bean.AdminsBean;

public interface AdminDao {
	public int addAdmin(AdminsBean adminsBean);
	
	public int deleteAdminById(AdminsBean adminsBean);
	public int updateAdminById(AdminsBean adminsBean);
	
}
