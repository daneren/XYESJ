package esj.publicdoc.bean;
/***
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-7-13 ����4:54:12
 * @����޸�ʱ�� 2016-7-13 ����4:54:12
 * @���� �޲�javabean
 * @version 1.0
 */
public class PraiseTreadBean {
	/**�޲ȱ��*/
	private String ptId;
	/**��Ʒid*/
	private String proId;
	/**�ޡ���   0������   1�����*/
	private int ports;
	/**������id*/
	private String ptuserId;
	/**Ԥ��*/
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
