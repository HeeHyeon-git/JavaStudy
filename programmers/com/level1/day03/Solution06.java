package com.level1.day03;

/*
 * ��� ���� ��������
 ���� ����
 �ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������. 
 �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ� �˴ϴ�.

 ���ѻ���
 s�� ���̰� 1 �̻�, 100������ ��Ʈ���Դϴ�.
 * 
 * */

public class Solution06 {
	public String solution(String s) {
		String answer = "";
		if (s.length() % 2 == 1) {
			answer = Character.toString(s.charAt(s.length() / 2));
		} else {
			answer = s.substring((s.length() / 2) - 1, (s.length() / 2) + 1);
		}
		return answer;
	}
}