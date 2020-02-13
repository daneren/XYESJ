package esj.front.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @���� ��־��
 * @��Ŀ���� XYESJ
 * @����ʱ�� 2016-6-26 ����1:31:46
 * @����޸�ʱ�� 2016-6-26 ����1:31:46
 * @������
 * @version 1.0
 */
public class DateUtil {

	/**
	 * ���ϵͳ��ǰʱ��
	 * 
	 * @return ������ ʱ����
	 */
	public static String getCurrentDatetime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dates = sdf.format(date);
		return dates;
	}
	/**���ظ�ʽyyyy-MM-dd*/
	public static String  getCurrentDate(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	/**
	 * �ж����� date1�Ƿ���date2֮ǰ  ���ڸ�ʽ yyyy-MM-dd HH:mm:ss
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
	 * �ж����� date1�Ƿ���date2֮ǰ  ���ڸ�ʽ yyyy-MM-dd
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
//	 * ���ϵͳ��ǰʱ��
//	 * 
//	 * @return ������ 
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
//	 * ����������ת����String����
//	 * @param date Ҫת��������
//	 * @param pattern ���ڸ�ʽ yyyy-MM-dd HH:mm:ss ���� yyyy-MM-dd
//	 * @return ��ʽ���������
//	 */
//	public static String dateToString(Date date,String pattern){
//		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		String dates = sdf.format(date);
//		return dates;
//	}
//	/**
//	 * ���ַ������͵�����ת����Date����
//	 * @param date Ҫת��������
//	 * @param pattern ���ڸ�ʽ yyyy-MM-dd HH:mm:ss ���� yyyy-MM-dd
//	 * @return ��ʽ���������
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
	 * �������ڣ�����һ������ yyyy-MM-dd HH:mm:ss,�ڴ˻����ϼ��� ����󣬼��º󣬼���� ��Сʱ�󣬼����Ӻ󣬼����� ʱ��
	 * 
	 * @param year
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param month
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param day
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param date
	 *            ��������� ��0Ϊ���������
	 * @param hours
	 *            Ҫ�����Ƶ�Сʱ�� ��0Ϊ���������
	 * @param minute
	 *            Ҫ�����Ʒ����� ��0Ϊ���������
	 * @param secongd
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @return һ�� yyyy-MM-dd HH:mm:ss ��ʽ������
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
	 * �������ڣ�����һ������ yyyy-MM-dd HH:mm:ss,�ڴ˻����ϼ��� ����ǰ������ǰ������ǰ ��Сʱǰ��������ǰ������ǰ�� ʱ��
	 * 
	 * @param date
	 *            ���������
	 * @param year
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @param month
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @param day
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @param hours
	 *            Ҫ��ǰ�Ƶ�Сʱ�� ��0Ϊ���������
	 * @param minute
	 *            Ҫ��ǰ�Ʒ����� ��0Ϊ���������
	 * @param secongd
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @return һ�� yyyy-MM-dd HH:mm:ss ��ʽ������
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
	 * �������ڣ�����һ������ yyyy-MM-dd,�ڴ˻����ϻ�� ����󣬼��º󣬼���� ������
	 * 
	 * @param year
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param month
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param day
	 *            Ҫ�����Ƶ� ���� ��0Ϊ���������
	 * @param date
	 *            ��������� ��0Ϊ���������
	 * @return һ�� yyyy-MM-dd��ʽ������
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
	 * �������ڣ�����һ������ yyyy-MM-dd,�ڴ˻����ϼ��� ����ǰ������ǰ������ǰ������
	 * 
	 * @param date
	 *            ���������
	 * @param year
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @param month
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @param day
	 *            Ҫ��ǰ�Ƶ� ���� ��0Ϊ���������
	 * @return һ�� yyyy-MM-dd ��ʽ������
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
