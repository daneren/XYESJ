package esj.front.usercenter.service;

import esj.publicdoc.bean.UsersBean;

/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-29 ����11:28:17
 * @����޸�ʱ�� 2016-6-29 ����11:28:17
 * @������
 * @version 1.0
 */
public interface PUsersBeanService {
	/**
	 * �����û���Ϣ��������������ѧУ��ѧԺ��רҵ�����գ���ѧ����,�Ա�
	 * @param usersBean
	 * @return
	 */
	public int updateUserMsg(UsersBean usersBean);
	/**
	 * �޸ĵ�¼����
	 * @param opwd ԭʼ����
	 * @param npwd ������
	 * @param userId �û����
	 * @return
	 */
	public int updateUserPwd(String npwd,String userId);
	
	/**
	 * �޸��ֻ���
	 * @param userId
	 * @param npwd ������
	 * @return
	 */
	public int updatePhone(String userId,String userPhone);
}
