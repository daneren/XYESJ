package esj.front.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @作者 朱志玉
 * @项目名称 XYESJ
 * @创建时间 2016-6-26 下午1:31:46
 * @最后修改时间 2016-6-26 下午1:31:46
 * @描述：
 * @version 1.0
 */
public class DateUtil {

	/**
	 * 获得系统当前时间
	 * 
	 * @return 年月日 时分秒
	 */
	public static String getCurrentDatetime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dates = sdf.format(date);
		return dates;
	}
	/**返回格式yyyy-MM-dd*/
	public static String  getCurrentDate(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	/**
	 * 判断日期 date1是否在date2之前  日期格式 yyyy-MM-dd HH:mm:ss
	 * @param date1
	 * @param date2
	 * @return 
	 */
	public static boolean beforeDatetime(String date1,String date2){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try {
			 d1 = sdf.parse(date1);
			 sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 d2 = sdf.parse(date2);			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(d1.before(d2)){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断日期 date1是否在date2之前  日期格式 yyyy-MM-dd
	 * @param date1
	 * @param date2
	 * @return 
	 */
	public static boolean beforeDate(String date1,String date2){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			 d1 = sdf.parse(date1);
			 sdf = new SimpleDateFormat("yyyy-MM-dd");
			 d2 = sdf.parse(date2);			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(d1.before(d2)){
			return true;
		}else {
			return false;
		}
	}
	
//	/**
//	 * 获得系统当前时间
//	 * 
//	 * @return 年月日 
//	 */
//	public Date getCurrentDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String s = sdf.format(new Date());
//		Date date = null;
//		try {
//			date = sdf.parse(s);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
//	/**
//	 * 将日期类型转换成String类型
//	 * @param date 要转换的日期
//	 * @param pattern 日期格式 yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd
//	 * @return 格式化后的日期
//	 */
//	public static String dateToString(Date date,String pattern){
//		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		String dates = sdf.format(date);
//		return dates;
//	}
//	/**
//	 * 将字符串类型的日期转换成Date类型
//	 * @param date 要转换的日期
//	 * @param pattern 日期格式 yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd
//	 * @return 格式化后的日期
//	 */
//	public static Date stringToDate(String date,String pattern){
//		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		Date d = new Date();
//		try {
//			d = sdf.parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		sdf.format(d);
//		return d;
//	}

	/**
	 * 计算日期，传入一个日期 yyyy-MM-dd HH:mm:ss,在此基础上计算 几年后，几月后，几天后 几小时后，几分钟后，几秒后的 时间
	 * 
	 * @param year
	 *            要往后推的 年数 ，0为不参与计算
	 * @param month
	 *            要往后推的 月数 ，0为不参与计算
	 * @param day
	 *            要往后推的 天数 ，0为不参与计算
	 * @param date
	 *            传入的日期 ，0为不参与计算
	 * @param hours
	 *            要往后推的小时数 ，0为不参与计算
	 * @param minute
	 *            要往后推分钟数 ，0为不参与计算
	 * @param secongd
	 *            要往后推的 秒数 ，0为不参与计算
	 * @return 一个 yyyy-MM-dd HH:mm:ss 格式的日期
	 */
	public static String CalDateTimeAdd(String date, int year, int month, int day,
			int hours, int minute, int second) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		Date d;
		try {
			d = sdf.parse(date);
			sdf.format(d);
			now.setTime(d);
			if (year != 0) {
				now.set(Calendar.YEAR, now.get(Calendar.YEAR) + year);
			}
			if (month != 0) {
				now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
			}
			if (day != 0) {
				now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
			}
			if (hours != 0) {
				now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hours);
			}
			if (minute != 0) {
				now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);
			}
			if (second != 0) {
				now.set(Calendar.SECOND, now.get(Calendar.SECOND) + second);
			}

			result = sdf.format(now.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 计算日期，传入一个日期 yyyy-MM-dd HH:mm:ss,在此基础上计算 几年前，几月前，几天前 几小时前，几分钟前，几秒前的 时间
	 * 
	 * @param date
	 *            传入的日期
	 * @param year
	 *            要往前推的 年数 ，0为不参与计算
	 * @param month
	 *            要往前推的 月数 ，0为不参与计算
	 * @param day
	 *            要往前推的 天数 ，0为不参与计算
	 * @param hours
	 *            要往前推的小时数 ，0为不参与计算
	 * @param minute
	 *            要往前推分钟数 ，0为不参与计算
	 * @param secongd
	 *            要往前推的 秒数 ，0为不参与计算
	 * @return 一个 yyyy-MM-dd HH:mm:ss 格式的日期
	 */
	public static String CalDateTimeSub(String date, int year, int month, int day,
			int hours, int minute, int second) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		Date d;
		try {
			d = sdf.parse(date);
			sdf.format(d);
			now.setTime(d);
			if (year != 0) {
				now.set(Calendar.YEAR, now.get(Calendar.YEAR) - year);
			}
			if (month != 0) {
				now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
			}
			if (day != 0) {
				now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
			}
			if (hours != 0) {
				now.set(Calendar.HOUR, now.get(Calendar.HOUR) - hours);
			}
			if (minute != 0) {
				now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) - minute);
			}
			if (second != 0) {
				now.set(Calendar.SECOND, now.get(Calendar.SECOND) - second);
			}

			result = sdf.format(now.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 计算日期，传入一个日期 yyyy-MM-dd,在此基础上获得 几年后，几月后，几天后 的日期
	 * 
	 * @param year
	 *            要往后推的 年数 ，0为不参与计算
	 * @param month
	 *            要往后推的 月数 ，0为不参与计算
	 * @param day
	 *            要往后推的 天数 ，0为不参与计算
	 * @param date
	 *            传入的日期 ，0为不参与计算
	 * @return 一个 yyyy-MM-dd格式的日期
	 */
	public static String CalDateAdd(String date, int year, int month, int day) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = "";
		Date d;
		try {
			d = sdf.parse(date);
			sdf.format(d);
			now.setTime(d);
			if (year != 0) {
				now.set(Calendar.YEAR, now.get(Calendar.YEAR) + year);
			}
			if (month != 0) {
				now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
			}
			if (day != 0) {
				now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
			}
			result = sdf.format(now.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 计算日期，传入一个日期 yyyy-MM-dd,在此基础上计算 几年前，几月前，几天前的日期
	 * 
	 * @param date
	 *            传入的日期
	 * @param year
	 *            要往前推的 年数 ，0为不参与计算
	 * @param month
	 *            要往前推的 月数 ，0为不参与计算
	 * @param day
	 *            要往前推的 天数 ，0为不参与计算
	 * @return 一个 yyyy-MM-dd 格式的日期
	 */
	public static String  CalDateSub(String date, int year, int month, int day) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = "";
		Date d;
		try {
			d = sdf.parse(date);
			sdf.format(d);
			now.setTime(d);
			if (year != 0) {
				now.set(Calendar.YEAR, now.get(Calendar.YEAR) - year);
			}
			if (month != 0) {
				now.set(Calendar.MONTH, now.get(Calendar.MONTH) - month);
			}
			if (day != 0) {
				now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
			}

			result = sdf.format(now.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}
}
