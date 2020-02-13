package esj.back.control.tag.service.impl;

import esj.back.control.tag.dao.TagsBeanDao;
import esj.back.control.tag.dao.impl.TagsBeanDaoImpl;
import esj.back.control.tag.service.TagsBeanService;
import esj.publicdoc.bean.TagsBean;

public class TagsBeanServiceImpl implements TagsBeanService {

	public int updateTagsStateById(TagsBean TagsBean) {
		TagsBeanDao dao=new TagsBeanDaoImpl();
		int count=dao.updateTagsStateById(TagsBean);
		return count;
	}

	public int updateTagsById(TagsBean TagsBean) {
		TagsBeanDao dao=new TagsBeanDaoImpl();
		int count=dao.updateTagsById(TagsBean);
		return count;
	}

}
