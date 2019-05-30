package com.checkingAccount;

import java.util.Scanner;

public class CADLogin {

	public static void main(String[] args) throws AuthenException {

		
		Scanner sc = new Scanner(System.in);
		
		CAD cad = new CAD();
		
		int ch;
		
		while(true) {
	
			String id = cad.login();
				
			while(!id.equals("")){
					
				do{
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.println("	1.����/ī�� ���         2.����/ī�� ����           3.����� �ۼ�           4.����� ����    ");
					System.out.println("	5.������ü               6.����� ��ȸ              7.����/ī�� ��ȸ        8.ī���ݰ���   ");
					System.out.println("	9.�α׾ƿ�");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.print("��");
					ch = sc.nextInt();

				}while(ch<1 || ch>9);
					
				System.out.println();
				
				switch (ch) {
				case 1:
					cad.insertAset(id);
					break;
				case 2:
					cad.deleteAsset(id);
					break;
				case 3:
					cad.inputCAData(id);
					break;
				case 4:
					cad.deleteCAData(id);
					break;
				case 5:
					cad.changeAsset(id);
					break;
				case 6:	
					cad.selectaccount(id);
					break;
				case 7:
					cad.selectAsset(id);
					break;
				case 8:
					cad.cardPayment(id);
					break;
				case 9:
					CADMain.main(args);
					break;
				}
			}
				
			if(id.equals(""))
				System.out.println("�α��ο� �����Ͽ����ϴ�.");
				
			CADMain.main(args);
		}
		
	}

}
