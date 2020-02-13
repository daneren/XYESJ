package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.StatesBean;

/**状态表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:42
 * @最后修改时间 2016-6-25 下午5:26:42
 * @描述 状态表 操作类
 * @version 1.0
 */
public interface StatesBeanDao {
	/**保存一个   状态信息*/
	public int saveStates(StatesBean StatesBean );
	/**查找全部 状态信息*/
	public List<StatesBean> findAllStates();
	/**删除一个 状态信息*/
	public int changeStatesState(StatesBean StatesBean);
	/**更新一个   状态信息*/
	public int updateStates(StatesBean StatesBean);
	/**根据编号（主键）查找   状态信息*/
	public StatesBean findStatesById(Integer id);
}
