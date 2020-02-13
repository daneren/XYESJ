package esj.back.control.authoritie.dao;

import java.util.List;

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
public interface AuthoritiesBeanDao {

	/**更新一个   权限状态*/
	public int updateStateAuthoritiesByID(AuthoritiesBean authoritiesBean);
	
	/**删除一个   权限状态*/
	public int deleteAuthoritiesByID(AuthoritiesBean authoritiesBean);
	/**
	 * @作者 徐新凯
	 * @desc 获取权限的详细信息 从menu表和authority表中获取字段
	 * @return
	 */
	public List<AuthoritiesBean> getAllAuthoritiesInfo();

}