package esj.publicdoc.bean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 下午4:48:50
 * @最后修改时间 2016-6-26 下午4:48:50
 * @描述 系统公告表javabean
 * @version 1.0
 * @字段
 * `broadcastId` varchar(50) NOT NULL,
  `details` varchar(200) NOT NULL,
  `imgurl` varchar(100) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class BroadcastsBean{

	// Fields
	/**公告编号*/
	private String broadcastId;
	/**公告描述*/
	private String details;
	/**公告图片地址*/
	private String imgurl;
	/**公告状态*/
	private String state;
	/**预留字段*/
	private String remark;

	// Constructors

	/** default constructor */
	public BroadcastsBean() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((broadcastId == null) ? 0 : broadcastId.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
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
		BroadcastsBean other = (BroadcastsBean) obj;
		if (broadcastId == null) {
			if (other.broadcastId != null)
				return false;
		} else if (!broadcastId.equals(other.broadcastId))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
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
	public BroadcastsBean(String broadcastId, String details,
			String imgurl, String state) {
		this.broadcastId = broadcastId;
		this.details = details;
		this.imgurl = imgurl;
		this.state = state;
	}

	/** full constructor */
	public BroadcastsBean(String broadcastId, String details,
			String imgurl, String state, String remark) {
		this.broadcastId = broadcastId;
		this.details = details;
		this.imgurl = imgurl;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getBroadcastId() {
		return this.broadcastId;
	}

	public void setBroadcastId(String broadcastId) {
		this.broadcastId = broadcastId;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
		return "broadcastId=" + broadcastId + ", details="
				+ details + ", imgurl=" + imgurl + ", state=" + state
				+ ", remark=" + remark ;
	}
	

}