package esj.back.levels_manage.dao;

import esj.publicdoc.bean.UserlevelsBean;

public interface admin_levelsbeandao 
{
	//��ӵȼ���Ϣ
	public int addlevels(UserlevelsBean serserlevelsBean);
	//ɾ���ȼ���Ϣ
	public int deletelevels(UserlevelsBean serserlevelsBean);
	//�޸ĵȼ���Ϣ
	public int updatelevels(UserlevelsBean serserlevelsBean);
	//��ѯ�ȼ���Ϣ
	public int searchlevels(UserlevelsBean serserlevelsBean);

}
