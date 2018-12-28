package com.day08;

import java.io.IOException;
import java.util.Scanner;

class Calc{
	private int num1, num2;
	private char oper;
	public boolean input() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ΰ��� ��?");//10 20
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		System.out.println("������?");//+,-,*,/
		oper = (char)System.in.read();
		if(oper!='+' && oper!='-' && oper!='/' && oper!='*'){
			return false;
		}
		return true;
	}
	
	public int result(){	
		int r = 0;
		switch(oper){
		case '+':
			r = num1 + num2; break;
		case '-':
			r = num1 - num2; break;
		case '/':
			r = num1 / num2; break;
		case '*':
			r = num1 * num2; break;
		}
		return r;
	}
	
	public void print(int r){
		System.out.printf("%d %c %d = %d\n",num1, oper, num2, r);	
	}
}

public class Test5 {

	public static void main(String[] args) throws IOException {	
		Calc ob = new Calc();
		boolean b = false;
		int r = 0 ;
/*		
		b = ob.input(); //����ó���� main�������� ����� ��
		if(b==true){		
			r = ob.result();
			ob.print(r);
		}
		System.out.println("������ ����!!");

*/
		//boolean�̹Ƿ� True�� False���� ����. �Ϲ������� �߰�ȣ �ٱ��� ��������� ���� �ۼ�. �ҽ��ڵ尡 ��
		if(!ob.input()){  
			System.out.println("������ ����!!");
			return;
		}
		r = ob.result();
		ob.print(r);
		
	}

	
}
