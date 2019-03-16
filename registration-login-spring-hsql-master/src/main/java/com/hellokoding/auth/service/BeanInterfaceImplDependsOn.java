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
public class BeanInterfaceImplDependsOn implements BeanInterface {

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
	
	BeanInterfaceDependencyImplDependsOn beanInterfaceDependencyImplDependsOn;
	
	public BeanInterfaceImplDependsOn (){
		
	}



	public BeanInterfaceDependencyImplDependsOn getBeanInterfaceDependencyImplDependsOn() {
		return beanInterfaceDependencyImplDependsOn;
	}

	public void setBeanInterfaceDependencyImplDependsOn(
			BeanInterfaceDependencyImplDependsOn beanInterfaceDependencyImplDependsOn) {
		this.beanInterfaceDependencyImplDependsOn = beanInterfaceDependencyImplDependsOn;
	}

	@Override
	public String showString(String str) {
		// TODO Auto-generated method stub
		System.out.println(" this method on setter injection from bean ceation");
		beanInterfaceDependencyImplDependsOn.setAddress("Hadapsar Pune setter injection ");
		beanInterfaceDependencyImplDependsOn.setArea( "958 sqr feet setter injection");
		beanInterfaceDependencyImplDependsOn.printDetails();
		return "test";
	}

}
