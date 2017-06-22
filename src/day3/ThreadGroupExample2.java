package day3;

import java.util.Map;
import java.util.Set;

public class ThreadGroupExample2 {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread");
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("Name: " + thread.getName() + ((thread.isDaemon())?"(����)": "(����)"));
			System.out.println("\t" + "�Ҽӱ׷�: " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}
}
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("�۾� ������ ������.");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}
