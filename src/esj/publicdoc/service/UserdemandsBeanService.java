package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
/**
 * �û�����������
 */
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:27
 * @����޸�ʱ�� 2016-6-25 ����5:25:27
 * @����
 * @version 1.0
 */
public interface UserdemandsBeanService {
	/**����һ��   �û�����*/
	public int saveUserdemands(UserdemandsBean userdemandsBean);
	/**����ȫ��   �û�����*/
	public List<UserdemandsBean> findAllUserdemands();
	/**ɾ��һ��  �û�����*/
	public int changeUserdemandsState(UserdemandsBean userdemandsBean);
	/**����һ��   �û�����*/
	public int updateUserdemands(UserdemandsBean userdemandsBean);
	/**���ݱ�ţ�����������   �û�����*/
	public UserdemandsBean findUserdemandsById(String id);
}
