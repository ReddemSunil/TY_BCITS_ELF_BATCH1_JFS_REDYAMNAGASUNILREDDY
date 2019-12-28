package com.bcits.thread.wait;

public class Thread1 extends Thread{
	public synchronized void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	synchronized void leaveMe() {
		System.out.println("notify called");
		notifyAll();
	}
}
