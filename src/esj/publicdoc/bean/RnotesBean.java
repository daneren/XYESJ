package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:45:23
 * @����޸�ʱ�� 2016-6-26 ����9:45:23
 * @���� �ظ���javabean
 * @version 1.0
 * @�ֶ�
 * `replyId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `leaveId` varchar(50) NOT NULL,
  `details` varchar(200) NOT NULL,
  `bdate` varchar(50) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `ipAddr` varchar(50) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class RnotesBean {

	// Fields
	/**�ظ����*/
	private String replyId;
	/**���ұ��*/
	private String userId;
	/**���Ա��*/
	private String leaveId;
	/**�ظ�����*/
	private String details;
	/**�ظ�����*/
	private String bdate;
	/**�û�������ַ*/
	private String ip;
	/**�û���������*/
	private String ipAddr;
	/**�ظ�״̬*/
	private String state;
	/**Ԥ���ֶ�*/
	private String remark;
	/**������飺����*/
	private List<UsersBean> users;
	/**������飺���Ա�*/
	private List<LnotesBean>  lnotes;
	
	
	
	// Constructors

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public List<LnotesBean> getLnotes() {
		return lnotes;
	}

	public void setLnotes(List<LnotesBean> lnotes) {
		this.lnotes = lnotes;
	}

	/** default constructor */
	public RnotesBean() {
	}

	/** minimal constructor */
	public RnotesBean(String replyId, String userId, String leaveId,
			String details, String bdate, String ip, String ipAddr,
			String state) {
		this.replyId = replyId;
		this.userId = userId;
		this.leaveId = leaveId;
		this.details = details;
		this.bdate = bdate;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.state = state;
	}

	/** full constructor */
	public RnotesBean(String replyId, String userId, String leaveId,
			String details, String bdate, String ip, String ipAddr,
			String state, String remark) {
		this.replyId = replyId;
		this.userId = userId;
		this.leaveId = leaveId;
		this.details = details;
		this.bdate = bdate;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getReplyId() {
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Rnotes [replyId=" + replyId + ", userId=" + userId
				+ ", leaveId=" + leaveId + ", details=" + details + ", bdate="
				+ bdate + ", ip=" + ip + ", ipAddr=" + ipAddr + ", state="
				+ state + ", remark=" + remark;
	}
	
	

}