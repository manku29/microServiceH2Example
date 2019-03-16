/**
 * 
 */
package com.md.executor.thread.test.pool;

/**
 * @author RAMAVI
 *
 */
public class TestThreadTypeFour implements Runnable {

	public static int count = 0;
	int id = 0;
	@Override
	public void run() {
		
		for(int i =10;i>=1 ;i--) {
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" thrad nunber "+id +" , counting " +i);
		}
		
	}

	TestThreadTypeFour(){
		count++;
		id = count;
	}
}
