package esj.publicdoc.service.impl;

import java.util.List;

import esj.publicdoc.bean.ReservesBean;
import esj.publicdoc.dao.ReservesBeanDao;
import esj.publicdoc.dao.impl.ReservesBeanDaoimpl;
import esj.publicdoc.service.ReservesBeanService;
import esj.util.DateHelper;
import esj.util.Random100;
/**预约表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:30:12
 * @最后修改时间 2016-6-25 下午5:30:12
 * @描述 预约表 操作类
 * @version 1.0
 */
public class ReservesBeanServiceimpl implements ReservesBeanService {
	private ReservesBeanDao dao = new ReservesBeanDaoimpl();
	public int saveReserves(ReservesBean ReservesBean) {
		ReservesBean.setReservId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		ReservesBean.setReservdate(DateHelper.getDateTimeFormat());
		return dao.saveReserves(ReservesBean);
	}

	public List<ReservesBean> findAllReserves() {
		// TODO Auto-generated method stub
		return dao.findAllReserves();
	}

	public int removeReserves(ReservesBean ReservesBean) {
		// TODO Auto-generated method stub
		return dao.removeReserves(ReservesBean);
	}

	public int updateReserves(ReservesBean ReservesBean) {
		// TODO Auto-generated method stub
		return dao.updateReserves(ReservesBean);
	}

	public ReservesBean findReservesById(String id) {
		// TODO Auto-generated method stub
		return dao.findReservesById(id);
	}


}
