package day3;
class ThreadEx22 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx21();
		new Thread(r).start(); 
		new Thread(r).start(); 
	}
}

class Account {
	private int balance = 1000;

	public  int getBalance() {
		return balance;
	}

	public boolean withdraw(int money){
		boolean result = false;
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
			result =  true;
		}
		return result;
	} 
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();

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
	} // run()
}
