package com.suntossh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		BeanA beanA = context.getBean("beanAID", BeanA.class);
		
		beanA.getBeanB().execute();
		//check if int value persists accross 2 invokation of getBeans
		beanA.setValue(101);
		System.out.println(beanA.getValue());
		BeanA beanA2 = context.getBean("beanAID", BeanA.class);
		System.out.println(beanA2.getValue());
		System.out.println(beanA == beanA2);// will be true as default scope of singleton is applied
		System.out.println(beanA == beanA2?"Same Instance" : "Different Instance");
		
		BeanB beanB = context.getBean("beanBID", BeanB.class);
		BeanB beanB2 = context.getBean("beanBID", BeanB.class);
		
		System.out.println(beanB == beanB2);// will be false as prototype scope is applied
		System.out.println(beanB == beanB2?"Same Instance": "Different Instance");
		
		// but when a prototype is part of Singleton, then Ideally Singleton should be same,
		// and prototype should not be same which will happen in normal scenario
		
		BeanB beanB3 = beanA.getBeanB();
		BeanB beanB4 = beanA2.getBeanB();
		
		System.out.println(beanB3 == beanB4);// will be true in normal coding, which is not Ideal, so will modify BeanA Code 
		// BeanA will implements ApplicationContextAware interface and reload BeanB in getBeanB method, so now it will be false
		System.out.println(beanB3 == beanB4?"Same Instance": "Different Instance");
		
		
		
		
		
	}
	
}
