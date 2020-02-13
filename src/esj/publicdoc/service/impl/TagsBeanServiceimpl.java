package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
import esj.publicdoc.dao.TagsBeanDao;
import esj.publicdoc.dao.impl.TagsBeanDaoimpl;
import esj.publicdoc.service.TagsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**��ǩ�� ʵ����*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:30:45
 * @����޸�ʱ�� 2016-6-25 ����5:30:45
 * @���� ��ǩ�� ������
 * @version 1.0
 */
public class TagsBeanServiceimpl implements TagsBeanService {
private TagsBeanDao dao = new TagsBeanDaoimpl();
	public int saveTags(TagsBean TagsBean) {
		TagsBean.setTagId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		TagsBean.setBdate(DateHelper.getDateTimeFormat());
		return dao.saveTags(TagsBean);
	}

	public List<TagsBean> findAllTags() {
		// TODO Auto-generated method stub
		return dao.findAllTags();
	}

	

	public int updateTags(TagsBean TagsBean) {
		// TODO Auto-generated method stub
		return dao.updateTags(TagsBean);
	}

	public TagsBean findTagsById(String id) {
		// TODO Auto-generated method stub
		return dao.findTagsById(id);
	}

	public int changeTagsState(TagsBean TagsBean) {
		// TODO Auto-generated method stub
		return dao.changeTagsState(TagsBean);
	}

	

}
