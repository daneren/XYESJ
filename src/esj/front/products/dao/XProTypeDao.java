package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����6:31:11
 * @����޸�ʱ�� 2016-6-27 ����6:31:11
 * @����
 * @version 1.0
 */
public interface XProTypeDao {
	
	
	/**
	 * ���ݸ�id��ȡ���е������
	 * 
	 * @return
	 */
	public List<ProtypesBean> getProtypesByfatherid(int fid);
	
}
