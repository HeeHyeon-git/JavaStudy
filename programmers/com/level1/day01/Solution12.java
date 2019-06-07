package com.level1.day01;

/*
 * ���� ������������ ��ġ�ϱ�
 ���� ����
 �Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���. ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.

 ���� ����
 n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.
 * */
public class Solution12 {
	public long solution(long n) {
		String answer = "";
		String str = Long.toString(n);
		int arr[] = new int[str.length()];
		int temp;
		long result = 0;
		for (int k = 0; k < str.length(); k++) {
			arr[k] = Character.getNumericValue(str.charAt(k));
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int s : arr) {
			System.out.printf("%d  ", s);
			answer += s;
		}
		result = Long.parseLong(answer);
		return result;
	}
}