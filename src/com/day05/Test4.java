package com.day05;

import java.util.Random;

public class Test4 {

	public static void main(String[] args) {

		// 1~45������ ���� 6���� ������ �߻����� ũ������� ���

		Random rd = new Random();
		//�������� : Random class ����ڰ� ������ ���ڹ��� �߿��� ������ ���ڸ� �ϳ� ������.

		int[] num = new int[6];
		int i, j, su, temp;
		su = 0;

		// while���� ����� �ݺ��ؾ����� �� �� ���.
		// ������ �����Ҷ� ������ ������ �����ԵǸ� �ٽ� �����ؾ� ��.
		while (su < 6) {
			num[su] = rd.nextInt(45) + 1; // 1~45�� ������. 0���� �����ϹǷ� '+1'�� �������
			for (int n = 0; n < su; n++) { //���� �����Ϳ� ���� ���ؾ��ϹǷ� for�� ���
				if (num[su] == num[n]) { // su:������ ���� ������ ����(�迭�� �ε���), n��° �����Ϳ� �����ϳ�
					su--; // �����ϴٸ� su�� ���̰� break������ ������. �ߺ������� �߻��ϸ� ������ ���� �ʿ���� �ٽ� ���� �̾Ƴ��� ��
					break;
				}
			}
			su++;		
		}

		// ����
		for (i = 0; i < num.length - 1; i++) {
			for (j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		// ���
		for (int n : num) {
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
}
