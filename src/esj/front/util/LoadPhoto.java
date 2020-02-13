package esj.front.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import esj.util.DateHelper;
import esj.util.Random100;

public class LoadPhoto {
	public static String getPhotoName(String path){
		
		String s =  DateHelper.getDateTimeForNumber()+Random100.getrandom100();
		s += path.substring(path.lastIndexOf('.'), path.length());
		return s;
	}
	/** 如果文件名是中文，需要进行url编码*/
	public static String chineseUrlEncode(String filename){

		String fn = "";
	    try {
			fn = URLEncoder.encode(filename, "UTF-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return fn;
	}
	
	public static String chineseEncode(String s){
		String st = "";
		try {
			st = new String(s.getBytes("iso8859-1"),"utf-8");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return st;
	}

	/**下载文件*/
	public static  void downLoadFile(File file,String fileName,OutputStream os ){
		//得到文件流
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			//边读边写
			//缓冲数组
			byte[] buff = new byte[1024];
			int len = 0 ;
			while((len = fis.read(buff)) != -1){
				os.write(buff, 0, len);
			}
			//关闭流
			os.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

}
