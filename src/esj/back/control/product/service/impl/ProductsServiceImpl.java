package esj.back.control.product.service.impl;

import java.util.List;

import esj.back.control.product.dao.ProductsDao;
import esj.back.control.product.dao.impl.ProductsDaoImpl;
import esj.back.control.product.service.ProductsService;
import esj.publicdoc.bean.ProductsBean;

public class ProductsServiceImpl implements ProductsService {
	ProductsDao dao=new ProductsDaoImpl();
	public List<ProductsBean> findAllProducts() {
		return dao.findAllProducts();
	}

	public int deleteProduct(ProductsBean bean) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(bean);
	}

}
