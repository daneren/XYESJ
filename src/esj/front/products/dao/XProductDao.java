package esj.front.products.dao;

import java.util.List;

import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.PraiseTreadBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ReservesBean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-9 下午3:41:23
 * @最后修改时间 2016-7-9 下午3:41:23
 * @描述 商品查询
 * @version 1.0
 */
public interface XProductDao {
	/**根据关键字搜索商品*/
	public List<ProductsBean> searchProducts(String keyWords,String typeid);
	/**获得出售中最新发布的商品数据,也就是最新发布的*/
	public List<ProductsBean> getNewProducts();
	/**获得毕业季的学生发布的商品,按照时间顺序*/
	public List<ProductsBean> getGraduateProducts();
	/**根据id获取商品的信息，然后推送相关的商品*/
	public List<ProductsBean> getPushProductsById(String id);
	/**获得赞商品的次数*/
	public int getPraiseCountByProId(String proId);
	/**获得踩商品的次数*/
	public int getTreadCountByProId(String proId);
	/**给商品点赞*/
	public int praiseProduct(PraiseTreadBean  ptb);
	/**踩商品点赞*/
	public int treadProduct(PraiseTreadBean  ptb);
	
	/**给商品表的赞次数加一*/
	public int updateProductPcount(String proId,int pcount);
	/**给商品表的踩次数加一*/
	public int updateProductNcount(String proId,int ncount);
	
	/**验证该商品是否已被该用户赞或踩了*/
	public boolean isTreadOrPraise(String userId,String proId);
	/**获取商品的收藏数*/
	public int collectCountByProId(String proId);
	/**判断该用户是否收藏了该商品*/
	public boolean isCollected(String userId,String proId);
	/**收藏该商品*/
	public int collectProduct(CollectsBean collect);
	/**根据userId获取该用户预约的商品数*/
	public int getReserveCountByUserId(String userId);
	/**根据userId获取该用户预约的所有商品的总价格*/
	public double getReservePriceCountByUserId(String userId);
	
	/***
	 * 根据Tag搜索商品
	 */
	public List<ProductsBean> getProByTag(String tag);

	/**
	 *作者：朱志玉 
	 * 设置评分,分数，总评分数*/
	public int updateScore(String score,String proId);
}
