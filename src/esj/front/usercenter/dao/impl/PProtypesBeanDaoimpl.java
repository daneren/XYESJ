package esj.front.usercenter.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.usercenter.dao.PProtypesBeanDao;
import esj.publicdoc.bean.ProtypesBean;
import esj.util.JdbcSourceUtil;

public class PProtypesBeanDaoimpl implements PProtypesBeanDao {

	public List<ProtypesBean> getProType(ProtypesBean protypesBean) {
		int fatherId = protypesBean.getFatherId();
		int typeId = protypesBean.getTypeId();
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "";
		
		List<ProtypesBean> list = null;
		try {
			if(fatherId<0){
				sql = "select * from  protypes where fatherId >0";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class));
			}else if(fatherId >=0 && typeId<=0){
				sql = "select * from  protypes where fatherId=?";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class), fatherId);
			}else if(typeId >0){
				sql = "select * from  protypes where typeId=?";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class), typeId);
			}			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProtypesBean> getByArray(String typeIds, String fatherIds) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "";
		
		List<ProtypesBean> list = null;
		try {
			if(typeIds != null && fatherIds == null){
				sql = "select * from  protypes where typeId in("+typeIds+")";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class));
			}else if(typeIds == null && fatherIds != null){
				sql = "select * from  protypes where fatherId in("+fatherIds+")";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class));
			}else if(typeIds != null && fatherIds != null){
				String[] s = {typeIds,fatherIds};
				sql = "select * from  protypes where typeId in("+typeIds+") or fatherId in("+fatherIds+")";
				list = runner.query(sql, new BeanListHandler<ProtypesBean>(ProtypesBean.class));
			}			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
