package esj.algorithm.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import esj.publicdoc.bean.ProductsBean;
import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.service.ProductsBeanService;
import esj.publicdoc.service.UserdemandsBeanService;
import esj.publicdoc.service.impl.ProductsBeanServiceImpl;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;

public class Search {

	static{
		try {
			CreateTDF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 
	 * ����TF-IDF��
	 */
	public static void CreateTDF() throws IOException {
		
		TFIDF tfidf=new TFIDF();
		
		//������ƷIDF��
		ProductDetailsText productDetailsText=new ProductDetailsText();
		String path=productDetailsText.CreateDetailsTexts();
		tfidf.tfidf(path);
		
		//��������IDF��
		UserDemandDetailsText userDemandDetailsText=new UserDemandDetailsText();
		String path1=userDemandDetailsText.CreateDetailsTexts();
		tfidf.tfidf(path1);
		
	}
	
	
	/*
	 * 
	 * ���������������ƶ�
		
	 */
	public static  List<UserdemandsBean> UserDemandCos(String searchContent) throws IOException {
		
		HashMap<String,Float> searchmap = TFIDF.tfBySearchString(searchContent);
		
        searchContent=null;
        
        Iterator<Entry<String, Float>> iter = searchmap.entrySet().iterator(); //iterator for that get from TF
        
        while(iter.hasNext()){
            @SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iter.next();
            searchContent=searchContent+entry.getKey().toString() + " = "+  Float.parseFloat(entry.getValue().toString())+",";
        }
        
        searchContent=searchContent.substring(4,searchContent.length()-2);
		
		String pathtext;
		
		Map<String, Double> result = new HashMap<String, Double>();
		UserdemandsBeanService service=new UserdemandsBeanServiceImpl();
		
		//String diridfpath=System.getProperty("user.dir");
		String diridfpath=UserDemandDetailsText.class.getResource("/").getPath();
		diridfpath=diridfpath+"/TFIDF/Userdemand";
		File file=new File(diridfpath); 
		File[] files=file.listFiles(); 
		
		for (File f : files) {  
			
            pathtext=diridfpath+"/"+f.getName();
            FileOperate fileOperate=new FileOperate();
            String content=fileOperate.readTxtFile(pathtext); 
            content=content.substring(1,content.length()-2);
            
            //double d=SimilarDegreeByCos.getSimilarDegree(searchContent, content);
            double d=CosSimilarDegree.getSimilarDegree(searchContent, content);
            if(d!=0.0){
            	result.put(f.getName().substring(0, f.getName().length()-4), d);
            	////System.out.println(f.getName()+d);
            }

            ////System.out.println(f.getName()+"	"+d);
            
        }  
        //��result.entrySet()ת����list,������  
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(result.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {  
            //��������  
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                
                return (o1.getValue()).toString().compareTo(o2.getValue().toString());  
            }  
        });
        
        
        //������Ʒ��ķ��ؽ����
        List<UserdemandsBean> listproduct = new ArrayList<UserdemandsBean>(); 
		for(Map.Entry<String, Double> item:list){
			listproduct.add(service.findUserdemandsById(item.getKey()));
			//System.out.println(item.toString());
		}
		
		return listproduct;
		
	}
	
	/*
	 * 
	 * ������Ʒ�������ƶ�
	 */
	public static  List<ProductsBean> ProductCos(String searchContent) throws IOException {
		
		HashMap<String,Float> searchmap = TFIDF.tfBySearchString(searchContent);
		
        searchContent=null;
        
        Iterator<Entry<String, Float>> iter = searchmap.entrySet().iterator(); //iterator for that get from TF
        
        while(iter.hasNext()){
            @SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iter.next();
            searchContent=searchContent+entry.getKey().toString() + " = "+  Float.parseFloat(entry.getValue().toString())+",";
        }
        searchContent=searchContent.substring(4,searchContent.length()-2);
		
		String pathtext;
		
		Map<String, Double> result = new HashMap<String, Double>();
		ProductsBeanService service=new ProductsBeanServiceImpl();
		
		//String diridfpath=System.getProperty("user.dir");
		String diridfpath=ProductDetailsText.class.getResource("/").getPath();
		diridfpath=diridfpath+"/TFIDF/Product";
		File file=new File(diridfpath); 
		File[] files=file.listFiles(); 
		
		for (File f : files) {  
			
            pathtext=diridfpath+"/"+f.getName();
            FileOperate fileOperate=new FileOperate();
            String content=fileOperate.readTxtFile(pathtext); 
           // //System.out.println(content);
            content=content.substring(1,content.length()-2);
            
            //double d=SimilarDegreeByCos.getSimilarDegree(searchContent, content);
            double d=CosSimilarDegree.getSimilarDegree(searchContent, content);
            if(d!=0.0){
            	result.put(f.getName().substring(0, f.getName().length()-4), d);
            	//System.out.println(f.getName()+d);
            }

            ////System.out.println(f.getName()+"	"+d);
            
        }  
        //��result.entrySet()ת����list,������  
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(result.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {  
            //��������  
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                
                return (o1.getValue()).toString().compareTo(o2.getValue().toString());  
            }  
        });
        
        
        //������Ʒ��ķ��ؽ����
        List<ProductsBean> listproduct = new ArrayList<ProductsBean>(); 
		for(Map.Entry<String, Double> item:list){
			listproduct.add(service.findProductsById(item.getKey()));
			//System.out.println(item.toString());
		}
		
		return listproduct;
		
	}
	
	public static void main(String[] args) throws IOException {
        
		CreateTDF();
		//UserDemandCos("�յ���������Я");
		//ProductCos("ȫ�·��ȷ���");
	}
	
}
