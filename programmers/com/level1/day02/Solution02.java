package com.level1.day02;

/*
 * ���ڼ��ڼ��ڼ��ڼ��ڼ�?
 ���� ����
 ���̰� n�̰�, ���ڼ��ڼ��ڼ�....�� ���� ������ �����ϴ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
 ������� n�� 4�̸� ���ڼ����� �����ϰ� 3�̶�� ���ڼ��� �����ϸ� �˴ϴ�.

 ���� ����
 n�� ���� 10,000������ �ڿ����Դϴ�.
 * */
public class Solution02 {
	public String solution(int n) {
		String answer = "";
		int cnt = 1;
		while (cnt <= n) {
			if (cnt % 2 == 1) {
				answer += "��";
			} else if (cnt % 2 == 0) {
				answer += "��";
			}
			cnt++;
		}
		System.out.print(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Solution02 sol = new Solution02();
		sol.solution(3);
	}
}