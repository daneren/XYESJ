package esj.front.demands.dao;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-18 上午8:53:02
 * @最后修改时间 2016-7-18 上午8:53:02
 * @描述：
 * @version 1.0
 */
public interface PUserDemandDao {
	/**
	 * 修改商品信息
	 * @param 
	 * @return
	 */
	public int updateDemand(UserdemandsBean userdemandsBean);
	
	/**
	 * 根据userid获取用户需求 已解决的
	 * @return
	 */
	public List<UserdemandsBean> getsolvedDemandsByUserid(String userId);
	/**
	 * 根据userid获取用户需求 未解决的
	 * @return
	 */
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId);
}
