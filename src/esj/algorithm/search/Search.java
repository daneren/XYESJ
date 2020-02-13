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
	 * 构建TF-IDF库
	 */
	public static void CreateTDF() throws IOException {
		
		TFIDF tfidf=new TFIDF();
		
		//建立商品IDF库
		ProductDetailsText productDetailsText=new ProductDetailsText();
		String path=productDetailsText.CreateDetailsTexts();
		tfidf.tfidf(path);
		
		//建立需求IDF库
		UserDemandDetailsText userDemandDetailsText=new UserDemandDetailsText();
		String path1=userDemandDetailsText.CreateDetailsTexts();
		tfidf.tfidf(path1);
		
	}
	
	
	/*
	 * 
	 * 计算需求余弦相似度
		
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
        //将result.entrySet()转换成list,并排序  
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(result.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {  
            //降序排序  
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                
                return (o1.getValue()).toString().compareTo(o2.getValue().toString());  
            }  
        });
        
        
        //构建商品表的返回结果集
        List<UserdemandsBean> listproduct = new ArrayList<UserdemandsBean>(); 
		for(Map.Entry<String, Double> item:list){
			listproduct.add(service.findUserdemandsById(item.getKey()));
			//System.out.println(item.toString());
		}
		
		return listproduct;
		
	}
	
	/*
	 * 
	 * 计算商品余弦相似度
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
        //将result.entrySet()转换成list,并排序  
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(result.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {  
            //降序排序  
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                
                return (o1.getValue()).toString().compareTo(o2.getValue().toString());  
            }  
        });
        
        
        //构建商品表的返回结果集
        List<ProductsBean> listproduct = new ArrayList<ProductsBean>(); 
		for(Map.Entry<String, Double> item:list){
			listproduct.add(service.findProductsById(item.getKey()));
			//System.out.println(item.toString());
		}
		
		return listproduct;
		
	}
	
	public static void main(String[] args) throws IOException {
        
		CreateTDF();
		//UserDemandCos("空调风扇随身携");
		//ProductCos("全新风扇风力");
	}
	
}
