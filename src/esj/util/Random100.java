package esj.util;

import java.util.Random;

/**
 * 
 * @author Arice ���¿�
 * @description ������λ�������
 * @version 1.0
 * @data 2016-5-25
 */
public class Random100 {
	/**
	 * �������3λ�����
	 * @return
	 */
	public static String  getrandom100(){
		Random r = new Random(); 
		int rs = r.nextInt(900)+100;
		return rs+"";
	}
	/**
	 * �������5λ�����
	 * @return
	 */
	public static String  getrandom10000(){
		Random r = new Random(); 
		int rs = r.nextInt(90000)+10000;
		return rs+"";
	}
	/**
	 * ����������������ַ�
	 * @return
	 */
	public static String getRandomcharacters() {
		String str="";
		for(int i=0;i<5;i++){//�������ɼ����ַ��ģ��Ͱ�3�ĳɼ�������ĳɣ�,�Ǿ�����һ�������ĸ��Randomcharacters
		str= str+(char) (Math.random ()*26+'a');
		}
		return str;
	}
}
