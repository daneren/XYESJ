package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:43:34
 * @最后修改时间 2016-6-26 上午9:43:34
 * @描述 预订表 javabean
 * @version 1.0
 * @字段
 * `reservId` varchar(50) NOT NULL,
  `proId` varchar(50) NOT NULL,
  `buyerId` varchar(50) NOT NULL,
  `sellerId` varchar(50) NOT NULL,
  `buyerPrice` float NOT NULL,
  `reservdate` varchar(30) NOT NULL,
  `cjdate` varchar(30) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public  class ReservesBean{

	// Fields
	/**预定编号*/
	private String reservId;
	/**商品编号*/
	private String proId;
	/**买家编号*/
	private String buyerId;
	/**卖家编号*/
	private String sellerId;
	/**买家出价*/
	private Float buyerPrice;
	/**预定日期*/
	private String reservdate;
	/**成交日期*/
	private String cjdate;
	/**预定状态*/
	private String state;
	/**预留字段*/
	private String remark;
	/**外键数组：买家*/
	private List<UsersBean> bUsers;
	/**外键数组：卖家*/
	private List<UsersBean> sUsers;
	/**外键数组：商品表*/
	private List<ProductsBean> products;
	
	
	
	// Constructors

	public List<UsersBean> getbUsers() {
		return bUsers;
	}

	public void setbUsers(List<UsersBean> bUsers) {
		this.bUsers = bUsers;
	}

	public List<UsersBean> getsUsers() {
		return sUsers;
	}

	public void setsUsers(List<UsersBean> sUsers) {
		this.sUsers = sUsers;
	}

	public List<ProductsBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsBean> products) {
		this.products = products;
	}

	/** default constructor */
	public ReservesBean() {
	}

	/** minimal constructor */
	public ReservesBean(String reservId, String proId, String buyerId,
			String sellerId, Float buyerPrice, String reservdate,
			String cjdate, String state) {
		this.reservId = reservId;
		this.proId = proId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.buyerPrice = buyerPrice;
		this.reservdate = reservdate;
		this.cjdate = cjdate;
		this.state = state;
	}

	/** full constructor */
	public ReservesBean(String reservId, String proId, String buyerId,
			String sellerId, Float buyerPrice, String reservdate,
			String cjdate, String state, String remark) {
		this.reservId = reservId;
		this.proId = proId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.buyerPrice = buyerPrice;
		this.reservdate = reservdate;
		this.cjdate = cjdate;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getReservId() {
		return this.reservId;
	}

	public void setReservId(String reservId) {
		this.reservId = reservId;
	}

	public String getProId() {
		return this.proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Float getBuyerPrice() {
		return this.buyerPrice;
	}

	public void setBuyerPrice(Float buyerPrice) {
		this.buyerPrice = buyerPrice;
	}

	public String getReservdate() {
		return this.reservdate;
	}

	public void setReservdate(String reservdate) {
		this.reservdate = reservdate;
	}

	public String getCjdate() {
		return this.cjdate;
	}

	public void setCjdate(String cjdate) {
		this.cjdate = cjdate;
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
		return "Reserves [reservId=" + reservId + ", proId=" + proId
				+ ", buyerId=" + buyerId + ", sellerId=" + sellerId
				+ ", buyerPrice=" + buyerPrice + ", reservdate=" + reservdate
				+ ", cjdate=" + cjdate + ", state=" + state + ", remark="
				+ remark;
	}
	
	

}