package com.day05;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		//5���� ������ �Է¹޾� �Է¹��� ���� ����ϰ� �Է¹��� ���� ���� ū���� �������� ���

		int num[] = new int[5];
		int i, max, min;

		System.out.print("���� �ټ����� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		for (i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		max = min = num[0];

		for (i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
		}

		System.out.println("�ִ�: " + max + ", �ּҰ�: " + min);
		sc.close();

	}// endmain

}// endclass
