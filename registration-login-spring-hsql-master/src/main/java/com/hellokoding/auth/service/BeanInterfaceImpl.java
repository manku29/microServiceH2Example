/**
 * 
 */
package com.hellokoding.auth.service;

import org.springframework.stereotype.Service;

/**
 * @author RAMAVI
 *
 */
@Service
public class BeanInterfaceImpl implements BeanInterface {

	/* (non-Javadoc)
	 * @see com.hellokoding.auth.service.BeanInterface#showString(java.lang.String)
	 */
	//https://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html
	public String init(){
		System.out.println("Im the init method................. ");
		System.out.println("Im the init method................. ");
		return "init method";
	}
	
	public void destory(){
		System.out.println("Im the destroy  method................. ");
		System.out.println("Im the destroy method................. ");
	}
	
	BeanInterfaceDependencyImpl beanInterfaceDependencyImpl;
	
	public BeanInterfaceImpl (){
		
	}
	public BeanInterfaceImpl(BeanInterfaceDependencyImpl beanInterfaceDependencyImpl) {
		super();
		this.beanInterfaceDependencyImpl = beanInterfaceDependencyImpl;
	}

	public BeanInterfaceDependencyImpl getBeanInterfaceDependencyImpl() {
		return beanInterfaceDependencyImpl;
	}

	public void setBeanInterfaceDependencyImpl(BeanInterfaceDependencyImpl beanInterfaceDependencyImpl) {
		this.beanInterfaceDependencyImpl = beanInterfaceDependencyImpl;
	}

	@Override
	public String showString(String str) {
		// TODO Auto-generated method stub
		System.out.println(" this method call from bean ceation");
		beanInterfaceDependencyImpl.setAddress("Hadapsar Pune ");
		beanInterfaceDependencyImpl.setArea( "958 sqr feet");
		beanInterfaceDependencyImpl.printDetails();
		return "test";
	}

}
