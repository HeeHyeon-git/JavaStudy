package com.guestbook;

import java.util.Scanner;

public class GBMain {

	public static void main(String[] args) {
		// ȸ������ -> ���� �ۼ�, ���� ��ȸ, ���� ����, �α׾ƿ�
		// �α���
		// ����
		Scanner sc = new Scanner(System.in);
		int ch, ch2;
		GB gb = new GB();
		
		try {
			while (true) {

				do {
					System.out.println("------------------------------------------------------------");
					System.out.println("                         GUEST BOOK  ");
					System.out.println("1.ȸ������    2.�α���     3.ȸ��Ż��     4.����  ");
					System.out.println("------------------------------------------------------------");
					System.out.print("��");
					ch = sc.nextInt();

				} while (ch < 1 || ch > 4);

				switch (ch) {

				case 1:
					gb.insert(); 			//1. ȸ������ (����)
					break;
				case 2:
					GBLogin.main(args);		//2. �α���   (����)
					break;	
				case 3:
					gb.deleteMember();		//3. ȸ��Ż�� (����)
					break;
				case 4:
					DBConn.close();			//4. ����
					System.exit(0);
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
