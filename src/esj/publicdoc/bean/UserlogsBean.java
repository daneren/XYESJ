package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:48:51
 * @最后修改时间 2016-6-26 上午9:48:51
 * @描述 用户日志表javabean
 * @version 1.0
 * @字段
 * `ulogId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `ipAddr` varchar(50) NOT NULL,
  `textAddr` varchar(200) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class UserlogsBean{

	// Fields
	/**用户日志编号*/
	private String ulogId;
	/**用户编号*/
	private String userId;
	/**用户外网地址*/
	private String ip;
	/**用户所在地区*/
	private String ipAddr;
	/**用户日志地址*/
	private String textAddr;
	/**预留字段*/
	private String remark;
	/**外键数组：Users*/
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