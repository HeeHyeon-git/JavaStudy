package com.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//������ String�� �޼ҵ�� �ڵ��غ� ��!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("����[3+5] : " ); //15+25  idx:01234
		String str = br.readLine();
		
		str = str.replaceAll("\\s", ""); //���� �Է� �� �� �����Ƿ� ����.
/*		
 		String[] o = {"+","-","*","/"}; //���������� �迭����.
		for(String op : o){		
		}
*/
		// ���� 3�ٰ� ���� �ڵ�. �迭������ ���ÿ� for�� �ۼ�.
		// �迭�� ������µ� �̸��� ���� ��. ���ϰ� ���ֹ����ڴ�. 
		// �ּҰ� ��� ã�ư� �� ����. garbage collector�� ����
		for(String op :new String[]{"+","-","*","/"}){ 
			
			int pos = str.indexOf(op);//15+25 ��� pos = 2 ����. ã������ �� ������ -1 ����
			if(pos>-1){ //�����ڰ� ��������� ��ȯ���� -1
				int num1 = Integer.parseInt(str.substring(0,pos)); //substring�� �������ε���-1
				int num2 = Integer.parseInt(str.substring(pos+1)); //pos+1���� �������� ���ڸ� int������ �ٲ㼭 ����
				int result = 0 ;
				char oper = str.charAt(pos); //2
				
				switch(oper){
				case '+':
					result = num1 + num2; break;
				case '-':
					result = num1 - num2; break;
				case '*':
					result = num1 * num2; break;
				case '/':
					result = num1 / num2; break;	
				}
				//System.out.printf("%d %c %d = %d", num1, oper, num2, result);	//�̴�� ����ض�	
				String s = String.format("%d %c %d = %d", num1, oper, num2, result); //��ȯ���� string���� ����� ��
				System.out.println(s);
				//return s; ��ȯ�� String�̹Ƿ� ���ϴ� ���� ����� s�� �ҷ��� ���.
			}
			
			
		}
		
	}	

}
