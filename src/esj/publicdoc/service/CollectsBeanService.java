package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.CollectsBean;
/**收藏表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:08
 * @最后修改时间 2016-6-25 下午5:26:08
 * @描述
 * @version 1.0
 */
public interface CollectsBeanService {
	/**保存一个   收藏信息*/
	public int saveCollects(CollectsBean CollectsBean );
	/**查找全部 收藏信息*/
	public List<CollectsBean> findAllCollects();
	/**删除一个 收藏信息*/
	public int changeCollectState(CollectsBean CollectsBean);
	/**根据编号（主键）查找   收藏信息*/
	public CollectsBean findCollectsById(String id);
}
