package esj.util;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.util:JdbcSourceUtil.java  数据库连接池帮助类
 * @version 1.0
 * @data 2016-5-25
 */
public class JdbcSourceUtil {

	private static ComboPooledDataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	
	//得到DBUtil 核心类
	public static QueryRunner getQueryRunner(){
		
		return new QueryRunner(dataSource);
	}
}
