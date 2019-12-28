package com.bcits.thread.creatthreadUsingRunable;

public class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
