package esj.publicdoc.bean;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:40:31
 * @����޸�ʱ�� 2016-6-26 ����9:40:31
 * @���� �˵���javabean
 * @version 1.0
 * @�ֶ�
 * `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) NOT NULL,
  `menuURL` varchar(100) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class MenusBean {

	// Fields
	/**�˵����*/
	private Integer menuId;
	/**�˵�����*/
	private String menuName;
	/**�˵��б�*/
	private String menuUrl;
	/**�˵�״̬*/
	private String state;
	/**Ԥ���ֶ�*/
	private String remark;

	// Constructors

	/** default constructor */
	public MenusBean() {
	}

	/** minimal constructor */
	public MenusBean(String menuName, String menuUrl, String state) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.state = state;
	}

	/** full constructor */
	public MenusBean(String menuName, String menuUrl, String state,
			String remark) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
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
		return "menuId=" + menuId + ", menuName=" + menuName
				+ ", menuUrl=" + menuUrl + ", state=" + state + ", remark="
				+ remark ;
	}
	
	

}