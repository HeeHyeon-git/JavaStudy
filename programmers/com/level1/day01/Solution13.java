package com.level1.day01;

/*
 * �ڿ��� ������ �迭�� �����
 ���� ����
 �ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. ������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.

 ���� ����
 n�� 10,000,000,000������ �ڿ����Դϴ�
 * */
public class Solution13 {
	public int[] solution(long n) {

		String str = Long.toString(n);
		int[] answer = new int[str.length()];

		for (int i = str.length() - 1; i >= 0; i--) {
			answer[(str.length() - 1) - i] = Character.getNumericValue(str
					.charAt(i));
		}
		return answer;
	}
}