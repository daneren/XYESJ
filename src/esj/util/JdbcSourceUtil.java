package esj.util;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.util:JdbcSourceUtil.java  ���ݿ����ӳذ�����
 * @version 1.0
 * @data 2016-5-25
 */
public class JdbcSourceUtil {

	private static ComboPooledDataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	
	//�õ�DBUtil ������
	public static QueryRunner getQueryRunner(){
		
		return new QueryRunner(dataSource);
	}
}
