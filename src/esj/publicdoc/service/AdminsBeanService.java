package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.AdminsBean;
/**����Ա�� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:25:54
 * @����޸�ʱ�� 2016-6-25 ����5:25:54
 * @����
 * @version 1.0
 */
public interface AdminsBeanService {
	/**����һ��   ����Ա��Ϣ*/
	public int saveAdmins(AdminsBean adminsBean);
	/**����ȫ��  ����Ա��Ϣ*/
	public List<AdminsBean> findAllAdmins();
	/**ɾ��һ��  ����Ա��Ϣ*/
	public int updateAdminsState(AdminsBean adminsBean);
	/**����һ��   ����Ա��Ϣ*/
	public int updateAdmins(AdminsBean adminsBean);
	/**���ݱ�ţ�����������   ����Ա��Ϣ*/
	public AdminsBean findAdminsByAdminId(Integer id);
}
