package esj.front.usercenter.service;

import java.util.List;

import esj.publicdoc.bean.TagsBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-29 ����3:57:13
 * @����޸�ʱ�� 2016-6-29 ����3:57:13
 * @������
 * @version 1.0
 */
public interface PTagsBeanService {
	/**
	 * ���������ǩ
	 * @param typeId
	 * @param tags �ö��Ÿ���
	 * @param state
	 * @return
	 */
	public int insertList(Integer typeId,String[] tags,String state);
	/**
	 * ���±�ǩ�⣬���ñ�ǩ���ڿ��У���ʹ�ô�����1���������ñ�ǩ
	 * @param tags �ö��Ÿ���
	 * @param state
	 * @return
	 */
	public int updateTags(Integer typeId,String tags,String state,int count);
	
	/**
	 * ��������Ų�ѯ��ǩ  ������ö��Ÿ�������ʹ�ô�������
	 * @param tags ��ǩ���֣��ö��Ÿ���
	 * @param count Ҫ��õ�����
	 * @return
	 */
	public List<TagsBean> getTagsByTyList(String typeId,int count);

}
