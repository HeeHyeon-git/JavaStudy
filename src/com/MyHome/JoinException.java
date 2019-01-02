package com.MyHome;

import java.util.regex.Pattern;

public class JoinException {
	
	//���̵� ���ɿ��� Ȯ��
	public void idFormat(String str) throws AuthenException{
		
		if(str.length()<5 || str.length()>10){
			throw new AuthenException("��5~10�� �̳��� ���̵� �����մϴ�");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
				cnt1++;
			else if(ch>='0' && ch<='9')
				cnt2++;
		}
	
		if(cnt1==0 || cnt2==0)
			throw new AuthenException("�ؾ��̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");	
		
	}
	
	//���̵� �ߺ����� Ȯ��
	public void sameId() throws AuthenException {
		throw new AuthenException("�ص����� ���̵� �̹� �����մϴ�");	
	}
	
	
	//��й�ȣ Ȯ��
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		if(!pw1.equals(pw2))
			throw new AuthenException("�غ�й�ȣ�� �ٸ��ϴ�");	
	}
	
	//�̸� Ȯ��
	public void nameCheck(String name) throws AuthenException{

		boolean check = Pattern.matches("^[��-����-�R]*$", name);
		if(!check)
			throw new AuthenException("���̸��� �ѱ۷� �Է����ּ���");	
	}

	//��ȭ��ȣ Ȯ��
	public void phoneCheck(String phone) throws AuthenException{

		boolean check = Pattern.matches("(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);

		if(!check)
			throw new AuthenException("����ȭ��ȣ �Է� ������ [XXX-XXXX-XXXX]�Դϴ�");	
	}
	
	//�߰�����, �Ǹ���/������ Ȯ��
	public void typeCheck(int type) throws AuthenException{
		if(!(type==1) && !(type==2))
			throw new AuthenException("�ع�ȣ�� �ٸ��� �Է����ּ���");
	}
}
