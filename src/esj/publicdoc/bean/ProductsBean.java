package esj.publicdoc.bean;

import java.util.List;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-26 上午9:42:11
 * @最后修改时间 2016-6-26 上午9:42:11
 * @描述 商品表javabean
 * @version 1.0
 * @字段
 * `proId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `tagName` varchar(100) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `details` varchar(200) NOT NULL,
  `photoAddr` varchar(500) NOT NULL,
  `oprice` float NOT NULL,
  `cprice` float NOT NULL,
  `dprice` float NOT NULL,
  `bdate` varchar(50) NOT NULL,
  `edate` varchar(50) NOT NULL,
  `state` varchar(10) DEFAULT NULL,
  `nCount` int(11) DEFAULT '0',
  `pCount` int(11) DEFAULT '0',
  `vCount` int(11) DEFAULT '0',
  `remark` varchar(100) DEFAULT NULL
 */

public class ProductsBean{

	// Fields
	/**商品编号*/
	private String proId;
	/**用户编号：卖家编号*/
	private String userId;
	/**类别编号*/
	private Integer typeId;
	/**标签名称*/
	private String tagName;
	/**商品名称*/
	private String title;
	/**商品描述*/
	private String details;
	/**照片地址*/
	private String photoAddr;
	/**商品买入价格*/
	private Float oprice;
	/**商品出售价格*/
	private Float cprice;
	/**商品折扣价*/
	private Float dprice;
	/**商品发布日期*/
	private String bdate;
	/**商品下架日期*/
	private String edate;
	/**商品状态*/
	private String state;
	/**商品差评数*/
	private Integer ncount;
	/**商品好评数*/
	private Integer pcount;
	/**商品浏览数*/
	private Integer vcount;
	/**预留字段*/
	private String remark;
	/**外键数组：用户表*/
	private List<UsersBean> users;
	/**外键数组：类别表*/
	private List<ProtypesBean> protypes;
	/**平均分*/
	private float scores;
	/**评分次数*/
	private Integer counts;
	/**星星个数*/
	private String startc;

	// Constructors

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bdate == null) ? 0 : bdate.hashCode());
		result = prime * result + ((counts == null) ? 0 : counts.hashCode());
		result = prime * result + ((cprice == null) ? 0 : cprice.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((dprice == null) ? 0 : dprice.hashCode());
		result = prime * result + ((edate == null) ? 0 : edate.hashCode());
		result = prime * result + ((ncount == null) ? 0 : ncount.hashCode());
		result = prime * result + ((oprice == null) ? 0 : oprice.hashCode());
		result = prime * result + ((pcount == null) ? 0 : pcount.hashCode());
		result = prime * result
				+ ((photoAddr == null) ? 0 : photoAddr.hashCode());
		result = prime * result + ((proId == null) ? 0 : proId.hashCode());
		result = prime * result
				+ ((protypes == null) ? 0 : protypes.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + Float.floatToIntBits(scores);
		result = prime * result + ((startc == null) ? 0 : startc.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((vcount == null) ? 0 : vcount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductsBean other = (ProductsBean) obj;
		if (bdate == null) {
			if (other.bdate != null)
				return false;
		} else if (!bdate.equals(other.bdate))
			return false;
		if (counts == null) {
			if (other.counts != null)
				return false;
		} else if (!counts.equals(other.counts))
			return false;
		if (cprice == null) {
			if (other.cprice != null)
				return false;
		} else if (!cprice.equals(other.cprice))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (dprice == null) {
			if (other.dprice != null)
				return false;
		} else if (!dprice.equals(other.dprice))
			return false;
		if (edate == null) {
			if (other.edate != null)
				return false;
		} else if (!edate.equals(other.edate))
			return false;
		if (ncount == null) {
			if (other.ncount != null)
				return false;
		} else if (!ncount.equals(other.ncount))
			return false;
		if (oprice == null) {
			if (other.oprice != null)
				return false;
		} else if (!oprice.equals(other.oprice))
			return false;
		if (pcount == null) {
			if (other.pcount != null)
				return false;
		} else if (!pcount.equals(other.pcount))
			return false;
		if (photoAddr == null) {
			if (other.photoAddr != null)
				return false;
		} else if (!photoAddr.equals(other.photoAddr))
			return false;
		if (proId == null) {
			if (other.proId != null)
				return false;
		} else if (!proId.equals(other.proId))
			return false;
		if (protypes == null) {
			if (other.protypes != null)
				return false;
		} else if (!protypes.equals(other.protypes))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (Float.floatToIntBits(scores) != Float.floatToIntBits(other.scores))
			return false;
		if (startc == null) {
			if (other.startc != null)
				return false;
		} else if (!startc.equals(other.startc))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (vcount == null) {
			if (other.vcount != null)
				return false;
		} else if (!vcount.equals(other.vcount))
			return false;
		return true;
	}

	public float getScores() {
		int count = getCounts();
		String sc = getRemark().split(",")[0];
		float scs = Float.parseFloat(sc);
		if(count<=0){
			this.scores = scs;
		}else{
			this.scores = scs/count;
		}
		return scores;
	}

	public String getStartc() {
		getScores();
		int c = (int) (this.scores/2);
		float f= this.scores/2;
		int d = 0;
		if(f>(c*1.0)){
			d = 1;
		}
		this.startc = c+","+d;
		return startc;
	}

	public void setScores(float scores) {
		this.scores = scores;
	}

	public Integer getCounts() {
		String c = getRemark().split(",")[1];
		this.counts = Integer.parseInt(c);
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public List<ProtypesBean> getProtypes() {
		return protypes;
	}

	public void setProtypes(List<ProtypesBean> protypes) {
		this.protypes = protypes;
	}

	/** default constructor */
	public ProductsBean() {
	}

	/** minimal constructor */
	public ProductsBean(String proId, String userId, Integer typeId,
			String title, String details, String photoAddr, Float oprice,
			Float cprice, Float dprice, String bdate, String edate, String state,
			Integer ncount, Integer pcount, Integer vcount) {
		this.proId = proId;
		this.userId = userId;
		this.typeId = typeId;
		this.title = title;
		this.details = details;
		this.photoAddr = photoAddr;
		this.oprice = oprice;
		this.cprice = cprice;
		this.dprice = dprice;
		this.bdate = bdate;
		this.edate = edate;
		this.state = state;
		this.ncount = ncount;
		this.pcount = pcount;
		this.vcount = vcount;
	}

	/** full constructor */
	public ProductsBean(String proId, String userId, Integer typeId,
			String tagName, String title, String details, String photoAddr,
			Float oprice, Float cprice, Float dprice, String bdate, String edate,
			String state, Integer ncount, Integer pcount, Integer vcount,
			String remark) {
		this.proId = proId;
		this.userId = userId;
		this.typeId = typeId;
		this.tagName = tagName;
		this.title = title;
		this.details = details;
		this.photoAddr = photoAddr;
		this.oprice = oprice;
		this.cprice = cprice;
		this.dprice = dprice;
		this.bdate = bdate;
		this.edate = edate;
		this.state = state;
		this.ncount = ncount;
		this.pcount = pcount;
		this.vcount = vcount;
		this.remark = remark;
	}

	// Property accessors

	public String getProId() {
		return this.proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPhotoAddr() {
		return this.photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public Float getOprice() {
		return this.oprice;
	}

	public void setOprice(Float oprice) {
		this.oprice = oprice;
	}

	public Float getCprice() {
		return this.cprice;
	}

	public void setCprice(Float cprice) {
		this.cprice = cprice;
	}

	public Float getDprice() {
		return this.dprice;
	}

	public void setDprice(Float dprice) {
		this.dprice = dprice;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getEdate() {
		return this.edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNcount() {
		return this.ncount;
	}

	public void setNcount(Integer ncount) {
		this.ncount = ncount;
	}

	public Integer getPcount() {
		return this.pcount;
	}

	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}

	public Integer getVcount() {
		return this.vcount;
	}

	public void setVcount(Integer vcount) {
		this.vcount = vcount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Products [proId=" + proId + ", userId=" + userId + ", typeId="
				+ typeId + ", tagName=" + tagName + ", title=" + title
				+ ", details=" + details + ", photoAddr=" + photoAddr
				+ ", oprice=" + oprice + ", cprice=" + cprice + ", dprice="
				+ dprice + ", bdate=" + bdate + ", edate=" + edate + ", state="
				+ state + ", ncount=" + ncount + ", pcount=" + pcount
				+ ", vcount=" + vcount + ", remark=" + remark;
	}
	
	

}