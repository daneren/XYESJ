package esj.front.usercenter.dao;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-28 下午5:28:04
 * @最后修改时间 2016-6-28 下午5:28:04
 * @描述：
 * @version 1.0
 */
public interface PProtypesBeanDao {
	/**获得类别信息
	 * 查询一级类别信息则设置 fatherId为0
	 * 查询所有子类类别信息则设置 fatherId为-1
	 * */
	public List<ProtypesBean> getProType(ProtypesBean protypesBean);
	
	/**根据数据集合查找类别信息，两个参数都不为空则返回  两个条件同时成立的并集
	 * @param typeIds 查询typeId属于typeIds集合的所有数据
	 * @param fatherIds 查询fatherId属于fatherIds集合的所有数据
	 * 
	 * */
	public List<ProtypesBean> getByArray(String typeIds,String fatherIds);
}
