package day3;
class ThreadEx23 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx22();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account2 {
	private int balance = 1000; // private���� �ؾ� ����ȭ�� �ǹ̰� �ִ�.

	public  int getBalance() {
		return balance;
	}

	public synchronized boolean withdraw(int money){ // synchronized�� �޼��带 ����ȭ
		boolean result = false;
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
			result =  true;
		}
		return result;
	} 
}

class RunnableEx22 implements Runnable {
	Account2 acc = new Account2();

	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			boolean result = acc.withdraw(money);
			if (result) {
				System.out.println(Thread.currentThread().getName()+"���� "+money +"���� ����Ͽ� " +acc.getBalance()+"�� ���Ҿ��.");
			} else {
				System.out.println(Thread.currentThread().getName()+"���� "+money +"�� ����� �źεǾ����.. �ܾ� : " +acc.getBalance()+"�� ");
			}
		}
	} 
}
