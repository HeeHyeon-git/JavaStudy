package com.checkingAccount;

import java.util.Scanner;

public class CADMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int ch;
		CAD cad = new CAD();
		
		try {
			while (true) {

				do {
					
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.println("      		                                 �����  ");
					System.out.println("	1.����� �Ұ�        2.ȸ������        3.�α���         4.ȸ��Ż��         5.����  ");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.print("��");
					ch = sc.nextInt();

				} while (ch < 1 || ch > 5);

				switch (ch) {

				case 1:
					cad.CAInformation();
					break;
				case 2:
					cad.insertMember(); 			
					break;
				case 3:
					CADLogin.main(args);
					break;	
				case 4:
					cad.deleteMember();
					break;
				case 5:
					DBConn.close();
					Ending.main(args);
					System.exit(0);
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
