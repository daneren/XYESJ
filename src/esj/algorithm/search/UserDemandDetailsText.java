package esj.algorithm.search;

import java.util.List;

import esj.publicdoc.bean.UserdemandsBean;
import esj.publicdoc.service.UserdemandsBeanService;
import esj.publicdoc.service.impl.UserdemandsBeanServiceImpl;
/**
 * 
 * 构建商品描文本集
 *
 */
public class UserDemandDetailsText {
	
	String CreateDetailsTexts(){
		
		UserdemandsBeanService service=new UserdemandsBeanServiceImpl();
		
		List<UserdemandsBean> list = service.findAllUserdemands();	
		
		FileOperate fileOperate=new FileOperate(); 
		
		//String rootpath=System.getProperty("user.dir");
		
		String rootpath=UserDemandDetailsText.class.getResource("/").getPath();
		
		String dirpath=rootpath+"/Details/Userdemand";	
		
		String diridfpath=rootpath+"/TFIDF/Userdemand";
		
		String textpath=null;
		
		String textcontent=null;
		
		fileOperate.createDir(dirpath);
		
		fileOperate.createDir(diridfpath);
		
		for(UserdemandsBean productsBean:list){
			
			textpath=dirpath+"/"+productsBean.getDemandId()+".txt";
			textcontent=productsBean.getTitle()+productsBean.getTagName()+productsBean.getDetails();
//			System.out.println(textpath);
//			System.out.println(textcontent);
			fileOperate.createFile(textpath,textcontent);
				
		}
		return dirpath;
		
	}	
	
}


