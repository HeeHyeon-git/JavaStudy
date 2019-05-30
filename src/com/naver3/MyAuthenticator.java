package com.naver3;

import java.util.regex.Pattern;

class MyAuthenticator extends Exception{
	
	private static final long serialVersionUID = 1L;

	public void inputFormat(String id) throws Exception{
		
		if(id.length()<8 || id.length()>15) { 
			throw new Exception("id�� 8~15 ���� �մϴ�.");		
		}
		
		int cnt1=0; 
		int cnt2=0;
		
		for(int i=0; i<id.length(); i++){			
			char ch = id.charAt(i);	
			if( (ch>=65 && ch<=90) || (ch>=97 && ch<=122) ){//����ҹ��ھƽ�Ű
				cnt1++;
			}else if(ch>=48 && ch<=57){//���ھƽ�Ű
				cnt2++;
			}
		}
		
		if(cnt1==0||cnt2==0){
			throw new Exception("id�� ����ҹ��ڿ� ���ڸ� ȥ���ؾ� �մϴ�.");
		}

	}
	
	public void inputFormat(String pw1, String pw2) throws Exception{
		if(!pw1.equals(pw2)){ 
			throw new Exception("��й�ȣ�� ���� ��ġ���� �ʽ��ϴ�.");
		}	
	}
	
	//���� �Է�
	public void inputFormatGender(String gender) throws Exception{
		if(!gender.equals("����") && !gender.equals("����")){ 
			throw new Exception("[����/����]�� �ٽ� �Է����ּ���.");
		}	
	}
	
	//�ڵ��� ��ȣ
	public void inputFormatTel(String tel) throws Exception{
		
		boolean check = Pattern.matches("(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", tel);
		if(!check)
			throw new Exception("����ȭ��ȣ �Է� ������ [XXX-XXXX-XXXX]�Դϴ�");	
	}
	
	
}