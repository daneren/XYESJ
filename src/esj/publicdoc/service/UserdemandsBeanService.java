package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
/**
 * 用户需求表操作类
 */
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:27
 * @最后修改时间 2016-6-25 下午5:25:27
 * @描述
 * @version 1.0
 */
public interface UserdemandsBeanService {
	/**保存一个   用户需求*/
	public int saveUserdemands(UserdemandsBean userdemandsBean);
	/**查找全部   用户需求*/
	public List<UserdemandsBean> findAllUserdemands();
	/**删除一个  用户需求*/
	public int changeUserdemandsState(UserdemandsBean userdemandsBean);
	/**更新一个   用户需求*/
	public int updateUserdemands(UserdemandsBean userdemandsBean);
	/**根据编号（主键）查找   用户需求*/
	public UserdemandsBean findUserdemandsById(String id);
}
