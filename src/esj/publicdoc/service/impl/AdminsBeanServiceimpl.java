package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.dao.AdminsBeanDao;
import esj.publicdoc.dao.impl.AdminsBeanDaoimpl;
import esj.publicdoc.service.AdminsBeanService;
import esj.util.DateHelper;
/**����Ա�� ʵ����*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:27:50
 * @����޸�ʱ�� 2016-6-25 ����5:27:50
 * @����
 * @version 1.0
 */
public class AdminsBeanServiceimpl implements AdminsBeanService {
	private AdminsBeanDao dao = new AdminsBeanDaoimpl();
	public int saveAdmins(AdminsBean admin) {
		admin.setRigistDay(DateHelper.getDateTimeFormat());
		return dao.saveAdmins(admin);
	}

	public List<AdminsBean> findAllAdmins() {
		return dao.findAllAdmins();
	}

	public int updateAdminsState(AdminsBean adminsBean) {
		return dao.updateAdminsState(adminsBean);
	}

	public int updateAdmins(AdminsBean adminsBean) {
		return dao.updateAdmins(adminsBean);
	}
	public AdminsBean findAdminsByAdminId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findAdminsByAdminId(id);
	}


	

}
