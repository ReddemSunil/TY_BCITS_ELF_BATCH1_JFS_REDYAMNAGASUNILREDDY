package com.bcits.thread.wait;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread1 t=new Thread1();
		t.start();
		Thread1 t1=new Thread1();
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.leaveMe();
		
		System.out.println("main ends");
	}
}
 