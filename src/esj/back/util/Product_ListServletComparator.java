package esj.back.util;

import java.util.Comparator;

import esj.publicdoc.bean.ProductsBean;

public class Product_ListServletComparator implements Comparator<ProductsBean> {

	public int compare(ProductsBean o1, ProductsBean o2) {
		 int i = o1.getProId().compareTo(o2.getProId()); //±È½ÏÃû×Ö×Ö·û´®  
		 return i; 
	}

}
