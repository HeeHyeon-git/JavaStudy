package com.level1;

/*
 * ���ڿ��� ������ �ٲٱ�
 ���� ����
 ���ڿ� s�� ���ڷ� ��ȯ�� ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.

 ���� ����
 s�� ���̴� 1 �̻� 5�����Դϴ�.
 s�� �Ǿտ��� ��ȣ(+, -)�� �� �� �ֽ��ϴ�.
 s�� ��ȣ�� ���ڷθ� �̷�����ֽ��ϴ�.
 s�� 0���� �������� �ʽ��ϴ�.
 * */
public class Solution16 {
	public int solution(String s) {
		int answer = 0;
		int su = Integer.parseInt(s.substring(1));
		if (s.charAt(0) == '-') {
			answer = 0 - su;
		} else {
			answer = Integer.parseInt(s);
		}
		return answer;
	}
}