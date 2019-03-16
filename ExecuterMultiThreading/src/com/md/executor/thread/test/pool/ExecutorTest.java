/**
 * 
 */
package com.md.executor.thread.test.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author RAMAVI
 *
 */
public class ExecutorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Start the main thread ");
	
	// pool only allow three parallel task execute in a pool, once available then another task will
	// start to execute.
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.submit(new TestThreadTypeFour());
		es.submit(new TestThreadTypeFour());
		es.submit(new TestThreadTypeFour());
		es.submit(new TestThreadTypeFour());
		es.submit(new TestThreadTypeFour());
		es.submit(new TestThreadTypeFour());
		
		es.shutdown();
		//Rejcted Exception because after shut down the executor no new thread can be
		//executed, but it wait untill all thread completed 
		es.submit(new TestThreadTypeFour());
		System.out.println("end  the main thread ");
		
	}

}
