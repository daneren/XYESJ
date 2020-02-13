package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.dao.ProductsBeanDao;
import esj.publicdoc.dao.impl.ProductsBeanDaoimpl;
import esj.publicdoc.service.ProductsBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**��Ʒ�������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:29:51
 * @����޸�ʱ�� 2016-6-25 ����5:29:51
 * @���� ��Ʒ�������
 * @version 1.0
 */
public  class ProductsBeanServiceImpl implements ProductsBeanService {
	private ProductsBeanDao dao = new ProductsBeanDaoimpl();
	public int saveProducts(ProductsBean ProductsBean) {
		ProductsBean.setProId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		ProductsBean.setBdate(DateHelper.getDateTimeFormat());
		return dao.saveProducts(ProductsBean);
	}

	public List<ProductsBean> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.findAllProducts();
	}

	public int changeProductsState(ProductsBean ProductsBean) {
		// TODO Auto-generated method stub
		return dao.changeProductsState(ProductsBean);
	}

	public int updateProducts(ProductsBean ProductsBean) {
		// TODO Auto-generated method stub
		return dao.updateProducts(ProductsBean);
	}

	public ProductsBean findProductsById(String id) {
		// TODO Auto-generated method stub
		return dao.findProductsById(id);
	}

	

}
