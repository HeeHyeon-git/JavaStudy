package com.level1;
/*
 * �ڸ��� ���ϱ�
���� ����
�ڿ��� N�� �־�����, N�� �� �ڸ����� ���� ���ؼ� return �ϴ� solution �Լ��� ����� �ּ���.
������� N = 123�̸� 1 + 2 + 3 = 6�� return �ϸ� �˴ϴ�.

���ѻ���
N�� ���� : 100,000,000 ������ �ڿ���
 * */

public class Solution14 {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        
        for(int i=0; i<str.length();i++){
           answer += Character.getNumericValue(str.charAt(i));
        }
        return answer;
    }
}
