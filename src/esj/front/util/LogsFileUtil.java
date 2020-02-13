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
 * @���� ���¿�
 * @��Ŀ���ƣ�XYESJ  
 * @����ʱ�� 2016-6-27 ����1:02:13
 * @����޸�ʱ�� 2016-6-27 ����1:02:13
 * @���� �û���־�͹���Ա��־д���ļ��İ�����
 * @version 1.0
 */
public class LogsFileUtil {
	private static FileOutputStream out;  
	/**
	 * @���� ���¿�
	 * @��Ŀ���ƣ�XYESJ  
	 * @����ʱ�� 2016-6-27 ����1:02:13
	 * @param fileName ��־�ļ��� �����ʽ�� �û�id+#+YYYYmmrrHHmmss.log
	 * @param desc д����־������ ��ʽ��[ip YYYY-mm-rr HH:mm:ss] ����
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
	 * @���� ���¿�
	 * @��Ŀ���ƣ�XYESJ  
	 * @����ʱ�� 2016-6-27 ����1:02:13
	 * @param fileName ��־�ļ��� �����ʽ�� ����Աid+#+YYYYmmrrHHmmss.log
	 * @param desc д����־������
	 */
	public static void saveAdminLogs(String fileName,String desc){
		String userlogsPath = LogsFileUtil.class.getResource("/").getPath()+"adminlogs";
		desc+="\r\n";
		savefile(userlogsPath,fileName, desc);
	}
//	public static void main(String[] args) {
//		saveUserLogs("1ca6055ad8814ad5abc9c4d1f4f49f26#20160627135511.log","[127.0.0.1 "+DateHelper.getDateTimeFormat()+"]��¼�ɹ�");
//		saveAdminLogs("1#20160627135511.log","[127.0.0.1 "+DateHelper.getDateTimeFormat()+"]��¼�ɹ�");
//	}
}
