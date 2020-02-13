package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 下午6:31:11
 * @最后修改时间 2016-6-27 下午6:31:11
 * @描述
 * @version 1.0
 */
public interface XProTypeDao {
	
	
	/**
	 * 根据父id获取所有的子类别
	 * 
	 * @return
	 */
	public List<ProtypesBean> getProtypesByfatherid(int fid);
	
}
