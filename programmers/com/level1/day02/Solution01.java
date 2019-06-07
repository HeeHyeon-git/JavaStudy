package com.level1.day02;

import java.util.Arrays;

/*
 * �������� ���� ����
 ���� ����
 ������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.

 �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 ���ѻ���
 ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
 completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
 �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
 ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 * */
public class Solution01 {
	/*
    public String solution(String[] participant, String[] completion) {
		String answer = "";
		for (int i = 0; i < completion.length; i++) {
			for (int k = 0; k < participant.length; k++) {
				if (participant[k].equalsIgnoreCase(completion[i])) {
					participant[k] = "";
					break;
				}
			}
		}

		for (String str : participant) {
			if (str != "" && str != null) {
				answer = str;
			}
		}
		return answer;
	}
	*/
    public String solution(String[] participant, String[] completion) {
		String answer = "";
    	Arrays.sort(participant);
		Arrays.sort(completion);

		for (int k = 0; k < completion.length; k++) {
			if (!completion[k].equals(participant[k])) {
				answer = participant[k];
                break;
			}
		}
        if(answer==""){
            answer = participant[completion.length];
        }
		return answer;
    }

	public static void main(String[] args) {
		Solution01 sol = new Solution01();
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(sol.solution(participant, completion));
	}
}