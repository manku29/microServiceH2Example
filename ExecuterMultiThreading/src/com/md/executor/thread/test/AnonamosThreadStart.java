package com.md.executor.thread.test;

public class AnonamosThreadStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 10; i > 0 ; i--) {
					System.out.println("Anonamus Thread Start " +i);
				}
			}
		}).start();
	}

}
