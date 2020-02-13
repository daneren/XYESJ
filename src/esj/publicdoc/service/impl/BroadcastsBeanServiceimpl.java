package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.BroadcastsBean;
import esj.publicdoc.dao.BroadcastsBeanDao;
import esj.publicdoc.dao.impl.BroadcastsBeanDaoimpl;
import esj.publicdoc.service.BroadcastsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**公告表 实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:44:12
 * @最后修改时间 2016-6-25 下午5:44:12
 * @描述
 * @version 1.0
 */
public class BroadcastsBeanServiceimpl implements BroadcastsBeanService {
	private BroadcastsBeanDao dao = new BroadcastsBeanDaoimpl();
	public int saveBroadcasts(BroadcastsBean BroadcastsBean) {
		BroadcastsBean.setBroadcastId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		return dao.saveBroadcasts(BroadcastsBean);
	}

	public List<BroadcastsBean> findAllBroadcasts() {
		return dao.findAllBroadcasts();
	}

	public int changeBroadcastState(BroadcastsBean BroadcastsBean) {
		return dao.changeBroadcastState(BroadcastsBean);
	}

	public int updateBroadcasts(BroadcastsBean BroadcastsBean) {
		return dao.updateBroadcasts(BroadcastsBean);
	}

	public BroadcastsBean findBroadcastsById(String id) {
		return dao.findBroadcastsById(id);
	}

	

}
