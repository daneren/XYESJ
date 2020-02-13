package esj.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-25 ����4:31:32
 * @����޸�ʱ��
 * @���� ��ip��ַת������ʵ��ַ
 * @version 1.0
 */
public class IPToAddr {
/***
 * 
 * @param ip
 * @return ip��ַ��Ӧ����ʵ��ַ
 */
	public static String jiexiip(String ip){
		String addr = null;
		String httpUrl = "http://apis.baidu.com/showapi_open_bus/ip/ip";
		String httpArg = "ip="+ip;
		String jsonResult = request(httpUrl, httpArg);
		try {
			JSONObject jobj = new JSONObject(jsonResult);
			JSONObject showapi = jobj.getJSONObject("showapi_res_body");
			String country = showapi.getString("country");
			String region = showapi.getString("region");
			String city = showapi.getString("city");
			String isp = showapi.getString("isp");
			addr = country+"-"+region+"-"+city+":"+isp;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return addr;
	}
	/**
	 * @param urlAll
	 *            :����ӿ�
	 * @param httpArg
	 *            :����
	 * @return ���ؽ��
	 */
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // ����apikey��HTTP header
	        connection.setRequestProperty("apikey",  "2a1dbae028ed07d5feb3b3aeadf04b02");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
