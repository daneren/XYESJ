package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.AdminlogsBean;
/**����Ա��־�������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:49
 * @����޸�ʱ�� 2016-6-25 ����5:25:49
 * @���� ����Ա��־�������
 * @version 1.0
 */
public interface AdminlogsBeanDao {
	/**����һ��   ����Ա��־*/
	public int saveAdminLogs(AdminlogsBean adminlogsBean);
	/**����ȫ��   ����Ա��־*/
	public List<AdminlogsBean> findAllAdminlogs();
	
	/**���ݱ�ţ�����������   ����Ա��־*/
	public AdminlogsBean findAdminlogsByLogId(String id);
}
