package com.day05;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		//int[] num = { 28, 65, 7, 4, 10 };
		int i, j, temp;
		int num[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ټ����� ���ڸ� �Է��ϼ���:");
		
		for(i=0;i<num.length;i++){
			num[i]= sc.nextInt();
		}
		
		System.out.print("Source data: ");
		for (i = 0; i < num.length; i++) {
			System.out.printf("%4d", num[i]); // ���� ��ĭ�� �ڸ��� �ΰ� ���� ���
		}
		System.out.println();

		// Selection Sort. ��������. ���ֻ��. �ϱ�.
		for (i = 0; i < num.length - 1; i++) {

			for (j = i + 1; j < num.length; j++) { // ���ذ��� ���ϴ� ���� �׻� +1��°����
												   // ���ۺ��� ~ ������ �迭���ڸ�����
				//System.out.println(i+":"+j); //�ε������� ȸ���� ��ȸ
				if (num[i] > num[j]) { //�ε�ȣ�� ���� ��������(<), ��������(>) ���� ����. ũ�⿡ ���� �ڸ��ٲ� ����
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}

		}

		// ���
		System.out.print("Sorted data: ");
		for (int su : num) {// Ȯ�� for��. ���۰��� ���� ���� �����൵��. �迭, collection������ ����
			System.out.printf("%4d", su);
		}
		System.out.println();
		
		sc.close();
	}

}
