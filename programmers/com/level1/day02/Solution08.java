package com.level1.day02;

/*
 * ���� ��ȣ
���� ����
� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
���� ��� AB�� 1��ŭ �и� BC�� �ǰ�, 3��ŭ �и� DE�� �˴ϴ�. z�� 1��ŭ �и� a�� �˴ϴ�.
 ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.

���� ����
������ �ƹ��� �о �����Դϴ�.
s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
s�� ���̴� 8000�����Դϴ�.
n�� 1 �̻�, 25������ �ڿ����Դϴ�.
 * */

public class Solution08 {
	  public String solution(String s, int n) {
	      String answer = "";
	      int code = 0;
	      for(int i=0; i<s.length(); i++){
	          if(s.charAt(i)==' '){
	              answer += " ";
	          }else{
	              code = s.charAt(i)+n;
	              if((s.charAt(i)>=97&&s.charAt(i)<=122)&&(code>122))
	                  code-=26;
	              else if((s.charAt(i)>=65&&s.charAt(i)<=90)&&(code>90))
	                  code-=26;
	              answer += (char)code;
	          }
	      }
	      System.out.print(answer);
	      return answer;
	  }
	}