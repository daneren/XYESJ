package esj.back.control.product.service;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;

public interface ProductsService {
	/**
	 * ��ѯ������Ʒ
	 */
	public List<ProductsBean> findAllProducts();
	
	
	
	public int deleteProduct(ProductsBean bean);
}
