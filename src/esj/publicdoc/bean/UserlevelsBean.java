package esj.publicdoc.bean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:48:31
 * @最后修改时间 2016-6-26 上午9:48:31
 * @描述 用户等级表javabean
 * @version 1.0
 * @字段
 *  `levelId` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(50) NOT NULL,
  `upperLimit` int(11) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class UserlevelsBean{

	// Fields
	/**等级编号*/
	private Integer levelId;
	/**等级名称*/
	private String levelName;
	/**等级上限*/
	private Integer upperLimit;
	/**预留字段*/
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