package com.MyHome;

import java.io.IOException;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) throws AuthenException, IOException {

		Scanner sc = new Scanner(System.in);
		MyHomeImpl mhi = new MyHomeImpl();
		JoinImpl ji = new JoinImpl();
		MySweetDreamHouseMain sweet = new MySweetDreamHouseMain();
		MyHomeException my = new MyHomeException();
		String id="";
		String pw="";
		
		String ch;
		boolean flaglogin = false;
		
		// admin ������ ���, ȸ������ �������� �ƴϸ� ����ó���� ���Ѿ��� �˸�
		while(true){
			
			System.out.println("�α����� ���� �Է��ϼ���.");
			System.out.print("ID: ");
			id = sc.next();
			System.out.print("PW: ");
			pw = sc.next();
			flaglogin = mhi.login(id,pw);
			if(flaglogin){
				break;
			}
		}
		
		
		while (true) { // �α��� �� ���� �޴�
			
			boolean check=true;
			
			try {
				
				do {
					System.out.print("���������������������������������������������\n");
					System.out.print("��1. �Ź� ���        2. �Ź� �˻�        3. �ε��� ��㿹��       4. ��� ���� Ȯ��  ��\n");
					System.out.print("��5. �α� �Ÿ�        6. ��� ü�� ���   7. �α׾ƿ�              8. ����ȸ�� ����   ��\n");
					System.out.print("���������������������������������������������\n");
					System.out.print("���Է� ");
					ch = sc.next();
					
					my.n(ch);
					check = false;
					System.out.println();
					
				} while (check);

				switch (ch) {

				case "1":
					mhi.iteminput(id);
					break;
				case "2":
					mhi.search();
					break;
				case "3":
					mhi.reserve(id);
					break;
				case "4":
					mhi.readingReserve(id);
					break;
				case "5":
					mhi.popRanking();
					break;
				case "6":
					mhi.contract(id);
					break;
				case "7":
					sweet.main(args);
				case "8":
					if(id.equals("admin123")){
						System.out.println("***********************ȸ�� ���� ����***********************\n");
						System.out.println("   ����              ���̵�      �̸�     �ڵ��� ��ȣ");
						System.out.println("-----------------------------------------------------------");
						ji.print(); 
						System.out.println();
					}else{
						System.out.println("������ ������ �ƴϹǷ� ������ �Ұ����մϴ�.");
					}
					break;
				default:
					System.exit(0);
				}
				
			} catch (IOException e) {
				System.out.println(e.toString());
			} catch (AuthenException e) {
				System.out.println(e.toString());
			}

		}

	}

}
