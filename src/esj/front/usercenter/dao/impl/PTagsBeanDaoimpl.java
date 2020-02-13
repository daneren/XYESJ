package esj.front.usercenter.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import esj.front.usercenter.dao.PTagsBeanDao;
import esj.publicdoc.bean.TagsBean;
import esj.publicdoc.bean.UsersBean;
import esj.util.JdbcSourceUtil;

public class PTagsBeanDaoimpl implements PTagsBeanDao {

	public int insertList(List<String> tagId ,Integer typeId,List<String> tags,String bdate,String state) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO tags(tagId,tagName,times,typeId,score,bdate,state) VALUES (?,?,?,?,?,?,?);";
		int count = 0;
		for(int i=0;i<tags.size();i++){
			Object[] obj = new Object[]{tagId.get(i),tags.get(i),1,typeId,0,bdate,state};		
			try {
				count += runner.update(sql,obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<String> getTags(String tags) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String[] s= tags.split(",");
		String p = "";
		for(int i=0;i<s.length;i++){
			p +="'"+s[i]+"',";
		}
		p = p.substring(0, p.lastIndexOf(","));
		String sql = "SELECT tagName from tags where tagName in("+p+");";
		List<TagsBean> tBeans = null;
			try {
				tBeans = runner.query(sql, new BeanListHandler<TagsBean>(TagsBean.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		p = "";
		List<String> list = new ArrayList<String>();
		for(TagsBean t:tBeans){
			list.add(t.getTagName());
		}
				
		return list;
	}

	public int upadateCounts(List<String> tags, int count) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update tags set times = times+ "+count+" where tagName = ?;";
		int count1 = 0;
		for(String t:tags){
			try {
				count1 += runner.update(sql,t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count1;
	}

	public List<TagsBean> getTagsByTyList(String typeId, int count) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "SELECT tagName FROM `tags` WHERE typeId IN ("+typeId+") AND state = '“—∆Ù”√' ORDER BY times DESC LIMIT ?;";
		List<TagsBean> tags = null;
	
		try {
			tags = runner.query(sql, new BeanListHandler<TagsBean>(TagsBean.class), count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}

}
