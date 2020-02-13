package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.StatesBean;

/**״̬�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:42
 * @����޸�ʱ�� 2016-6-25 ����5:26:42
 * @���� ״̬�� ������
 * @version 1.0
 */
public interface StatesBeanDao {
	/**����һ��   ״̬��Ϣ*/
	public int saveStates(StatesBean StatesBean );
	/**����ȫ�� ״̬��Ϣ*/
	public List<StatesBean> findAllStates();
	/**ɾ��һ�� ״̬��Ϣ*/
	public int changeStatesState(StatesBean StatesBean);
	/**����һ��   ״̬��Ϣ*/
	public int updateStates(StatesBean StatesBean);
	/**���ݱ�ţ�����������   ״̬��Ϣ*/
	public StatesBean findStatesById(Integer id);
}
