package com.level1.day02;
/*
 * ���ڿ� �ٷ�� �⺻
���� ����
���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���.
���� ��� s�� a234�̸� False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.

���� ����
s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
 * 
 * */
public class Solution03 {

	public boolean solution(String s) {
		boolean answer = true;
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) > 47) || !(s.charAt(i) < 58)) {
				return false;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Solution03 sol = new Solution03();
		System.out.println(sol.solution("a123"));
		System.out.println(sol.solution("1123"));
	}
}