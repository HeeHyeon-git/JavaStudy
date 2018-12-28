package com.day10;

class Parent{
	
	protected int a = 10; //protected: ������Ű���ȿ��� ��밡��
	protected int b = 20;
	
	public void write(){
		System.out.println("Parent Class write()...");
		System.out.println("a: "+ a + ", b: "+ b); //10,20
	}	
}

class Child extends Parent{
	protected int b = 30;
	protected int c = 40;
	
	@Override
	public void write() {
		//super.write();//�θ��� write �޼ҵ� ȣ��
		System.out.println("Child Class write()...");
		System.out.println("a: "+ a + ", b: "+ b+", c: "+ c); //10,20
		System.out.println("super.b: " + super.b);
	}
	public void print1(){
		System.out.println("Child Class print1() : write()ȣ��..");
		write(); //�θ� write�޼ҵ带 ���������� ���� �����ϱ� ���� ȣ��
	}
	public void print2(){
		System.out.println("Child Class print2() : super.write()ȣ��..");
		super.write();
	}	
}

public class Test8 {
	
	public static void main(String[] args) {

		Child ob = new Child();
		ob.write();		 //�ڽ��� �޼ҵ� ���. a�� ���� �����ϱ� �θ�Ŭ�������� ������. a: 10,b: 30,c: 40
		System.out.println("--------------------------------------------");
		
		ob.print1();
		System.out.println("--------------------------------------------");
		
		ob.print2();     //�θ��� �޼ҵ� ���. super �پ�����
		System.out.println("--------------------------------------------");
		
		System.out.println("ob.b : " + ob.b);						//�θ�Ŭ����, �ڽ�Ŭ���� ��� �����ϸ� �ڱ�� ���. b=30
		System.out.println("((Parent)ob).b : " + ((Parent)ob).b);	//�ڽ��� �θ�Ŭ������ ����ȯ��Ŵ. upcast. b=20
																	//�ڽ��� �θ�� casting : upcast 
		System.out.println("--------------------------------------------");
		
		ob.write();	//�ڽ��� write�޼ҵ� ȣ��
		System.out.println("--------------------------------------------");
		
		
		((Parent)ob).write();
		//�޼ҵ�� �ν��Ͻ� �����ʹ� �ٸ��� �ڽ��� �޼ҵ带 ȣ���Ѵ�
		//�޼ҵ�� heap������ �ƴ϶� �޼ҵ� ������ �ֱ� ������ ���� ����.(�޼ҵ� ���� ���� ����)
		//�޼ҵ�� upcast�� �ص� ������ �ڽ��� ���� ����Ѵ�.
		//�ڽ��� write�޼ҵ� ȣ��
/*	
 	**���**
	�ڽ��� �θ��� �޼ҵ带 override�ߴٸ� ������ ���� �޼ҵ峻���� �ٲٰ� �ͱ� ������ ����	
	���� �ǵ��� �� -> å������ ���ȿ����� ���ϱ� ������ ȣ���� ��� �ϴ��� �ڽ��� �޼ҵ� ����� ������
	�������̵� �޼ҵ带 �θ�Ŭ������ �޼ҵ�� �� ����ϰ� �ʹٸ� 
	�ڽĸ޼ҵ忡 super.�޼ҵ�();�� ȣ���ؼ� �ϴ� �������. ��, main�������� �Ұ�.
*/
	}
}
