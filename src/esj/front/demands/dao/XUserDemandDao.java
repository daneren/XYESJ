package esj.front.demands.dao;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.bean.UserdemandsBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-9 ����6:59:27
 * @����޸�ʱ�� 2016-7-9 ����6:59:27
 * @����
 * @version 1.0
 */
public interface XUserDemandDao {
	/**
	 * ����userid��ȡ�û����� δ�����
	 * @return
	 */
	public List<UserdemandsBean> getUnsolveDemandsByUserid(String userId);
	/**
	 * ��ȡ���µ��û�����
	 */
	public List<UserdemandsBean> getNewUnsolveDemands();
	/**
	 * ��ȡ��ҵ�����û�����
	 */
	public List<UserdemandsBean> getNewGraduateUnsolveDemands();
	
	/**
	 * ��ѯ���� ���ݹؼ���
	 */
	public List<UserdemandsBean> searchDemands(String keyWords);
	/**
	 * ��������id��ȡ�Ը���Ʒ������
	 */
	public List<LnotesBean> getLnotesBydemandId(String demandId);
}
