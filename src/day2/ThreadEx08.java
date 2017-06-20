package day2;

public class ThreadEx08 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("���α׷� ���� ������ �̸�: " + mainThread.getName());
		System.out.println("-------------------------------");
		ThreadA threadA = new ThreadA();
		System.out.println("�۾� ������ �̸�: " + threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("�۾� ������ �̸�: " + threadB.getName());
		threadB.start();
		
		ThreadC threadC = new ThreadC();
		System.out.println("�۾� ������ �̸�: " + threadC.getName());
		threadC.start();
	}
}

class ThreadA extends Thread {	
	public ThreadA() {
		//setName("ThreadA");
	}
	
	public void run() {		
		for(int i=0; i<2; i++) {		
			System.out.println(getName() + "�� ����� ����");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadB extends Thread {
	public ThreadB() {
		//setName("ThreadB");
	}
	public void run() {		
		for(int i=0; i<2; i++) {		
			System.out.println(getName() + "�� ����� ����");
		}
		System.out.println("-------------------------------");
	}
}

class ThreadC extends Thread {	
	public void run() {		
		for(int i=0; i<2; i++) {		
			System.out.println(getName() + "�� ����� ����");
		}
		System.out.println("-------------------------------");
	}
}