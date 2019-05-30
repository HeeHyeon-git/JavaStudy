package com.checkingAccount;

import java.util.regex.Pattern;

public class CADException {

	//���̵� ���� Ȯ��
	public void idFormat(String str) throws AuthenException {

		if (str.length() < 3 || str.length() > 10) {
			throw new AuthenException("\n3~10�� �̳��� ���̵� �����մϴ�");
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
			throw new AuthenException("\n���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");

	}

	//��й�ȣ ����Ȯ��
	public void pwCheck(String pw1, String pw2) throws AuthenException {

		if (pw1.length() < 3 || pw1.length() > 10) {
			throw new AuthenException("\n5~20�� �̳��� ��й�ȣ�� �����մϴ�");
		}

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
			throw new AuthenException("\n���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");

		if (!pw1.equals(pw2))
			throw new AuthenException("\n��й�ȣ�� �ٸ��ϴ�");
	}

	//�г��� ����
	public void nameCheck(String name) throws AuthenException {

		boolean check = Pattern.matches("^[��-����-�R]*$", name);
		if (!check)
			throw new AuthenException("\n���̸��� �ѱ۷� �Է����ּ���");
	}

	//�����, ��/���ݸ� �Է� ����
	public void accdivCheck(String accdiv) throws AuthenException {

		if (!accdiv.equals("�����") && !accdiv.equals("��/����"))
			throw new AuthenException("\n���Է��� [�����],[��/����]���θ� �����մϴ�");
	}

	//����/ī�� �����̸� ����
	public void accNickCheck(String accNick) throws AuthenException {

		if (accNick.length() < 1 || accNick.length() > 10) {
			throw new AuthenException("\n10�� �̳��� �����̸��� �����մϴ�");
		}

		boolean check = Pattern.matches("^[��-����-�R]*$", accNick);
		if (!check)
			throw new AuthenException("\n�ذ����̸��� �ѱ۷θ� �Է°����մϴ�");
	}

	// �ݾ��� ���ڸ� �Է� ����
	public int numberCheck1(String number) throws AuthenException{

		boolean check = number.matches("^[0-9]*$");
		if (!check)
			throw new AuthenException("\n�ع�ȣ�� ���ڷθ� �Է°����մϴ�");

		if (check)
			return Integer.parseInt(number);

		return 0;
	}

	//����/ī�� ��ȣ�� ���ڸ� �Է� ����
	public String numberCheck2(String number) throws AuthenException{

		boolean check = number.matches("^[0-9]*$");
		if (!check)
			throw new AuthenException("\n�ؼ��ڷθ� �Է°����մϴ�");

		if (check)
			return number;

		return null;
	}

	//ī�װ� �Է�
	public void categoryCheck(String category) throws AuthenException {

		String check[] = {"�ڱ���", "��Ȱ��", "�Ĵ�", "����", "��ȭ", "�̿�", "����", "����", "����"};

		int x = 0;
		for(String i: check){
			if(category.equals(i)){
				x = 1;
				break;
			}
		}

		if(x!=1)
			throw new AuthenException(
					"\n��ī�װ� : [�ڱ���] [��Ȱ��] [�Ĵ�] [����] [��ȭ] [�̿�] [����] [����] [����]");
	}

	// ��¥ Ȯ��
	public void dateCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"(\\d{4})-(\\d{2})-(\\d{2})", date);

		if (!check)
			throw new AuthenException("�س�¥ �Է� ������ [YYYY-MM-DD]�Դϴ�");
	}
	
	// ���� Ȯ��
	public void yearCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"(\\d{4})", date);
		if (!check)
			throw new AuthenException("�ؿ����� ��Ȯ�� �Է����ּ���.");
	}
	
	// �� Ȯ��
	public void monthCheck(String date) throws AuthenException {

		boolean check = Pattern.matches(
				"01|02|03|04|05|06|07|08|09|10|11|12", date);
		if (!check)
			throw new AuthenException("�ؿ��� ��Ȯ�� �Է����ּ���. �Է� ������ 1���� ��� [01]�Դϴ�.");
	}
	
}
