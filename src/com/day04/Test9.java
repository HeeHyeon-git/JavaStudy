package com.day04;

public class Test9 {

	public static void main(String[] args) {

		// 1���� 100���� ���� Ȧ���� ��, ¦���� ��, ��ü�� ��
		int num[] = new int[100];
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < 100; i++) {
			num[i] = i + 1;
			// System.out.println(num[i]);

			if (num[i] % 2 == 0) {
				sum1 += num[i]; //¦����
			} else {
				sum2 += num[i];	//Ȧ����
			}
			sum = sum1 + sum2; //��ü��
		}

		System.out.println("1~100�� ��ü�� ��:" + sum);
		System.out.println("1~100�� ¦���� ��:" + sum1);
		System.out.println("1~100�� Ȧ���� ��:" + sum2);

	}

}
