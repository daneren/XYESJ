package esj.back.control.authoritie.service.impl;

import esj.back.control.authoritie.dao.AdminDao;
import esj.back.control.authoritie.dao.impl.AdminDaoImpl;
import esj.back.control.authoritie.service.AdminService;
import esj.publicdoc.bean.AdminsBean;

public class AdminServiceImpl implements AdminService {

	public int addAdmin(AdminsBean adminsBean) {
		AdminDao dao=new AdminDaoImpl();
		int flag=dao.addAdmin(adminsBean);
		return flag;
	}

	public int updateAdminById(AdminsBean adminsBean) {
		AdminDao dao=new AdminDaoImpl();
		int flag=dao.updateAdminById(adminsBean);
		return flag;
	}

	public int deleteAdminById(AdminsBean adminsBean) {
		AdminDao dao=new AdminDaoImpl();
		int flag=dao.deleteAdminById(adminsBean);
		return flag;
	}

}
