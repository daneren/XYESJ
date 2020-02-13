package esj.front.products.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.front.products.dao.XTagsDao;
import esj.publicdoc.bean.TagsBean;
import esj.util.JdbcSourceUtil;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-28 下午3:01:15
 * @最后修改时间 2016-6-28 下午3:01:15
 * @描述
 * @version 1.0
 */
public class XTagsDaoImpl implements XTagsDao {

	public int insertTag(TagsBean bean) {
			QueryRunner runner = JdbcSourceUtil.getQueryRunner();
			String sql = "INSERT INTO tags( tagId,tagName,bdate,state) VALUES (?,?,?,?);";
			Object[] obj = new Object[]{
					bean.getTagId(),
					bean.getTagName(),
					bean.getBdate(),
					bean.getState()
			};
			int count = 0;
			try {
				count = runner.update(sql,obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
	}
	public int getTagTimesBytagName(String tagName) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from tags where tagName = '"+tagName+"'";
		TagsBean tagsBean=new TagsBean();
		try {
			
			tagsBean=runner.query(sql, new BeanHandler<TagsBean>(TagsBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tagsBean != null){
			return tagsBean.getTimes();
		}else{
			return 0;
		}
	}
	public int addOneTotimes(String tagName) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update tags set times=? where tagName = ?;";
		Object[] obj = new Object[]{getTagTimesBytagName(tagName)+1,tagName};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/***
	 * 按搜索热度排序tag
	 */
	public List<TagsBean> getTagsBytimesDesc(){
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from tags order by times desc;";
		List<TagsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<TagsBean>(TagsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
