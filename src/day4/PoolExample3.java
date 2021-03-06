package day4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolExample3 {
	public static void main(String[] args) {
		ExecutorService  executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		
		System.out.println("[작업 처리 요청]");
		Callable<Integer> task = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
					try {
						Thread.sleep(1000);
						System.out.println("계산중");
					} catch(Exception e) {						
					}
				}
				return sum;
			}
		};
		Future<Integer> future = executorService.submit(task);
		
		try {
			int sum = future.get();
			System.out.println("[처리 결과] " + sum);
			System.out.println("[작업 처리 정상 종료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생함] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
