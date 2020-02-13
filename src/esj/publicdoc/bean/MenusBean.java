package esj.publicdoc.bean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:40:31
 * @最后修改时间 2016-6-26 上午9:40:31
 * @描述 菜单表javabean
 * @version 1.0
 * @字段
 * `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) NOT NULL,
  `menuURL` varchar(100) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class MenusBean {

	// Fields
	/**菜单编号*/
	private Integer menuId;
	/**菜单名称*/
	private String menuName;
	/**菜单列表*/
	private String menuUrl;
	/**菜单状态*/
	private String state;
	/**预留字段*/
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