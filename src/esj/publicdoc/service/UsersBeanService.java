package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.UsersBean;
/**
 * �û��������
 */
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:42
 * @����޸�ʱ�� 2016-6-25 ����5:25:42
 * @����
 * @version 1.0
 */
public interface UsersBeanService {
	/**����һ��   �û�*/
	public int saveUsers(UsersBean userBean);
	/**����ȫ��   �û�*/
	public List<UsersBean> findAllUsers();
	/**ɾ��һ��  �û�*/
	public int changeUserState(UsersBean userBean);
	/**����һ��   �û�*/
	public int updateUser(UsersBean userBean);
	/**���ݱ�ţ�����������   �û�*/
	public UsersBean findUserById(String id);
}
