package com.naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Naver ob = new NaverImpl();
		int ch;
		
		while(true){ //�����ϱ� ������ ��� ����
			
			do {
				System.out.println("���̹� ȸ������ ���");
				System.out.print("1.ȸ������ \n2.ȸ����ü��� \n3.���̵� �˻� \n4.����\n");
				System.out.print("-----------------------------------------------\n����:");
				ch = sc.nextInt();
			}while (ch < 1);
			
			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.searchId();break;
			case 4:
				break;
			default:
				System.exit(0);
			}
			
		}
		
	}
	
}
