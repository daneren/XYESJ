package esj.front.usercenter.service;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����10:37:56
 * @����޸�ʱ�� 2016-6-27 ����10:37:56
 * @���� �û������ӿ�
 * @version 1.0
 */
public interface XUsersBeanService {
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
