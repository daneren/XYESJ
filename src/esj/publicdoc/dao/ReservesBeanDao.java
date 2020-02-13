package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.ReservesBean;
/**ԤԼ�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:33
 * @����޸�ʱ�� 2016-6-25 ����5:26:33
 * @���� ԤԼ�� ������
 * @version 1.0
 */
public interface ReservesBeanDao {
	/**����һ��   ԤԼ��Ϣ*/
	public int saveReserves(ReservesBean reservesBean );
	/**����ȫ�� ԤԼ��Ϣ*/
	public List<ReservesBean> findAllReserves();
	/**ɾ��һ�� ԤԼ��Ϣ*/
	public int removeReserves(ReservesBean reservesBean);
	/**����һ��   ԤԼ��Ϣ*/
	public int updateReserves(ReservesBean reservesBean);
	/**���ݱ�ţ�����������   ԤԼ��Ϣ*/
	public ReservesBean findReservesById(String id);
}
