package com.day14;

import java.util.Calendar;

class TClock implements Runnable {

	private int num;
	public TClock(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		int i = 0;
		while (i < num) {

			System.out.printf("%1$tF %1$tT\n", Calendar.getInstance());//������ �Ű����� ���� 1$
			i++;
			try {

				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		
/*		
		//���ѷ����� ������ �������
		while(true){
			
			System.out.printf("%1$tF %1$tT\n", Calendar.getInstance());
			try {
				Thread.sleep(1000);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
*/			

	}

}

public class Test3 {

	public static void main(String[] args) {//main ������

		System.out.println("main ����....");
		
		Thread t1 = new Thread(new TClock(100));
		
		t1.start();


	}

}
