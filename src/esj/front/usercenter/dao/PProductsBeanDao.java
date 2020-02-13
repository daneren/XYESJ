package esj.front.usercenter.dao;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.publicdoc.bean.ProductsBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午11:17:35
 * @最后修改时间 2016-7-1 上午11:17:35
 * @描述：
 * @version 1.0
 */
public interface PProductsBeanDao {
	/**已售出*/
	/**proId,title,pCount,nCount,photoAddr,cjdate,
	 * buyerPrice,ruCount,cuCount
	 *  ORDER BY p.bdate
	 * 
	 */
	public List<ProCommBean> getSoldOut(String buyerId);
	

	/**出售中的商品*/
	/**proId,title,pCount,nCount,photoAddr,ruCount  ORDER BY p.bdate;
	 */
	public List<ProCommBean> getOnSale(String buyerId);
	
	/**
	 * 根据用户名查找商品信息
	 * @param userId
	 * @return
	 */
	public List<ProductsBean> findProductByUserId(String userId);
	
	/**
	 * 根据用户名和商品状态查找商品信息
	 * @param userId
	 * @param state
	 * @return
	 */
	public List<ProductsBean> findProduct(String userId,String state);
	
	/**
	 * 根据商品状态计算商品数
	 * @param state 用逗号隔开
	 * @return
	 */
	public List<ProductsBean> countProduct(String state);
	
	public int setProductStateByProId(String proId, String state);
	
	/**
	 * 修改商品信息
	 * @param 
	 * @return
	 */
	public int updateProduct(ProductsBean productsBean);
	
	
	
}
