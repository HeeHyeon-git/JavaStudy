package com.day12;

//����Ŭ����(Local)
//�޼ҵ�ȿ� Ŭ������ ����

class Outer2{
	
	static int a = 10;
	int b = 20;
	
	public void write(){
		int c = 30;
		final int d = 40;
		
		class Local{//�޼ҵ�ȿ� Ŭ������ ����
			public void  print(){
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
			}		
		}
		
		//�޼ҵ�ȿ� �ִ� ����Ŭ������ �޼ҵ� �ȿ����� ��ü ���� ����
		Local ob = new Local();
		ob.print();
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		out.write();
	}

}
