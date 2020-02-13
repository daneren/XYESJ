package esj.publicdoc.service;

import java.util.List;

import esj.publicdoc.bean.ReservesBean;
/**预约表 操作类*/
/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-25 下午5:26:33
 * @最后修改时间 2016-6-25 下午5:26:33
 * @描述
 * @version 1.0
 */
public interface ReservesBeanService {
	/**保存一个   预约信息*/
	public int saveReserves(ReservesBean ReservesBean );
	/**查找全部 预约信息*/
	public List<ReservesBean> findAllReserves();
	/**删除一个 预约信息*/
	public int removeReserves(ReservesBean ReservesBean);
	/**更新一个   预约信息*/
	public int updateReserves(ReservesBean ReservesBean);
	/**根据编号（主键）查找   预约信息*/
	public ReservesBean findReservesById(String id);
}
