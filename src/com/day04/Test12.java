package com.day04;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		// �μ��� �Է¹޾� ���� ������ ū�������� �� 1 10
		
		//����
		int i, j, k, tot;
		int max, min;
		
		//���� �ʱ�ȭ
		max = min = tot = 0;

		//�Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���� �Է��ϼ���.");
		i = sc.nextInt();//30
		j = sc.nextInt();//20		
		
		//����
		if (i > j) {
			max = i;
			min = j;
		}

		if (j > i) {
			max = j;
			min = i;
		}

		for (k = min; k <= max; k++) {
			tot += k;
		}
		//���
		System.out.printf("%d���� %d������ �� : %d", min, max, tot);

		sc.close();

	}

}
