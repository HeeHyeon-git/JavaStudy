package com.day09;

class Super{
	public Super(){}
	public Super(int x){		
		
	}
	public Super(int x, int y){		
		
	}	
}

class Sub extends Super{
	
	//Sub(){} �⺻������ ����
	//�� �ȿ� super() ����������. super()�� ������ �θ�-�ڽİ��� ���踦 ���������ִ� �� 
	public Sub(){
		this(10); //public Sub(int a){} ȣ��. �����ڿ��� ������ ȣ��. �̷��� this���
	}  
	public Sub(int a){
		//super(); �⺻������ ȣ��
		super(10,20); //�����ε��� �����ڸ� ȣ��.
	}
	
}



public class Test2 {

	public static void main(String[] args){
		Sub ob = new Sub(10);
	}
	
}
