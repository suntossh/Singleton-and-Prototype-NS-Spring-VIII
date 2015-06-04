package com.suntossh.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanA implements ApplicationContextAware{
	
	private int value;
	private BeanB beanB;
	private ApplicationContext context;
	public BeanB getBeanB() {
		return context.getBean("beanBID",BeanB.class);
	}

	public void setBeanB(BeanB beanB) {
		System.out.println("Setting beanB through setBeanB method, setterInjection");
		this.beanB = beanB;
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
