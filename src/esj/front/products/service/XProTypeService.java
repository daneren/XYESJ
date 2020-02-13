package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

public interface XProTypeService {
	/**
	 * 根据父id获取所有的子类别
	 * 
	 * @return
	 */
	public List<ProtypesBean> getProtypesByfatherid(int fid);
}
