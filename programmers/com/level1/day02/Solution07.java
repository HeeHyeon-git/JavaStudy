package com.level1.day02;

/*
 * ���ڿ� ������������ ��ġ�ϱ�
 ���� ����
 ���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
 s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.

 ���� ����
 str�� ���� 1 �̻��� ���ڿ��Դϴ�.
 * */

public class Solution07 {
	public String solution(String s) {
		String answer = "";
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		char temp;

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (char w : arr) {
			answer += w;
		}
		return answer;
	}
}