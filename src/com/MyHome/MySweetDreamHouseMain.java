package com.MyHome;

import java.util.Scanner;

import com.excep.AuthenException;

public class MySweetDreamHouseMain {

	public static void main(String[] args) throws AuthenException {
		
		Scanner sc = new Scanner(System.in);
		JoinImpl ji = new JoinImpl();
		Picture pi = new Picture();
		int ch;
		
		while(true){
			
			pi.run();
			do {
				System.out.println("���������������������������������������������");
				System.out.print("��\t\t\t����� �� ������ �� ��� �ε��� ã��\t\t\t      ��\n");
				System.out.print("��1. ȸ �� �� ��\t\t\t2. �� �� ��\t\t\t3. ��\t��    ��\n");
				System.out.println("���������������������������������������������");
				ch = sc.nextInt();
			}while (ch < 1);
			
			switch (ch) {
			
			case 1:
				ji.sign();break;
			case 2:
				LoginMain.main(args);
			case 3:
			default:
				System.exit(0);
			}

		}
	
	}
	
}
