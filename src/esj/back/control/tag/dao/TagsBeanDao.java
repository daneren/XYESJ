package esj.back.control.tag.dao;

import esj.publicdoc.bean.TagsBean;
/**��ǩ�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:46
 * @����޸�ʱ�� 2016-6-25 ����5:26:46
 * @����
 * @version 1.0
 */
public interface TagsBeanDao{
	/**����һ��   ��ǩ״̬*/
	public int updateTagsStateById(TagsBean TagsBean);
	/**����һ��   ��ǩ*/
	public int updateTagsById(TagsBean TagsBean);
}
