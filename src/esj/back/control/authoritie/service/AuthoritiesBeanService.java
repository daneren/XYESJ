package esj.back.control.authoritie.service;

import esj.publicdoc.bean.AuthoritiesBean;
/**权限表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:58
 * @最后修改时间 2016-6-25 下午5:25:58
 * @描述
 * @version 1.0
 */
public interface AuthoritiesBeanService {

	/**更新一个   权限状态*/
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean);
	
	/**删除一个   权限状态*/
	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean);
	

}
