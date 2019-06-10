package com.level1.day05;

/*
 * ���� ���� �� �����ϱ�
 ���� ����
 ������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���. 
 ��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. 
 ������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.

 ���� ����
 arr�� ���� 1 �̻��� �迭�Դϴ�.
 �ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.
 * 
 * */
public class Solution05 {

	public int[] solution(int[] arr) {
		int[] answer = new int[arr.length == 1 ? 1 : (arr.length - 1)];
		int min = arr[0];
		int j = 0;

		// ��迭�� ��� -1
		if (arr.length == 1) {

			answer[0] = -1;
			return answer;

		} else {

			// ���� ���� �� ã��
			for (int k = 0; k < arr.length; k++) {
				if (min > arr[k]) {
					min = arr[k];
				}
			}

			for (int i = 0; i < answer.length; i++) {

				if (arr[i] == min) {
					j = 1;
				}
				answer[i] = arr[i + j];
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution05 sol = new Solution05();
		int[] arr = { 9, 15, 4, 6, 98, 77 };
		int[] answer = sol.solution(arr);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}