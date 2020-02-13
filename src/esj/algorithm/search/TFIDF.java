package esj.algorithm.search;

import java.io.*;
import java.util.*;

import org.wltea.analyzer.lucene.IKAnalyzer;

public class TFIDF {

    /**
     * @param args
     */    
    private static ArrayList<String> FileList = new ArrayList<String>(); // the list of file

    //get list of file for the directory, including sub-directory of it
    public static List<String> readDirs(String filepath) throws FileNotFoundException, IOException
    {
        try
        {
            File file = new File(filepath);
            if(!file.isDirectory())
            {
                //System.out.println("�����[]");
                //System.out.println("filepath:" + file.getAbsolutePath());
            }
            else
            {
                String[] flist = file.list();
                for(int i = 0; i < flist.length; i++)
                {
                    File newfile = new File(filepath + "/" + flist[i]);
                    if(!newfile.isDirectory())
                    {
                        FileList.add(newfile.getAbsolutePath());
                    }
                    else if(newfile.isDirectory()) //if file is a directory, call ReadDirs
                    {
                        readDirs(filepath + "/" + flist[i]);
                    }                    
                }
            }
        }catch(FileNotFoundException e)
        {
            //System.out.println(e.getMessage());
        }
        return FileList;
    }
    
    //read file
    public static String readFile(String file) throws FileNotFoundException, IOException
    {
        StringBuffer strSb = new StringBuffer(); //String is constant�� StringBuffer can be changed.
        InputStreamReader inStrR = new InputStreamReader(new FileInputStream(file), "gbk"); //byte streams to character streams
        BufferedReader br = new BufferedReader(inStrR); 
        String line = br.readLine();
        while(line != null){
            strSb.append(line).append("\r\n");
            line = br.readLine();    
        }
        
        return strSb.toString();
    }
    
    //word segmentation
    public static ArrayList<String> cutWords(String file) throws IOException{
        
        ArrayList<String> words = new ArrayList<String>();
        String text = TFIDF.readFile(file);
        IKAnalyzer analyzer = new IKAnalyzer();
        words = analyzer.split(text);
        
        return words;
    }
    
    //term frequency in a file, times for each word
    public static HashMap<String, Integer> normalTF(ArrayList<String> cutwords){
        HashMap<String, Integer> resTF = new HashMap<String, Integer>();
        
        for(String word : cutwords){
            if(resTF.get(word) == null){
                resTF.put(word, 1);
                //System.out.println(word);
            }
            else{
                resTF.put(word, resTF.get(word) + 1);
                //System.out.println(word.toString());
            }
        }
        return resTF;
    }
    
