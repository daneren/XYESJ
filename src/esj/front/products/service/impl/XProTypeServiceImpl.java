package esj.front.products.service.impl;

import java.util.List;

import esj.front.products.dao.impl.XProTypeDaoImpl;
import esj.front.products.service.XProTypeService;
import esj.publicdoc.bean.ProtypesBean;

public class XProTypeServiceImpl implements XProTypeService {

	private XProTypeDaoImpl dao = new XProTypeDaoImpl();

	public List<ProtypesBean> getProtypesByfatherid(int fid) {
		// TODO Auto-generated method stub
		return dao.getProtypesByfatherid(fid);
	}
	
	
}
