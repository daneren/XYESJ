package esj.back.control.product.dao;

import esj.publicdoc.bean.ProtypesBean;

public interface ProtypesDao {
	/**����һ��   ��Ʒ���*/
	public int addProtypes(ProtypesBean protypesBean);
	
	/**����һ��   ��Ʒ���*/
	public int updateProtypesChildID(ProtypesBean protypesBean);
	public int updateProtypes(ProtypesBean protypesBean);
	
	/**����һ��   ��Ʒ��� ͨ������*/
	public ProtypesBean findProtypesByName(ProtypesBean protypesBean);
}
