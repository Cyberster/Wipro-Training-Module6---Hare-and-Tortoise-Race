package com.w3epic.bean;

public class Tortoise extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}
