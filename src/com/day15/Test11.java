package com.day15;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test11 {

	public static void main(String[] args) {
		
		try {
			//�̷������� �����ϴ� �͵� ����
			FileOutputStream fos;
			PrintStream ps;
			
			//fos = new FileOutputStream("d:\\doc\\out3.txt");
			ps = new PrintStream(new FileOutputStream("d:\\doc\\out3.txt"));
			
			ps.println("�����");
			ps.println("�ڽ���");
			ps.println("���¸�");
			ps.println("������");
			ps.println("�����");

			//fos.close();
			ps.close();
			
			//-----------------------------------------------------------------
			//true:append
			
			fos = new FileOutputStream("d:\\doc\\out3.txt",true);//�����ؼ� ����. True�� ���� ��� ��ȭ����ݸ� ������ ��. ���ƾ���
			ps = new PrintStream(fos);
			
			ps.println("������");
			ps.println("ȭ����");
			ps.println("������");
			ps.println("�����");
			ps.println("�ݿ���");
			
			fos.close();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
