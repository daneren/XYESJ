package esj.front.usercenter.service.impl;

import esj.front.usercenter.dao.impl.XUserLogsDaoImpl;
import esj.front.usercenter.service.XUserLogsService;

public class XUserLogsServiceImpl implements XUserLogsService {
private XUserLogsDaoImpl dao = new XUserLogsDaoImpl();
	public String getlogfileNameByLogsId(String logsId) {
		return dao.getlogfileNameByLogsId(logsId);
	}

}
