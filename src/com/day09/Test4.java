package com.day09;
//Object : ���Ŭ������ Object�� ��ӹ޴´�. 
class TestA extends Object{ // ���Ŭ������ �θ�Ŭ������ Object. 
	//extends Object�� ���� �ʾƵ� ���� �ȳ�. �⺻������ ��Ӱ����� �̹� �ݿ��Ǿ�����
	
	private int a = 10;
	
	public void write(){
		System.out.println("a: " + a);
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
	TestA ob1 = new TestA();	// new : ���������� ���Ӱ� ������. 100�� ������ 100�� �������
	TestA ob2 = new TestA();	
	System.out.println("ob1==ob2 : " + (ob1==ob2) ); 	//false : �ּҸ� ���� �� �̱� ����
	//�Ȱ��� Ŭ������ ��ü ���������� ob1�� ���� �ּҿ� ob2�� ���� �ּҰ� �ٸ��� ����
	System.out.println("ob1.equals(ob2) : " + (ob1.equals(ob2)) );	//.equals()��� �޼ҵ� ���
	//��� Ŭ������ �θ�� Object. ������� ������ �� �� ���� 
	//equals() �޼ҵ�� �ּҿ� �ּҸ� ����
	System.out.println("ob1: " + ob1); //com.day9.TestA@15db9742    <- @�ڿ� ���ڴ� hashcode
	System.out.println("ob2: " + ob2.toString()); //com.day9.TestA@6d06d69c ��Ű��.Ŭ����.hashcode
	//�ڹٿ����� �����ͺ��� ��� ���Ѵ�. 
	
	
	}

}
