package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

public interface XProTypeService {
	/**
	 * ���ݸ�id��ȡ���е������
	 * 
	 * @return
	 */
	public List<ProtypesBean> getProtypesByfatherid(int fid);
}
