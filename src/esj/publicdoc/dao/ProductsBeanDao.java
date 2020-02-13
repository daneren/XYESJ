package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.ProductsBean;
/**��Ʒ�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:20
 * @����޸�ʱ�� 2016-6-25 ����5:26:20
 * @���� ��Ʒ�� ������
 * @version 1.0
 */
public interface ProductsBeanDao {
	/**����һ��   ��Ʒ��Ϣ*/
	public int saveProducts(ProductsBean ProductsBean );
	/**����ȫ�� ��Ʒ��Ϣ*/
	public List<ProductsBean> findAllProducts();
	/**ɾ��һ�� ��Ʒ��Ϣ*/
	public int changeProductsState(ProductsBean ProductsBean);
	/**����һ��   ��Ʒ��Ϣ*/
	public int updateProducts(ProductsBean ProductsBean);
	/**���ݱ�ţ�����������   ��Ʒ��Ϣ*/
	public ProductsBean findProductsById(String id);
}
