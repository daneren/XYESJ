package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.StatesBean;
import esj.publicdoc.dao.StatesBeanDao;
import esj.publicdoc.dao.impl.StatesBeanDaoimpl;
import esj.publicdoc.service.StatesBeanService;
/**״̬�����*/
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����5:30:40
 * @����޸�ʱ�� 2016-6-25 ����5:30:40
 * @���� ״̬�����
 * @version 1.0
 */
public class StatesBeanServiceimpl implements StatesBeanService {
private StatesBeanDao dao = new StatesBeanDaoimpl();
	public int saveStates(StatesBean StatesBean) {
		// TODO Auto-generated method stub
		return dao.saveStates(StatesBean);
	}

	public List<StatesBean> findAllStates() {
		// TODO Auto-generated method stub
		return dao.findAllStates();
	}

	

	public int updateStates(StatesBean StatesBean) {
		// TODO Auto-generated method stub
		return dao.updateStates(StatesBean);
	}

	public StatesBean findStatesById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findStatesById(id);
	}

	public int changeStatesState(StatesBean StatesBean) {
		// TODO Auto-generated method stub
		return dao.changeStatesState(StatesBean);
	}

	
}
