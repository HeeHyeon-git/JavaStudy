/*
6. �̸��� 3������ ������ �Է� �޾� �������ǿ� ���� ���
-��� ������ ������ 40�� �̻��̰� ����� 60�� �̻��̸� �հ�
-�Ѱ����̶� 40�� �̸��̰� ����� 60�� �̻��̸� ����
-����� 60�� �̸��̸� ���հ�

�̸� ? ȫ�浿
������ ���� ? 60 70 80
�̸� : ȫ�浿
���� : 210, ��� : 70, ���� :�հ�
*/
package com.problem;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		String name;
		int i, j, k;
		float average;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		name = sc.next();
		
		System.out.print("�� ������ ���� : ");
		i = sc.nextInt();
		j = sc.nextInt();
		k = sc.nextInt();
		
		average = (float)(i+j+k)/3 ;
		
		if(average<60){
			System.out.printf("%s���� ��� %.1f�� ���հ��Դϴ�.",name, average);
		}else if(i<40 || j<40 || k<40 ){
			System.out.printf("%s���� �������� ���հ��Դϴ�.",name);
		}else{
			System.out.printf("%s���� ��� %f�� �հ��Դϴ�.",name, average);	
		}	
		sc.close();
		
	
	}

}
