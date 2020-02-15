package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:48:51
 * @����޸�ʱ�� 2016-6-26 ����9:48:51
 * @���� �û���־��javabean
 * @version 1.0
 * @�ֶ�
 * `ulogId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `ipAddr` varchar(50) NOT NULL,
  `textAddr` varchar(200) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class UserlogsBean{

	// Fields
	/**�û���־���*/
	private String ulogId;
	/**�û����*/
	private String userId;
	/**�û�������ַ*/
	private String ip;
	/**�û����ڵ���*/
	private String ipAddr;
	/**�û���־��ַ*/
	private String textAddr;
	/**Ԥ���ֶ�*/
	private String remark;
	/**������飺Users*/
	private List<UsersBean> users;
	
	
	
	// Constructors

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	/** default constructor */
	public UserlogsBean() {
	}

	/** minimal constructor */
	public UserlogsBean(String ulogId, String userId, String ip,
			String ipAddr, String textAddr) {
		this.ulogId = ulogId;
		this.userId = userId;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.textAddr = textAddr;
	}

	/** full constructor */
	public UserlogsBean(String ulogId, String userId, String ip,
			String ipAddr, String textAddr, String remark) {
		this.ulogId = ulogId;
		this.userId = userId;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.textAddr = textAddr;
		this.remark = remark;
	}

	// Property accessors

	public String getUlogId() {
		return this.ulogId;
	}

	public void setUlogId(String ulogId) {
		this.ulogId = ulogId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getTextAddr() {
		return this.textAddr;
	}

	public void setTextAddr(String textAddr) {
		this.textAddr = textAddr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ulogId=" + ulogId + ", userId=" + userId + ", ip="
				+ ip + ", ipAddr=" + ipAddr + ", textAddr=" + textAddr
				+ ", remark=" + remark;
	}

	
}