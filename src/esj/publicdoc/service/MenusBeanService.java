package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.MenusBean;
/**�˵��� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:16
 * @����޸�ʱ�� 2016-6-25 ����5:26:16
 * @����
 * @version 1.0
 */
public interface MenusBeanService {
	/**����һ��   �˵���Ϣ*/
	public int saveMenus(MenusBean MenusBean );
	/**����ȫ�� �˵���Ϣ*/
	public List<MenusBean> findAllMenus();
	/**ɾ��һ�� �˵���Ϣ*/
	public int changeMenusState(MenusBean MenusBean);
	/**����һ��   �˵���Ϣ*/
	public int updateMenus(MenusBean MenusBean);
	/**���ݱ�ţ�����������   �˵���Ϣ*/
	public MenusBean findMenusById(Integer id);
}
