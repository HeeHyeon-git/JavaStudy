package com.level1.day03;

/*
 * ���� ���ڴ� �Ⱦ�
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
 * 
 * */

public class Solution04 {

	public int[] solution(int []arr) {
        StringBuffer result = new StringBuffer("");
        result.append(arr[0]);//ù��°��
    
        for(int i=1; i<arr.length; i++){
            if(arr[i-1]!=arr[i]){              
            	result.append(arr[i]) ;
            }
        }
        
        int[] answer = new int[result.length()];
        for(int i=0; i<result.length(); i++){
           answer[i] = result.charAt(i)-48;
        }
        return answer;
	}
	
	public static void main(String[] args) {
		Solution04 s = new Solution04();
		int[] arr= {1,1,3,3,0,1,1};
		//[1,3,0,1]
		int[] res = s.solution(arr);
		for(int i : res){
			System.out.print(i+" ");
		}
	}
}
