package com.day14;

//������ �׷�
//�����带 ������ ���� ����� �� �׷����� ���


public class Test11 {

	public static void main(String[] args) {
		
		System.out.println("���� ������ �׷� : " +Thread.currentThread().getThreadGroup());//main�̶�� �׷��� �ִµ� �׾ȿ� �����尡 �ִ� ��. 
		System.out.println("���� : " + Thread.currentThread());//���ν�����׷��� ����ִ� ���ν������� ����..?
		
		Thread t1 = new Thread();
		System.out.println("t1 ������ �׷� : " +Thread.currentThread().getThreadGroup());//t1�����带 ����� �׻� ���ν����� �׷쿡 ��
		System.out.println("t1 : " +t1);
		//Thread[Thread-0,5,main] = �������̸� Thread-0, �켱���� 5, main ������׷쿡 ����ִ�
	
		ThreadGroup tg = new ThreadGroup("tg");//�׷��̸�
		Thread t2 = new Thread(tg, "t2");
		Thread t3 = new Thread(tg, "t3");
		
		System.out.println("t2 : " +t2);
		System.out.println("t3 : " +t3);
		
	
	}

}
