package esj.algorithm.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
  
public class FileOperate {  
      
    public void createFile(String path,String content){  
        File file=new File(path);  
        if(!file.exists()){//�ж��ļ��Ƿ����  
            try {  
                file.createNewFile();  //�����ļ�  
                  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } 
        
        FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(content);
	        bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }  
      
    public void createDir(String path){  
        File file=new File(path);  
        if(!file.exists()){  
            file.mkdirs();  //�����ļ���  
        }  
          
        //file.delete();  ���ļ���Ϊ��,��ɾ���ļ���  
        
    }  
      
    /** 
     * �����ļ����е��ļ�����ʾ 
     */  
    public void showfiles(String path){  
        File file=new File(path);  
        File[] files=file.listFiles();  
        ////System.out.println(files.length);  
          
        for (File f : files) {  
            if(f.isFile()){  
                //System.out.println(f.getName()+"���ļ�!");  
            }else if(f.isDirectory()){  
            	showfiles(f.getPath());  
            }  
        }  
          
    }  

    public String readTxtFile(String filePath){
    	
    	String content="";
    	
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
                    BufferedReader bufferedReader = new BufferedReader(read);
                    
                    String lineTxt=null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        ////System.out.println(lineTxt);
                    	content=content+lineTxt;
                    }
                    read.close();
        }else{
            ////System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            ////System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
		return content;
        
     
    }


}  


