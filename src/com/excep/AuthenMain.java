package com.excep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthenMain {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1, num2, result;
		
		OperationAuthen oa = new OperationAuthen();

		try {
			
			System.out.print("�� ���� �Է�[a,b]");//10.5,30
			str = br.readLine();
			
			oa.inputFormat(str);//�Է� ���� �˻�. ���� ó���� ���� ���� �߻��� �����޼���. �����ȳ��ԵǸ� �׳� �Ѿ
			
			String[] temp = str.split(",");
			
			//------------------------------------------
			
			oa.number(temp[0]);//���� �Ǽ� �˻�
			num1 = Double.parseDouble(temp[0]); //����,�Ǽ� ������� double���·� num1�� ����
			oa.number(temp[1]);//���� �Ǽ� �˻�
			num2 = Double.parseDouble(temp[1]);
			
			//------------------------------------------
			
			System.out.print("������?");
			str = br.readLine();
			
			oa.operator(str.charAt(0));//������ �˻�. str:String. operator�޼ҵ�:char�� ��. �׷��Ƿ� 0��°�� �ش��ϴ� char������ ��. �����ȳ��� �Ѿ
			char ch = str.charAt(0);
			result=0;
			
			switch(ch){
				case '+':
					result = num1+num2; break;
				case '-':
					result = num1-num2; break;
				case '/':
					result = num1/num2; break;
				case '*':
					result = num1*num2; break;
			}
		
			System.out.printf("%g %s %g = %g\n",num1, ch, num2, result);
			
		} catch (IOException e) {

			System.out.println(e.toString());
		
		} catch (AuthenException e) {
		
			System.out.println(e.toString());
		
		}
		

	}

}
