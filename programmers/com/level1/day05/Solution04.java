package com.level1.day05;

import java.util.Arrays;

/*
 * �������� ���� ����
���� ����
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.

�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
������ �߿��� ���������� ���� �� �ֽ��ϴ�.
����� ��
 * */

public class Solution04 {

	    public String solution(String[] participant, String[] completion) {
			String answer = "";
	        
	    	Arrays.sort(participant);
			Arrays.sort(completion);

			for (int k = 0; k < completion.length; k++) {
				if (!completion[k].equals(participant[k])) {
					answer = participant[k];    //�������� ���� ���
	                break;
				}
			}
	        
	        //null�� ��� ���� ������ ����� �ش�
	        if(answer==""){
	            answer = participant[completion.length];
	        }
			return answer;
	    }
	    
	    public static void main(String[] args) {
	    	
			Solution04 sol = new Solution04();
			String[] participant = {"leo", "kiki", "eden"};
			String[] completion = {"eden", "kiki"};
			System.out.println("�������� ���� ���� : "+sol.solution(participant, completion));
			
		}
	}