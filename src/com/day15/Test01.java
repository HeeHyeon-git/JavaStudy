package com.day15;

import java.io.IOException;

//Stream. ������ ���� �پ�. ���������� ����
//�⺻ �Է� ��Ʈ��(in): �����͸� ������ �� �� ������� 1byte����
public class Test01 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("���ڿ� �Է�[ctrl+z]: ");//abfdg123
		while((data=System.in.read())!=-1){ //System.in.read() 1byte�� ����
			char ch = (char)data;
			System.out.print(ch);
		}
		
	}

}
