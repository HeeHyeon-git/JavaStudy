package com.naver3;

import java.util.Scanner;
public class NaverMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Naver ob = new Naver();
		int ch;
		
		while(true){ 
			
			do {
				System.out.println("���̹� ȸ������ ���");
				System.out.print("1.ȸ������ \n2.ȸ���������� \n3.ȸ���������� \n4.ȸ����ü��� \n5.���̵� �˻�\n6.����\n");
				System.out.print("-----------------------------------------------\n����:");
				ch = sc.nextInt();
			}while (ch < 1);
			
			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.update();break;
			case 3:
				ob.delete();break;
			case 4:
				ob.print();break;
			case 5:
				ob.searchId();break;
			default:
				System.exit(0);
			}
			
		}
		
	}
	

}
