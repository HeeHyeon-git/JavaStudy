package com.day04;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		// �迭. �� ��� �� �ۼ� ����
		// �Ϲ������� 1���� �迭,2���� �迭 ���� �����. 3���� �迭�� ���� ��
		// int num[]= new int[5];
		int[] num = new int[5];

		Scanner sc = new Scanner(System.in);

		System.out.println("���� �Է��ϼ���");
		// �迭�� ����� �ʱⰪ�� �������ϸ� ����Ʈ���� ����
		// String:null, int:0, boolean:False(0)

		// for���ȿ��� ���� ������ ��������. �ٸ� for���� ���������ʹ� ���� ��ġ�� ����
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		// ���۰��� ������ ������ �����Ƿ� �迭 + �ݺ��� �Բ����� �� ����
		for (int i = 0; i < num.length; i++) {
			System.out.println("num[" + i + "]: " + num[i]);
		}

		// �迭�� ����
		System.out.println("�迭�� ����: " + num.length); // �迭�� length �޼ҵ常 ()�� ����.
		System.out.println("�迭�� ������ �� ��ȣ: " + (num.length - 1));

		sc.close();

	}

}
