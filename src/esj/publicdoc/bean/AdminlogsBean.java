package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:31:54
 * @最后修改时间 2016-6-26 上午9:31:54
 * @描述 管理员操作日志表javabean
 * @version 1.0
 * @字段 
 * `alogId` varchar(50) NOT NULL,
  `adminId` int(11) NOT NULL,
  `time` varchar(30) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `ipAddr` varchar(50) NOT NULL,
  `textAddr` varchar(200) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class AdminlogsBean{

	// Fields
	/** 管理员日志编号  ： 年月日时分秒+用户编号*/
	private String alogId;
	/** 管理员编号*/
	private int adminId;
	/** 登陆时间*/
	private String time;
	/**客户端外网地址*/
	private String ip;
	/**所在地区*/
	private String ipAddr;
	/**日志文件地址   :  file/用户Id/年月日时分秒.txt*/
	private String textAddr;
	/**预留字段*/
	private String remark;
	/**外键数组：管理员表*/
	private List<AdminsBean> adminsBean;

	
	
	// Constructors

	public List<AdminsBean> getAdminsBean() {
		return adminsBean;
	}

	public void setAdminsBean(List<AdminsBean> adminsBean) {
		this.adminsBean = adminsBean;
	}

	/** default constructor */
	public AdminlogsBean() {
	}

	/** minimal constructor */
	public AdminlogsBean(String alogId, int adminId, String time,
			String ip, String ipAddr, String textAddr) {
		this.alogId = alogId;
		this.adminId = adminId;
		this.time = time;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.textAddr = textAddr;
	}

	/** full constructor */
	public AdminlogsBean(String alogId, int adminId, String time,
			String ip, String ipAddr, String textAddr, String remark) {
		this.alogId = alogId;
		this.adminId = adminId;
		this.time = time;
		this.ip = ip;
		this.ipAddr = ipAddr;
		this.textAddr = textAddr;
		this.remark = remark;
	}

	// Property accessors

	public String getAlogId() {
		return this.alogId;
	}

	public void setAlogId(String alogId) {
		this.alogId = alogId;
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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
		return "alogId=" + alogId + ", adminId=" + adminId
				+ ", time=" + time + ", ip=" + ip + ", ipAddr=" + ipAddr
				+ ", textAddr=" + textAddr + ", remark=" + remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result
				+ ((adminsBean == null) ? 0 : adminsBean.hashCode());
		result = prime * result + ((alogId == null) ? 0 : alogId.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((ipAddr == null) ? 0 : ipAddr.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((textAddr == null) ? 0 : textAddr.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminlogsBean other = (AdminlogsBean) obj;
		if (adminId != other.adminId)
			return false;
		if (adminsBean == null) {
			if (other.adminsBean != null)
				return false;
		} else if (!adminsBean.equals(other.adminsBean))
			return false;
		if (alogId == null) {
			if (other.alogId != null)
				return false;
		} else if (!alogId.equals(other.alogId))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (ipAddr == null) {
			if (other.ipAddr != null)
				return false;
		} else if (!ipAddr.equals(other.ipAddr))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (textAddr == null) {
			if (other.textAddr != null)
				return false;
		} else if (!textAddr.equals(other.textAddr))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	
	
	

}