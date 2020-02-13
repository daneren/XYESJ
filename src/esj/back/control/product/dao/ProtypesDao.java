package esj.back.control.product.dao;

import esj.publicdoc.bean.ProtypesBean;

public interface ProtypesDao {
	/**新增一个   商品类别*/
	public int addProtypes(ProtypesBean protypesBean);
	
	/**更新一个   商品类别*/
	public int updateProtypesChildID(ProtypesBean protypesBean);
	public int updateProtypes(ProtypesBean protypesBean);
	
	/**查找一个   商品类别 通过名字*/
	public ProtypesBean findProtypesByName(ProtypesBean protypesBean);
}
