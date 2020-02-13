package esj.algorithm.search;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;
import java.util.Map;  
import java.util.Map.Entry;
  
public class CosSimilarDegree  
{  
    /* 
     * 计算两个字符串的相似度，简单的余弦计算，未添权重 
     */  
     public static double getSimilarDegree(String str1, String str2)  
     {  
    	 
    	 str1=str1.replace(" ", "");
    	 str2=str2.replace(" ", "");
    	 
    	 String str11=null;
    	 String str22=null;
    	 
        //创建向量空间模型，使用map实现，主键为词项，值为长度为2的数组，存放着对应词项在字符串中的出现次数  
         Map<String, Double> vectorSpace1 = new HashMap<String, Double>();  
         Map<String, Double> vectorSpace2 = new HashMap<String, Double>();
         Map<String, Double> vectorSpace11 = new HashMap<String, Double>();
         Map<String, Double> vectorSpace22 = new HashMap<String, Double>();
         String[] itemArray = null;//为了避免频繁产生局部变量，所以将itemCountArray声明在此  
         
         //以空格为分隔符,分解字符串 ,构建str1中文字符串与vectorSpace1向量组
         String strArray1[] = str1.split(",");
         for(int i=0; i<strArray1.length; ++i)  
         {
        	 itemArray=strArray1[i].split("=");
        	 vectorSpace11.put(itemArray[0], Double.parseDouble(itemArray[1])); 
        	 str11=str11+itemArray[0];
         } 
         
         //以空格为分隔符,分解字符串 ,构建str2中文字符串与vectorSpace2向量组
         String strArray2[] = str2.split(",");
         for(int i=0; i<strArray2.length; ++i)  
         {
        	 itemArray=strArray2[i].split("=");
        	 vectorSpace22.put(itemArray[0], Double.parseDouble(itemArray[1]));
        	 str22=str22+itemArray[0];
         }
         

         //取vectorSpace11向量组与vectorSpace22向量组的交集构建vectorSpace1与vectorSpace2
         //构建vectorSpace1
         Iterator<Entry<String, Double>> iter1 = vectorSpace11.entrySet().iterator(); //iterator for that get from TF
         while(iter1.hasNext()){
             @SuppressWarnings("rawtypes")
 			 Map.Entry entry = (Map.Entry)iter1.next();
             if(str22.contains(entry.getKey().toString().trim())){
            	 vectorSpace1.put(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
             }
         }
         //构建vectorSpace2
         Iterator<Entry<String, Double>> iter2 = vectorSpace22.entrySet().iterator(); //iterator for that get from TF
         while(iter2.hasNext()){
             @SuppressWarnings("rawtypes")
 			 Map.Entry entry = (Map.Entry)iter2.next();
             if(str11.contains(entry.getKey().toString().trim())){
            	 vectorSpace2.put(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
             }
         }

         
         //将vectorSpace1.entrySet()转换成list1,并排序
         List<Map.Entry<String, Double>> list1 = new ArrayList<Map.Entry<String, Double>>(vectorSpace1.entrySet());  
         Collections.sort(list1, new Comparator<Map.Entry<String, Double>>() {  
             //降序排序  
             public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                 //return o1.getValue().compareTo(o2.getValue());  
                 return (o1.getKey()).toString().compareTo(o2.getKey());  
             }  
         }); 
         
         //将vectorSpace2.entrySet()转换成list2,并排序  
         List<Map.Entry<String, Double>> list2 = new ArrayList<Map.Entry<String, Double>>(vectorSpace2.entrySet());  
         Collections.sort(list2, new Comparator<Map.Entry<String, Double>>() {  
             //降序排序  
             public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {  
                 //return o1.getValue().compareTo(o2.getValue());  
                 return (o1.getKey()).toString().compareTo(o2.getKey());  
             }  
         });  
         
           
         //计算相似度  
         double vector1Modulo = 0.00;//向量1的模  
         double vector2Modulo = 0.00;//向量2的模  
         double vectorProduct = 0.00;//向量积  
         
         
         for (int i = 0; i < list1.size()&&i < list2.size(); i++) {
        	 
        	 double vector1=(Double) list1.get(i).getValue();
             double vector2=(Double) list2.get(i).getValue();
                 
             vector1Modulo += vector1*vector1;  
             vector2Modulo += vector2*vector2;  
                 
             vectorProduct += vector1*vector2;  
         }  
           
         vector1Modulo = Math.sqrt(vector1Modulo);  
         vector2Modulo = Math.sqrt(vector2Modulo);  
           
         BigDecimal bd1 = new BigDecimal(Double.toString(vector1Modulo));
         BigDecimal bd2 = new BigDecimal(Double.toString(vector2Modulo));
         double flag=bd1.multiply(bd2).doubleValue();
         
         
         
         if(flag==0){
        	 return 0;  
         }
         else{
        	 BigDecimal bd11 = new BigDecimal(Double.toString(vectorProduct));
         	 BigDecimal bd22 = new BigDecimal(Double.toString(flag));
         	 double result=bd11.divide(bd22,10,BigDecimal.ROUND_HALF_UP).doubleValue();
         	 
         	if(result==1)	 return flag;  

         	return result;

         }
     }         
}  
