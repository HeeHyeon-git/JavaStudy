package com.day10;

//Wrapper class
//�ڹ����� �����ʹ� 2�� ����.
//boolean, byte, char, short, int, long, float, double

//���۷���(������) ������
//Boolean, Byte, Character, Short, Integer, Long, Float, Double
//����� ����� �Ǵ��� 

//auto-Boxing : stack -> heap  stack ������ �����Ͱ� heap �������� �Ѿ�� �� 
//auto-UnBoxing :heap -> stack  

public class Test4 {

	//n1 -> num1 , num2 -> n2 ������ Ȯ��. �� ����!
	public static void main(String[] args) {
		
		int n1 = 10;
		int n2; //�����Ⱚ 
		
		Integer num1;	//null. Integer�� Wrapper class. class�� �ʱⰪ�� null
		Integer num2 = new Integer(20);
		 
		num1 = n1; //auto-Boxing 
		n2 = num2; //auto-UnBoxing 
		
		System.out.println(n1+":"+ num1); //10:10
		System.out.println(n2+":"+ num2); //20:20
		
		/*
		int a = 10;
		double b; 
	
		b = a;			�Ͻ�������ȯ �ߵ�. 
		b = (double)a;  ���������ȯ
		
		a = b; 			�ȵ�
		a = (int)b;		���������ȯ. ū �������ڷ����� �ֱ� ���ؼ� �ݵ�� ���������ȯ �ʼ�
		---------------------------------------------
		
		**double�� int�� ��Ӱ���� �ƴ����� �����ϱ� ���ϰ� �� ��
		�θ�(b) - �ڽ�(a)	double�� �� ũ�� ��� ����. 
		
		�θ� = �ڽ� 		O upcast 
		�θ� = (�θ�)�ڽ�	O upcast 
		
		�ڽ� = �θ�			X
		�ڽ� = (�ڽ�)�θ�  	O downcast
		
		upcast������ �˾ƾ� ���߿� downcast�� �� �̿��� ����
		
		*/
	
	}
	
}
