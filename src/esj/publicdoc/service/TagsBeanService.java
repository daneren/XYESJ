package esj.publicdoc.service;

import java.util.List;

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
public interface TagsBeanService {
	/**����һ��   ��ǩ��Ϣ*/
	public int saveTags(TagsBean TagsBean );
	/**����ȫ�� ��ǩ��Ϣ*/
	public List<TagsBean> findAllTags();
	/**ɾ��һ�� ��ǩ��Ϣ*/
	public int changeTagsState(TagsBean TagsBean);
	/**����һ��   ��ǩ��Ϣ*/
	public int updateTags(TagsBean TagsBean);
	/**���ݱ�ţ�����������   ��ǩ��Ϣ*/
	public TagsBean findTagsById(String id);
}
