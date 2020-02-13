package esj.front.products.service;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 上午11:48:05
 * @最后修改时间 2016-7-13 上午11:48:05
 * @描述 留言处理
 * @version 1.0
 */
public interface XLnotesService {
	/**
	 * 根据商品id获取对该商品的留言
	 */
	public List<LnotesBean> getLnotesByProId(String proId);
	
	/**
	 * 作者：朱志玉
	 * 根据商品id和买家编号用户对该商品的评分
	 */
	public String getByProId(String proId,String userId);
}
