package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.MenusBean;
import esj.publicdoc.dao.MenusBeanDao;
import esj.publicdoc.dao.impl.MenusBeanDaoimpl;
import esj.publicdoc.service.MenusBeanService;
/**�˵��� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:29:32
 * @����޸�ʱ�� 2016-6-25 ����5:29:32
 * @���� �˵��� ������
 * @version 1.0
 */
public class MenusBeanServiceimpl implements MenusBeanService {
	private MenusBeanDao dao = new MenusBeanDaoimpl();
	public int saveMenus(MenusBean MenusBean) {
		// TODO Auto-generated method stub
		return dao.saveMenus(MenusBean);
	}

	public List<MenusBean> findAllMenus() {
		// TODO Auto-generated method stub
		return dao.findAllMenus();
	}

	public int changeMenusState(MenusBean MenusBean) {
		// TODO Auto-generated method stub
		return dao.changeMenusState(MenusBean);
	}

	public int updateMenus(MenusBean MenusBean) {
		// TODO Auto-generated method stub
		return dao.updateMenus(MenusBean);
	}

	public MenusBean findMenusById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findMenusById(id);
	}


}
