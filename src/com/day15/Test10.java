package com.day15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

//PrintStream

public class Test10 {

	public static void main(String[] args) {

		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out1.txt");//���ϻ���
			
			PrintStream ps = new PrintStream(fos); //PrintStream�� �⺻�����ڰ� ����. �ݵ�� ���� ��ġ �˷���� ��
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("���ڿ��Է�?");
			
			String str;
			while((str=br.readLine())!=null){//br�� �ִ� �����͸� ���� ������ ��� String���� �о��. null�� ���� ������
				ps.println(str);//ps ��Ʈ���� ���
			}
			
			//����� ������ �׻� �ݾ��ֱ�
			ps.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
