package com.day06;

public class Test3 {
	
	public static void main(String[] args) {
			
		//�迭�� �迭
		
		int[][] arr = new int[6][6]; //�̷��� ����ԵǸ� �迭�ȿ��� ��� 0�� �������	
		int i,j ; 
		int n=0;
		
		for(i=0;i<5;i++){ //�Է��� 5*5
			for(j=0;j<5;j++){			
				//System.out.println(i +":"+ j); // �ڸ��� ���
				n++;
				arr[i][j] = n;
				
				arr[i][5] += n; //[0,5] [1,5] [2,5] [3,5] [4,5]�� ����
				arr[5][j] += n;	//[5,0] [5,1] [5,2] [5,3] [5,4]�� ����		
				arr[5][5] += n;	//��ü�����հ�
			}
		}
			
		for(i=0;i<6;i++){ //����� 6*6
			for(j=0;j<6;j++){			
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}		
		
	}

}
