package esj.front.usercenter.dao;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����10:34:28
 * @����޸�ʱ�� 2016-6-27 ����10:34:28
 * @���� �û����ݿ�����ӿ�
 * @version 1.0
 */
public interface XUsersBeanDao {

	/**
	 * �û���¼��ѯ
	 */
	public boolean userLogin(String email,String pwd);
	/**
	 * ��������������ҵ��û�id
	 */
	public String getUserIdByEmailAndPwd(String email,String pwd);
	/**
	 * ���������޸��û�������
	 */
	public int changePwdByEmail(String email,String pwd);
	/**
	 * ����userid����pwd
	 */
	public String getPwdByUserId(String userId);
}
