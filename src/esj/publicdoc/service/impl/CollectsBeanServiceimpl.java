package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.dao.CollectsBeanDao;
import esj.publicdoc.dao.impl.CollectsBeanDaoimpl;
import esj.publicdoc.service.CollectsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**收藏表 实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:04
 * @最后修改时间 2016-6-25 下午5:29:04
 * @描述
 * @version 1.0
 */
public class CollectsBeanServiceimpl implements CollectsBeanService {
private CollectsBeanDao dao = new CollectsBeanDaoimpl();
	public int saveCollects(CollectsBean CollectsBean) {
		CollectsBean.setCollectId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		CollectsBean.setBdate(DateHelper.getDateTimeFormat());
		return dao.saveCollects(CollectsBean);
	}

	public List<CollectsBean> findAllCollects() {
		return dao.findAllCollects();
	}

	public int changeCollectState(CollectsBean CollectsBean) {
		return dao.changeCollectState(CollectsBean);
	}


	public CollectsBean findCollectsById(String id) {
		return dao.findCollectsById(id);
	}

	
}
