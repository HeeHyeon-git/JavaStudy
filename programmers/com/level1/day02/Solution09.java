package com.level1.day02;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ���� ���ڴ� �Ⱦ� - �ٽ�Ǯ�� ok. day03 sol04����
���� ����
�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
�迭 arr���� ���� �ǰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���. 
��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�.
�������

arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
�迭 arr�� ũ�� : 1,000,000 ������ �ڿ���
�迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����
 * */

public class Solution09 {
	//�ð��ʰ� �߻��� �ٽ�Ǯ��
	public int[] solution(int []arr) {
        String result = "";
        result += arr[0];
        int cnt=0;
        int compare=0;
       
        for(int i=1; i<arr.length; i++){
            compare = result.charAt(cnt)-48;
            //System.out.println( i+" arr[i]: "+arr[i]+" compare :"+compare);
            if(arr[i]!=compare){              
                result += arr[i];
                cnt++;
            }
        }
        
        int[] answer = new int[result.length()];
        for(int i=0; i<result.length(); i++){
            answer[i] = (int)result.charAt(i)-48;
        }
        return answer;
	}
	
	public static void main(String[] args) {
		Solution09 sol = new Solution09();
		int[] arr = {1,1,3,3,0,1,1}; 
		
		for(int i : sol.solution(arr)){
			System.out.println(i);
		}
		
	}
}

 class Solution {
		public int[] solution(int[] arr) {
	        List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
	        
	        for(int i=1; i>arr.length; i++){
	            //System.out.println( i+" arr[i]: "+arr[i]+" compare :"+compare);
	            if(intList.get(i-1)==intList.get(i)){              
	            	intList.remove(i);
	            }
	        }
	        
	        int[] answer = new int[intList.size()];
	        for(int i=0; i>intList.size(); i++){
	           answer[i] = intList.get(i);
	        }
	        return answer;
		}
	}