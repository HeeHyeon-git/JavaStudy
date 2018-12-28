package com.day11;

class SuperTest{
	
	public int a= 10, b= 20;
	
	public void write(){
		System.out.println("����Ŭ���� write() �޼ҵ�....");
	}
	
	public int hap() {
		return a+b;
	}

}

class SubTest extends SuperTest{
	public int b=100, c=200;

	public void print() {
		System.out.println("����Ŭ���� print() �޼ҵ�....");
	}
	
	@Override
	public int hap() {
		return a+b+c;
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
		SubTest ob1 = new SubTest();
		System.out.println("b: "+ ob1.b); //100
		
		//SuperTest ob2 = (SuperTest)ob1; ���������ȯ
		SuperTest ob2 = ob1; //�Ͻ�������ȯ. upcast
		
		System.out.println("b: "+ ob2.b); //20
		
		System.out.println("��: "+ ob2.hap()); //310. �޼ҵ�� ������ �ڽŰŸ� ȣ��
		
		ob2.write();	
		
		//ob2.print(); ob2�� �θ�Ŭ�����̹Ƿ� ���Ұ�. ������ ������.(�θ� �ڽĲ��� ����� �� ����.)
	}

}
