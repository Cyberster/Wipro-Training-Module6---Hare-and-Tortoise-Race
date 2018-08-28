package com.w3epic.service;

import com.w3epic.bean.Hare;
import com.w3epic.bean.Tortoise;

public class RaceMain implements Runnable {
	static Tortoise tortoise;
	static Hare hare;

	public static void main(String[] args) {		
		tortoise = new Tortoise();
		tortoise.setName("Tortoise");
		tortoise.setPriority(Thread.MIN_PRIORITY);
		
		hare = new Hare();
		hare.setName("Hare");
		hare.setPriority(Thread.MAX_PRIORITY);

		Thread t = new Thread(new RaceMain());
		
		tortoise.start();
		hare.start();
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			if (!tortoise.isAlive() && hare.isAlive()) {
				hare.stop();
				System.out.println("Tortoise won the race!");
				break;
			}
			if (!hare.isAlive() && tortoise.isAlive()) {
				tortoise.stop();
				System.out.println("Hare won the race!");
				break;
			}
		}
	}

}
