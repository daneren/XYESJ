package esj.publicdoc.bean;


/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-26 ����9:49:20
 * @����޸�ʱ�� 2016-6-26 ����9:49:20
 * @���� �û���javabean
 * @version 1.0
 * @�ֶ�
 *  `userId` varchar(50) NOT NULL,
  `userPhone` varchar(50) DEFAULT NULL,
  `userName` varchar(30) NOT NULL,
  `userPwd` varchar(30) NOT NULL,
  `rigistDay` varchar(30) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthDay` varchar(30) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `entranceDay` varchar(30) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `empirical` int(11) DEFAULT NULL,
  `creditPoints` int(11) DEFAULT NULL,
  `iconAddr` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
 */

public class UsersBean{

	// Fields
	/**�û����*/
	private String userId;
	/**�û���½�˺� �ֻ���*/
	private String userPhone;
	/**�û�����*/
	private String userName;
	/**�û���½����*/
	private String userPwd;
	/**�û�ע������*/
	private String rigistDay;
	/**�û��Ա�*/
	private String sex;
	/**�û�����*/
	private String birthDay;
	/**�û�ѧУ*/
	private String school;
	/**�û�ѧԺ*/
	private String department;
	/**�û�רҵ*/
	private String major;
	/**�û���ѧ����*/
	private String entranceDay;
	/**�û�״̬*/
	private String state;
	/**�û�����ֵ*/
	private Integer empirical;
	/**�û�������*/
	private Integer creditPoints;
	/**�û�ͷ���ַ*/
	private String iconAddr;
	/**�û�����*/
	private String email;
	/**Ԥ���ֶ�*/
	private String remark;

	// Constructors

	/** default constructor */
	public UsersBean() {
	}

	/** minimal constructor */
	public UsersBean(String userId, String userPhone, String userName,
			String userPwd, String rigistDay) {
		this.userId = userId;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userPwd = userPwd;
		this.rigistDay = rigistDay;
	}

	/** full constructor */
	

	// Property accessors
	
	public String getUserId() {
		return this.userId;
	}

	public UsersBean(String userId, String userPhone, String userName,
			String userPwd, String rigistDay, String sex, String birthDay,
			String school, String department, String major, String entranceDay,
			String state, Integer empirical, Integer creditPoints,
			String iconAddr, String email, String remark) {
		super();
		this.userId = userId;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userPwd = userPwd;
		this.rigistDay = rigistDay;
		this.sex = sex;
		this.birthDay = birthDay;
		this.school = school;
		this.department = department;
		this.major = major;
		this.entranceDay = entranceDay;
		this.state = state;
		this.empirical = empirical;
		this.creditPoints = creditPoints;
		this.iconAddr = iconAddr;
		this.email = email;
		this.remark = remark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getRigistDay() {
		return this.rigistDay;
	}

	public void setRigistDay(String rigistDay) {
		this.rigistDay = rigistDay;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEntranceDay() {
		return this.entranceDay;
	}

	public void setEntranceDay(String entranceDay) {
		this.entranceDay = entranceDay;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getEmpirical() {
		return this.empirical;
	}

	public void setEmpirical(Integer empirical) {
		this.empirical = empirical;
	}

	public Integer getCreditPoints() {
		return this.creditPoints;
	}

	public void setCreditPoints(Integer creditPoints) {
		this.creditPoints = creditPoints;
	}

	public String getIconAddr() {
		return this.iconAddr;
	}

	public void setIconAddr(String iconAddr) {
		this.iconAddr = iconAddr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "userId=" + userId + ", userPhone=" + userPhone
				+ ", userName=" + userName + ", userPwd=" + userPwd
				+ ", rigistDay=" + rigistDay + ", sex=" + sex + ", birthDay="
				+ birthDay + ", shool=" + school + ", department=" + department
				+ ", major=" + major + ", entranceDay=" + entranceDay
				+ ", state=" + state + ", empirical=" + empirical
				+ ", creditPoints=" + creditPoints + ", iconAddr=" + iconAddr
				+ ", email=" + email + ", remark=" + remark ;
	}

	
	
	

}