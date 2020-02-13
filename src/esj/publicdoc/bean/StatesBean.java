package esj.publicdoc.bean;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:45:45
 * @����޸�ʱ�� 2016-6-26 ����9:45:45
 * @���� ״̬��javabean
 * @version 1.0
 * @�ֶ�
 * `stateId` int(11) NOT NULL AUTO_INCREMENT,
  `stateName` varchar(30) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */
public class StatesBean{

	// Fields
	/**״̬���*/
	private Integer stateId;
	/**״̬����*/
	private String stateName;
	/**״̬*/
	private String state;
	/**Ԥ���ֶ�*/
	private String remark;

	// Constructors

	/** default constructor */
	public StatesBean() {
	}

	/** minimal constructor */
	public StatesBean(String stateName, String state) {
		this.stateName = stateName;
		this.state = state;
	}

	/** full constructor */
	public StatesBean(String stateName, String state, String remark) {
		this.stateName = stateName;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
		return "stateId=" + stateId + ", stateName=" + stateName
				+ ", state=" + state + ", remark=" + remark ;
	}
	
	

}