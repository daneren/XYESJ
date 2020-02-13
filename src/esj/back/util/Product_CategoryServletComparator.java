package esj.back.util;

import java.util.Comparator;

import esj.publicdoc.bean.ProtypesBean;

public class Product_CategoryServletComparator implements Comparator<ProtypesBean>{
	public int compare(ProtypesBean one, ProtypesBean two) {
		
		 int i = one.getTypeId().compareTo(two.getTypeId()); //±È½ÏÃû×Ö×Ö·û´®  
		 return i;  
		 
	}
}
