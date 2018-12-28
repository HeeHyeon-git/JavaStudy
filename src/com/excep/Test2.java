package com.excep;

import java.util.Scanner;

//���� ó�� ���� 
//[����]
//1. 5~10���� �̳� ���� �˻�
//2. ������(��ҹ��� ��������)�� �Է�

class MyAuthenticator{
	
	public void inputFormat(String str) throws Exception{
		
		if(str.length()<5 || str.length()>10) { 
			throw new Exception("���ڿ��� ���̴� 5~10 ���� �մϴ�.");
		}
		
		for(int i=0; i<str.length(); i++){			
			char ch = str.charAt(i);	
			if( ch<65 || (ch>90 && ch<97) || ch>122 ){ 
				throw new Exception("�����ڸ� �Է��ϼ���! " + str );
			}
		}
	}
}

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		String str;
		MyAuthenticator ma = new MyAuthenticator();

		try {
			
			System.out.print("���ڿ�?");//asdsa
			str = sc.next();
			ma.inputFormat(str);// ���ǰ˻�
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//endmain

}//endclass
