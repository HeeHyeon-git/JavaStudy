package com.day07;

class IntClass{//int�� �ΰ��� ������ �� �ִ� Ŭ����. Ŭ���� ��ü�� �ڷ����̶�� ����. Ŭ����=����ҷ� ����ϸ� ����
	//�������� ����
	int a;
	int b;	
}


public class Test1 {

	public static void main(String[] args) {

		IntClass ob1 = new IntClass(); //new�� ��ü�� ������ ���������� �ʱⰪ�� �������. int���̹Ƿ� 0
		IntClass ob2 = new IntClass();
		
		//�ν��Ͻ������� �ݵ�� �޸𸮸� �ٸ����� �����ϰ� 
		//�޼ҵ常 ���� �ּҷ� ������� �� �� �ִ� ����

		ob1.a=10;
		ob1.b=20;
		System.out.println("ob1.a:"+ob1.a); //10
		System.out.println("ob1.b:"+ob1.b); //20
		System.out.println("-------------");
		
		System.out.println("ob2.a:"+ob2.a); //0
		System.out.println("ob2.b:"+ob2.b);	//0
		System.out.println("-------------");
		
		ob2.a=100;
		ob2.b=200;
		System.out.println("ob2.a:"+ob2.a); //100
		System.out.println("ob2.b:"+ob2.b);	//200
		System.out.println("-------------");
		
		System.out.println("ob1.a:"+ob1.a); //10
		System.out.println("ob1.b:"+ob1.b); //20
		
	}

}
