package com.day08;

public class Test3 {
	
	int a=5; //instance����
	
	//��ü�� �����Ǹ� �ٷ� ����Ǵ� instance ��
	
	{//�ʱ�ȭ ��. �޼ҵ�� ȣ������ �ʴµ� ������ ����� ��. instance. ��ü�� �����ؾ� �� �� ����
		System.out.println("�ʱ�ȭ �� a -> " + a);
		a=10;
		System.out.println("�ʱ�ȭ �� a -> " + a);	
	}
	
	static int b; //Ŭ��������. �޸� �Ҵ� �Ǿ� ����.
	
	static{//static ��
		b = 20;
		System.out.println("static �� b -> " + b);
	}
	
	final int C; //final���� = ���. �׻� ������ �ʴ� ��. �빮�ڷ� �ۼ���. ���α׷��� ���� �� ���� ���� �ٲ� �� ����
	//���࿡���� �������� �ʴ� ����������. ������(����)�� ���� ���� ������ ����Ѵ�.
	//����� ���� ���� ���صθ� ����. �ʱⰪ �ݵ�� �����ؾ� ��. �޸𸮿� �ö󰡾߸� �ʱ�ȭ ����. 
	//�Ϲ� �޼ҵ忡�� �ʱ�ȭ ��ų �� ����
	
	public Test3(){
		System.out.println("������...");
		C = 100;
		System.out.println("C:"+ C);
	}//�̷� ��쿡 ���� �������� �����Ǵ� ���� ������.
	
	public static void main(String[] args) {
		
		Test3 ob = new Test3(); //��ü����. static����� ���� ���� ������
		Test3 ob1 = new Test3(); //��ü �ΰ� ������ static�� ��ü�� ������ ���� �ѹ��� ���������. �޸𸮸� ���� ���ϱ�
	
		final int k = 10;
	}

}
