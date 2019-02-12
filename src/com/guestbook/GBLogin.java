package com.guestbook;

import java.util.Scanner;

public class GBLogin {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		GB gb = new GB();
		
		int ch;
		
		while(true) {
	
			String id = gb.login();
				
			while(!id.equals("")){
					
				do{
					System.out.println("------------------------------------------------------------");
					System.out.println("1.���� �ۼ�  2.���� ��ȸ   3.���� ����   4.�α׾ƿ�");
					System.out.println("------------------------------------------------------------");
					System.out.print("��");
					ch = sc.nextInt();

				}while(ch<1 || ch>4);
					
				System.out.println();
				
				switch (ch) {
				case 1:
					gb.insertGB(id);	 //����
					break;

				case 2:
					gb.selectGB();		 //����
					break;
					
				case 3:
					gb.deleteGB(id); 	 //����
					break;
					
				case 4:
					GBMain.main(args);
					break;
				}
			}
				
			if(id.equals(""))
				System.out.println("�α��ο� �����Ͽ����ϴ�.");
				
			GBMain.main(args);
		}
	}
}
