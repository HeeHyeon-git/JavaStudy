package com.level1;

/*
 * ����� ��
 ���� ����
 �ڿ��� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

 ���� ����
 n�� 0 �̻� 3000������ �ڿ����Դϴ�.
 */
public class Solution15 {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= (n / 2); i++) {
			answer += (n % i == 0) ? i : 0;
		}
		answer += n; // �ڱ��ڽ�
		return answer;
	}
}