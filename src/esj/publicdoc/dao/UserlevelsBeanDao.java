package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.UserlevelsBean;
/**
 * �û��ȼ��������
 */
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:31
 * @����޸�ʱ�� 2016-6-25 ����5:25:31
 * @���� �û��ȼ��������
 * @version 1.0
 */
public interface UserlevelsBeanDao {
	/**����һ��   �û��ȼ�*/
	public int saveUserlevels(UserlevelsBean serlevelsBean);
	/**����ȫ��   �û��ȼ�*/
	public List<UserlevelsBean> findAllAdminlogs();
	/**ɾ��һ��  �û��ȼ�*/
	public int changeStatesState(UserlevelsBean userlevelsBean);
	/**����һ��   �û��ȼ�*/
	public int updateUserlevels(UserlevelsBean userlevelsBean);
	/**���ݱ�ţ�����������   �û��ȼ�*/
	public UserlevelsBean findUserlevelsById(Integer id);
}
