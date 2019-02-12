package com.guestbook;

import java.util.regex.Pattern;

public class GBException {

	//���̵� ���� Ȯ��
	public void idFormat(String str) throws Exception {

		if (str.length() < 5 || str.length() > 15) {
			throw new Exception("3~10�� �̳��� ���̵� �����մϴ�");
		}

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}

		if (cnt1 == 0 || cnt2 == 0)
			throw new Exception("���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");

	}

	//��й�ȣ ����Ȯ��
	public void pwCheck(String pw1, String pw2) throws Exception {

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < pw1.length(); i++) {
			char ch = pw1.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}

		if (cnt1 == 0 || cnt2 == 0)
			throw new Exception("���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");

		if (!pw1.equals(pw2))
			throw new Exception("��й�ȣ�� �ٸ��ϴ�");
	}

	// �̸� Ȯ��
	public void nameCheck(String name) throws Exception {

		boolean check = Pattern.matches("^[��-����-�R]*$", name);
		if (!check)
			throw new Exception("���̸��� �ѱ۷� �Է����ּ���");
	}

	// ��ȭ��ȣ Ȯ��
	public void phoneCheck(String phone) throws Exception {

		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if (!check)
			throw new Exception("����ȭ��ȣ �Է� ������ [XXX-XXXX-XXXX]�Դϴ�");
	}

	//���� Ȯ��
	public void genCheck(String gender) throws Exception {

		if (!gender.equals("����") && !gender.equals("����")) {
			throw new Exception("�ؼ����� ��ȣ�ϱ���!\n������ [����/����]�� �����ּ���;)");
		}
	}
}
