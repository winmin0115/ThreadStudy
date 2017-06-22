package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolExample2 {
	public static void main(String[] args) {
		System.out.println("���� ���μ��� ���� : " + Runtime.getRuntime().availableProcessors());
		ExecutorService  executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		
		System.out.println("[�۾� ó�� ��û]" );
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
					try {
						Thread.sleep(1000);
						System.out.println("�����");
					} catch(Exception e) {						
					}
				}
				
				System.out.println("[ó�� ���] " + sum);
			}
		};
		Future<?> future = executorService.submit(runnable);
		
		try {
			if(future.get() == null) {
				System.out.println("[�۾� ó�� ���� ����]");
			}
		} catch(Exception e) {
			System.out.println("[���� ���� �߻���] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
