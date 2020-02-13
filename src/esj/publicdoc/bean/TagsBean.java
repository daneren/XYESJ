package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:46:05
 * @����޸�ʱ�� 2016-6-26 ����9:46:05
 * @���� ��ǩ��javabean
 * @version 1.0
 * @�ֶ�
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
	/**��ǩ���*/
	private String tagId;
	/**��ǩ����*/
	private String tagName;
	/**ʹ�ô���*/
	private Integer times;
	/**�����*/
	private Integer typeId;
	/**�ȶȷ���*/
	private Float score;
	/**��������*/
	private String bdate;
	/**��ǩ״̬*/
	private String state;
	/**Ԥ��״̬*/
	private String remark;
	/**������飺����*/
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