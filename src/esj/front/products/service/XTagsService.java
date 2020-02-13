package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-28 下午3:01:11
 * @最后修改时间 2016-6-28 下午3:01:11
 * @描述
 * @version 1.0
 */
public interface XTagsService {
	/**
	 * 插入一条数据
	 * @param bean
	 * @return
	 */
	public int insertTag(TagsBean bean);
	/**
	 * 给tag的点击次数加一 根据名字
	 */
	public int addOneTotimes(String tagName);
	/**
	 * 获取tag的点击次数 根据名字
	 * @param id
	 * @return
	 */
	public int getTagTimesById(String tagName);
	/**
	 * 按搜索热度排序tag
	 * @return
	 */
	public List<TagsBean> getTagsBytimesDesc();
}
