package esj.front.products.service.impl;

import java.util.List;

import esj.front.products.dao.impl.XProductsDaoImpl;
import esj.front.products.service.XProductsService;
import esj.publicdoc.bean.CollectsBean;
import esj.publicdoc.bean.PraiseTreadBean;
import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.ReservesBean;
import esj.util.DateHelper;
import esj.util.Random100;

public class XProductsServiceImpl implements XProductsService {
private XProductsDaoImpl dao = new XProductsDaoImpl();
	public List<ProductsBean> getNewProducts() {
		// TODO Auto-generated method stub
		return dao.getNewProducts();
	}

	public List<ProductsBean> getGraduateProducts() {
		// TODO Auto-generated method stub
		return dao.getGraduateProducts();
	}

	public List<ProductsBean> getPushProductsById(String id) {
		// TODO Auto-generated method stub
		return dao.getPushProductsById(id);
	}

	public int getPraiseCountByProId(String proId) {
		// TODO Auto-generated method stub
		return dao.getPraiseCountByProId(proId);
	}

	public int getTreadCountByProId(String proId) {
		// TODO Auto-generated method stub
		return dao.getTreadCountByProId(proId);
	}

	public int praiseProduct(PraiseTreadBean ptb) {
		ptb.setPtId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		return dao.praiseProduct(ptb);
	}

	public int treadProduct(PraiseTreadBean ptb) {
		ptb.setPtId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		return dao.treadProduct(ptb);
	}

	public boolean isTreadOrPraise(String userId, String proId) {
		// TODO Auto-generated method stub
		return dao.isTreadOrPraise(userId, proId);
	}

	public int collectCountByProId(String proId) {
		// TODO Auto-generated method stub
		return dao.collectCountByProId(proId);
	}

	public boolean isCollected(String userId, String proId) {
		// TODO Auto-generated method stub
		return dao.isCollected(userId, proId);
	}

	public int collectProduct(CollectsBean collect) {
		collect.setCollectId(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		collect.setBdate(DateHelper.getDateTimeFormat());
		return dao.collectProduct(collect);
	}

	public List<ProductsBean> searchProducts(String keyWords,String typeid) {
		// TODO Auto-generated method stub
		return dao.searchProducts(keyWords,typeid);
	}

	/**
	 *作者：朱志玉 
	 * 设置评分,分数，总评分数*/
	public int updateScore(String score, String proId) {
		return dao.updateScore(score, proId);
	}

	public List<ProductsBean> getProByTag(String tag) {
		// TODO Auto-generated method stub
		return dao.getProByTag(tag);
	}

	public int getReserveCountByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.getReserveCountByUserId(userId);
	}

	public double getReservePriceCountByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.getReservePriceCountByUserId(userId);
	}

	public int updateProductPcount(String proId, int pcount) {
		pcount = dao.getPraiseCountByProId(proId);
		return dao.updateProductPcount(proId, pcount);
	}

	public int updateProductNcount(String proId, int ncount) {
		ncount = dao.getTreadCountByProId(proId);
		return dao.updateProductNcount(proId, ncount);
	}
}
