package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-28 下午2:58:55
 * @最后修改时间 2016-6-28 下午2:58:55
 * @描述
 * @version 1.0
 */
public interface XTagsDao {

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
	 * 获取tag的点击次数 根据tagName
	 * @param id
	 * @return
	 */
	public int getTagTimesBytagName(String tagName);
	/**
	 * 按搜索热度排序tag
	 * @return
	 */
	public List<TagsBean> getTagsBytimesDesc();
	
}
