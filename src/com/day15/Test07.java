package com.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//���� �������α׷�
//���� ����?:d:\\doc\\test.txt
//��� ����?:d:\\doc\\abc.txt
//���� ����

public class Test07 {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			int data;
			String str1, str2;
			
			System.out.print("�������ϰ��?:");//	d:\\doc\\test.txt
			str1 =sc.next();
						
			System.out.print("������ϰ��?:");//	d:\\doc\\out2.txt
			str2 =sc.next();
			
			FileInputStream fis = new FileInputStream(str1); //�����б�
			
			FileOutputStream fos = new FileOutputStream(str2);//���ϻ���
			
			while((data=fis.read())!=-1){//���� ����(fis)�� �����Ͱ� ���� ���� ����

				fos.write(data);//fos�� �ش� �����͸� ���
				fos.flush();
				
			}
			
			fis.close();
			fos.close();	
			System.out.println("���缺��!");
			
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
