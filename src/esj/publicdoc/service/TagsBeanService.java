package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**标签表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:46
 * @最后修改时间 2016-6-25 下午5:26:46
 * @描述
 * @version 1.0
 */
public interface TagsBeanService {
	/**保存一个   标签信息*/
	public int saveTags(TagsBean TagsBean );
	/**查找全部 标签信息*/
	public List<TagsBean> findAllTags();
	/**删除一个 标签信息*/
	public int changeTagsState(TagsBean TagsBean);
	/**更新一个   标签信息*/
	public int updateTags(TagsBean TagsBean);
	/**根据编号（主键）查找   标签信息*/
	public TagsBean findTagsById(String id);
}
