package com.day03;

import java.util.Scanner;

class Test1 {
	
	public static void main(String[] args) {
		
/*		
		�ݺ���(for,while,do~while)
		for:���۰� ������ ���������� ��
		while:������ ���������� ���� ��
		do~while:1���� ������ �����Ű�� Ȯ���ؾ� �Ҷ�
*/
		//����
		Scanner sc = new Scanner(System.in);
		int dan;
		
		//�Է�
		System.out.print("�� �Է�?");
		dan = sc.nextInt(); //Scanner �ȿ� �ִ� �޼ҵ� : .nextInt(). �ݵ�� Scanner �� ���� ���ǵǾ� �־�� ��

		//for(�ʱⰪ;�ִ밪_����;������)
		for (int i=1;i<=9;i++) {
			//System.out.println(dan + " * " + i + " = " + (dan*i));
			System.out.printf("%d * %d = %d\n",dan, i, dan*i);
		}

		System.out.println("------------------------------------------");

		//while���� �Ϲ������� �ʱⰪ�� 0���� ������. 
		//�迭�� ����� ��� ù��° �迭�� [0]�� �� Ȱ���ϱ� ����
		
		//while(����) ��� ������ ���� �𸦋� ��κ� ���.
		
		int j=0; //���߿� �迭�� ����� �� ���ϰ� �ϱ� ���ؼ� 0���� ����. �������� �ƴ�. 
		while (j<9) {			
		
			j++;
			System.out.printf("%d * %d = %d\n",dan, j, dan*j);
		
		}
		
		System.out.println("------------------------------------------");

		//do~while(���ǹ�); �����ݷ� ������ �ȵ�. 1���� ������ �ٷ� ������ �ȴ�.
		int k=0;
		do {

			k++;
			System.out.printf("%d * %d = %d\n",dan, k, dan*k);			

		} while (k<9);

		System.out.println("------------------------------------------");		
/*		

		//���ѷ���. ���ǹ��� true�� ����.��� �ݺ�����
		while (true) {
			System.out.println("���ư���");
		}
*/
		sc.close(); //������ ��Ʈ���̱� ������ ����� �� �ݾ��ְų� null�� �ʱ�ȭ ���Ѿ� ��. �׷��� ������ �����Ⱚ�� �������� �� ����
		//������ Scanner�� �˾Ƽ� �ʱ�ȭ�����༭ ������ �ȳ�!
		
	}
}
