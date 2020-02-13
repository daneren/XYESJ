package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.AuthoritiesBean;
/***/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:25:58
 * @最后修改时间 2016-6-25 下午5:25:58
 * @描述 权限表 操作类
 * @version 1.0
 */
public interface AuthoritiesBeanDao {
	/**保存一个   权限信息*/
	public int saveAuthorities(AuthoritiesBean authoritiesBean );
	/**查找全部 权限信息*/
	public List<AuthoritiesBean> findAllAuthorities();
	/**修改权限的状态*/
	public int changeAuthorityState(AuthoritiesBean authoritiesBean);
	/**更新一个   权限信息*/
	public int updateAuthorities(AuthoritiesBean authoritiesBean);
	/**根据编号（主键）查找   权限信息*/
	public AuthoritiesBean findAuthoritiesById(Integer id);
}
