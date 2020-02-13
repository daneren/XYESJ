package esj.publicdoc.bean;
/***
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 下午4:54:12
 * @最后修改时间 2016-7-13 下午4:54:12
 * @描述 赞踩javabean
 * @version 1.0
 */
public class PraiseTreadBean {
	/**赞踩编号*/
	private String ptId;
	/**商品id*/
	private String proId;
	/**赞、踩   0代表赞   1代表踩*/
	private int ports;
	/**踩赞人id*/
	private String ptuserId;
	/**预留*/
	private String remark;
	
	
	public PraiseTreadBean() {
	}
	public PraiseTreadBean(String ptId, String proId, int ports, String ptuserId,
			String remark) {
		super();
		this.ptId = ptId;
		this.proId = proId;
		this.ports = ports;
		this.ptuserId = ptuserId;
		this.remark = remark;
	}
	public String getPtId() {
		return ptId;
	}
	public void setPtId(String ptId) {
		this.ptId = ptId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public int getPorts() {
		return ports;
	}
	public void setPorts(int ports) {
		this.ports = ports;
	}
	public String getPtuserId() {
		return ptuserId;
	}
	public void setPtuserId(String ptuserId) {
		this.ptuserId = ptuserId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
