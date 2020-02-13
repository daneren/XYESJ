package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.RnotesBean;
/**回复表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:37
 * @最后修改时间 2016-6-25 下午5:26:37
 * @描述 回复表 操作类
 * @version 1.0
 */
public interface RnotesBeanDao {
	/**保存一个   回复信息*/
	public int saveRnotes(RnotesBean RnotesBean );
	/**查找全部 回复信息*/
	public List<RnotesBean> findAllRnotes();
	/**删除一个 回复信息*/
	public int changeRnotesState(RnotesBean RnotesBean);
	/**更新一个   回复信息*/
	public int updateRnotes(RnotesBean RnotesBean);
	/**根据编号（主键）查找   回复信息*/
	public RnotesBean findRnotesById(String id);
}
