package com.day07;

import java.util.Scanner;

class Circle{
	
	private int r; //instance����. �߰��� ���� ������ �� �����ϱ� �ܺο��� �������� ���ϰ� ���������� �ۼ�. 
				   //private : within the class 
				   //�ƹ��͵� ���� ������ public 
				   //������ ����(ĸ��ȭ)
/*	
	�����ʱ�ȭ ��� : '=' �̿��ؼ� ���� ���� 
					  .set()�޼ҵ� Ȱ��

	Circle ob = new Circle(); ��ü���� 
	ob.setData(10); �Ű����� 10���� setData�޼ҵ带 �����ض�.  
	��ȸ�ؼ� ������ ���� �ִ� ��. private�� ��� �ݵ�� �̷� �޼ҵ尡 �־�� �Ѵ�.
	
	this : me. class �̸�
	
	�ڵ��ϴٺ��� ������ ������ garbage �����Ͱ� �����ϴ� ��찡 ����
	VM���� �̷� Ŭ�������� �����ϴ� garbage collector�� ������
	�׷��� �޼ҵ尡 ���� ���� ������ ���ƴٴϴ� �ڵ����� �����ǹǷ� �ϳ��� ������ ���ϴ� ��쵵 ����
	
*/	
	//�ʱ�ȭ �޼ҵ�. �Ű����� �̿�. private ������ ��� �� �޼ҵ尡 �ݵ�� �ʿ��� 
	public void setData(int r){//setData(int r, Circle this) ���������δ� �̷��� ó����
		
		this.r = r;	//�������� r, �������� r �̸��� �����ϸ� ���и���
					//��ǻ�Ϳ��� ���������� �ν��ϰ� �ϱ� ���� this���. this�� me �� ����. �ڱ��ڽ�. Ŭ�����̸��� ����.
					//ȥ���� ������ ������ �����ص� ��
	}

	public double area(){//area(Circle this)
		return this.r*this.r*3.14;	
	}
	
	public void write(double a){//write(double a, Circle this)
		System.out.println("������:" + this.r);
		System.out.println("����:" + a);
	}
	
}

public class Test2 {

	public static void main(String[] args) {

		Circle c1 = new Circle(); 
		//c1.r = 100; ĸ��ȭ �Ǿ��־� �ܺο��� ������ �� ����. �����ϸ� ������
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� �Է��ϼ���: ");
		int r = sc.nextInt();
		c1.setData(r);				//c1.setData(r,c1); ���������� c1Ŭ������ �ּҸ� ������ 
		double result = c1.area();	//c1.area(c1); �Ű����� �����Ƿ� c1Ŭ������ �ּҸ� ������ 
		c1.write(result);			//c1.write(result,c1);
		
	}

}
