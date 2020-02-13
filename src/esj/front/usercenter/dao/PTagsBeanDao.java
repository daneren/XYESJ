package esj.front.usercenter.dao;

import java.util.ArrayList;
import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-29 ����3:50:40
 * @����޸�ʱ�� 2016-6-29 ����3:50:40
 * @������
 * @version 1.0
 */
public interface PTagsBeanDao {
	/**
	 * ���������ǩ
	 * @param typeId
	 * @param tags ��ǩ���֣��ö��Ÿ���
	 * @param bdate ��������
	 * @param state ״̬
	 * @return
	 */
	public int insertList(List<String> tagId ,Integer typeId,List<String> tags,String bdate,String state);
	/**
	 * �����ж����ݿ����Ƿ����XXX��ǩ
	 * @param tags ��ǩ���֣��ö��Ÿ���
	 * @return ����tags���������ݿ��еı�ǩ,�Զ��Ÿ���
	 */
	public List<String> getTags(String tags);
	/**
	 * �������±�ǩ��ʹ�ô���
	 * @param tags ��ǩ���֣��ö��Ÿ���
	 * @param count Ҫ���ӵ�ʹ�ô���
	 * @return
	 */
	public int upadateCounts(List<String> tags,int count);
	
	/**
	 * ��������Ų�ѯ��ǩ  ������ö��Ÿ�������ʹ�ô�������
	 * @param tags ��ǩ���֣��ö��Ÿ���
	 * @param count Ҫ��õ�����
	 * @return
	 */
	public List<TagsBean> getTagsByTyList(String typeId,int count);
}
