package daoTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crelic.dao.UserDao;
import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.UserBean;

public class UserDaoTest {
	
	/*测试登录*/
	public void testLogin(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		UserBean user = new UserBean();
		user.setUserName("test");
		user.setPassword("test123");
		if(userDao.checkUser(user))
			System.out.println("success");
		else
			System.out.println("failure");
	}
	
	/*测试收藏文物*/
	public void testCollectCul(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("33C54BEA95344D3580B7D4A17409DA11");
		cb.setCulid("0e74d085-d082-4533-8670-a211ffcf8396");
		cb.setCultype("铜  器");
		cb.setTime("2015-07-02 03:27:46");
		cb.setBiaoyin("贵重");
		if(userDao.collectCul(cb))
			System.out.println("收藏成功");
		else
			System.out.println("收藏失败");

	}
	
	/*测试删除收藏*/
	public void testDelCollect(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("33C54BEA95344D3580B7D4A17409DA11");
		cb.setCulid("0e74d085-d082-4533-8670-a211ffcf8396");
		if(userDao.delCollect(cb)){
			System.out.println("删除收藏成功！");
		}else
			System.out.println("删除收藏失败");
	}
	
	/*测试保存标引*/
	public void testSaveBy(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		cb.setCulid("1579ee28-f333-4994-896b-f5b577f321c6");
		cb.setBiaoyin("好看,漂亮");
		userDao.saveBy(cb);
	}
	
	/*测试批量标引*/
	public void testBatchBy(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		List<Biaoyin> bylist = new ArrayList<Biaoyin>();
		Biaoyin b1 = new Biaoyin();
		b1.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b1.setBiaoyin("漂亮");
		bylist.add(b1);
		Biaoyin b2 = new Biaoyin();
		b2.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b2.setBiaoyin("美丽");
		bylist.add(b2);
		userDao.batchBy(bylist);

	}
	
	/*测试获取标引列表*/
	public void testGetByList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		String userid = "00A3FA987B4546779E5D0F9780C0A828";
		List<String> bylist = userDao.getBy(userid);
		for(int i=0;i<bylist.size();i++)
			System.out.println(bylist.get(i));

	}
	
	/*测试根据名字获取id*/
	public void testGetIdByName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		String username = "wcytest";
		String userid = userDao.getIdByName(username);
		System.out.println(userid);
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		List<Biaoyin> bylist = new ArrayList<Biaoyin>();
		Biaoyin b1 = new Biaoyin();
		b1.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b1.setBiaoyin("漂亮");
		bylist.add(b1);
		Biaoyin b2 = new Biaoyin();
		b2.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b2.setBiaoyin("美丽");
		bylist.add(b2);
		userDao.batchBy(bylist);
	}
	
}
