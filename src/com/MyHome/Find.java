package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class Find {
	
	int choice;
	String item ="";
	String term ="";
	String local ="";
	long price =0;
	
	boolean check;
	
	MyHomeException my = new MyHomeException();
	
	Scanner sc = new Scanner(System.in);
	
	public void item() throws IOException {
		
		check = true;
		
		do{
			try {
				
				System.out.println("�ְ����¸� �Է��Ͻÿ�[��ȣ�� �Է����ּ���]");
				System.out.print("1.����Ʈ 2.���� 3.�� 4.���� : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//�Է��� ���� �������� Ȯ��
				
				switch (choice) {
				case 1:
					item = "����Ʈ"; break;
				case 2:
					item = "����"; break;
				case 3:
					item = "��"; break;
				case 4:
					item = "����"; break;
				default:
					my.homeCheck();			//1-4������ ���ڰ� �ƴҰ�� 
				}
				
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);

	}
	
	
	public void term() throws IOException{
		
		check = true;
		do{
			try {
				
				System.out.println("������¸� ���ÿ�[��ȣ�� �Է����ּ���]");
				System.out.print("1.���� 2.���� 3.�Ÿ� : ");
				
				choice = sc.nextInt();
				my.choiceCheck(choice);		//�Է��� ���� �������� Ȯ��
				
				switch (choice) {
				case 1:
					term = "����"; break;
				case 2:
					term = "����"; break;
				case 3:
					term = "�Ÿ�"; break;
				default:
					my.homeCheck();			//1-3������ ���ڰ� �ƴҰ�� 
				}
				
				check = false;
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}
			
		}while(check);
		
	}
	
	public void local() throws IOException{
		
		System.out.print("����:");
		local = sc.next();
		
	}
	
	public void price() throws IOException{
		
		System.out.print("����:");
		price = sc.nextInt();	
		
	}
}
