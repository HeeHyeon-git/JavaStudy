package com.day05;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
/*		
 		�迭������ �����۾�.(Selection Sort)
		
		�ڹٿ����� �迭�� ������ �����ϱ����� collection �����
		collection �� �迭�� ����ϴ� ��� ����
		���� �ϳ��� ������ �־�� �����ص״ٰ� �����
		num[0] > num[1,2,3,4]? num[0]�� �� ũ�� �ڸ��ٲ� : ������ �⺻ ����

		int num[] = {35,27,13,5,10}  

		27 35 13 5 10
		13 35 27 5 10
		5 35 27 13 10		
		5 35 27 13 10 (4�� �ݺ�)
		->5�� ��ü�������� ���� ���� ������ ����.
		
		5 27 35 13 10
		5 13 35 27 10
		5 10 35 27 13 (3�� �ݺ�)
		->5 ,10 ����.
		
		5 10 27 35 13
		5 10 13 35 27 (2�� �ݺ�)
		->5 ,10, 13 ����.
		
		5 10 13 27 35 (1�� �ݺ�)
		->���� ��
			
		���� for�� �̿�. ��ü������ '�迭�� length-1'��, ���������� 4-3-2-1��
*/
		
		//�� ���� ���� �Է¹޾Ƽ� ���� �� ���� ū ���� ���
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3,temp;
		System.out.print("������ ��?");//9 5 2
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
/*		
 	 	//1-2, 2-3, 1-2�� 
 		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if(num2>num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
*/

		//1-2, 1-3, 2-3�� 
		if(num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
 		
 		if(num1>num3){
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
 		
		if(num2>num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.printf("��� : %d %d %d\n",num1, num2, num3);
		sc.close();
	}
}
