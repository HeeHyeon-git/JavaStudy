package com.naver2;

class MyAuthenticator extends Exception{
	
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
	
}