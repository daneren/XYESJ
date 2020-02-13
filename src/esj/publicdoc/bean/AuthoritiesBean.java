package esj.publicdoc.bean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:38:16
 * @最后修改时间 2016-6-26 上午9:38:16
 * @描述 权限表javabean
 * @version 1.0
 * @字段 
 * `authId` int(11) NOT NULL AUTO_INCREMENT,
  `authName` varchar(50) NOT NULL,
  `menuList` varchar(100) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public  class AuthoritiesBean {

	// Fields
	/**权限编号*/
	private int authId;
	/**权限名称*/
	private String authName;
	/**权限菜单列表*/
	private String menuList;
	/**权限状态*/
	private String state;
	/**预留字段*/
	private String remark;

	// Constructors

	/** default constructor */
	public AuthoritiesBean() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authId;
		result = prime * result
				+ ((authName == null) ? 0 : authName.hashCode());
		result = prime * result
				+ ((menuList == null) ? 0 : menuList.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		AuthoritiesBean other = (AuthoritiesBean) obj;
		if (authId != other.authId)
			return false;
		if (authName == null) {
			if (other.authName != null)
				return false;
		} else if (!authName.equals(other.authName))
			return false;
		if (menuList == null) {
			if (other.menuList != null)
				return false;
		} else if (!menuList.equals(other.menuList))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	/** minimal constructor */
	public AuthoritiesBean(String authName, String menuList, String state) {
		this.authName = authName;
		this.menuList = menuList;
		this.state = state;
	}

	/** full constructor */
	public AuthoritiesBean(String authName, String menuList, String state,
			String remark) {
		this.authName = authName;
		this.menuList = menuList;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getMenuList() {
		return this.menuList;
	}

	public void setMenuList(String menuList) {
		this.menuList = menuList;
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
		return "authId=" + authId + ", authName=" + authName
				+ ", menuList=" + menuList + ", state=" + state + ", remark="
				+ remark;
	}
	

}