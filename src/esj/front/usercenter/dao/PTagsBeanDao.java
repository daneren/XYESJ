package esj.front.usercenter.dao;

import java.util.ArrayList;
import java.util.List;

import esj.publicdoc.bean.TagsBean;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-29 下午3:50:40
 * @最后修改时间 2016-6-29 下午3:50:40
 * @描述：
 * @version 1.0
 */
public interface PTagsBeanDao {
	/**
	 * 批量插入标签
	 * @param typeId
	 * @param tags 标签名字，用逗号隔开
	 * @param bdate 插入日期
	 * @param state 状态
	 * @return
	 */
	public int insertList(List<String> tagId ,Integer typeId,List<String> tags,String bdate,String state);
	/**
	 * 批量判断数据库中是否存在XXX标签
	 * @param tags 标签名字，用逗号隔开
	 * @return 返回tags中已在数据库中的标签,以逗号隔开
	 */
	public List<String> getTags(String tags);
	/**
	 * 批量更新标签的使用次数
	 * @param tags 标签名字，用逗号隔开
	 * @param count 要增加的使用次数
	 * @return
	 */
	public int upadateCounts(List<String> tags,int count);
	
	/**
	 * 根据类别编号查询标签  类别编号用逗号隔开，按使用次数排序
	 * @param tags 标签名字，用逗号隔开
	 * @param count 要获得的条数
	 * @return
	 */
	public List<TagsBean> getTagsByTyList(String typeId,int count);
}
