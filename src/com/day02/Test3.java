package com.day02;
class Test3 {
	public static void main(String[] args) {
		
		float f = 0; //�Ǽ��� ���� ���尪�� 0.0
		double d = 0; //�Ǽ��� ���� ���尪�� 0.0
		
		//�ݺ��� for (�ʱⰪ, ���ǹ�, ����) 
		//i++ -> i=i+1
		for (int i=1;i<=100000;i++){

			f = f + 100000;
			d = d + 100000;	

		}
		
		System.out.println("float: "+ (f/100000));
		System.out.println("double: "+ (d/100000));
		//�Ǽ��� �����Ҷ� float�� �������� �ս��� ���� �� ����.-> double�� �����ϴ°� ����
	}
}
