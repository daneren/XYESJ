package esj.publicdoc.dao;

import java.util.List;

import esj.publicdoc.bean.AdminsBean;
/**����Ա�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:54
 * @����޸�ʱ�� 2016-6-25 ����5:25:54
 * @���� ����Ա�� ������
 * @version 1.0
 */
public interface AdminsBeanDao {
	/**����һ��   ����Ա��Ϣ*/
	public int saveAdmins(AdminsBean adminsBean);
	/**����ȫ��  ����Ա��Ϣ*/
	public List<AdminsBean> findAllAdmins();
	/**�޸Ĺ���Ա״̬*/
	public int updateAdminsState(AdminsBean adminsBean);
	/**����һ��   ����Ա��Ϣ*/
	public int updateAdmins(AdminsBean adminsBean);
	/**���ݱ�ţ�����������   ����Ա��Ϣ*/
	public AdminsBean findAdminsByAdminId(Integer id);
}
