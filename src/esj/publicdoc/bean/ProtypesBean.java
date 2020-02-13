package esj.publicdoc.bean;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:42:57
 * @最后修改时间 2016-6-26 上午9:42:57
 * @描述 类别表javabean
 * @version 1.0
 * @字段
 * `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) NOT NULL,
  `fatherId` int(11) NOT NULL,
  `childId` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
 * 
 */

public  class ProtypesBean{

	// Fields
	/**类别编号*/
	private Integer typeId;
	/**类别名称*/
	private String typeName;
	/**父类编号*/
	private Integer fatherId;
	/**子类编号 ，用逗号隔开*/
	private String childId;
	/**预留字段*/
	private String remark;
	
	

	// Constructors

	/** default constructor */
	public ProtypesBean() {
	}

	/** minimal constructor */
	public ProtypesBean(String typeName, Integer fatherId) {
		this.typeName = typeName;
		this.fatherId = fatherId;
	}

	/** full constructor */
	public ProtypesBean(String typeName, Integer fatherId, String childId,
			String remark) {
		this.typeName = typeName;
		this.fatherId = fatherId;
		this.childId = childId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public String getChildId() {
		return this.childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "typeId=" + typeId + ", typeName=" + typeName
				+ ", fatherId=" + fatherId + ", childId=" + childId
				+ ", remark=" + remark;
	}
	
	

}