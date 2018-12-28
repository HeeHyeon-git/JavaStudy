package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test7 {
	
	public static String getOper() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String oper = null;
		
		try {
			
			System.out.println("������?");
			oper =br.readLine();
			
			if(!oper.equals("+") && !oper.equals("-") && !oper.equals("/") && !oper.equals("*")){
			
				//throw�� ���ܸ� �ǵ������� �߻� ��Ŵ
				//throw�� ����ҷ��� �ݵ�� throws Exception�� ����Ѵ� 
				//try.. catch������ �����ش�.
				throw new Exception("������ �Է� ����!");//�� �޼����� Exception�� ����			
			}		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return oper;	
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, result;
		String oper;
		
		try {
			System.out.print("ù��° ��? ");
			a = Integer.parseInt(br.readLine());
			System.out.print("�ι�° ��? ");
			b = Integer.parseInt(br.readLine());
			
			oper = Test7.getOper();

			result = 0;
			
			if (oper.equals("+"))
				result = a + b;
			else if (oper.equals("-"))
				result = a - b;
			else if (oper.equals("/"))
				result = a / b;
			else if (oper.equals("*"))
				result = a * b;
			System.out.printf("%d %s %d  = %d \n", a, oper, b, result);
			
		} catch (Exception e) { //Try������ ���� �߻��� catch�� ��Ƴ�
			System.out.println(e.toString());
		}
		
	}

}
