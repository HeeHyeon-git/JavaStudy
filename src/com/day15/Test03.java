package com.day15;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader
//1byte Stream�� 2byte Stream���� ��ȯ���ִ� Stream

public class Test03 {
	
	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.print("���ڿ� �Է�: ");
		
		//InputStramReader : �긴��Ŭ����
		Reader rd = new InputStreamReader(System.in); //Reader: �о�� �����͸� ��� ��Ƶδ� Ŭ����. Abstract class for reading character streams
		//Reader���� BufferedReader�� �� ����
		
		//rd�� �� �̻� ������ ���� ������ ����
		while((data=rd.read())!=-1){//read() : Reads a single character. data: �ƽ�Ű�ڵ尪�� �����Ƿ� Integer ���
			
			char ch = (char)data;
			System.out.print(ch);
			
		}
	}

}
