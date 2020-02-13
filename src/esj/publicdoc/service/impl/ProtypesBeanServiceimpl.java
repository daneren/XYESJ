package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;
import esj.publicdoc.dao.ProtypesBeanDao;
import esj.publicdoc.dao.impl.ProtypesBeanDaoimpl;
import esj.publicdoc.service.ProtypesBeanService;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:58
 * @最后修改时间 2016-6-25 下午5:29:58
 * @描述
 * @version 1.0
 */
public class ProtypesBeanServiceimpl implements ProtypesBeanService {
	private ProtypesBeanDao dao = new ProtypesBeanDaoimpl();
	public int saveProtypes(ProtypesBean ProtypesBean) {
		return dao.saveProtypes(ProtypesBean);
	}

	public List<ProtypesBean> findAllProtypes() {
		return dao.findAllProtypes();
	}

	public int removeProtypes(ProtypesBean ProtypesBean) {
		return dao.removeProtypes(ProtypesBean);
	}

	public int updateProtypes(ProtypesBean ProtypesBean) {
		return dao.updateProtypes(ProtypesBean);
	}

	public ProtypesBean findProtypesById(Integer id) {
		return dao.findProtypesById(id);
	}

	

}
