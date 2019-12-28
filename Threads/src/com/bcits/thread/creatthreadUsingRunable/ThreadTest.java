package com.bcits.thread.creatthreadUsingRunable;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread1 t1=new Thread1();
		Thread t3=new Thread(t1);
		Thread1 t2=new Thread1();
		Thread t4=new Thread(t2);
		t3.start();
		t4.start();
		System.out.println("main ends");
	}
}
