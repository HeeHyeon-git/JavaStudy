package com.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//�μ�[5,2]? 15,40 ���ڱ����۾�
//������? + �������Է�
//15+40=55

class TestTest{
	public void print(String result){	
		System.out.println(result);
	}	
}

class Calc extends TestTest{ //��Ӱ��� ���	
	private int num1, num2, r;
	private char oper;
	String result, str;
	public void input() throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		System.out.print("�� ���� �Է�[5,2] : " );
		String str = br.readLine();	
		str = str.replaceAll("\\s", "");	
		String ss[] = str.split(",");

		num1 = Integer.parseInt(ss[0]);
		num2 = Integer.parseInt(ss[1]);
		
		System.out.println("������?");//+,-,*,/
		oper = (char)System.in.read();
	}
		
	public String calc(){
		
		if(oper=='+'){
			r = num1 + num2 ; 
		}else if(oper=='-'){
			r = num1 - num2 ;
		}else if(oper=='/'){
			r = num1 / num2 ;
		}else if(oper=='*'){
			r = num1 * num2 ;
		}else{
			System.out.println("������ ����");
		}
		
		String result = String.format("%d %c %d = %d", num1, oper, num2, r);		
		
		return result;	
		//return String.format("%d %c %d = %d", num1, oper, num2, r);
	}

}

public class Test3 {
	
	public static void main(String[] args) throws IOException {
	
		Calc ob = new Calc();
		ob.input();
		String r = ob.calc();
		ob.print(r);
		
	}
}
