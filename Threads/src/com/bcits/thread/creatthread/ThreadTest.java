package com.bcits.thread.creatthread;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread1 t=new Thread1();
		Thread1 t1=new Thread1();
		t.start();
		t1.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
