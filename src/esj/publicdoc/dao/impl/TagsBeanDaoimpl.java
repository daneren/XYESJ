package esj.publicdoc.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import esj.publicdoc.bean.TagsBean;
import esj.publicdoc.dao.TagsBeanDao;
import esj.util.JdbcSourceUtil;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:45
 * @最后修改时间 2016-6-25 下午5:30:45
 * @描述 标签表操作类
 * @version 1.0
 */


public class TagsBeanDaoimpl implements TagsBeanDao {

	public int saveTags(TagsBean tagsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "INSERT INTO tags( tagId,tagName,times,typeId,score,bdate,state) VALUES (?,?,?,?,?,?,?);";
		Object[] obj = new Object[]{
				tagsBean.getTagId(),
				tagsBean.getTagName(),
				tagsBean.getTimes(),
				tagsBean.getTypeId(),
				tagsBean.getScore(),
				tagsBean.getBdate(),
				tagsBean.getState()
		};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<TagsBean> findAllTags() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from tags;";
		List<TagsBean> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<TagsBean>(TagsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int changeTagsState(TagsBean tagsBean) {
		
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE tags set  state=? where tagId = ?";
		
		Object[] obj = new Object[]{
				tagsBean.getState(),
				tagsBean.getTagId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateTags(TagsBean tagsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE tags set tagName=?,times=?,typeId=?,score=?,state=? where tagId = ?";
		
		Object[] obj = new Object[]{	
				tagsBean.getTagName(),
				tagsBean.getTimes(),
				tagsBean.getTagId(),
				tagsBean.getScore(),
				tagsBean.getState(),
				tagsBean.getTagId()
		};
		
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public TagsBean findTagsById(String id) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from tags where tagId ='"+id+"'";
		TagsBean tagsBean=new TagsBean();
		try {
			
			tagsBean=runner.query(sql, new BeanHandler<TagsBean>(TagsBean.class));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tagsBean;
	}
}
