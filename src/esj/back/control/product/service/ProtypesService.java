package esj.back.control.product.service;

import esj.publicdoc.bean.ProtypesBean;

public interface ProtypesService {
	/**����һ��   ��Ʒ���*/
	public int addProtypes(ProtypesBean protypesBean);
	
	/**����һ��   ��Ʒ���*/
	public int updateProtypesChildID(ProtypesBean protypesBean);
	public int updateProtypes(ProtypesBean protypesBean);
	
	
	/**����һ��   ��Ʒ��� ͨ������*/
	public ProtypesBean findProtypesByName(ProtypesBean protypesBean);
}
