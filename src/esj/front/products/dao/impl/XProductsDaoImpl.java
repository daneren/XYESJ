package esj.front.products.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import esj.front.products.dao.XProductDao;
import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.PraiseTreadBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ReservesBean;
import esj.util.DateHelper;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 下午5:19:10
 * @最后修改时间 2016-7-13 下午5:19:10
 * @描述
 * @version 1.0
 */
public class XProductsDaoImpl implements XProductDao {

	public List<ProductsBean> getNewProducts() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String date = (Integer.parseInt(DateHelper.getDateTimeFormatDuan().replace("-", ""))-10)+"000000000";
		//System.out.println(date);
		String sql = "select * from products where state='出售中'  and proId >='"+date+"' ORDER BY proid desc;";
		//System.out.println(sql);
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductsBean> getGraduateProducts() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from products where state='出售中' or state = '交易中' ORDER BY proid desc;";
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductsBean> getPushProductsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "";
		if(id == null){
			sql = "select * from products where state='出售中' or state = '交易中' ORDER BY proid desc;";
		}else{
			sql = "select * from products where state='出售中' or state = '交易中' and userId = "+id+" ORDER BY proid desc;";
		}
		
		List<ProductsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getPraiseCountByProId(String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) as ports from praisetread where proId=? and ports=0;";
		//Object[] obj = new Object[]{proId};
		PraiseTreadBean bean = null;
		try {
			//count = Integer.parseInt(runner.query(sql, new ScalarHandler<Long>() ,obj).toString());
			bean = runner.query(sql,new BeanHandler<PraiseTreadBean>(PraiseTreadBean.class), proId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean.getPorts();
	}

	public int getTreadCountByProId(String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from praisetread where proId=? and ports=1;";
		Object[] obj = new Object[]{proId};
		int count = 0;
		try {
			count = Integer.parseInt(runner.query(sql, new ScalarHandler<Long>() ,obj).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int praiseProduct(PraiseTreadBean ptb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into praisetread(ptId,proId,ports,ptuserId) values(?,?,?,?);";
		Object[] obj = new Object[]{ptb.getPtId(),ptb.getProId(),0,ptb.getPtuserId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int treadProduct(PraiseTreadBean ptb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into praisetread(ptId,proId,ports,ptuserId) values(?,?,?,?);";
		Object[] obj = new Object[]{ptb.getPtId(),ptb.getProId(),1,ptb.getPtuserId()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean isTreadOrPraise(String userId, String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from praisetread where proId=? and ptuserId = ?;";
		Object[] obj = new Object[]{proId,userId};
		PraiseTreadBean bean = null;
		boolean flag = false;
		try {
			bean = runner.query(sql,new BeanHandler<PraiseTreadBean>(PraiseTreadBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(bean != null){
			flag = true;
		}
		return flag;
	}

	public int collectCountByProId(String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from collects where proId=? and state='启用';";
		Object[] obj = new Object[]{proId};
		int count = 0;
		try {
			count = Integer.parseInt(runner.query(sql, new ScalarHandler<Long>() ,obj).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean isCollected(String userId, String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from collects where proId=? and userId = ?;";
		Object[] obj = new Object[]{proId,userId};
		CollectsBean bean = null;
		boolean flag = false;
		try {
			bean = runner.query(sql,new BeanHandler<CollectsBean>(CollectsBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(bean != null){
			flag = true;
		}
		return flag;
	}

	public int collectProduct(CollectsBean collect) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into collects(collects.collectId,collects.userId,collects.proId,collects.bdate,collects.state) values(?,?,?,?,?);";
		Object[] obj = new Object[]{collect.getCollectId(),collect.getUserId(),collect.getProId(),collect.getBdate(),collect.getState()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@SuppressWarnings("null")
	public List<ProductsBean> searchProducts(String keyWords,String typeids) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		List<ProductsBean> list = new ArrayList<ProductsBean>();
		if(typeids != null && typeids.trim() != ""){
			if(typeids.contains("-")){
				String[] types = typeids.split("-");
				for(String type:types){
					String sql = "select * from products where state='出售中' and typeId=? ORDER BY proId desc;";
					try {
						
						list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class),Integer.parseInt(type)));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}else{
				String sql = "select * from products where state='出售中' and typeId=? ORDER BY proId desc;";
				try {
					
					list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class),Integer.parseInt(typeids)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(keyWords.contains(" ")){
			String[] keys = keyWords.split(" ");
			for(String key:keys){
				String sql = "select * from products where state='出售中' and title like '%"+key+"%' ORDER BY proId desc;";
				try {
					
					list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(String key:keys){
				String sql = "select * from products where state='出售中' and  details like '%"+key+"%' ORDER BY proId desc;";
				try {
					list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(String key:keys){
				String sql = "select * from products where state='出售中' and  tagName like '%"+key+"%' ORDER BY proId desc;";
				try {
					list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			String sql = "select * from products where state='出售中' and title like '%"+keyWords+"%' ORDER BY proId desc;";
			try {
				list.addAll(runner.query(sql, new BeanListHandler<ProductsBean>(ProductsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql1 = "select * from products where state='出售中' and details like '%"+keyWords+"%' ORDER BY proId desc;";
			try {
				list.addAll(runner.query(sql1, new BeanListHandler<ProductsBean>(ProductsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql2 = "select * from products where state='出售中' and tagName like '%"+keyWords+"%' ORDER BY proId desc;";
			try {
				list.addAll(runner.query(sql2, new BeanListHandler<ProductsBean>(ProductsBean.class)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    
		 List<ProductsBean> tempList= new ArrayList<ProductsBean>();  
		    for(ProductsBean i:list){
		        if(!tempList.contains(i)){
		            tempList.add(i);  
		        }  
		    }  
		
		return tempList;
	}
	
	/**
	 *作者：朱志玉 
	 * 设置评分,分数，总评分数*/
	public int updateScore(String score,String proId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update  products set remark = ? where proId=?";
		Object[] params = {score,proId};
		int count = 0;
		try {
			count = runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ProductsBean> getProByTag(String tag) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		List<ProductsBean> list = new ArrayList<ProductsBean>();
		String sql2 = "select * from products where state='出售中' and tagName like '%"+tag+"%' ORDER BY proId desc;";
		try {
			list.addAll(runner.query(sql2, new BeanListHandler<ProductsBean>(ProductsBean.class)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getReserveCountByUserId(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT * from reserves where buyerId='"+userId+"' and state = '预约中'";
		List<ReservesBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<ReservesBean>(ReservesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list != null){
			for(int i = 0;i<list.size();i++){
				ReservesBean bean = list.get(i);
				for(int j = 0;j<list.size();j++){
					ReservesBean bean1 = list.get(j);
					if(bean.getProId().equals(bean1.getProId())){
						if(bean.getBuyerPrice()<bean1.getBuyerPrice()){
							list.remove(j);
						}else if(bean.getBuyerPrice()>bean1.getBuyerPrice()){
							list.remove(i);
						}
					}
				}
			}
			return list.size();
		}else{
			return 0;
		}
		
		
	}

	public double getReservePriceCountByUserId(String userId) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT * from reserves where buyerId='"+userId+"' and state = '预约中';";
		List<ReservesBean> list = null;
		double count = 0;
		try {
			list = runner.query(sql, new BeanListHandler<ReservesBean>(ReservesBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list != null){
			for(int i = 0;i<list.size();i++){
				ReservesBean bean = list.get(i);
				for(int j = 0;j<list.size();j++){
					ReservesBean bean1 = list.get(j);
					if(bean.getProId().equals(bean1.getProId())){
						if(bean.getBuyerPrice()<bean1.getBuyerPrice()){
							list.remove(j);
						}else if(bean.getBuyerPrice()>bean1.getBuyerPrice()){
							list.remove(i);
						}
					}
				}
			}
			for(ReservesBean bean:list){
				count  += bean.getBuyerPrice();
			}
		}
		BigDecimal   b  =  new   BigDecimal(count); 
		double f1  =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return f1;
	}

	public int updateProductPcount(String proId,int pcount) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set pcount =? where proId = ?";
		Object[] obj = new Object[]{pcount,proId};
		int count = 0;
		try {
			count =runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateProductNcount(String proId,int ncount) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update products set pcount =? where proId = ?";
		Object[] obj = new Object[]{ncount,proId};
		int count = 0;
		try {
			count =runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	
}
