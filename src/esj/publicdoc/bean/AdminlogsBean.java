package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:31:54
 * @����޸�ʱ�� 2016-6-26 ����9:31:54
 * @���� ����Ա������־��javabean
 * @version 1.0
 * @�ֶ� 
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
	/** ����Ա��־���  �� ������ʱ����+�û����*/
	private String alogId;
	/** ����Ա���*/
	private int adminId;
	/** ��½ʱ��*/
	private String time;
	/**�ͻ���������ַ*/
	private String ip;
	/**���ڵ���*/
	private String ipAddr;
	/**��־�ļ���ַ   :  file/�û�Id/������ʱ����.txt*/
	private String textAddr;
	/**Ԥ���ֶ�*/
	private String remark;
	/**������飺����Ա��*/
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