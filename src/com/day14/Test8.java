package com.day14;

class MyThread8 implements Runnable{
	
	private int bank = 10000;
	
	private int getBank(){//�ܾ�Ȯ�θ޼ҵ�
		return bank;
	}
	
	private int drawMoney(int m){//�ܾ�����޼ҵ�
		bank -=m;//bank=bank-m;
		return m;
	}
	
	@Override
	public void run() {
		
		int money_need = 6000;//����ݾ�
		int money;//�ܾ�
		String msg = "";
		
		try {
			
			//����ȭ�� t1 �����尡 �����ԵǸ� �ٸ� ������ ���� ���ٺҰ�
			synchronized (this) {

				if (getBank() > money_need) {//�ܰ� �� ũ�� ����
					
					Thread.yield();
					// A hint to the scheduler that the current thread is willing to yield its current use of a processor.
					// The scheduler is free to ignore this hint.
					// sleep �޼ҵ�ó�� �ٸ� �����忡�� ������ ��ȸ�� �ֱ� ���� ����.
					// �켱���� ������ �����忡�� ���� ��ȸ ����
					money = drawMoney(money_need);
				
				} else {
					money = 0;
					msg = ", �������";
				}
			}
		
			System.out.println(Thread.currentThread().getName()+ msg +", ����ݾ�: " + money + ", �ܰ�: "+ getBank());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

public class Test8 {

	public static void main(String[] args) {

		MyThread8 ob = new MyThread8();
		//Thread t1 = new Thread(new MyThread8()); ����

		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
		//������ t1,t2�� run�� �����Ϸ��� �����ϴٺ��� �ܰ� -2000, -2000�� �Ǵ� ��� �߻�
		//����ȭ ������� �ذ� synchronized(){}
		//wait() �޼ҵ�,  notify() �޼ҵ� �� ����ȭ ��Ͽ����� ���
	}

}
