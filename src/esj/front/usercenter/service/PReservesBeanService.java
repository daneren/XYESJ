package esj.front.usercenter.service;

import java.util.List;

import esj.front.usercenter.bean.ProCommBean;
import esj.publicdoc.bean.ReservesBean;
/**
 * 我买过的商品
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-7-1 上午12:51:17
 * @最后修改时间 2016-7-15 晚上21：56
 * @描述：
 * @version 1.0
 */
public interface PReservesBeanService {
	/**我买到的商品：预约中，预约成功，PReservesBean 按状态排序*/
	/**rstate ,COUNT(proId)as remark,sum(buyerPrice) as buyerPrice*/
	public List<ProCommBean> getPriceSum(String buyerId);	
	
	/**我买到的商品 ：PReservesBean*/
	/**proId,title,sellerId,photoAddr,buyerPrice,cjdate,reservId
	 *  ORDER BY r.cjdate
	 */
	public List<ProCommBean> getUserBuy(String buyerId);
	
	/**我预约中的商品 ：PReservesBean*/
	/**"SELECT proId,title,sellerId,photoAddr,buyerPrice,reservId,
	 * cprice,dprice,oprice 
	 * ORDER BY r.reservdate
	 */
	public List<ProCommBean> getUserReserve(String buyerId);	
	
	/**获得该卖家的，全部被预约的商品的信息
	 * SELECT r.proId,p.title,p.bdate,p.edate AS cjdate,p.dprice,
	 * COUNT(r.buyerId) AS ruCount 
	 * */
	public List<ProCommBean> getAllReserved(String sellerId);	
	
	/**根据商品编号查询全部预约信息，全部被预约的商品的信息
	 * SELECT r.proId,r.buyerId,u.userName AS remark, 
	 * u.email,r.buyerPrice,r.reservdate
	 * */
	public List<ReservesBean> getDetailReserved(String proId);
	
	/**根据预约编号更改预约状态
	 * */
	public int updateReserveState(String reserveId,String state);
	
	/**卖给他/她*/
	public int acceptReserv(String proId,String reserveId,String state);
	
	/**退回全部预约订单*/
	public int turndownAllReserv(String proId,String ostate,String nstate);
	
	/**发送邮件提醒用户的预约被选中
	 * SELECT r.buyerPrice,u.userName AS buyerId,
	 * u.email AS sellerId,p.proId,p.title AS remark 
	 * */
	public ReservesBean getUserMag(String reserveId);
		
	/**
	 * 获得用户的预约信息，交易中的预约信息
	 * 
	 * */
	public List<ProCommBean> getSellerDealing(String buyerId);
	
	/**根据预约编号，和买家编号 批量修改更改预约状态
	 * */
	public int updateReserveStates(String proId,String ostate,String nstate);
	
	/**
	 * 买家--->用户的预约信息，交易中的预约信息
	 * 
	 * */
	public List<ProCommBean> getBuyerDealing(String buyerId);
	
	/**发送邮件提醒卖家有新的预约信息
	 * SELECT r.buyerPrice,u.userName AS buyerId,
	 * u.email AS sellerId,p.proId,p.title AS remark 
	 * */
	public ReservesBean getSellerMag(String reserveId);

}
