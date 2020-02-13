package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
import esj.publicdoc.dao.TagsBeanDao;
import esj.publicdoc.dao.impl.TagsBeanDaoimpl;
import esj.publicdoc.service.TagsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**标签表 实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:45
 * @最后修改时间 2016-6-25 下午5:30:45
 * @描述 标签表 操作类
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
