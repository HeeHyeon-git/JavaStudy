package com.MyHome;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) throws AuthenException {

		Scanner sc = new Scanner(System.in);
		MyHomeImpl mhi = new MyHomeImpl();
		JoinImpl ji = new JoinImpl();
		MySweetDreamHouseMain sweet = new MySweetDreamHouseMain();
		String id="";
		String pw="";
		int ch1;
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
			
			do {
				System.out.print("���������������������������������������������\n");
				System.out.print("��1. �Ź� ���        2. �Ź� �˻�        3. �ε��� ��㿹��       4. ��� ���� Ȯ��  ��\n");
				System.out.print("��5. ��� ü�� ���   6. �α׾ƿ�         7. ����ȸ�� ����                            ��\n");
				System.out.print("���������������������������������������������\n");
				ch1 = sc.nextInt();
			} while (ch1 < 1);

			switch (ch1) {

			case 1:
				mhi.iteminput(id);
				break;
			case 2:
				mhi.search();
				break;
			case 3:
				mhi.reserve(id);
				break;
			case 4:
				mhi.readingReserve(id);
				break;
			case 5:
				mhi.contract(id);
				break;
			case 6:
				sweet.main(args);
			case 7:
				if(id.substring(0,5).equals("admin")){
					System.out.println("***********************ȸ�� ���� ����***********************\n");
					System.out.println("   ����              ���̵�      �̸�     �ڵ��� ��ȣ");
					System.out.println("-----------------------------------------------------------");
					ji.print(); 
				}else{
					System.out.println("������ ������ �ƴϹǷ� ������ �Ұ����մϴ�.");
				}
				break;
			default:
				System.exit(0);
			}

		}

	}

}
