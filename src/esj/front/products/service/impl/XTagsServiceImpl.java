package esj.front.products.service.impl;

import java.util.List;

import esj.front.products.dao.impl.XTagsDaoImpl;
import esj.front.products.service.XTagsService;
import esj.publicdoc.bean.TagsBean;
import esj.util.DateHelper;
import esj.util.Random100;

public class XTagsServiceImpl implements XTagsService {
private XTagsDaoImpl dao = new XTagsDaoImpl();
	public int insertTag(TagsBean bean) {
		bean.setTagId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		bean.setBdate(DateHelper.getDateTimeFormat());
		return dao.insertTag(bean);
	}
	public int addOneTotimes(String tagName) {
		return dao.addOneTotimes(tagName);
	}
	public int getTagTimesById(String tagName) {
		// TODO Auto-generated method stub
		return dao.getTagTimesBytagName(tagName);
	}
	public List<TagsBean> getTagsBytimesDesc() {
		// TODO Auto-generated method stub
		return dao.getTagsBytimesDesc();
	}

}
