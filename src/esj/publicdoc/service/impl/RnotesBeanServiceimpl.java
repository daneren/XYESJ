package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.RnotesBean;
import esj.publicdoc.dao.RnotesBeanDao;
import esj.publicdoc.dao.impl.RnotesBeanDaoimpl;
import esj.publicdoc.service.RnotesBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**�ظ���  ������*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:30:23
 * @����޸�ʱ�� 2016-6-25 ����5:30:23
 * @���� �ظ���  ������
 * @version 1.0
 */
public class RnotesBeanServiceimpl implements RnotesBeanService {
	private RnotesBeanDao dao = new RnotesBeanDaoimpl();
	public int saveRnotes(RnotesBean RnotesBean) {
		RnotesBean.setReplyId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		RnotesBean.setBdate(DateHelper.getDateTimeFormat());
		return dao.saveRnotes(RnotesBean);
	}

	public List<RnotesBean> findAllRnotes() {
		// TODO Auto-generated method stub
		return dao.findAllRnotes();
	}

	
	public int updateRnotes(RnotesBean RnotesBean) {
		// TODO Auto-generated method stub
		return dao.updateRnotes(RnotesBean);
	}

	public RnotesBean findRnotesById(String id) {
		// TODO Auto-generated method stub
		return dao.findRnotesById(id);
	}

	public int changeRnotesState(RnotesBean RnotesBean) {
		// TODO Auto-generated method stub
		return dao.changeRnotesState(RnotesBean);
	}


}
