package com.day08;

class Rect{
	
	private int w;
	private int h;
	
	//private ���� �ʱ�ȭ ����� �ΰ���. �ʱ�ȭ�޼ҵ� �̿�, ������ �̿� 
	
	public Rect(){//�⺻������	
	}
	
	public Rect(int w, int h){//�����ε��� ������
		this.w = w;
		this.h = h;
	}
	
	public void set(int w, int h){//�ʱ�ȭ �޼ҵ�
		this.w = w;
		this.h = h;
	}
	
	public int area(){	
		return w*h;
	}
	
	public int length(){
		return 2*(w+h);
	}
	
	public void print(int a, int l){
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("����: "+ a);
		System.out.println("�ѷ�: "+ l);
	}
	
	public void print(int a){ //�޼ҵ� �����ε�(�ߺ�����)
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("����: "+ a);
	}
}

public class Test2 {
	
	public static void main(String[] args) {
		
		Rect ob1 = new Rect(); //�⺻������ + �ʱ�ȭ�޼ҵ� ���
		ob1.set(10, 20);		
		
		int area = ob1.area();
		int length = ob1.length();		
		ob1.print(area);
		ob1.print(area, length);
		
		System.out.println("-------------------");
		
		Rect ob2 = new Rect(100,200); //�����ε��� �����ڸ� ���� ��ü ������ �ʱ�ȭ �ٷ� ����. spring���� '������ ����'�̶�� ��
		
		area = ob2.area();
		length = ob2.length();	
		ob2.print(area);
		ob2.print(area, length);
		
	}

}
