package esj.publicdoc.service;

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
public interface AuthoritiesBeanService {
	/**保存一个   权限信息*/
	public int saveAuthorities(AuthoritiesBean authoritiesBean );
	/**查找全部 权限信息*/
	public List<AuthoritiesBean> findAllAuthorities();
	/**删除一个 权限信息*/
	public int changeAuthorityState(AuthoritiesBean authoritiesBean);
	/**更新一个   权限信息*/
	public int updateAuthorities(AuthoritiesBean authoritiesBean);
	/**根据编号（主键）查找   权限信息*/
	public AuthoritiesBean findAuthoritiesById(Integer id);
}
