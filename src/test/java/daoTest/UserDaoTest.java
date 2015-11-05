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
	
	/*���Ե�¼*/
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
	
	/*�����ղ�����*/
	public void testCollectCul(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("33C54BEA95344D3580B7D4A17409DA11");
		cb.setCulid("0e74d085-d082-4533-8670-a211ffcf8396");
		cb.setCultype("ͭ  ��");
		cb.setTime("2015-07-02 03:27:46");
		cb.setBiaoyin("����");
		if(userDao.collectCul(cb))
			System.out.println("�ղسɹ�");
		else
			System.out.println("�ղ�ʧ��");

	}
	
	/*����ɾ���ղ�*/
	public void testDelCollect(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("33C54BEA95344D3580B7D4A17409DA11");
		cb.setCulid("0e74d085-d082-4533-8670-a211ffcf8396");
		if(userDao.delCollect(cb)){
			System.out.println("ɾ���ղسɹ���");
		}else
			System.out.println("ɾ���ղ�ʧ��");
	}
	
	/*���Ա������*/
	public void testSaveBy(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CollectBean cb = new CollectBean();
		cb.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		cb.setCulid("1579ee28-f333-4994-896b-f5b577f321c6");
		cb.setBiaoyin("�ÿ�,Ư��");
		userDao.saveBy(cb);
	}
	
	/*������������*/
	public void testBatchBy(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		List<Biaoyin> bylist = new ArrayList<Biaoyin>();
		Biaoyin b1 = new Biaoyin();
		b1.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b1.setBiaoyin("Ư��");
		bylist.add(b1);
		Biaoyin b2 = new Biaoyin();
		b2.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b2.setBiaoyin("����");
		bylist.add(b2);
		userDao.batchBy(bylist);

	}
	
	/*���Ի�ȡ�����б�*/
	public void testGetByList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		String userid = "00A3FA987B4546779E5D0F9780C0A828";
		List<String> bylist = userDao.getBy(userid);
		for(int i=0;i<bylist.size();i++)
			System.out.println(bylist.get(i));

	}
	
	/*���Ը������ֻ�ȡid*/
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
		b1.setBiaoyin("Ư��");
		bylist.add(b1);
		Biaoyin b2 = new Biaoyin();
		b2.setUserid("00A3FA987B4546779E5D0F9780C0A828");
		b2.setBiaoyin("����");
		bylist.add(b2);
		userDao.batchBy(bylist);
	}
	
}
