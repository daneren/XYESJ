package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;
/**类别表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:29
 * @最后修改时间 2016-6-25 下午5:26:29
 * @描述
 * @version 1.0
 */
public interface ProtypesBeanService {
	/**保存一个   类别信息*/
	public int saveProtypes(ProtypesBean ProtypesBean );
	/**查找全部 类别信息*/
	public List<ProtypesBean> findAllProtypes();
	/**删除一个 类别信息*/
	public int removeProtypes(ProtypesBean ProtypesBean);
	/**更新一个   类别信息*/
	public int updateProtypes(ProtypesBean ProtypesBean);
	/**根据编号（主键）查找   类别信息*/
	public ProtypesBean findProtypesById(Integer id);
}
