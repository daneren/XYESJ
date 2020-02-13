package esj.back.control.tag.dao;

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
public interface TagsBeanDao{
	/**更新一个   标签状态*/
	public int updateTagsStateById(TagsBean TagsBean);
	/**更新一个   标签*/
	public int updateTagsById(TagsBean TagsBean);
}
