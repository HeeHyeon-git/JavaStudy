package com.day15;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//OutputStreamWriter
//1byte Stream�� 2byte Stream���� ��ȯ ���ִ� Stream

public class Test04 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("���ڿ� �Է�: ");
		Reader rd = new InputStreamReader(System.in);
		
		Writer wr = new OutputStreamWriter(System.out); //so�� osw�� ���ΰ� osw�� w�� ���� ��.
		
		while((data=rd.read())!=-1){
		
			wr.write(data); //write(): Writes a single character.
			wr.flush(); //�� �޼ҵ尡 ���� ��� ���۰� �� ���������� �������� ����.
		
		}
		
	}

}
