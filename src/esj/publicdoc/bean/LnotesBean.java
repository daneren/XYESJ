package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:39:38
 * @最后修改时间 2016-6-26 上午9:39:38
 * @描述 留言表javabean
 * @version 1.0
 * @字段
 * `leaveId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `proId` varchar(50) NOT NULL,
  `details` varchar(200) NOT NULL,
  `bdate` varchar(50) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `ipAddr` varchar(50) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class LnotesBean{

	// Fields
	/**留言编号*/
	private String leaveId;
	/**用户编号*/
	private String userId;
	/**商品编号*/
	private String proId;
	/**留言内容*/
	private String details;
	/**留言日期*/
	private String bdate;
	/**  客户端外网地址*/
	private String ip;
	/** 用户地区*/
	private String ipAddr;
	/**留言状态*/
	private String state;
	/**预留字段*/
	private String remark;
	/**外键数组：用户表*/
	private List<UsersBean> usersBean;
	/**外键数组：商品表*/
	private List<ProductsBean> productsBean;
	
	

	// Constructors

	
	/** default constructor */
	public LnotesBean() {
	}

	public List<UsersBean> getUsersBean() {
		return usersBean;
	}

	public void setUsersBean(List<UsersBean> usersBean) {
		this.usersBean = usersBean;
	}

	public List<ProductsBean> getProductsBean() {
		return productsBean;
	}

	public void setProductsBean(List<ProductsBean> productsBean) {
		this.productsBean = productsBean;
	}

	/** minimal constructor */
	public LnotesBean(String leaveId, String userId, String proId,
			String details, String bdate, String ip, String ipAddr,
			String state) {
		this.leaveId = leaveId;
		this.userId = userId;
		this.proId = proId;
		this.details = details;
		this.bdate = bdate;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.state = state;
	}

	/** full constructor */
	public LnotesBean(String leaveId, String userId, String proId,
			String details, String bdate, String ip, String ipAddr,
			String state, String remark) {
		this.leaveId = leaveId;
		this.userId = userId;
		this.proId = proId;
		this.details = details;
		this.bdate = bdate;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProId() {
		return this.proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
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
		return "leaveId=" + leaveId + ", userId=" + userId + ", proId="
				+ proId + ", details=" + details + ", bdate=" + bdate + ", ip="
				+ ip + ", ipAddr=" + ipAddr + ", state=" + state + ", remark="
				+ remark;
	}
	
	

}