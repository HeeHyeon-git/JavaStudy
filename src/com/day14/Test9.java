package com.day14;

class MyThread9 implements Runnable{
	
	private int bank = 10000;
	private int getBank(){
		return bank;
	}
	
	//wait() �޼ҵ�,  notify() �޼ҵ� �� ����ȭ ��� synchronized(){} ������ ���
	private int drawMoney(int m){
		
		if(getBank()>0){
			bank -= m ;
			System.out.println(Thread.currentThread().getName() + ",����: " +m +", �ܾ�:" + bank);
			
		}else{
			m=0;
			System.out.println(Thread.currentThread().getName() + "�ܾ׺���!");
		}
			
		return m;
		
	}

	@Override
	public void run() {

		synchronized (this) {// Ŭ���� ��ü�� ���;���. Ŭ���� ��ü�� ������.

			for (int i = 0; i <= 10; i++) {

				if (getBank() <= 0) {
					this.notifyAll();// �������� ��罺���带 ����
					break;
				}

				drawMoney(1000);

				if (getBank() == 2000 || getBank() == 4000 || getBank() == 6000|| getBank() == 8000) {

					try {
						wait();//stop
						// synchronized�� ���� �ٸ� �����尡 ���� �� ������ wait�� ������ ����.
						// �ϳ��� �����尡 ������̸� �ٸ� ������� ����ȭ ���� ���� �� ������ wait()�� ������ �����ϴ�.
					} catch (Exception e) {

					}

				} else {
					notify();
				}
			}

		}

	}
	
}


public class Test9 {

	public static void main(String[] args) {
		MyThread9 ob = new MyThread9();
		
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
	}
	
}
