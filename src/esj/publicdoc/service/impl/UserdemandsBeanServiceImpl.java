package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.dao.UserdemandsBeanDao;
import esj.publicdoc.dao.impl.UserdemandsBeanDaoImpl;
import esj.publicdoc.service.UserdemandsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:59
 * @最后修改时间 2016-6-25 下午5:30:59
 * @描述 用户需求 实现类
 * @version 1.0
 */
public class UserdemandsBeanServiceImpl implements UserdemandsBeanService {
	private UserdemandsBeanDao dao = new UserdemandsBeanDaoImpl();
	public int saveUserdemands(UserdemandsBean userdemandsBean) {
		userdemandsBean.setDemandId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		userdemandsBean.setBdate(DateHelper.getDateTimeFormat());
		return dao.saveUserdemands(userdemandsBean);
	}

	public List<UserdemandsBean> findAllUserdemands() {
		// TODO Auto-generated method stub
		return dao.findAllUserdemands();
	}



	public int updateUserdemands(UserdemandsBean userdemandsBean) {
		// TODO Auto-generated method stub
		return dao.updateUserdemands(userdemandsBean);
	}

	public UserdemandsBean findUserdemandsById(String id) {
		// TODO Auto-generated method stub
		return dao.findUserdemandsById(id);
	}

	public int changeUserdemandsState(UserdemandsBean userdemandsBean) {
		// TODO Auto-generated method stub
		return dao.changeUserdemandsState(userdemandsBean);
	}

	

}
