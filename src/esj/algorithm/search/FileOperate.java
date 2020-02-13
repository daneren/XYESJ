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
        if(!file.exists()){//判断文件是否存在  
            try {  
                file.createNewFile();  //创建文件  
                  
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
            file.mkdirs();  //创建文件夹  
        }  
          
        //file.delete();  若文件夹为空,则删除文件夹  
        
    }  
      
    /** 
     * 遍历文件夹中的文件并显示 
     */  
    public void showfiles(String path){  
        File file=new File(path);  
        File[] files=file.listFiles();  
        ////System.out.println(files.length);  
          
        for (File f : files) {  
            if(f.isFile()){  
                //System.out.println(f.getName()+"是文件!");  
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
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    
                    String lineTxt=null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        ////System.out.println(lineTxt);
                    	content=content+lineTxt;
                    }
                    read.close();
        }else{
            ////System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            ////System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		return content;
        
     
    }


}  


