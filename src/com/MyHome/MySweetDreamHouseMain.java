package com.MyHome;

import java.util.Scanner;

import com.naver2.NaverImpl;

public class MySweetDreamHouseMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NaverImpl ob = new NaverImpl();
		int ch;
		
		while(true){ //�����ϱ� ������ ��� ����
			
			do {
				System.out.println("�ε��� �װ��� �˰�ʹ� ����");
				System.out.print("1.ȸ������\t2.�α���\t3.����\n");
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
				ob.writeFile();
			default:
				System.exit(0);
			}

			
			
		}
		
	}
	
}
