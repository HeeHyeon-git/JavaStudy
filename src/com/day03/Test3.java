package com.day03;

public class Test3 {

	public static void main(String[] args) {

		// ����for��. for���� 4������ ��ø�Ǵ� ���������� ���� ����. ������尡 ũ�� ����.

		// ����
		int i, j;

		for (i = 2; i <= 9; i++) {

			System.out.println(i + "��");

			for (j = 2; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}

			System.out.println();
		}

	}

}
