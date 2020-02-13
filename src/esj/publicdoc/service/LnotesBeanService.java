package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;
/**留言表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:12
 * @最后修改时间 2016-6-25 下午5:26:12
 * @描述
 * @version 1.0
 */
public interface LnotesBeanService {
	/**保存一个   留言信息*/
	public int saveLnotes(LnotesBean LnotesBean );
	/**查找全部 留言信息*/
	public List<LnotesBean> findAllLnotes();
	/**删除一个 留言信息*/
	public int changeLnotesState(LnotesBean LnotesBean);
	/**更新一个   留言信息*/
	public int updateLnotes(LnotesBean LnotesBean);
	/**根据编号（主键）查找   留言信息*/
	public LnotesBean findLnotesById(String id);
}
