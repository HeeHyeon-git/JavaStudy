package com.level1.day01;

/*
 * ��� ���ϱ�
 ���� ����
 ������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution�� �ϼ��غ�����.

 ���ѻ���
 arr�� ���� 1 �̻�, 100 ������ �迭�Դϴ�.
 arr�� ���Ҵ� -10,000 �̻� 10,000 ������ �����Դϴ�.
 * */
public class Solution07 {
	public double solution(int[] arr) {
		double answer = 0;
		double sum = 0;
		for (int num : arr) {
			sum += num;
		}
		answer = sum / arr.length;
		return answer;
	}
}
