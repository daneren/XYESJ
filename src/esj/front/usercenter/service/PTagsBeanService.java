package esj.front.usercenter.service;

import java.util.List;

import esj.publicdoc.bean.TagsBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-29 下午3:57:13
 * @最后修改时间 2016-6-29 下午3:57:13
 * @描述：
 * @version 1.0
 */
public interface PTagsBeanService {
	/**
	 * 批量插入标签
	 * @param typeId
	 * @param tags 用逗号隔开
	 * @param state
	 * @return
	 */
	public int insertList(Integer typeId,String[] tags,String state);
	/**
	 * 更新标签库，若该标签已在库中，则使用次数加1；否则插入该标签
	 * @param tags 用逗号隔开
	 * @param state
	 * @return
	 */
	public int updateTags(Integer typeId,String tags,String state,int count);
	
	/**
	 * 根据类别编号查询标签  类别编号用逗号隔开，按使用次数排序
	 * @param tags 标签名字，用逗号隔开
	 * @param count 要获得的条数
	 * @return
	 */
	public List<TagsBean> getTagsByTyList(String typeId,int count);

}
