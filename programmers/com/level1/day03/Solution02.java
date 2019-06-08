package com.level1.day03;

/*
 * 2016��
 ���� ����
 2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��? 
 �� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
 ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT

 �Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

 ���� ����
 2016���� �����Դϴ�.
 2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
 * 
 * */
public class Solution02 {
	public String solution(int a, int b) {
		String answer = "";
		String[] dayName = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		int[] day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int nalsu = 4;// 1��1���� �ݿ���. ���������� ������� �ε����� 4 �ݿ�

		for (int i = 0; i < a - 1; i++) {
			nalsu += day[i];// ������
		}
		nalsu += b;// ����
		answer = dayName[nalsu % 7];
		return answer;
	}
}