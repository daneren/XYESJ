package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.UserlevelsBean;
/**
 * 用户等级表操作类
 */
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:31
 * @最后修改时间 2016-6-25 下午5:25:31
 * @描述 用户等级表操作类
 * @version 1.0
 */
public interface UserlevelsBeanDao {
	/**保存一个   用户等级*/
	public int saveUserlevels(UserlevelsBean serlevelsBean);
	/**查找全部   用户等级*/
	public List<UserlevelsBean> findAllAdminlogs();
	/**删除一个  用户等级*/
	public int changeStatesState(UserlevelsBean userlevelsBean);
	/**更新一个   用户等级*/
	public int updateUserlevels(UserlevelsBean userlevelsBean);
	/**根据编号（主键）查找   用户等级*/
	public UserlevelsBean findUserlevelsById(Integer id);
}
