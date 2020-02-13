package esj.front.products.service.impl;

import java.util.List;

import esj.front.products.dao.XLnotesDao;
import esj.front.products.dao.impl.XLnotesDaoImpl;
import esj.front.products.service.XLnotesService;
import esj.publicdoc.bean.LnotesBean;
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-7-13 上午11:56:05
 * @最后修改时间 2016-7-13 上午11:56:05
 * @描述
 * @version 1.0
 */
public class XLnotesServiceImpl implements XLnotesService {
	XLnotesDao dao = new XLnotesDaoImpl();
	public List<LnotesBean> getLnotesByProId(String proId) {
		return dao.getLnotesByProId(proId);
	}
	
	public String getByProId(String proId, String userId) {
		// TODO Auto-generated method stub
		return dao.getByProId(proId, userId);
	}
}
