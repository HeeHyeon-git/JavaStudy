package com.level1.day03;

import java.util.Arrays;

/*
 * K��°�� - �ٽ�Ǯ��
���� ����
�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��

array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
 * */

public class Solution03 {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands[0].length];
		int[] selected ;
		int range = 0;
        int start, end;
        
		for (int i = 0; i < commands[0].length; i++) {
            end = commands[i][1];
            start = commands[i][0]-1;
			range = (end-start);
			selected = new int[range];

			for (int j = 0; j < range; j++) {
				selected[j] = array[start+j];
				System.out.print(selected[j]);
			}	
			
			Arrays.sort(selected);
			
			int idx = commands[i][2]-1;
			System.out.println("... idx " + idx);
			answer[i] = selected[idx];
			System.out.println("answer[i]: " + answer[i]);
		}

		return answer;
	}

	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4}; 
		int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		Solution03 s = new Solution03();
		s.solution(array, commands);
	}
}