    //term frequency in a file, frequency of each word
    public static HashMap<String, Float> tf(ArrayList<String> cutwords){
        HashMap<String, Float> resTF = new HashMap<String, Float>();
        
        int wordLen = cutwords.size();
        HashMap<String, Integer> intTF = TFIDF.normalTF(cutwords); 
        
        Iterator iter = intTF.entrySet().iterator(); //iterator for that get from TF
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            resTF.put(entry.getKey().toString(), Float.parseFloat(entry.getValue().toString()) / wordLen);
            //System.out.println(entry.getKey().toString() + " = "+  Float.parseFloat(entry.getValue().toString()) / wordLen);
        }
        return resTF;
    } 
    
    //tf times for file
    public static HashMap<String, HashMap<String, Integer>> normalTFAllFiles(String dirc) throws IOException{
        HashMap<String, HashMap<String, Integer>> allNormalTF = new HashMap<String, HashMap<String,Integer>>();
        
        List<String> filelist = TFIDF.readDirs(dirc);
        for(String file : filelist){
            HashMap<String, Integer> dict = new HashMap<String, Integer>();
            ArrayList<String> cutwords = TFIDF.cutWords(file); //get cut word for one file
            
            dict = TFIDF.normalTF(cutwords);
            allNormalTF.put(file, dict);
        }    
        return allNormalTF;
    }
    
    //tf for all file
    public static HashMap<String,HashMap<String, Float>> tfAllFiles(String dirc) throws IOException{
        HashMap<String, HashMap<String, Float>> allTF = new HashMap<String, HashMap<String, Float>>();
        List<String> filelist = TFIDF.readDirs(dirc);
        
        for(String file : filelist){
            HashMap<String, Float> dict = new HashMap<String, Float>();
            ArrayList<String> cutwords = TFIDF.cutWords(file); //get cut words for one file
            
            dict = TFIDF.tf(cutwords);
            allTF.put(file, dict);
        }
        return allTF;
    }
    
    //tf for searchString
    public static HashMap<String,Float> tfBySearchString(String searchString) throws IOException{
        
        HashMap<String, Float> searchtf = new HashMap<String, Float>();
        IKAnalyzer analyzer = new IKAnalyzer();
        ArrayList<String> cutwords = analyzer.split(searchString);
        cutwords.get(0).replace("��", "");
        //ArrayList<String> cutwords = TFIDF.cutWords(searchString); //get cut words for one file
        searchtf = TFIDF.tf(cutwords);
        return searchtf;
    }
    
    public static HashMap<String, Float> idf(HashMap<String,HashMap<String, Float>> all_tf){
        HashMap<String, Float> resIdf = new HashMap<String, Float>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        int docNum = FileList.size();
        
        for(int i = 0; i < docNum; i++){
            HashMap<String, Float> temp = all_tf.get(FileList.get(i));
            Iterator iter = temp.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                String word = entry.getKey().toString();
                if(dict.get(word) == null){
                    dict.put(word, 1);
                }else {
                    dict.put(word, dict.get(word) + 1);
                }
            }
        }
        //System.out.println("IDF for every word is:");
        Iterator iter_dict = dict.entrySet().iterator();
        while(iter_dict.hasNext()){
            Map.Entry entry = (Map.Entry)iter_dict.next();
            float value = (float)Math.log(docNum / Float.parseFloat(entry.getValue().toString()));
            resIdf.put(entry.getKey().toString(), value);
            //System.out.println(entry.getKey().toString() + " = " + value);
        }
        return resIdf;
    }
    public static void tf_idf(HashMap<String,HashMap<String, Float>> all_tf,HashMap<String, Float> idfs){
        HashMap<String, HashMap<String, Float>> resTfIdf = new HashMap<String, HashMap<String, Float>>();
            
        int docNum = FileList.size();
        for(int i = 0; i < docNum; i++){
            String filepath = FileList.get(i);
            HashMap<String, Float> tfidf = new HashMap<String, Float>();
            HashMap<String, Float> temp = all_tf.get(filepath);
            Iterator iter = temp.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                String word = entry.getKey().toString();
                Float value = (float)Float.parseFloat(entry.getValue().toString()) * idfs.get(word); 
                tfidf.put(word, value);
            }
            resTfIdf.put(filepath, tfidf);
        }
        //System.out.println("TF-IDF for Every file is :");
        DisTfIdf(resTfIdf);
    }

	public static void DisTfIdf(HashMap<String, HashMap<String, Float>> tfidf){
		FileOperate fileOperate=new FileOperate();
        Iterator iter1 = tfidf.entrySet().iterator();
        while(iter1.hasNext()){
            Map.Entry entrys = (Map.Entry)iter1.next();
            
            //System.out.println("FileName: " + entrys.getKey().toString());
            //System.out.print("{");
            String path=entrys.getKey().toString();
            path=path.replace("Details", "TFIDF");
            //System.out.println(path);
            String content="{";
            
            HashMap<String, Float> temp = (HashMap<String, Float>) entrys.getValue();
            Iterator iter2 = temp.entrySet().iterator();
            while(iter2.hasNext()){
               
            	Map.Entry entry = (Map.Entry)iter2.next(); 
                
            	content=content+entry.getKey().toString() + " = " + entry.getValue().toString() + ", ";
                //System.out.print(entry.getKey().toString() + " = " + entry.getValue().toString() + ", ");
                
            }
            content=content.substring(0,content.length()-1);
            content=content+"}";
            
            //System.out.println(content);
            
            fileOperate.createFile(path,content);
            
            //System.out.println("}");
            
        }
        
    }
	
    void tfidf(String path) throws IOException{
    	// TODO Auto-generated method stub
        String file = path;

        HashMap<String,HashMap<String, Float>> all_tf = tfAllFiles(file);
        //System.out.println();
        HashMap<String, Float> idfs = idf(all_tf);
        System.out.println();
        tf_idf(all_tf, idfs);
    }

}