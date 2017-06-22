package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PoolExample6 {
	public static void main(String[] args) throws Exception {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		fixedThreadPool.execute(new TestThread());
		fixedThreadPool.execute(new TestThread());
		fixedThreadPool.shutdown();
		
		while(!fixedThreadPool.isTerminated());
		System.out.println("-----------------");
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.execute(new TestThread());
		cachedThreadPool.execute(new TestThread());
		cachedThreadPool.shutdown();

		while(!cachedThreadPool.isTerminated());
		
		System.out.println("-----------------");
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ": Start");
				System.out.println("Executed");
				System.out.println(Thread.currentThread().getName() + ": End");
			}
		}, 3, TimeUnit.SECONDS);
		scheduledThreadPool.shutdown();
	}
}

class TestThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Start");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": End");
	}
}
