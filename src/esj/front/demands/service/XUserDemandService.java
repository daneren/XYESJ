package esj.front.demands.service;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.UserdemandsBean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-9 下午6:59:41
 * @最后修改时间 2016-7-9 下午6:59:41
 * @描述
 * @version 1.0
 */
public interface XUserDemandService {
	/**
	 * 根据userid获取用户需求 未解决的
	 * @return
	 */
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId);
	/**
	 * 获取最新的用户需求
	 */
	public List<UserdemandsBean> getNewUnsolveDemands();
	/**
	 * 获取毕业季的用户需求
	 */
	public List<UserdemandsBean> getNewGraduateUnsolveDemands();
	/**
	 * 查询需求 根据关键字
	 */
	public List<UserdemandsBean>searchDemands(String keyWords);
	/**
	 * 根据需求id获取对该商品的留言
	 */
	public List<LnotesBean> getLnotesBydemandId(String demandId);
}
