package esj.front.usercenter.service;

import java.util.List;
import java.util.Map;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-28 下午5:33:54
 * @最后修改时间 2016-6-28 下午5:33:54
 * @描述：
 * @version 1.0
 */
public interface PProtypesBeanService {
	/**
	 * 查询父类编号为fatherId 的数据
	 * */
	public List<ProtypesBean> getProType(int fatherId);
	/**
	 * 查询类别编号为typeId 的数据
	 * */
	public ProtypesBean getProTypeByTypeId(int typeId);
	
	/**获得类别关系图*/
	public Map<String,List<ProtypesBean>> getProTypeTree(String id);
	
	/**根据数据集合查找类别信息，两个参数都不为空则返回  两个条件同时成立的并集
	 * @param typeIds 查询typeId属于typeIds集合的所有数据
	 * @param fatherIds 查询fatherId属于fatherIds集合的所有数据
	 * 
	 * */
	public List<ProtypesBean> getByArray(String typeIds,String fatherIds);
	
}
