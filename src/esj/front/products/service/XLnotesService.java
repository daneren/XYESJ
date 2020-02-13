package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-13 ����11:48:05
 * @����޸�ʱ�� 2016-7-13 ����11:48:05
 * @���� ���Դ���
 * @version 1.0
 */
public interface XLnotesService {
	/**
	 * ������Ʒid��ȡ�Ը���Ʒ������
	 */
	public List<LnotesBean> getLnotesByProId(String proId);
	
	/**
	 * ���ߣ���־��
	 * ������Ʒid����ұ���û��Ը���Ʒ������
	 */
	public String getByProId(String proId,String userId);
}
