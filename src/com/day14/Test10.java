package com.day14;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//������ �ð����� Ư�� �۾��� �ϰ� ������

public class Test10 extends Thread{
	
	private int num = 10;
	
	public Test10(){
		
		TimerTask task = new TimerTask() {//�͸���Ŭ����
			
			@Override
			public void run() {
				//�ݺ� ������ �۾�
				num = 0;
			}
		};
		
		Timer t = new Timer();
		Calendar d = Calendar.getInstance();
		/*
		  ���� 0�� 0�� 0�ʺ��� �Ϸ翡 �ѹ��� �ݺ�
		  d.add(Calendar.Date,1);
		  d.set(Calendar.Hour,0); 			//���� 1�ô� 13���� ǥ��. 0�� �� 12��. 1�� ���� 1��
		  d.set(Calendar.MINUTE,0);			//��
		  d.set(Calendar.SECOND,0);			//��
		  d.set(Calendar.MILLISECOND,0);	//�и�����
		  
		  t.schedule(task, d.getTime(),1000*60*60*24)//�и�����*��*��*��
		  
		 */
		t.schedule(task, d.getTime(), 5000);// 5000:interval(5�ʰ���)���� ����
		
	}
	
	@Override
	public void run() {
		while(true){
			
			System.out.println(num++);
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {

		//Test10 ob = new Test10();
		//ob.start();
		
		new Test10().start();//��ü�� ���� �ѹ��� �����ϰ� ������ ��. �޸��� ���� ���� �� ����.
		
		
	}

}
