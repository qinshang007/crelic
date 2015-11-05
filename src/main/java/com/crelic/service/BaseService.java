package com.crelic.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crelic.dao.CulturalDao;
import com.crelic.dao.UserDao;

public class BaseService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/applicationContext.xml");

	private UserDao userDao = (UserDao) context.getBean("userDao");
	
	private CulturalDao cDao = (CulturalDao) context.getBean("culturalDao");
	
	public  UserDao getUserDao(){
		return userDao;
	}
	
	public CulturalDao getCulturalDao(){
		return cDao;
	}
}
