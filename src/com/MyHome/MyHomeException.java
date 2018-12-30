package com.MyHome;

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
	
	
	//�Ź��˻��� 1-5�� ��ȣ �Է� Ȯ��
	public void searchCheck(Object choice) throws AuthenException{
		
		if(!(choice instanceof Integer))
			throw new AuthenException("��ȣ�� ����� �Է��ּ���");
		
		if((Integer)choice>5)
			throw new AuthenException("1~5������ ���ڸ� �Է����ּ���");
		
	}

}
