package esj.front.usercenter.dao;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;

/**
 * 我的愿望清单
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午1:12:31
 * @最后修改时间 2016-7-1 上午1:12:31
 * @描述：
 * @version 1.0
 */
public interface PCollectsBeanDao {
	/**商品基本信息*/
	/**proId,photoAddr,title,details,cprice,dprice,oprice,pstate,bdate,collectId
	 * */
	public List<ProCommBean> getUCollects(String buyerId);
	
	/**关注人数，预约人数*/
	/**ruCount,r.proId,cuCount
	 * */
	public List<ProCommBean> getProData(String buyerId);
	
}
