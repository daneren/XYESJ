package esj.back.control.product.dao;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;

public interface ProductsDao {
	/**
	 * ��ѯ������Ʒ
	 */
	public List<ProductsBean> findAllProducts();
	
	
	
	
	public int deleteProduct(ProductsBean bean);
}
