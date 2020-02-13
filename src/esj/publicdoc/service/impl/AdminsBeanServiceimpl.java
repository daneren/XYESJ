package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.AdminsBean;
import esj.publicdoc.dao.AdminsBeanDao;
import esj.publicdoc.dao.impl.AdminsBeanDaoimpl;
import esj.publicdoc.service.AdminsBeanService;
import esj.util.DateHelper;
/**管理员表 实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:27:50
 * @最后修改时间 2016-6-25 下午5:27:50
 * @描述
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
