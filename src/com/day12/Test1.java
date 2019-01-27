package com.day12;

//����Ŭ����(inner) 
//Ŭ���� �ȿ� Ŭ������ ����. Nested class
//Ŭ������ �޼ҵ��, Ŭ�����ȿ� �� �����ص� ���� ����. ��, ��ȣ �� ������� ��

class Outer1{ 	//������ �ϰԵǸ� Outer1.class
	
	static int a = 10;
	int b = 20;
	
	//InnerŬ������ ����ϱ� ���ؼ��� Outer1Ŭ������ �ݵ�� ��ü ���� ����� ��
	//�׷��� Outer1�� ��ü�� ���� �ƴٰ� Inner�� ������ �� �ƴϴ�.
	
	public class Inner1{	//������ �ϰԵǸ� Outer$Inner.class 
		
		int c = 30;
		
		public void write(){
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}

	public void print(){
		Inner1 ob = new Inner1(); //ù��° ���	
		ob.write();
	}

}


public class Test1 {

	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.print(); //Outer1�ȿ� �ִ� �޼ҵ带 ���ؼ� innerŬ������ ������ �� ����

		Outer1.Inner1 inner = out.new Inner1(); //�ι�°���
		inner.write();
	
	}

}
