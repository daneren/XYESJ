package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.BroadcastsBean;
/**公告表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:02
 * @最后修改时间 2016-6-25 下午5:26:02
 * @描述
 * @version 1.0
 */
public interface BroadcastsBeanService {
	/**保存一个   公告信息*/
	public int saveBroadcasts(BroadcastsBean BroadcastsBean );
	/**查找全部 公告信息*/
	public List<BroadcastsBean> findAllBroadcasts();
	/**删除一个 公告信息*/
	public int changeBroadcastState(BroadcastsBean BroadcastsBean);
	/**更新一个   公告信息*/
	public int updateBroadcasts(BroadcastsBean BroadcastsBean);
	/**根据编号（主键）查找   公告信息*/
	public BroadcastsBean findBroadcastsById(String id);
}
