package com.level1.day01;

/*
 * ¦���� Ȧ��
 ���� ����
 ���� num�� ¦���� ��� Even�� ��ȯ�ϰ� Ȧ���� ��� Odd�� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.

 ���� ����
 num�� int ������ �����Դϴ�.
 0�� ¦���Դϴ�.
 * */

public class Solution10 {
	public String solution(int num) {
		String answer = (num % 2) == 0 ? "Even" : "Odd";
		return answer;
	}
}