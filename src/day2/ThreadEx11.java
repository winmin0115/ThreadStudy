package day2;

import java.awt.Toolkit;

public class ThreadEx11 {
	public static void main(String[] args) {
		System.out.println("�������");
		Toolkit toolkit = Toolkit.getDefaultToolkit();		
		for(int i=0; i<10; i++) {
			toolkit.beep();
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {			
			}		
		}
		System.out.println("��������");
	}
}
