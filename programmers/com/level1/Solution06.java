package com.level1;

/*
 * �ϻ��� ��
 ���� ����
 ���� ���� x�� �ϻ��� ���̷��� x�� �ڸ����� ������ x�� ���������� �մϴ�. ���� ��� 18�� �ڸ��� ���� 1+8=9�̰�, 18�� 9�� ������ �������Ƿ� 18�� �ϻ��� ���Դϴ�. �ڿ��� x�� �Է¹޾� x�� �ϻ��� ������ �ƴ��� �˻��ϴ� �Լ�, solution�� �ϼ����ּ���.

 ���� ����
 x�� 1 �̻�, 10000 ������ �����Դϴ�
 * */
public class Solution06 {

	public boolean solution(int x) {
		boolean answer = false;
		String num = Integer.toString(x);
		int cnt[] = { 0, 0, 0, 0, 0 };
		int sum = 0; // �ڸ�����

		for (int i = 0; i < num.length(); i++) {
			cnt[i] = Character.getNumericValue(num.charAt(i));// �� �ڸ���
			System.out.println("cut[" + i + "]:" + cnt[i]);
			sum += cnt[i];
		}
		if ((x % sum) == 0) {
			answer = true;
		}
		return answer;
	}
}
