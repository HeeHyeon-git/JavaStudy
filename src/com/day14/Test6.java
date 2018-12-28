package com.day14;

//������ �����ֱ�(Time to live)

class MyThread6 extends Thread{
	
	@Override
	public void run() {
	
		try {
			System.out.println("������ ����..");
			System.out.println("�켱����: " + getPriority());
			System.out.println("������ �̸�: " + getName());//ù��° ��������� �������� �������� �̸� : Thread-0
			
			sleep(500);//0.5�� ��
			
			//�켱���� ����
			setPriority(2);
			System.out.println("����� �켱����: " + getPriority());
			
			System.out.println("������ ����..");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}


public class Test6 {

	public static void main(String[] args){
		
		Thread t1 = Thread.currentThread();//���� ������(=main ������)�� t1�� �Ҵ�. 
		Thread t2 = new MyThread6();//upcast. MyThread6�� ������ �ִ� �޼ҵ��� �θ�Ŭ������ ���°� �ִٸ� upcast �ȵ�
		
		System.out.println("main������ �켱����: " + t1.getPriority());//��� ������� ����Ʈ�� 5
		System.out.println("main������ �̸�: "+ t1.getName());//main
		System.out.println("start()�޼ҵ� ȣ�� ���� isAlive: " + t2.isAlive());//start�����̹Ƿ� �翬�� false
		
		t2.start();
		
		//t2�� �켱����
		System.out.println("t2�� �켱����: " + t2.getPriority());
		
		//t2�� �켱���� ����(5->1)
		t2.setPriority(1);
		
		try {
			//0.1�� ��
			Thread.sleep(100);
			
			//t2����Ȯ��
			System.out.println("t2 ����ֳ�? " + t2.isAlive());
			
			//1�� ��
			Thread.sleep(1000);
			
			//t2����Ȯ��
			System.out.println("1���� t2 ����ֳ�? " + t2.isAlive());
			
			t2.join();//main������ wait��û. �̹� t2�� ����Ǿ������Ƿ� join�ص� ����Ǿ�����. �ѹ� ����� ������� �ٽ� �츱 �� ����
			System.out.println("t2 �׷��� ����ֳ�? " + t2.isAlive());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
