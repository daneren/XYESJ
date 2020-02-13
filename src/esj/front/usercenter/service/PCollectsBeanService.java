package esj.front.usercenter.service;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
/**
 * 我的愿望清单
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午1:29:30
 * @最后修改时间 2016-7-1 上午1:29:30
 * @描述：
 * @version 1.0
 */
public interface PCollectsBeanService {
	/**商品基本信息*/
	/**proId,photoAddr,title,details,cprice,dprice,oprice,state,bdate
	 * */
	public List<ProCommBean> getUCollects(String buyerId);
	
	/**关注人数，预约人数*/
	/**ruCount,r.proId,cuCount
	 * */
	public List<ProCommBean> getProData(String buyerId);
}
