package com.MyHome;

import com.excep.AuthenException;

public class JoinException {
	
	//���̵� ���ɿ��� Ȯ��
	public void idFormat(String str) throws AuthenException{
		
		if(str.length()<5 || str.length()>10){
			throw new AuthenException("5~10�� �̳��� ���̵� �����մϴ�");
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
			throw new AuthenException("���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���");	
		
	}
	
	//���̵� �ߺ����� Ȯ��
	public void sameId() throws AuthenException {
		throw new AuthenException("������ ���̵� �̹� �����մϴ�");	
	}
	
	
	//��й�ȣ Ȯ��
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		if(!pw1.equals(pw2))
			throw new AuthenException("��й�ȣ�� �ٸ��ϴ�");	
	}

	
	//�߰�����, �Ǹ���/������ Ȯ��
	public void typeCheck(int type) throws AuthenException{
		if(!(type==1)&&!(type==2)){
			throw new AuthenException("��ȣ�� �ٸ��� �Է����ּ���");
		}
	}
}
