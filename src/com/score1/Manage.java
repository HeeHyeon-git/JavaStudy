package com.score1;

import java.util.Scanner;

public class Manage {
	
	
	int inwon; //�ܺο��� �������� ���ϵ��� �̷� �������� private�� �ص� 
	String[] title = {"�̸�","�ּ�","�ڵ�����ȣ","Ű","������","��Ͼ�"};
	
	Var[] rec;
	Scanner sc = new Scanner(System.in);
	
	public void set(){
		do{
			System.out.print("�ο���?");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);		
		rec = new Var[inwon];
		
	}
	
	public void input(){

		for (int i = 0; i < inwon; i++) {

			rec[i] = new Var();

			for (int j = 0; j < 3; j++) {
				System.out.print(title[j]);
				rec[i].infor[j] = sc.next();
			}		
			
			for (int j = 0; j < 3; j++) {
				System.out.print(title[j+3]);
				rec[i].personal[j] = sc.nextInt();
			}	
			System.out.print("------------------\n");
		}
		
	}
	
	private void bmi(){
		
		for(int i=0;i<inwon;i++){			
			rec[i].bmi = (float)rec[i].personal[1]/(rec[i].personal[0]*rec[i].personal[0]) ;
		
		}			
	}
	
	public void print() {

		bmi();
		//System.out.println("�̸� �ּ� �ڵ�����ȣ Ű ������ ��Ͼ� BMI ");

		for (int i = 0; i < inwon; i++) {
			
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s  ", rec[i].infor[j]);
			}
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s  ", rec[i].personal[j]);
			}
			System.out.printf("%f  ", rec[i].bmi);
			
			System.out.println();
		}
	
	}
	
}
	


