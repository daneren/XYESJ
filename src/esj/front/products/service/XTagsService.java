package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-28 ����3:01:11
 * @����޸�ʱ�� 2016-6-28 ����3:01:11
 * @����
 * @version 1.0
 */
public interface XTagsService {
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
	 * ��ȡtag�ĵ������ ��������
	 * @param id
	 * @return
	 */
	public int getTagTimesById(String tagName);
	/**
	 * �������ȶ�����tag
	 * @return
	 */
	public List<TagsBean> getTagsBytimesDesc();
}
