package com.level1.day02;

/*
 * �� ���� ������ ��
���� ����
�� ���� a, b�� �־����� �� a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
���� ��� a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.

���� ����
a�� b�� ���� ���� �� �� �ƹ� ���� �����ϼ���.
a�� b�� -10,000,000 �̻� 10,000,000 ������ �����Դϴ�.
a�� b�� ��Ұ���� ���������� �ʽ��ϴ�.
 * */

public class Solution05 {
	  public long solution(int a, int b) {
	      long answer = 0;
	      int max, min;
	      if(a>b){
	          max = a;
	          min = b;
	      }else if(a<b){
	          max = b;
	          min = a;
	      }else{
	          return a;
	      }
	      
	      for(int i=min; i<=max; i++ ){
	          answer += i;
	      }
	      return answer;
	  }
	  
		public static void main(String[] args) {
			Solution05 sol = new Solution05();
			System.out.println(sol.solution(3,5));
			System.out.println(sol.solution(3,3));
		}
	}