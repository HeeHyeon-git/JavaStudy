package com.guestbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GB {

	Scanner sc = new Scanner(System.in);
	GBDAO dao = new GBDAO();
	GBException ge = new GBException();

	// ������ȸ
	public void selectGB() {

		List<GBDTO> lists = dao.selectbang();
		Iterator<GBDTO> it = lists.iterator();

		// lists ���
		while (it.hasNext()) {
			GBDTO dto = it.next();
			dto.print();
		}
	}

	// ȸ��Ż��
	public void deleteMember() {

		try {
			String delid, delpwd;
			System.out.println("������ ������ �Է��ϼ���.");
			System.out.print("id: ");
			delid = sc.next();
			System.out.print("pwd: ");
			delpwd = sc.next();

			int result = dao.deletedata(delid, delpwd);

			if (result==1) {
				System.out.println("ȸ��Ż�� ���������� ����Ǿ����ϴ�!");
			} else {
				System.out.println("ȸ��Ż�� ������� ���Ͽ����ϴ�! ȸ�������� Ȯ�����ּ���.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void insertGB(String id) {

		try {
			GBDTO dto = new GBDTO();
			// ���̵�
			dto.setId(id);

			System.out.print("���� ����:");
			dto.setText(sc.next());

			int result = dao.insertGB(dto);

			if (result!=0) {
				System.out.println("�ۼ� �Ϸ�!!");
			} else {
				System.out.println("�ۼ� ����!!");
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void deleteGB(String id) {
		GBDTO dto = new GBDTO();

		try {

			System.out.println("������ ���� ��ȣ");
			int dn = sc.nextInt();

			int result = dao.deleteGB(dn, id);

			if (result != 0)
				System.out.println("���� ����!!");
			else
				System.out.println("���� ����!!");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void insert() throws Exception {

		String pw2 = null;
		String str = null;
		boolean phone = true;
		boolean id = true;
		boolean pw = true;
		boolean name = true;
		boolean gender = true;

		System.out.println("             ȸ������");
		System.out.println("-------------------------------------");

		try {

			GBDTO dto = new GBDTO();

			do {
				try {
					System.out.print("���̵�:");
					str = (sc.next());
					ge.idFormat(str);
					id = false;
					dto.setId(str);

				} catch (Exception e) {
					System.out.println(e.toString());
				}

			} while (id);

			do {
				try {

					System.out.print("��й�ȣ:");
					dto.setPwd(sc.next());

					System.out.print("��й�ȣ Ȯ��:");
					pw2 = sc.next();
					ge.pwCheck(dto.getPwd(), pw2);

					pw = false;

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (pw);

			do {
				try {
					System.out.print("�̸�:");
					str = sc.next();
					ge.nameCheck(str);

					name = false;
					dto.setName(str);

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (name);

			System.out.print("����[��/��]:");
			str = sc.next();
			dto.setGender(str);


			System.out.print("����[xxxx-xx-xx]:");
			dto.setBirth(sc.next());

			do {
				try {
					System.out.print("��ȭ��ȣ[xxx-xxxx-xxxx]:");
					str = sc.next();
					ge.phoneCheck(str);

					phone = false;
					dto.setTel(str);

				} catch (Exception e) {
					System.out.println(e.toString());

				}

			} while (phone);

			int result = dao.insertMember(dto);

			if (result != 0) {
				System.out.println();
				System.out.println("****���������� ������ �Ǿ����ϴ�!****");
				System.out.println();

				System.out.println("-----------[ȸ������ Ȯ��]-----------");
			} else
				System.out.println("ȸ�����Կ� �����߽��ϴ�");

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public String login() {

		String id;
		String pwd;
		String checkid = null;

		try {

			GBDTO dto = new GBDTO();

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

}
