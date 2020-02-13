package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:39:06
 * @����޸�ʱ�� 2016-6-26 ����9:39:06
 * @���� �ղر�javabean
 * @version 1.0
 * @�ֶ�
 * `collectId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `proId` varchar(50) NOT NULL,
  `bdate` varchar(30) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class CollectsBean {

	// Fields
	/**�ղر��*/
	private String collectId;
	/**��ұ��*/
	private String userId;
	/**��Ʒ��ź�*/
	private String proId;
	/**�ղ�����*/
	private String bdate;
	/**�ղ�״̬*/
	private String state;
	/**Ԥ���ֶ�*/
	private String remark;
	/**������飺�û���*/
	private List<UsersBean> usersBean;
	/**������飺��Ʒ��*/
	private List<ProductsBean> productsBean;
	
	// Constructors

	

	/** default constructor */
	public CollectsBean() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bdate == null) ? 0 : bdate.hashCode());
		result = prime * result
				+ ((collectId == null) ? 0 : collectId.hashCode());
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		result = prime * result
				+ ((productsBean == null) ? 0 : productsBean.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((usersBean == null) ? 0 : usersBean.hashCode());
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
		CollectsBean other = (CollectsBean) obj;
		if (bdate == null) {
			if (other.bdate != null)
				return false;
		} else if (!bdate.equals(other.bdate))
			return false;
		if (collectId == null) {
			if (other.collectId != null)
				return false;
		} else if (!collectId.equals(other.collectId))
			return false;
		if (proId == null) {
			if (other.proId != null)
				return false;
		} else if (!proId.equals(other.proId))
			return false;
		if (productsBean == null) {
			if (other.productsBean != null)
				return false;
		} else if (!productsBean.equals(other.productsBean))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (usersBean == null) {
			if (other.usersBean != null)
				return false;
		} else if (!usersBean.equals(other.usersBean))
			return false;
		return true;
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
	public CollectsBean(String collectId, String userId, String proId,
			String bdate, String state) {
		this.collectId = collectId;
		this.userId = userId;
		this.proId = proId;
		this.bdate = bdate;
		this.state = state;
	}

	/** full constructor */
	public CollectsBean(String collectId, String userId, String proId,
			String bdate, String state, String remark) {
		this.collectId = collectId;
		this.userId = userId;
		this.proId = proId;
		this.bdate = bdate;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getCollectId() {
		return this.collectId;
	}

	public void setCollectId(String collectId) {
		this.collectId = collectId;
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

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
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
		return "collectId=" + collectId + ", userId=" + userId
				+ ", proId=" + proId + ", bdate=" + bdate + ", state=" + state
				+ ", remark=" + remark;
	}
	
	

}