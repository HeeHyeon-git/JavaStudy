package com.level1;

/*
 * �ڵ��� ��ȣ ������
 * ���α׷��ӽ� ������� �������� ��ȣ�� ���� �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�.
 * ��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, ��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

 * ���� ����
 * s�� ���� 4 �̻�, 20������ ���ڿ��Դϴ�.
 */
public class Solution05 {
	public String solution(String phone_number) {
		String answer = "";
		for (int i = 0; i < phone_number.length() - 4; i++) {
			answer += "*";
		}
		answer += phone_number.substring(phone_number.length() - 4);

		return answer;
	}
}
