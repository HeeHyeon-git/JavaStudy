package com.day06;

public class Test5 {

	public static void main(String[] args) {
		
		//������(2~5��) ���η� �������� ����� ���̴� \t���� ���� 
		//������(6~9��) 
		//3�� for������ �ۼ� - ��� 3���� ����. 2�� for���� ������
		//��Ʈ:������ �߰��� �ʱ�ȭ���Ѿ� ��
		
		int i, j;
		
		for(i=1;i<10;i++){ 
			for(j=2;j<6;j++){			
				System.out.printf("%d * %d = %d\t",j,i,(i*j) );
			}
			System.out.println();
		
		}
		
		System.out.println("-----------------------------------------------------------");
		
		for(i=1;i<10;i++){ 
			for(j=6;j<10;j++){			
				System.out.printf("%d * %d = %d\t",j,i,(i*j) );
			}
			System.out.println();
		}
		

	}

}
