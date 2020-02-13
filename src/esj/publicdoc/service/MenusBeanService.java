package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.MenusBean;
/**菜单表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:16
 * @最后修改时间 2016-6-25 下午5:26:16
 * @描述
 * @version 1.0
 */
public interface MenusBeanService {
	/**保存一个   菜单信息*/
	public int saveMenus(MenusBean MenusBean );
	/**查找全部 菜单信息*/
	public List<MenusBean> findAllMenus();
	/**删除一个 菜单信息*/
	public int changeMenusState(MenusBean MenusBean);
	/**更新一个   菜单信息*/
	public int updateMenus(MenusBean MenusBean);
	/**根据编号（主键）查找   菜单信息*/
	public MenusBean findMenusById(Integer id);
}
