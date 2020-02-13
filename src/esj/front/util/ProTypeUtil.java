package esj.front.util;

import java.util.ArrayList;
import java.util.List;

import esj.front.usercenter.service.PProductsBeanService;
import esj.front.usercenter.service.PProtypesBeanService;
import esj.front.usercenter.service.impl.PProductsBeanServiceimpl;
import esj.front.usercenter.service.impl.PProtypesBeanServiceimpl;
import esj.publicdoc.bean.ProtypesBean;

/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-28 下午5:43:05
 * @最后修改时间 2016-6-28 下午5:43:05
 * @描述：
 * @version 1.0
 */
public class ProTypeUtil {

	public static List<ProtypesBean> getFirst(){
		List<ProtypesBean> tBeans = null;
		PProtypesBeanService ppService = new PProtypesBeanServiceimpl();
		ppService.getProType(0);		
		return tBeans;
	}
	
	public static List<ProtypesBean> getSecond(String children){
		List<ProtypesBean> tBeans = null;
		PProtypesBeanService ppService = new PProtypesBeanServiceimpl();
		ppService.getProTypeTree(children);	
		return tBeans;
	}
}
