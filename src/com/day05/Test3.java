package com.day05;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		
		//selection sort
		//10�� �̳��� �̸��� ������ �Է¹޾� 
		//������ ���� ������� ���� ��������� ���	
		Scanner sc = new Scanner(System.in);
		
		int i, j, inwon, temp1;
		String temp2;

		String[] name; // �迭ũ�Ⱑ �Է°��� ���� �޶����Ƿ� ũ�� ������ �̸� �� �� ����.
		int[] score;	
		
		do{
			System.out.print("�ο���[1~10?]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//�迭�� ��ü ����, �޸� �Ҵ�. new�� ������ ��ü�� �����ߴ� = �޸𸮻� �ε����״�.
		name = new String[inwon];
		score = new int[inwon];
		
		//�ο��� ��ŭ �̸��� ���� �Է�
		for(i=0;i<inwon;i++){
			System.out.print((i+1)+"��° �̸�?");
			name[i]=sc.next();
			System.out.print((i+1)+"��° ����?");
			score[i]=sc.nextInt();
		}
		
		//����
		for(i=0;i<inwon-1;i++){		
			for(j=i+1;j<inwon;j++){
				if(score[i]<score[j]){//������������
					temp1=score[i];
					score[i]=score[j];
					score[j]=temp1;			   
					
					temp2=name[i];
					name[i]=name[j];
					name[j]=temp2;		
				}			
			}			
		}
		
		//���. Ȯ��for���� �迭1���϶��� ����. ���������� 2���� �迭�̹Ƿ� ���Ұ�	
		System.out.printf("�̸�   ����\n");
		System.out.printf("-----------\n");
		for(i=0;i<inwon;i++){
			System.out.printf("%6s %4d\n",name[i],score[i]);
		}	
		sc.close();		
		
	}//endmain

}//endclass
