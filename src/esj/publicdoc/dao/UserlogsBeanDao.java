package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.UserlogsBean;

/**
 * �û���־�������
 */
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:37
 * @����޸�ʱ�� 2016-6-25 ����5:25:37
 * @���� �û���־�������
 * @version 1.0
 */
public interface UserlogsBeanDao {

	/** ����һ�� �û���־ */
	public int saveUserlogs(UserlogsBean userlogsBean);

	/** ����ȫ�� �û���־ */
	public List<UserlogsBean> findAllAdminlogs();

	/** ɾ��һ�� �û���־ */
	public int removeUserlogs(UserlogsBean userlogsBean);

	/** ����һ�� �û���־ */
	public int updateUserlogs(UserlogsBean userlogsBean);

	/** ���ݱ�ţ����������� �û���־ */
	public UserlogsBean findUserlogsById(String id);
}
