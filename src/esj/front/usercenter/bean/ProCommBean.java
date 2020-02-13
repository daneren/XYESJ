package esj.front.usercenter.bean;
/**
 * 我买过的商品，实体类（帮助类）
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午12:45:06
 * @最后修改时间 2016-7-1 上午12:45:06
 * @描述：
 * @version 1.0
 */
public class ProCommBean {
	/**预约状态,预约成功（我买到的），预约中，预约失败*/
	private String rstate;
	/**预约编号*/
	private String reservId;	
	/**预约编号*/
	private String collectId;
	/**商品名称*/
	private String title;	
	/**卖家编号*/
	private String sellerId;
	/**买家编号*/
	private String buyerId;
	/**预约人数*/
	private String ruCount;
	/**收藏人数*/
	private String cuCount;
	/**类别编号*/
	private Integer typeId;
	/**好评数*/
	private Integer pCount;
	/**差评数*/
	private Integer nCount;
	/**商品编号*/
	private String proId;
	/**商品描述*/
	private String details;
	/**照片地址*/
	private String photoAddr;
	/**商品折扣价*/
	private Float dprice;
	/**商品现价*/
	private Float cprice;
	/**商品买入价*/
	private Float oprice;
	/**商品买家出价*/
	private Float buyerPrice;
	/**成交日*/
	private String cjdate;
	/**开始日*/
	private String bdate;
	/**商品状态*/
	private String pstate;
	/**预留字段*/
	private String remark;
	
	
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getReservId() {
		return reservId;
	}
	public void setReservId(String reservId) {
		this.reservId = reservId;
	}
	public Integer getpCount() {
		return pCount;
	}
	public void setpCount(Integer pCount) {
		this.pCount = pCount;
	}
	public Integer getnCount() {
		return nCount;
	}
	public void setnCount(Integer nCount) {
		this.nCount = nCount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Float getCprice() {
		return cprice;
	}
	public void setCprice(Float cprice) {
		this.cprice = cprice;
	}
	public Float getOprice() {
		return oprice;
	}
	public void setOprice(Float oprice) {
		this.oprice = oprice;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getRuCount() {
		return ruCount;
	}
	public void setRuCount(String ruCount) {
		this.ruCount = ruCount;
	}
	public String getCuCount() {
		return cuCount;
	}
	public void setCuCount(String cuCount) {
		this.cuCount = cuCount;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getPhotoAddr() {
		return photoAddr;
	}
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}
	public Float getDprice() {
		return dprice;
	}
	public void setDprice(Float dprice) {
		this.dprice = dprice;
	}
	public Float getBuyerPrice() {
		return buyerPrice;
	}
	public void setBuyerPrice(Float buyerPrice) {
		this.buyerPrice = buyerPrice;
	}
	public String getCjdate() {
		return cjdate;
	}
	public void setCjdate(String cjdate) {
		this.cjdate = cjdate;
	}
	public String getPstate() {
		return pstate;
	}
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
