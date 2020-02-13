package esj.front.usercenter.dao;

import esj.publicdoc.bean.UsersBean;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-26 ����1:48:59
 * @����޸�ʱ�� 2016-6-26 ����1:48:59
 * @������
 * @version 1.0
 */
public interface PUsersBeanDao {
	/**
	 * ������֤֮�����������ַ�����û�
	 * @param email
	 * @return
	 */
	public UsersBean findUserByEmail(String email);
	/**
	 * ������֤֮��ͨ����������û���״̬
	 * @param usersBean
	 * @return
	 */
	public int updateUser(String email,String state);
	/**
	 * �����û���Ϣ��������������ѧУ��ѧԺ��רҵ�����գ���ѧ����,�Ա�
	 * @param usersBean
	 * @return
	 */
	public int updateUserMsg(UsersBean usersBean);
	
	/**
	 * �޸ĵ�½���� 
	 * @param userId
	 * @param npwd ������
	 * @return
	 */
	public int updatePwd(String userId,String npwd);
	
	/**
	 * �޸��ֻ���
	 * @param userId
	 * @param npwd ������
	 * @return
	 */
	public int updatePhone(String userId,String userPhone);
	

}
