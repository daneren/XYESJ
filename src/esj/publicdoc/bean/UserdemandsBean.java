package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:46:24
 * @最后修改时间 2016-6-26 上午9:46:24
 * @描述 用户需求表javabean
 * @version 1.0
 * @字段
 * `demandId` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `tagName` varchar(100) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `details` varchar(200) NOT NULL,
  `bdate` varchar(50) DEFAULT NULL,
  `edate` varchar(50) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `photoAddr` varchar(200) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */
public class UserdemandsBean{

	// Fields
	/**需求编号*/
	private String demandId;
	/**类别编号*/
	private Integer typeId;
	/**标签名称*/
	private String tagName;
	/**用户编号*/
	private String userId;
	/**需求名称*/
	private String title;
	/**需求描述*/
	private String details;
	/**需求发布日期*/
	private String bdate;
	/**需求结束日期*/
	private String edate;
	/**需求状态*/
	private String state;
	/**照片地址*/
	private String photoAddr;
	/**预留字段*/
	private String remark;
	/**外键数组：用户表*/
	private List<UsersBean> users;
	/**外键数组：类别表*/
	private List<ProtypesBean> protypes;
	
	

	// Constructors

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bdate == null) ? 0 : bdate.hashCode());
		result = prime * result
				+ ((demandId == null) ? 0 : demandId.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((edate == null) ? 0 : edate.hashCode());
		result = prime * result
				+ ((photoAddr == null) ? 0 : photoAddr.hashCode());
		result = prime * result
				+ ((protypes == null) ? 0 : protypes.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		UserdemandsBean other = (UserdemandsBean) obj;
		if (bdate == null) {
			if (other.bdate != null)
				return false;
		} else if (!bdate.equals(other.bdate))
			return false;
		if (demandId == null) {
			if (other.demandId != null)
				return false;
		} else if (!demandId.equals(other.demandId))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (edate == null) {
			if (other.edate != null)
				return false;
		} else if (!edate.equals(other.edate))
			return false;
		if (photoAddr == null) {
			if (other.photoAddr != null)
				return false;
		} else if (!photoAddr.equals(other.photoAddr))
			return false;
		if (protypes == null) {
			if (other.protypes != null)
				return false;
		} else if (!protypes.equals(other.protypes))
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
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public List<ProtypesBean> getProtypes() {
		return protypes;
	}

	public void setProtypes(List<ProtypesBean> protypes) {
		this.protypes = protypes;
	}

	/** default constructor */
	public UserdemandsBean() {
	}

	/** minimal constructor */
	public UserdemandsBean(String demandId, Integer typeId, String tagName,
			String userId, String title, String details) {
		this.demandId = demandId;
		this.typeId = typeId;
		this.tagName = tagName;
		this.userId = userId;
		this.title = title;
		this.details = details;
	}

	/** full constructor */
	public UserdemandsBean(String demandId, Integer typeId, String tagName,
			String userId, String title, String details, String bdate,
			String edate, String state, String photoAddr, String remark) {
		this.demandId = demandId;
		this.typeId = typeId;
		this.tagName = tagName;
		this.userId = userId;
		this.title = title;
		this.details = details;
		this.bdate = bdate;
		this.edate = edate;
		this.state = state;
		this.photoAddr = photoAddr;
		this.remark = remark;
	}

	// Property accessors

	public String getDemandId() {
		return this.demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getEdate() {
		return this.edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhotoAddr() {
		return this.photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "demandId=" + demandId + ", typeId=" + typeId
				+ ", tagName=" + tagName + ", userId=" + userId + ", title="
				+ title + ", details=" + details + ", bdate=" + bdate
				+ ", edate=" + edate + ", state=" + state + ", photoAddr="
				+ photoAddr + ", remark=" + remark;
	}
	
	

}