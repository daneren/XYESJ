package esj.util;

import java.util.Random;

/**
 * 
 * @author Arice 徐新凯
 * @description 生成三位的随机数
 * @version 1.0
 * @data 2016-5-25
 */
public class Random100 {
	/**
	 * 随机产生3位随机数
	 * @return
	 */
	public static String  getrandom100(){
		Random r = new Random(); 
		int rs = r.nextInt(900)+100;
		return rs+"";
	}
	/**
	 * 随机产生5位随机数
	 * @return
	 */
	public static String  getrandom10000(){
		Random r = new Random(); 
		int rs = r.nextInt(90000)+10000;
		return rs+"";
	}
	/**
	 * 随机产生五个随机的字符
	 * @return
	 */
	public static String getRandomcharacters() {
		String str="";
		for(int i=0;i<5;i++){//你想生成几个字符的，就把3改成几，如果改成１,那就生成一个随机字母．Randomcharacters
		str= str+(char) (Math.random ()*26+'a');
		}
		return str;
	}
}
