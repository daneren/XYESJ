package esj.front.usercenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import esj.front.usercenter.dao.PTagsBeanDao;
import esj.front.usercenter.dao.impl.PTagsBeanDaoimpl;
import esj.front.usercenter.service.PTagsBeanService;
import esj.publicdoc.bean.TagsBean;
import esj.util.DateHelper;

public class PTagsBeanServiceimpl implements PTagsBeanService {
	private PTagsBeanDao pTagsBeanDao = new PTagsBeanDaoimpl();
	public int insertList(Integer typeId, String[] tags, String state) {
		if(tags.length<=0){
			return -1;
		}
		List<String> l = new ArrayList<String>();		
		List<String> tagId = new ArrayList<String>();
		String time = DateHelper.getDateTimeForNumber();//年月日时分秒
		for(int i =0;i<tags.length;i++){
			l.add(tags[i]);
			tagId.add(time+i+"");
		}
		System.out.println(l.size()+":"+tagId.size());
		return pTagsBeanDao.insertList(tagId,
				typeId, l, DateHelper.getDateTimeFormatDuan(),state);
	}

	public int updateTags(Integer typeId,String tags, String state,int count) {
		if(tags.trim().equals("") || tags == null){
			return 0;
		}
		int counts = 0;
		List<String> ts = pTagsBeanDao.getTags(tags);//已存在的标签
		List<String> l = new ArrayList<String>();//用户数据
		List<String> tagId = new ArrayList<String>();//标签编号
		String time = DateHelper.getDateTimeForNumber();//年月日时分秒
		if(tags.lastIndexOf(",")>0){
			String[] tag = tags.split(",");
			for(int i =0;i<tag.length;i++){
				l.add(tag[i]);
				tagId.add(time+i+"");
			}

		}else{
			l.add(tags);
			tagId.add(time+1+"");
		}
		if(ts != null && ts.size()>0){
			l.removeAll(ts);
			counts = pTagsBeanDao.upadateCounts(ts, count);
		}
		if(l!=null && l.size()>0){
			counts =pTagsBeanDao.insertList(tagId,typeId, l, 
					DateHelper.getDateTimeFormatDuan(),state);				
		}
		return counts;
	}

	public List<TagsBean> getTagsByTyList(String typeId, int count) {
		if("".equals(typeId.trim()) || typeId==null || count<=0){
			return null;
		}
		return pTagsBeanDao.getTagsByTyList(typeId, count);
	}

}
