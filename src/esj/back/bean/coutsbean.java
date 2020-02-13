package esj.back.bean;

public class coutsbean {
	// Fields
		/**用户编号*/
		private String userId;
		/**用户登陆账号 手机号*/
		private String userPhone;
		/**用户姓名*/
		private String userName;
		/**用户登陆密码*/
		private String userPwd;
		/**用户注册日期*/
		private String rigistDay;
		/**用户性别*/
		private String sex;
		/**用户生日*/
		private String birthDay;
		/**用户学校*/
		private String school;
		/**用户学院*/
		private String department;
		/**用户专业*/
		private String major;
		/**用户入学日期*/
		private String entranceDay;
		/**用户状态*/
		private String state;
		/**用户经验值*/
		private Integer empirical;
		/**用户信誉分*/
		private Integer creditPoints;
		/**用户头像地址*/
		private String iconAddr;
		/**用户邮箱*/
		private String email;
		/**预留字段*/
		private String remark;
		/*发布商品数*/
		private int pproducts;
		/*发布需求数*/
		private int pdemands;
		/*购买商品数*/
		private int bproducts;
		/*预约商品数*/
		private int rproducts;

		// Constructors

		public int getPproducts() {
			return pproducts;
		}

		public void setPproducts(int pproducts) {
			this.pproducts = pproducts;
		}

		public int getPdemands() {
			return pdemands;
		}

		public void setPdemands(int pdemands) {
			this.pdemands = pdemands;
		}

		public int getBproducts() {
			return bproducts;
		}

		public void setBproducts(int bproducts) {
			this.bproducts = bproducts;
		}

		public int getRproducts() {
			return rproducts;
		}

		public void setRproducts(int rproducts) {
			this.rproducts = rproducts;
		}

		/** default constructor */
		public coutsbean() {
		}

		/** minimal constructor */
		public coutsbean(String userId, String userPhone, String userName,
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

		public coutsbean(String userId, String userPhone, String userName,
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
			return "coutsbean [userId=" + userId + ", userPhone=" + userPhone
					+ ", userName=" + userName + ", userPwd=" + userPwd
					+ ", rigistDay=" + rigistDay + ", sex=" + sex
					+ ", birthDay=" + birthDay + ", school=" + school
					+ ", department=" + department + ", major=" + major
					+ ", entranceDay=" + entranceDay + ", state=" + state
					+ ", empirical=" + empirical + ", creditPoints="
					+ creditPoints + ", iconAddr=" + iconAddr + ", email="
					+ email + ", remark=" + remark + ", pproducts=" + pproducts
					+ ", pdemands=" + pdemands + ", bproducts=" + bproducts
					+ ", rproducts=" + rproducts + "]";
		}

		
		
		

	}