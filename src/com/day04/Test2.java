package com.day04;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		// switch
		Scanner sc = new Scanner(System.in);
		int su;

		System.out.print("1~3�̳��� ��?");
		su = sc.nextInt();

		// switch(����)���� �ڷ��� ��� ��� ����. String�� ��������. ����ǥ ������ ����
		switch (su) {
		case 3:
			System.out.print("***");break;
		case 2:
			System.out.print("**");break;
		case 1:
			System.out.print("*");break;
		default:
			System.out.print("�����Է¿���!!");
		}

		sc.close();

	}
}
