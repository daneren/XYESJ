package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-28 ����2:58:55
 * @����޸�ʱ�� 2016-6-28 ����2:58:55
 * @����
 * @version 1.0
 */
public interface XTagsDao {

	/**
	 * ����һ������
	 * @param bean
	 * @return
	 */
	public int insertTag(TagsBean bean);
	/**
	 * ��tag�ĵ��������һ ��������
	 */
	public int addOneTotimes(String tagName);
	/**
	 * ��ȡtag�ĵ������ ����tagName
	 * @param id
	 * @return
	 */
	public int getTagTimesBytagName(String tagName);
	/**
	 * �������ȶ�����tag
	 * @return
	 */
	public List<TagsBean> getTagsBytimesDesc();
	
}
