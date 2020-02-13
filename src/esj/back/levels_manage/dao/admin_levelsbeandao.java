package esj.back.levels_manage.dao;

import esj.publicdoc.bean.UserlevelsBean;

public interface admin_levelsbeandao 
{
	//添加等级信息
	public int addlevels(UserlevelsBean serserlevelsBean);
	//删除等级信息
	public int deletelevels(UserlevelsBean serserlevelsBean);
	//修改等级信息
	public int updatelevels(UserlevelsBean serserlevelsBean);
	//查询等级信息
	public int searchlevels(UserlevelsBean serserlevelsBean);

}
