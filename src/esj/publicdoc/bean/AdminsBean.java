package esj.publicdoc.bean;
import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:36:02
 * @最后修改时间 2016-6-26 上午9:36:02
 * @描述 管理员表javabean
 * @version 1.0
 * @字段 
 * `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminPhone` varchar(50) NOT NULL,
  `adminName` varchar(50) NOT NULL,
  `adminPwd` varchar(50) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthDay` varchar(30) DEFAULT NULL,
  `rigistDay` varchar(30) DEFAULT NULL,
  `authId` int(11) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public  class AdminsBean{

	// Fields
	/**管理员编号*/
	private int adminId;
	/**管理员账号：手机号*/
	private String adminPhone;
	/**管理员名字*/
	private String adminName;
	/**管理员登陆密码*/
	private String adminPwd;
	/**管理员性别*/
	private String sex;
	/**管理员生日*/
	private String birthDay;
	/**管理员登陆日期*/
	private String rigistDay;
	/**管理员权限编号*/
	private int authId;
	/**管理员状态 1：启用，0禁用*/
	private String state;
	/**预留字段*/
	private String remark;
	/**外键：权限表数组*/
	private List<AuthoritiesBean> authoritiesBean;
	
	
	// Constructors

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result
				+ ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result
				+ ((adminPhone == null) ? 0 : adminPhone.hashCode());
		result = prime * result
				+ ((adminPwd == null) ? 0 : adminPwd.hashCode());
		result = prime * result + authId;
		result = prime * result
				+ ((authoritiesBean == null) ? 0 : authoritiesBean.hashCode());
		result = prime * result
				+ ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((rigistDay == null) ? 0 : rigistDay.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		AdminsBean other = (AdminsBean) obj;
		if (adminId != other.adminId)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPhone == null) {
			if (other.adminPhone != null)
				return false;
		} else if (!adminPhone.equals(other.adminPhone))
			return false;
		if (adminPwd == null) {
			if (other.adminPwd != null)
				return false;
		} else if (!adminPwd.equals(other.adminPwd))
			return false;
		if (authId != other.authId)
			return false;
		if (authoritiesBean == null) {
			if (other.authoritiesBean != null)
				return false;
		} else if (!authoritiesBean.equals(other.authoritiesBean))
			return false;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rigistDay == null) {
			if (other.rigistDay != null)
				return false;
		} else if (!rigistDay.equals(other.rigistDay))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	/** default constructor */
	public AdminsBean() {
	}

	public List<AuthoritiesBean> getAuthoritiesBean() {
		return authoritiesBean;
	}

	public void setAuthoritiesBean(List<AuthoritiesBean> authoritiesBean) {
		this.authoritiesBean = authoritiesBean;
	}

	/** minimal constructor */
	public AdminsBean(String adminPhone, String adminName, String adminPwd,
			String state) {
		this.adminPhone = adminPhone;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.state = state;
	}

	/** full constructor */
	public AdminsBean(String adminPhone, String adminName, String adminPwd,
			String sex, String birthDay, String rigistDay, Integer authId,
			String state, String remark) {
		this.adminPhone = adminPhone;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.sex = sex;
		this.birthDay = birthDay;
		this.rigistDay = rigistDay;
		this.authId = authId;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminPhone() {
		return this.adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getRigistDay() {
		return this.rigistDay;
	}

	public void setRigistDay(String rigistDay) {
		this.rigistDay = rigistDay;
	}

	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
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
		return "adminId=" + adminId + ", adminPhone=" + adminPhone
				+ ", adminName=" + adminName + ", adminPwd=" + adminPwd
				+ ", sex=" + sex + ", birthDay=" + birthDay + ", rigistDay="
				+ rigistDay + ", authId=" + authId + ", state=" + state
				+ ", remark=" + remark ;
	}

	
}