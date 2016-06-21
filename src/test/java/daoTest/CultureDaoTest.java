package daoTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crelic.dao.CulturalDao;
import com.crelic.model.CulturalBean;
import com.crelic.model.UploadFile;

public class CultureDaoTest {
	
	public void testHotSearch(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		List<CulturalBean> cblist = clDao.getHotSearch();
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle()+"  id:"+cblist.get(i).getIdentifier());
			System.out.println("mainpic:"+cblist.get(i).getMainpic());
			System.out.println("shape:"+cblist.get(i).getShape());
		}
	}
	
	public void testLatestCul(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		List<CulturalBean> cblist = clDao.getLatestCul();
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle()+"  id:"+cblist.get(i).getIdentifier());
			System.out.println("mainpic:"+cblist.get(i).getMainpic());
		}
	}
	
	public void testRecommdCul(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		List<CulturalBean> cblist = clDao.getRecommCul("Í­  Æ÷", 2);
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle()+"  id:"+cblist.get(i).getIdentifier());
			System.out.println("mainpic:"+cblist.get(i).getMainpic());
		}
	}
	
	public void testGetCultural(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String culId = "05177d86-af42-4b92-aad0-a39833454e52";
		CulturalBean cb = clDao.getCultural(culId);
		System.out.println(cb.toString());
	
	}
	
	public void testGetCulturalPic(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String culId = "05177d86-af42-4b92-aad0-a39833454e52";
		List<UploadFile> ewlist = clDao.getCulturalPic(culId);
		for(int i=0;i<ewlist.size();i++){
			System.out.println(ewlist.get(i).getFileSrc());
		}
	}
	
	public void testGetCulByType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String type="Í­  Æ÷";
		String time = null;
		String color = null;
		int pageNow = 2;
		List<CulturalBean> cblist = clDao.getCulByType(type, time, color, pageNow);
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle()+"  id:"+cblist.get(i).getIdentifier());
			System.out.println("mainpic:"+cblist.get(i).getMainpic());
		}
	}
	
	public void testSearch(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		List<String> keywords = new ArrayList<String>();
		keywords.add("Çà»¨´É");
		String time = "Ã÷";
		String color = null;
		int pageNow = 1;
		List<CulturalBean> cblist = clDao.search(keywords, time, color, "",pageNow);
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle());
		}
	}
	
	public void testGetCulByUserId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String userid="00A3FA987B4546779E5D0F9780C0A828";
		String time = null;
		String biaoyin = "¸ß¹ó";
		String color = null;
		int pageNow = 1;
		List<CulturalBean> cblist = clDao.getCulByUserId(userid, time, color, biaoyin,pageNow);
		for(int i=0;i<cblist.size();i++){
			System.out.println("title:"+cblist.get(i).getTitle());
		}
	}

	public void testGetRowCountByType(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String type="Í­  Æ÷";
		String time = "ºº";
		String color = null;
		int count = clDao.getRowCountByType(type, time, color);
		System.out.println(count);
	}
	
	public void testGetRowCountBySer(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		List<String> keywords = new ArrayList<String>();
		keywords.add("Çà»¨´É");
		String time = "";
		String color = null;
		int count = clDao.getRowCountBySer(keywords, time, color,"");
		System.out.println(count);
	}
	
	public void testGetRowCountByUserId(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String userid = "00A3FA987B4546779E5D0F9780C0A828";
		String time = null;
		String biaoyin = null;
		String color = null;
		int count = clDao.getRowCountByUserId(userid, time, color,biaoyin);
		System.out.println(count);
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CulturalDao clDao = (CulturalDao)context.getBean("culturalDao");
		String userid = "00A3FA987B4546779E5D0F9780C0A828";
		String time = null;
		String biaoyin = null;
		String color = null;
		int count = clDao.getRowCountByUserId(userid, time, color,biaoyin);
		System.out.println(count);
	}
	
}
