package com.day13;

//Generic
class Box<T>{
	
	private T t; //T�� �ڷ����� �������� ����
	
	public void set(T t){//�ʱ�ȭ�޼ҵ�
		this.t = t;
	}
	
	public T get(){//��ȯ��ȣ��޼ҵ�
		return t;
	}
	
}

public class Test4 {
	
	public static void main(String[] args) {
		//������ ���� ������ ����. ���ʸ� ���� 
		Box<Integer> b1 = new Box<Integer>();
		
		b1.set(new Integer(10)); //T�� Ŭ����. �Ű����� �Է� �� ��ü�� ��������� ��. ������ �ڷ����� ��ü����
		Integer i = b1.get();
		System.out.println(i);
		//-----------------------------------------
		
		Box<String> b2 = new Box<String>();
		b2.set("����");
		String s = b2.get();
		System.out.println(s);
		//-----------------------------------------
		
		Box b3 = new Box(); //Box�� �ڷ��� ���� ���� ����. Object�� �������
		b3.set(30); //���� ū Ŭ���� Object�� box�� 30�Է�. upcast
		Integer ii = (Integer)b3.get(); //downcast
	
	}

}
