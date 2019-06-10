package com.level1.day05;

/*
 ���ǰ��
 ���� ����
 �����ڴ� ������ ������ ����� �ظ��Դϴ�. 
 ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. 
 �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
 ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

 ���� ����
 ������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
 ������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
 ���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
 */

public class Solution02 {
	public int[] solution(int[] answers) {
		int[] answer;
		int[] count = new int[3]; // �����
		int topCount = 1;
		int max = -1;
		int supoja1[] = { 1, 2, 3, 4, 5 };
		int supoja2[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int supoja3[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int k = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == supoja1[i % 5])
				count[0]++;// 1������������
			if (answers[i] == supoja2[i % 8])
				count[1]++;// 2������������
			if (answers[i] == supoja3[i % 10])
				count[2]++;// 3������������
		}

		// ���� ���� ������ �ο��� ã��
		for (int j = 0; j < 3; j++) {
			if (count[j] == max) {
				topCount++;
			}

			if (count[j] > max) {
				max = count[j];
				topCount = 1;// �ִ�ġ �������� �ʱ�ȭ
			}
		}

		// �迭 ��ȯ
		answer = new int[topCount];
		for (int j = 0; j < 3; j++) {
			if (count[j] == max) {
				answer[k++] = j + 1;
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		Solution02 supoja = new Solution02();
		int[] answers= {1,2,3,4,5};
		int[] grade = supoja.solution(answers);
		for(int i:grade){
			System.out.print(i+" ");
		}
	}
}