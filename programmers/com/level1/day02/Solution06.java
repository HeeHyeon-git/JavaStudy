package com.level1.day02;

/*
 * ���￡�� �輭�� ã��
 ���� ����
 String�� �迭 seoul�� element�� Kim�� ��ġ x�� ã��,
 �輭���� x�� �ִٴ� String�� ��ȯ�ϴ� �Լ�,
 solution�� �ϼ��ϼ���. seoul�� Kim�� ���� �� ����
 ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.
 ���� ����
 seoul�� ���� 1 �̻�, 1000 ������ �迭�Դϴ�.
 seoul�� ���Ҵ� ���� 1 �̻�, 20 ������ ���ڿ��Դϴ�.
 Kim�� �ݵ�� seoul �ȿ� ���ԵǾ� �ֽ��ϴ�.
 * 
 * */
public class Solution06 {
	public String solution(String[] seoul) {
		String answer = "";
		int idx = 0;
		for (String s : seoul) {
			if (s.equals("Kim")) {
				answer = "�輭���� " + idx + "�� �ִ�";
			}
			idx++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution06 sol = new Solution06();
		String[] seoul = { "Jane", "Kim" };
		System.out.println(sol.solution(seoul));
	}
}