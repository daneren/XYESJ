package esj.front.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import esj.util.DateHelper;

/**
 * 
 * @作者 徐新凯
 * @项目名称：XYESJ  
 * @创建时间 2016-6-27 下午1:02:13
 * @最后修改时间 2016-6-27 下午1:02:13
 * @描述 用户日志和管理员日志写入文件的帮助类
 * @version 1.0
 */
public class LogsFileUtil {
	private static FileOutputStream out;  
	/**
	 * @作者 徐新凯
	 * @项目名称：XYESJ  
	 * @创建时间 2016-6-27 下午1:02:13
	 * @param fileName 日志文件名 传入格式： 用户id+#+YYYYmmrrHHmmss.log
	 * @param desc 写入日志的内容 格式：[ip YYYY-mm-rr HH:mm:ss] 操作
	 */
	public static void saveUserLogs(String fileName,String desc){
		String userlogsPath = LogsFileUtil.class.getResource("/").getPath()+"userlogs";
		desc+="\r\n";
		savefile(userlogsPath,fileName, desc);
	}
	public static void savefile(String logsPath, String fileName,String desc){
		
		try {  
            File file = new File(logsPath+"/"+fileName);
            if (!file.exists()) {  
                file.createNewFile();
            }    
            out = new FileOutputStream(file, true);  
            byte[] buffer = new byte[]{}; 
            buffer = desc.getBytes(); 
            out.write(buffer);
        } catch (IOException e) {  
        	e.printStackTrace();
        } finally {   
            try {
            	out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	/**
	 * @作者 徐新凯
	 * @项目名称：XYESJ  
	 * @创建时间 2016-6-27 下午1:02:13
	 * @param fileName 日志文件名 传入格式： 管理员id+#+YYYYmmrrHHmmss.log
	 * @param desc 写入日志的内容
	 */
	public static void saveAdminLogs(String fileName,String desc){
		String userlogsPath = LogsFileUtil.class.getResource("/").getPath()+"adminlogs";
		desc+="\r\n";
		savefile(userlogsPath,fileName, desc);
	}
//	public static void main(String[] args) {
//		saveUserLogs("1ca6055ad8814ad5abc9c4d1f4f49f26#20160627135511.log","[127.0.0.1 "+DateHelper.getDateTimeFormat()+"]登录成功");
//		saveAdminLogs("1#20160627135511.log","[127.0.0.1 "+DateHelper.getDateTimeFormat()+"]登录成功");
//	}
}
