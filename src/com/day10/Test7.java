package com.day10;

//final�� ���� �� �ִ� 3���� ���
//��������� final�� ���̸� : �� �ѹ��� �ʱ�ȭ�� ����
//�޼ҵ忡 final�� ���̸� : Override(������) �Ұ�.
//Ŭ������ final�� ���̸� : ��� �Ұ�
//final class Test{} -> public class Test7 extends Test{}  �Ұ���!

class Test{ 								//TestŬ������ final������ ��� �Ұ�
	public static final double PI;			//�������
	static{
		PI = 3.141592; 
	}
	public double area; 					//�ν��Ͻ� ����
	public final void write(String title){	//�޼ҵ忡 final�پ �������̵� �Ұ�
		System.out.println(title+":"+area);
	}
}

public class Test7 extends Test{ 
/* 
    �θ�Ŭ������ final�� �پ������� �������̵��� �Ұ����ϴ�.
 	@Override
	public void write(String title) {
		super.write(title);
	}
*/	
	public void circleArea(int r){
		area= (double)r*r*PI;	
	}
	
	public static void main(String[] args) {
		Test7 ob = new Test7();			//��ü����
		//PI = 100; �ʱ�ȭ�� ������ ���� �Ұ�
		ob.circleArea(10);				//�ڽ�Ŭ���� �޼ҵ�
		ob.write("��");					//�θ�Ŭ���� �޼ҵ�
	}

}
