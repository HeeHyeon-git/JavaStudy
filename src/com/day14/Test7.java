package com.day14;

//���ͷ�Ʈ
//�켱������ ���� ���α׷��� ���� �����Ű�� �ٽ� ���ƿ´�. ������ ���鼭 �����Ű�� ���.

class MyThread7 extends Thread{
	
	private Thread next;
	
	public void setNext(Thread next){
		this.next=next;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			
			try {
				sleep(2000);//2�ʽ�
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(getName()+":"+i);
			
			if(next.isAlive())//�����尡 ��������� �����
				next.interrupt();//������ �����带 ������� ������ �ϴ°� ���ͷ�Ʈ
		}
	
	}
	
}
public class Test7 {

	public static void main(String[] args) {
		
		MyThread7 t1 = new MyThread7();
		MyThread7 t2 = new MyThread7();
		MyThread7 t3 = new MyThread7();
		
		t1.setNext(t2);//t1�� ���߸� t2�� ��Ƴ�
		t2.setNext(t3);//t2�� ���߸� t3�� ��Ƴ�
		t3.setNext(t1);//t3�� ���߸� t1�� ��Ƴ�
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();
		
	}

}
