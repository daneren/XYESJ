package esj.back.control.product.service.impl;

import esj.back.control.product.dao.ProtypesDao;
import esj.back.control.product.dao.impl.ProtypesDaoImpl;
import esj.back.control.product.service.ProtypesService;
import esj.publicdoc.bean.ProtypesBean;

public class ProtypesServiceImpl implements ProtypesService {

	ProtypesDao dao=new ProtypesDaoImpl();
	
	public int addProtypes(ProtypesBean protypesBean) {
		int count=0;
		count=dao.addProtypes(protypesBean);
		return count;
	}

	public int updateProtypesChildID(ProtypesBean protypesBean) {
		int count=0;
		count=dao.updateProtypesChildID(protypesBean);
		return count;
	}

	public ProtypesBean findProtypesByName(ProtypesBean protypesBean) {
		return dao.findProtypesByName(protypesBean);
	}

	public int updateProtypes(ProtypesBean protypesBean) {
		int count=0;
		count=dao.updateProtypes(protypesBean);
		return count;
	}

}
