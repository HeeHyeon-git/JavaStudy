package com.level1.day03;

/*
 * �Ҽ� ã�� - �ٽ�Ǯ��
 ���� ����
 1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.

 �Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
 (1�� �Ҽ��� �ƴմϴ�.)

 ���� ����
 n�� 2�̻� 1000000������ �ڿ����Դϴ�
 * */

public class Solution05 {
	public int solution(int n) {
		int cnt = 0;
		boolean flag;

		for (int i = 2; i <= n; i++) {
			flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0 && i != j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		return cnt;
	}
}