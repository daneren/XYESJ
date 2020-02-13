package esj.back.control.product.service;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;

public interface ProductsService {
	/**
	 * 查询所有商品
	 */
	public List<ProductsBean> findAllProducts();
	
	
	
	public int deleteProduct(ProductsBean bean);
}
