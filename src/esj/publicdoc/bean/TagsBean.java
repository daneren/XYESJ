package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:46:05
 * @最后修改时间 2016-6-26 上午9:46:05
 * @描述 标签表javabean
 * @version 1.0
 * @字段
 * `tagId` varchar(50) NOT NULL,
  `tagName` varchar(30) NOT NULL,
  `times` int(11) NOT NULL DEFAULT '1',
  `typeId` int(11) NOT NULL,
  `score` float DEFAULT NULL,
  `bdate` varchar(30) NOT NULL,
  `state` varchar(10) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */
public class TagsBean{

	// Fields
	/**标签编号*/
	private String tagId;
	/**标签名称*/
	private String tagName;
	/**使用次数*/
	private Integer times;
	/**类别编号*/
	private Integer typeId;
	/**热度分数*/
	private Float score;
	/**创建日期*/
	private String bdate;
	/**标签状态*/
	private String state;
	/**预留状态*/
	private String remark;
	/**外键数组：类别表*/
	private List<ProtypesBean> protypes;
	
	

	// Constructors

	public List<ProtypesBean> getProtypes() {
		return protypes;
	}

	public void setProtypes(List<ProtypesBean> protypes) {
		this.protypes = protypes;
	}

	/** default constructor */
	public TagsBean() {
	}

	/** minimal constructor */
	public TagsBean(String tagId, String tagName, Integer times,
			Integer typeId, String bdate, String state) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.times = times;
		this.typeId = typeId;
		this.bdate = bdate;
		this.state = state;
	}

	/** full constructor */
	public TagsBean(String tagId, String tagName, Integer times,
			Integer typeId, Float score, String bdate, String state,
			String remark) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.times = times;
		this.typeId = typeId;
		this.score = score;
		this.bdate = bdate;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public String getTagId() {
		return this.tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
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
		return "tagId=" + tagId + ", tagName=" + tagName + ", times="
				+ times + ", typeId=" + typeId + ", score=" + score
				+ ", bdate=" + bdate + ", state=" + state + ", remark="
				+ remark;
	}
	
	

}