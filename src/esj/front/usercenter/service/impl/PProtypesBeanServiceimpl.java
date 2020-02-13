package esj.front.usercenter.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import esj.front.usercenter.dao.PProtypesBeanDao;
import esj.front.usercenter.dao.impl.PProtypesBeanDaoimpl;
import esj.front.usercenter.service.PProtypesBeanService;
import esj.publicdoc.bean.ProtypesBean;

public class PProtypesBeanServiceimpl implements PProtypesBeanService {
	private PProtypesBeanDao pProtypesBeanDao = new PProtypesBeanDaoimpl();
	
	public List<ProtypesBean> getProType(int fatherId) {
		// TODO Auto-generated method stub
		ProtypesBean protypesBean = new ProtypesBean();
		protypesBean.setFatherId(fatherId);
		protypesBean.setTypeId(-1);
		return pProtypesBeanDao.getProType(protypesBean);
	}

	public ProtypesBean getProTypeByTypeId(int typeId) {
		if(typeId>0){
			ProtypesBean protypesBean = new ProtypesBean();
			protypesBean.setTypeId(typeId);		
			return pProtypesBeanDao.getProType(protypesBean).get(0);
		}

		return null;
	}

	public Map<String, List<ProtypesBean>> getProTypeTree(String id) {
		int typeId = 1;
		if(id.trim() == "" || id == null){
			typeId = 1;
			
		}else{
			typeId = Integer.parseInt(id);			
		}
		
		List<ProtypesBean> list = new ArrayList<ProtypesBean>();
		ProtypesBean protypesBean = new ProtypesBean();
		Map<String,List<ProtypesBean>> map = new HashMap<String, List<ProtypesBean>>();
		//获得编号为typeId 的数据
		
		protypesBean = this.getProTypeByTypeId(typeId);
		list.add(protypesBean);
		map.put("1", list);
				
		String childern =protypesBean.getChildId();	
		list = pProtypesBeanDao.getByArray(childern, null);
		map.put("2", list);								
		return map;
	}

	public List<ProtypesBean> getByArray(String typeIds, String fatherIds) {
		return pProtypesBeanDao.getByArray(typeIds, fatherIds);
	}


}
