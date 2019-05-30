package com.checkingAccount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CAD {

	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	CADAO dao = new CADAO();
	CADException cad = new CADException();
	Money money = new Money();
	Picture pic = new Picture();

	// 1. ����� �Ұ�
	public void CAInformation() {

		System.out.println("300�� ������ ������ ��ǥ �����! \n���󿡼� ���� ���� Sunkist ����θ� �Ұ��մϴ�!");
		System.out.println("\n����θ� ����ϴ� ����� �ƴ϶� ������� �ʴ� ����� �м��߽��ϴ�.");
		System.out.println("����� �ۼ��� �����ϰ� �����ٰ� �����Ͻô� �е��� ���� ��������ϴ�!");
		System.out.println("\n���� ���� Sunkist����η� ����� �ڱ��� �����ϼ���!");
		System.out.println("\n[��ɾȳ�] \n*������ ī��� ���� ��ϰ� ���� \n*���� �������� \n*�ְ� �������� \n*�ϰ� �������� \n*ī�װ��� �������");
		System.out.println("\n���� ������ ������ sunkist_orange@naver.com�� ���Ϻ����ֽñ� �ٶ��ϴ�:)");
		System.out.println();
		pic.main2();
	}

	// 2.ȸ������
	public void insertMember() throws AuthenException {

		String pw2 = null;
		String str = null;
		boolean id = true;
		boolean pw = true;
		boolean name = true;


		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("             				        ȸ������");
		System.out.println("-----------------------------------------------------------------------------------------------------");

		try {

			CADTO dto = new CADTO();

			do {
				try {
					System.out.print("���̵�:");
					str = (sc.next());
					cad.idFormat(str);

					id = false;

					dto.setId(str);

				} catch (AuthenException e) {
					System.out.println(e.toString());
				}

			} while (id);

			do {
				try {

					System.out.print("��й�ȣ:");
					dto.setPwd(sc.next());

					System.out.print("��й�ȣ Ȯ��:");
					pw2 = sc.next();
					cad.pwCheck(dto.getPwd(), pw2);

					pw = false;

				} catch (AuthenException e) {
					System.out.println(e.toString());

				}

			} while (pw);

			do {
				try {
					System.out.print("�̸�:");
					str = sc.next();
					cad.nameCheck(str);

					name = false;
					dto.setName(str);

				} catch (AuthenException e) {
					System.out.println(e.toString());

				}

			} while (name);

			int result = dao.insertMember(dto);

			if (result == 1) {
				System.out.println();
				System.out.println("****���������� ������ �Ǿ����ϴ�!****");
				System.out.println();
			} else
				System.out.println("ȸ�����Կ� �����߽��ϴ�");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// 3.�α���
	public String login() {

		String id;
		String pwd;
		String checkid = null;

		try {

			System.out.print("���̵�:");
			id = sc.next();

			System.out.print("��й�ȣ:");
			pwd = sc.next();

			checkid = dao.login(id, pwd);

		} catch (Exception e) {
			System.out.println(e.toString());
			return checkid;
		}
		return checkid;

	}

	// 4.ȸ��Ż��
	public void deleteMember() {

		try {
			String id, pwd;
			System.out.println("������ ������ �Է��ϼ���.");
			System.out.print("id: ");
			id = sc.next();
			System.out.print("pwd: ");
			pwd = sc.next();

			int result = dao.deleteMember(id, pwd);

			if (result == 1) {
				System.out.println("ȸ��Ż�� ���������� ����Ǿ����ϴ�!");
			} else {
				System.out.println("ȸ��Ż�� ������� ���Ͽ����ϴ�! ȸ�������� Ȯ�����ּ���.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// 5.����/ī�� ���
	public void insertAset(String id) throws AuthenException {


		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("                                        ��ī��/���� ��Ϣ�");
		System.out.println("-----------------------------------------------------------------------------------------------------");

		try {

			int result = 0;
			int BC = 0;
			int y = 0;
			String str = null;

			boolean accDiv = true;
			boolean accno = true;
			boolean cardno = true;
			boolean accAmount = true;
			boolean nickname = true;

			CADTO dto = new CADTO();

			// ���µ�� / ī���� Ȯ��
			do {
				System.out
				.println("���� ����� ���Ͻø� [1]��, ī�� ����� ���Ͻø� [2]�� �Է����ּ���.");
				System.out.print("��");
				BC = sc.nextInt();
			} while (BC < 1 || BC > 2);

			System.out.println();

			switch (BC) {
			case 1:
				System.out.println("����Ͻô� ������ ������ �Է����ּ���.");
				System.out.println("������ [�����],[��/����] �ΰ����� �����մϴ�.");
				do {
					try {

						System.out.print("��");
						str = sc.next();
						cad.accdivCheck(str);

						accDiv = false;
						dto.setAccDiv(str);

					} catch (AuthenException e) {
						System.out.println(e.toString());
					}
				} while (accDiv);

				System.out.println();

				System.out.println("������ �Է����ּ���");
				System.out.print("��");
				dto.setBank(sc.next());

				System.out.println();

				System.out.println("�����ָ� �Է����ּ���");
				System.out.print("��");
				dto.setAccName(sc.next());

				System.out.println();

				System.out.println("���¹�ȣ�� �Է����ּ���.");
				System.out.println("���¹�ȣ�� - ���� ���ڷθ� �Է� �����մϴ�.");
				do {
					try {
						System.out.print("��");
						str = cad.numberCheck2(sc.next());

						dto.setAccno(str);
						accno = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}

				} while (accno);

				System.out.println();

				System.out.println("���� ���¿� �ִ� �ݾ��� �Է����ּ���.");
				System.out.println("�ݾ��� ���ڷθ� �Է� �����մϴ�.");
				do {
					try {
						System.out.print("��");
						y = cad.numberCheck1(sc.next());

						dto.setAccAmount(y);
						accAmount = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}

				} while (accAmount);

				System.out.println();

				do {
					try {
						System.out.println("���� �����̸��� �ۼ����ּ���");
						System.out.print("��");
						str = sc.next();
						cad.accNickCheck(str);

						nickname = false;
						dto.setBankNick(str);

					} catch (AuthenException e) {
						System.out.println(e.toString());
					}
				} while (nickname);

				result = dao.insertAsset(dto, id, BC);

				if (result == 1) {
					System.out.println();
					System.out.println("****���������� ���µ���� �Ǿ����ϴ�!****");
					System.out.println();
				} else
					System.out.println("���µ�Ͽ� �����߽��ϴ�");

				break;

			case 2:
				System.out.println("ī���ȣ�� �Է����ּ���.");
				System.out.println("ī���ȣ�� - ���� ���ڷθ� �Է� �����մϴ�.");
				do {
					try {
						System.out.print("��");
						str = cad.numberCheck2(sc.next());

						dto.setCardno(str);
						cardno = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}

				} while (cardno);

				System.out.println();

				System.out.println("ī�� ������ �Է����ּ���");
				System.out.print("��");
				dto.setCard(sc.next());

				System.out.println();

				System.out.println("�����ָ� �Է����ּ���");
				System.out.print("��");
				dto.setCardName(sc.next());

				System.out.println();

				do {
					try {
						System.out.println("ī�� �����̸��� �ۼ����ּ���");
						System.out.print("��");
						str = sc.next();
						cad.accNickCheck(str);

						nickname = false;
						dto.setCardNick(str);

					} catch (AuthenException e) {
						System.out.println(e.toString());
					}
				} while (nickname);

				result = dao.insertAsset(dto, id, BC);

				if (result == 1) {
					System.out.println();
					System.out.println("****���������� ī������ �Ǿ����ϴ�!****");
					System.out.println();
				} else
					System.out.println("ī���Ͽ� �����߽��ϴ�");

				break;
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 6.����/ī�� ����
	public void deleteAsset(String id) {

		try {
			String CAname;
			String CAno;
			int BC = 0;
			int result = 0;

			do {
				System.out
				.println("���� ������ ���Ͻø� [1]��, ī�� ������ ���Ͻø� [2]�� �Է����ּ���.");
				System.out.print("��");
				BC = sc.nextInt();
			} while (BC < 1 || BC > 2);

			System.out.println("������ ������ �Է��ϼ���.");
			System.out.print("����ϴ� ī��/���� ����: ");
			CAname = sc.next();
			System.out.print("����ϴ� ī��/���� ��ȣ: ");
			CAno = sc.next();

			result = dao.deleteAsset(id, CAname, CAno, BC);

			if (result == 1) {
				System.out.println("�������� ����Ǿ����ϴ�!");
			} else {
				System.out.println("������ ������� ���Ͽ����ϴ�! ����/ī�� ������ Ȯ�����ּ���.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// 8.����/ī�� ��ȸ
	public void selectAsset(String id) {

		System.out.println("   ī��/����            ����           ������           ����/ī���ȣ        �ݾ�           �����̸�");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		// �������� ���
		List<CADTO> lists = dao.selectAsset(id, 1);
		Iterator<CADTO> it = lists.iterator();

		while (it.hasNext()) {
			CADTO dto = it.next();
			dto.printAcc();
		}

		// ī������ ���
		lists = dao.selectAsset(id, 2);
		it = lists.iterator();

		while (it.hasNext()) {
			CADTO dto = it.next();
			dto.printCard();
		}

		System.out.println();

	}

	// ����� ��ȸ
	public void selectaccount(String id) {

		int ch = 0;
		int dal = 0;
		String date1 = "";
		String date2 = "";
		String category = "";
		boolean categoryCheck = true;
		boolean flag=true;
		
		try {
			do {
				System.out.println("����� ��ȸ ������ �����ϼ���.");
				System.out.println("1.�Ϻ� 2.�Ⱓ�� 3.���� 4.������ 5.�޷� ");
				System.out.print("�Է� �� ");
				ch = sc.nextInt();

				switch (ch) {
				
				case 1:
					// 4.1 �Ϻ�
					do{
						try {
							System.out.print("��ȸ�� ���ڸ� �Է��ϼ���: ");
							date1 = sc.next();
							cad.dateCheck(date1);
							dao.selectday(id, date1);
							flag=false;
						} catch (Exception e) {
							System.out.println(e.toString());
						}						
					}while(flag);
					break;

				case 2:
					// 4.2 �Ⱓ��
					do{
						try {
							System.out.println("��ȸ�� �Ⱓ�� �Է��ϼ���. ");
							System.out.print("������: ");
							date1 = sc.next();
							cad.dateCheck(date1);
							System.out.print("������: ");
							date2 = sc.next();
							cad.dateCheck(date2);
							dao.selectweek(id, date1, date2);
							flag=false;
						} catch (Exception e) {
							System.out.println(e.toString());
						}
					}while(flag);
					break;
					
				case 3:
					// 4.3 ����
					do{
						try {
							System.out.println("��ȸ�� ��/���� �Է��ϼ���.");
							System.out.print("����: ");
							date1 = sc.next();
							cad.yearCheck(date1);
							System.out.print("��: ");
							date2 = sc.next();
							cad.monthCheck(date2);
							flag=false;
							dao.selectmonth(id, date1, date2);
						} catch (Exception e) {
							System.out.println(e.toString());
						}						
					}while(flag);
					break;
					
				case 4:
					// 4.4 ī�װ���
					System.out.println("��ȸ�� ī�װ��� �Է��ϼ���.");
					System.out.println("��ī�װ� : [�ڱ���] [��Ȱ��] [�Ĵ�] [����] [��ȭ] [�̿�] [����] [����] [����]");
					do{
						try {
							System.out.print("ī�װ�: ");
							category = sc.next();
							
							cad.categoryCheck(category);
							categoryCheck = false;
							
						} catch (AuthenException e) {
							System.out.println(e.toString());
						}	
						
					} while(categoryCheck);
					dao.selectcategory(id, category);
					break;
					
				case 5:
					// 4.5 �޷�
					do{
						System.out.println("�޷��� ��ȸ�� �⵵�� ���� �Է��ϼ���.");
						System.out.print("����: ");
						date1 = sc.next();
						cad.yearCheck(date1);
						System.out.print("��: ");
						date2 = sc.next();
						cad.monthCheck(date2);
						System.out.println("����� �޷� �� ������ ��ȸ�Ͻðڽ��ϱ�? [1:�Ա�], [2:���], [3:����ȭ������ ���ư���] ");
						dal = sc.nextInt();

						if(1 == dal){
							dao.selectcalendar1(id, date1, date2); break;
						}else if(2 == dal){
							dao.selectcalendar2(id, date1, date2); break;
						}else if(3 == dal){
							break;
						}else{
							System.out.println("�ٽ� �Է��Ͽ� �ּ���. ");
						}
					}while(true);

				}

			} while (ch > 5 || ch < 1);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void deleteCAData(String id) { // ���� ����� ����
		int se1, se2;
		int result;

		do {
			System.out
			.println("ī���� ����� ������ ���Ͻø� [1]��, ���»�� ����� ������ ���Ͻø� [2]��,");
			System.out.println("����� ������ ����Ͻ÷��� [3]�� �Է����ּ���.");
			System.out.print("��");
			se1 = sc.nextInt();
		} while (se1 < 1 || se1 > 3);

		System.out.println();

		switch (se1) {

		case 1:
			System.out.println("ī���� ����� ������ �����մϴ�.");
			System.out.println("������ �Է����ּ���.");
			System.out.print("��");

			result = money.inputMoney(id,1);
			if (result != 0) {
				System.out.println("���� �Ϸ�!!");
			} else {
				System.out.println("�ش� �������� �ۼ��� ����ΰ� �������� �ʽ��ϴ�.");
			}
			break; // ī�� ��� ����

		case 2:
			do {
				System.out.println("�����Ա� ���� ����� ������ ���Ͻø� [1]��, ������� ����� ������ ���Ͻø� [2]��,");
				System.out.println("����� ������ ����Ͻ÷��� [3]�� �Է����ּ���.");
				System.out.print("��");
				se2 = sc.nextInt();
			} while (se2 < 1 || se2 > 3);

			switch (se2) {
			case 1:
				result = money.inputMoney(id,2);
				if (result != 0) {
					System.out.println("���� �Ϸ�!!");
				} else {
					System.out.println("�ش� �������� �ۼ��� ����ΰ� �������� �ʽ��ϴ�.");
				}
				break;

			case 2:
				result = money.inputMoney(id,3);
				if (result != 0) {
					System.out.println("���� �Ϸ�!!");
				} else {
					System.out.println("�ش� �������� �ۼ��� ����ΰ� �������� �ʽ��ϴ�.");
				}

				break;
			case 3:
				break;
			}

			break; // ���� ��� ����
		case 3:
			break;// ���� ������

		}

	}

	public void inputCAData(String id) {

		int se1, se2;
		int result;

		do {
			System.out.println("���� ����θ� ���Ͻø� [1]��, ���� ����θ� ���Ͻø� [2]��,");
			System.out.println("����� �Է��� ����Ͻ÷��� [3]�� �Է����ּ���.");
			System.out.print("��");
			se1 = sc.nextInt();
		} while (se1 < 1 || se1 > 3);

		System.out.println();

		switch (se1) {// ���� ���� ����
		case 1:// ���� ����� �Է�
			do {
				System.out.println("ī�� ������ ���Ͻø� [1]��, ���� ������ ���Ͻø� [2]��,");
				System.out.println("����� �Է��� ����Ͻ÷��� [3]�� �Է����ּ���.");
				System.out.print("��");
				se2 = sc.nextInt();
			} while (se2 < 1 || se2 > 3);

			switch (se2) {// ī������
			case 1:
				result = money.inputMoney(id,4);

				if (result != 0) {
					System.out.println("�ۼ� �Ϸ�!!");
				} else {
					System.out.println("�ۼ� ����!!");
				}
				break;

			case 2: // ���� ����
				result = money.inputMoney(id,5);

				if (result != 0) {
					System.out.println("�ۼ� �Ϸ�!!");
				} else {
					System.out.println("�ۼ� ����!!");
				}

				break;
			case 3:
				break; // ���� ����� ��
			}

			break;

		case 2:// �����Է�

			result = money.inputMoney(id,6);
			if (result != 0) {
				System.out.println("�ۼ� �Ϸ�!!");
			} else {
				System.out.println("�ۼ� ����!!");
			}

		case 3:
			break;

		}

	}// ����� �ۼ� ��

	//������ü
	public void changeAsset(String id) {

		try{

			String str;
			String str2;
			int money;

			System.out.print("������� : ");
			str = sc.next();
			System.out.print("�Ա����� : ");
			str2 = sc.next();
			System.out.print("�ݾ� : ");
			money = sc.nextInt();

			int result = dao.changeAsset(id, str, str2, money);

			if(result==4)
				System.out.println("������ü�� �����ϼ̽��ϴ�.");
			else
				System.out.println("������ü�� �����ϼ̽��ϴ�. ���������� Ȯ�����ּ���");

		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//ī�����
	public void cardPayment(String id) {
		
		try {
			
			String str;
			String str2;
			int money;
			
			System.out.print("���� ī��[�����̸�] : ");
			str = sc.next();
			System.out.print("���� ����[�����̸�] : ");
			str2 =sc.next();
			System.out.print("�����ݾ� : ");
			money = sc.nextInt();
			
			int result = dao.cardPayment(id, str, str2, money);
			
			if(result==4)
				System.out.println("ī������� �����ϼ̽��ϴ�.");
			else
				System.out.println("ī������� �����ϼ̽��ϴ�. ���������� Ȯ�����ּ���");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}