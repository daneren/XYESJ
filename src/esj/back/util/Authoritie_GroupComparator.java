package esj.back.util;

import java.util.Comparator;

import esj.publicdoc.bean.AuthoritiesBean;

public class Authoritie_GroupComparator implements Comparator<AuthoritiesBean> {

	public int compare(AuthoritiesBean one, AuthoritiesBean two) {
		
		 int i = one.getAuthId().compareTo(two.getAuthId()); //�Ƚ������ַ���  
		 return i;  
		 
	}
}
