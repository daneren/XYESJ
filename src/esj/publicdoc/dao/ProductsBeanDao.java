package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;
/**商品表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:20
 * @最后修改时间 2016-6-25 下午5:26:20
 * @描述 商品表 操作类
 * @version 1.0
 */
public interface ProductsBeanDao {
	/**保存一个   商品信息*/
	public int saveProducts(ProductsBean ProductsBean );
	/**查找全部 商品信息*/
	public List<ProductsBean> findAllProducts();
	/**删除一个 商品信息*/
	public int changeProductsState(ProductsBean ProductsBean);
	/**更新一个   商品信息*/
	public int updateProducts(ProductsBean ProductsBean);
	/**根据编号（主键）查找   商品信息*/
	public ProductsBean findProductsById(String id);
}
