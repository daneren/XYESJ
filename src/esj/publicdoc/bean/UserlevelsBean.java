package esj.publicdoc.bean;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:48:31
 * @����޸�ʱ�� 2016-6-26 ����9:48:31
 * @���� �û��ȼ���javabean
 * @version 1.0
 * @�ֶ�
 *  `levelId` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(50) NOT NULL,
  `upperLimit` int(11) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class UserlevelsBean{

	// Fields
	/**�ȼ����*/
	private Integer levelId;
	/**�ȼ�����*/
	private String levelName;
	/**�ȼ�����*/
	private Integer upperLimit;
	/**Ԥ���ֶ�*/
	private String remark;

	// Constructors

	/** default constructor */
	public UserlevelsBean() {
	}

	/** minimal constructor */
	public UserlevelsBean(String levelName, Integer upperLimit) {
		this.levelName = levelName;
		this.upperLimit = upperLimit;
	}

	/** full constructor */
	public UserlevelsBean(int levelId, String levelName, Integer upperLimit,
			String remark) {
		this.levelId = levelId;
		this.levelName = levelName;
		this.upperLimit = upperLimit;
		this.remark = remark;
	}

	// Property accessors

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getUpperLimit() {
		return this.upperLimit;
	}

	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "levelId=" + levelId + ", levelName=" + levelName
				+ ", upperLimit=" + upperLimit + ", remark=" + remark ;
	}
	
	

}