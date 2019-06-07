package com.level1.day02;

/*
 * ���ڿ� �� p�� y�� ����
���� ����
�빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�. s�� 'p'�� ������ 'y'�� ������ ���� ������ True, 
�ٸ��� False�� return �ϴ� solution�� �ϼ��ϼ���. 'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�.
 ��, ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.

������� s�� pPoooyY�� true�� return�ϰ� Pyy��� false�� return�մϴ�.

���ѻ���
���ڿ� s�� ���� : 50 ������ �ڿ���
���ڿ� s�� ���ĺ����θ� �̷���� �ֽ��ϴ�.
 * 
 * */

public class Solution04 {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i)=='y'||s.charAt(i)=='Y')
                yCount++;
            if(s.charAt(i)=='p'||s.charAt(i)=='P')
                pCount++;
        }
        if(pCount!=yCount)
            answer = false;
        return answer;
    }
    
	public static void main(String[] args) {
		Solution04 sol = new Solution04();
		System.out.println(sol.solution("ppyy"));
		System.out.println(sol.solution("pYYy"));
	}
}
