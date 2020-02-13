package esj.back.control.tag.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import esj.back.control.tag.dao.TagsBeanDao;
import esj.publicdoc.bean.TagsBean;
import esj.util.JdbcSourceUtil;

public class TagsBeanDaoImpl implements TagsBeanDao {

	public int updateTagsStateById(TagsBean tagsBean) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update tags set state = ?where tagId=?;";
		Object[] obj = new Object[]{tagsBean.getState(),tagsBean.getTagId()};
		int count=0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int updateTagsById(TagsBean tagsBean) {
		//System.out.println(tagsBean);
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		
		String sql = "UPDATE tags set tagName=?,typeId=?,score=? where tagId = ?";
		
		Object[] obj = new Object[]{	
				tagsBean.getTagName(),
				tagsBean.getTypeId(),
				tagsBean.getScore(),
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

}
