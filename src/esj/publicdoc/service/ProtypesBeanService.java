package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.ProtypesBean;
/**���� ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:26:29
 * @����޸�ʱ�� 2016-6-25 ����5:26:29
 * @����
 * @version 1.0
 */
public interface ProtypesBeanService {
	/**����һ��   �����Ϣ*/
	public int saveProtypes(ProtypesBean ProtypesBean );
	/**����ȫ�� �����Ϣ*/
	public List<ProtypesBean> findAllProtypes();
	/**ɾ��һ�� �����Ϣ*/
	public int removeProtypes(ProtypesBean ProtypesBean);
	/**����һ��   �����Ϣ*/
	public int updateProtypes(ProtypesBean ProtypesBean);
	/**���ݱ�ţ�����������   �����Ϣ*/
	public ProtypesBean findProtypesById(Integer id);
}
