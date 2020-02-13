package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.UserlevelsBean;
import esj.publicdoc.dao.UserlevelsBeanDao;
import esj.publicdoc.dao.impl.UserlevelsBeanDaoimpl;
import esj.publicdoc.service.UserlevelsBeanService;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:31:30
 * @最后修改时间 2016-6-25 下午5:31:30
 * @描述 用户等级实现表
 * @version 1.0
 */
public class UserlevelsBeanServiceimpl implements UserlevelsBeanService {
	private UserlevelsBeanDao dao = new UserlevelsBeanDaoimpl();
	public int saveUserlevels(UserlevelsBean serlevelsBean) {
		// TODO Auto-generated method stub
		return dao.saveUserlevels(serlevelsBean);
	}

	public List<UserlevelsBean> findAllAdminlogs() {
		// TODO Auto-generated method stub
		return dao.findAllAdminlogs();
	}

	

	public int updateUserlevels(UserlevelsBean userlevelsBean) {
		// TODO Auto-generated method stub
		return dao.updateUserlevels(userlevelsBean);
	}

	public UserlevelsBean findUserlevelsById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findUserlevelsById(id);
	}

	public int changeStatesState(UserlevelsBean userlevelsBean) {
		// TODO Auto-generated method stub
		return dao.changeStatesState(userlevelsBean);
	}

	

}
