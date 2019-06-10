package com.level1.day05;

/*
 * �Ҽ� ã��
 ���� ����
 1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.

 �Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
 (1�� �Ҽ��� �ƴմϴ�.)

 ���� ����
 n�� 2�̻� 1000000������ �ڿ����Դϴ�.
 * */
public class Solution03 {
	public int solution(int n) {
		int cnt = 0;
		boolean flag;
		for (int i = 2; i <= n; i++) {
			flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0 && i != j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		return cnt;
	}
	
	
	//�ð��ʰ�
	public int solution1(int n) {
		int cnt = 0;
		boolean flag;

		for (int i = 2; i <= n; i++) {
			flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0 && i != j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Solution03 sol = new Solution03();
		System.out.println(sol.solution(54));
		
	}
}