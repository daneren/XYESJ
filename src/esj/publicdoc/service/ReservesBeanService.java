package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.ReservesBean;
/**ԤԼ�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:33
 * @����޸�ʱ�� 2016-6-25 ����5:26:33
 * @����
 * @version 1.0
 */
public interface ReservesBeanService {
	/**����һ��   ԤԼ��Ϣ*/
	public int saveReserves(ReservesBean ReservesBean );
	/**����ȫ�� ԤԼ��Ϣ*/
	public List<ReservesBean> findAllReserves();
	/**ɾ��һ�� ԤԼ��Ϣ*/
	public int removeReserves(ReservesBean ReservesBean);
	/**����һ��   ԤԼ��Ϣ*/
	public int updateReserves(ReservesBean ReservesBean);
	/**���ݱ�ţ�����������   ԤԼ��Ϣ*/
	public ReservesBean findReservesById(String id);
}