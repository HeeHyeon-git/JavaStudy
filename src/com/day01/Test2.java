package com.day01;
class Test2 {

	public static void main(String[] args) {
	//args = argument
	//static ���� ���� ���� �����ʾƵ� �ڵ����� �޸𸮻� �ö󰡱� ������ ���డ�� - ��� ���α׷��� �޸𸮿� �ö󰡾� ������ ����.
	//�̰� ������� �ʴ´ٸ� ������ �۾��� ����� �� 
	//������ ���� integer. �ݵ�� �ҹ��ڷ� ����(����). �ι�°�ܾ��� ù���ڴ� �빮�� numOne. ����϶��� NUM ���� �빮�ڷ� ���

/*
		��������. ��׸��� �����. �ʱⰪ�� �������� ������ �����Ⱚ�� ����ִ�.
		int num1; 
		int num2;
		int�� ���尡�ɹ��� : �� -21��~21�� �� ���� �ʰ��� long���� �����ؾ� ��  
		������ �ʰ��ϸ� ��Ÿ�� ���� �߻�. �ڵ����� ������ �ƴ϶� �������� ����
				
		���� �ʱ�ȭ.(�ʱⰪ ����)
		num1 = 20; 
		num2 = 3; 
*/

		//�ڷ��� : int
		int num1 = 20;
		int num2 = 3;
		int num3;
		int num4;//�ʱⰪ���� �������Ƿ� �����Ⱚ�� ����ִ�
		
		//System.out.println(num3); //�ۼ� �� �����Ⱚ�� ����־ ����
		num3 = num1 + num2 ; 
		num4 = num1 - num2 ; 
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);		
		System.out.println(num1 + "+" + num2 +"= " + num3 );
		System.out.println(num1 + "-" + num2 +"= " + num4 );
		System.out.print("����\n\n"); //print�� �Ű������� �ݵ�� �ʿ�. println�� ��� ������ ����
		
		//format
		System.out.printf("%d+%d=%d\n",num1,num2,num3);
		System.out.printf("%d-%d=%d\n",num1,num2,num4);

	}
}



