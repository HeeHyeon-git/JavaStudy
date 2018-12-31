package com.day05;

import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) {
		
		//Selection sort
		//10�� �̳��� �̸��� ������ �Է¹޾� ������ ���ϼ���
		//������ ���� ��������� ���			
		Scanner sc = new Scanner(System.in);
		int i, j, k, inwon;

		String[] name; 
		int[] score;	
		int[] rank;
		
		//�ο��� �Է�
		do{
			System.out.print("�ο���[1~10?]");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//�ο����� ���� ��ü ����
		name = new String[inwon];
		score = new int[inwon];
		rank = new int[inwon]; 
		
		//int�� �迭���� �ʱⰪ 0 �� �������. ��� 1�� �ʱ�ȭ
		for(i=0;i<inwon;i++){
			rank[i]=1;
		}
		
		//�ο��� ��ŭ �̸��� ���� �Է�
		for(i=0;i<inwon;i++){
			System.out.print("�̸�?");
			name[i]=sc.next();
			System.out.print("����?");
			score[i]=sc.nextInt();
		}
		
 		//�����ۼ�. if�� ���
		for (i = 0; i < inwon - 1; i++) {
			for (j = i + 1; j < inwon; j++) {
				if (score[i] > score[j])
					rank[j]++;
				else if (score[i] < score[j])
					rank[i]++;
			}
		}
		
		//���� �� ���
		System.out.printf("�̸�   ����    ����\n");
		System.out.printf("-------------------\n");
		for(k=1;k<=inwon;k++){
			for(i=0;i<inwon;i++){
				if(k==rank[i]){
					System.out.printf("%6s %4d %4d\n",name[i],score[i],k);
				}
			}
		}
		sc.close();	
		
	}//endmain

}//endclass
