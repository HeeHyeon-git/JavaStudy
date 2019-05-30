package com.MyHome;

import java.util.regex.Pattern;

public class MyHomeException {
	
	//�α���(���̵� Ȯ��)
	public void loginCheck(String id) throws AuthenException{
		throw new AuthenException("\n" +id+ "�� �������� �ʽ��ϴ�. \n���̵� Ȯ�����ּ���.");
	}
		
	//�α���(��й�ȣ Ȯ��)
	public void pwCheck(String pw) throws AuthenException{
		throw new AuthenException("\n��й�ȣ�� ��ġ���� �ʽ��ϴ�. \n��й�ȣ�� Ȯ�����ּ���.");
	}

	public void homeCheck() throws AuthenException{
		throw new AuthenException("��ȣ�� ����� �Է��ּ���");
	}
	
	public void choiceCheck(Object choice) throws AuthenException{
		
		if(!(choice instanceof Integer))
			throw new AuthenException("��ȣ�� ����� �Է��ּ���");
	}
	
	public void n(String n) throws AuthenException{
		
		if( !n.equals("1") && !n.equals("2") && !n.equals("3") && !n.equals("4") && !n.equals("5")
				&& !n.equals("6") && !n.equals("7") && !n.equals("8"))
			throw new AuthenException("�ع�ȣ�� ����� �Է����ּ���");	
	}
	
	
	//�Ź��˻��� 1-5�� ��ȣ �Է� Ȯ��
	public void searchCheck(Object choice) throws AuthenException{
		
		if(!(choice instanceof Integer))
			throw new AuthenException("��ȣ�� ����� �Է��ּ���");
		
		if((Integer)choice>5)
			throw new AuthenException("1~5������ ���ڸ� �Է����ּ���");
		
	}
	
	public void check(String s) throws AuthenException{
		
		boolean check = false;
		
		if(Pattern.matches("^[0-9]*$", s))
			check = true;
		
		if(!check)
			throw new AuthenException("�ذ����� ���ڷθ� �Է����ּ���");	
		
	}
	
	public void localCheck(String local) throws AuthenException{
		
		int check = 0;
		String localCheck[] = {"������", "������", "���ϱ�", "������", "���Ǳ�", "������", "���α�", "��õ��", "�����", "������", "���빮��",
							   "���۱�", "������", "���빮��", "���ʱ�", "������", "���ϱ�", "���ı�", "��õ��","��������", "��걸", "����",
							   "���α�", "�߱�", "�߶���"};
		
		for(String s : localCheck){
			if(local.equals(s))
				check = 1;
		}
		
		if(check == 0)
			throw new AuthenException("\n������ ����� �Է����ּ���. \n[XX��]�������� �Է����ּ���");
		
	}

}
