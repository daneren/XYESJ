package esj.algorithm.search;

import java.util.Collections;
import java.util.List;

import esj.back.control.product.service.ProductsService;
import esj.back.control.product.service.impl.ProductsServiceImpl;
import esj.back.util.Product_ListServletComparator;
import esj.publicdoc.bean.ProductsBean;
/**
 * 
 * 构建商品描文本集
 *
 */
public class ProductDetailsText {
	
	String CreateDetailsTexts(){
		
		ProductsService service=new ProductsServiceImpl();
		
		List<ProductsBean> list = service.findAllProducts();
		
		Collections.sort(list,new Product_ListServletComparator());				
		
		FileOperate fileOperate=new FileOperate(); 
		
		//String rootpath=System.getProperty("user.dir");
		String rootpath=ProductDetailsText.class.getResource("/").getPath();
		
		String dirpath=rootpath+"/Details/Product";	
		
		String diridfpath=rootpath+"/TFIDF/Product";
		
		String textpath=null;
		
		String textcontent=null;
		
		fileOperate.createDir(dirpath);
		
		fileOperate.createDir(diridfpath);
		
		for(ProductsBean productsBean:list){
			
			textpath=dirpath+"/"+productsBean.getProId()+".txt";
			textcontent=productsBean.getTitle()+productsBean.getTagName()+productsBean.getDetails();
			//System.out.println(textpath);
			//System.out.println(textcontent);
			fileOperate.createFile(textpath,textcontent);
				
		}
		return dirpath;
		
	}	
	
}


