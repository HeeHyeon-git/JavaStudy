package com.level1.day03;

import java.util.Arrays;

/*
 * ������ �������� ���� �迭
���� ����
array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.

���ѻ���
arr�� �ڿ����� ���� �迭�Դϴ�.
���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
divisor�� �ڿ����Դϴ�.
array�� ���� 1 �̻��� �迭�Դϴ�.
*/


public class Solution01 {

	public int[] solution(int[] arr, int divisor) {
		int[] answer;
		int cnt = 0;
		Arrays.sort(arr);
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				cnt++;
			}
		}

		if (cnt == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[cnt];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % divisor == 0) {
					answer[k++] = arr[i];
				}
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		
		Solution01 s = new Solution01();
		int[] arr = {2,3,4,5,6,7,8,9,9,10,15};
		int divisor = 5;
		int[] answer = s.solution(arr, divisor);
		for(int a: answer){
			System.out.print(a+" ");
		}	
	}
}