package esj.front.usercenter.bean;
/**
 * ���������Ʒ��ʵ���ࣨ�����ࣩ
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-7-1 ����12:45:06
 * @����޸�ʱ�� 2016-7-1 ����12:45:06
 * @������
 * @version 1.0
 */
public class ProCommBean {
	/**ԤԼ״̬,ԤԼ�ɹ������򵽵ģ���ԤԼ�У�ԤԼʧ��*/
	private String rstate;
	/**ԤԼ���*/
	private String reservId;	
	/**ԤԼ���*/
	private String collectId;
	/**��Ʒ����*/
	private String title;	
	/**���ұ��*/
	private String sellerId;
	/**��ұ��*/
	private String buyerId;
	/**ԤԼ����*/
	private String ruCount;
	/**�ղ�����*/
	private String cuCount;
	/**�����*/
	private Integer typeId;
	/**������*/
	private Integer pCount;
	/**������*/
	private Integer nCount;
	/**��Ʒ���*/
	private String proId;
	/**��Ʒ����*/
	private String details;
	/**��Ƭ��ַ*/
	private String photoAddr;
	/**��Ʒ�ۿۼ�*/
	private Float dprice;
	/**��Ʒ�ּ�*/
	private Float cprice;
	/**��Ʒ�����*/
	private Float oprice;
	/**��Ʒ��ҳ���*/
	private Float buyerPrice;
	/**�ɽ���*/
	private String cjdate;
	/**��ʼ��*/
	private String bdate;
	/**��Ʒ״̬*/
	private String pstate;
	/**Ԥ���ֶ�*/
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
