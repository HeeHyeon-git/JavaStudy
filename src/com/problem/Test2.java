/* 
 	2.�װ��� ������ �Է� �ް�, ū ���ڿ� ���� ���ڸ� �����ؼ� ���.(if�� �̿�)
	��) 20, 30 �Է½� -> ū ���� 30, ���� ���� 20

*/
package com.problem;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		int i, j;

		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���ڸ� �Է��ϼ���:"); //60 20
		i = sc.nextInt(); //����ȯ
		j = sc.nextInt(); 

		if(i < j) {
			System.out.printf("ū ���� %d, ���� ���� %d�Դϴ�.", j, i); 
		} else if(i > j) {
			System.out.printf("ū ���� %d, ���� ���� %d�Դϴ�.", i, j); 
		} else {	
			System.out.printf(" %d�� %d�� �����ϴ�.", i, j); 
		}

		sc.close();


	}

}
