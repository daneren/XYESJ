package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.LnotesBean;
import esj.publicdoc.dao.LnotesBeanDao;
import esj.publicdoc.dao.impl.LnotesBeanDaoimpl;
import esj.publicdoc.service.LnotesBeanService;
import esj.util.DateHelper;
import esj.util.IPToAddr;
import esj.util.Random100;
/**留言表 实现类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:29:18
 * @最后修改时间 2016-6-25 下午5:29:18
 * @描述 留言表 实现类
 * @version 1.0
 */
public class LnotesBeanServiceimpl implements LnotesBeanService {
private LnotesBeanDao dao = new LnotesBeanDaoimpl();
	public int saveLnotes(LnotesBean LnotesBean) {
		LnotesBean.setLeaveId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		LnotesBean.setBdate(DateHelper.getDateTimeFormat());
		LnotesBean.setIpAddr(IPToAddr.jiexiip( LnotesBean.getIp()));
		return dao.saveLnotes(LnotesBean);
	}

	public List<LnotesBean> findAllLnotes() {
		// TODO Auto-generated method stub
		return dao.findAllLnotes();
	}

	public int changeLnotesState(LnotesBean LnotesBean) {
		// TODO Auto-generated method stub
		return dao.changeLnotesState(LnotesBean);
	}

	public int updateLnotes(LnotesBean LnotesBean) {
		// TODO Auto-generated method stub
		return dao.updateLnotes(LnotesBean);
	}

	public LnotesBean findLnotesById(String id) {
		// TODO Auto-generated method stub
		return dao.findLnotesById(id);
	}

	

}
