package com.day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test08 {
	
	public boolean flieCopy(String file1, String file2){
		
		File f = new File(file1);//���� ��ο� ���� ����
		
		if(!f.exists()){//�ش� ���� ������ ����
			return false; 
		}
		
		try {
			FileInputStream fis = new FileInputStream(f);//f, file1 �� �ᵵ ��� ����. f�� file1�� �־���� ����
			FileOutputStream fos = new FileOutputStream(file2);
			
			//**���۸� ����ؼ� while�� ���� �� ���� ���**
			int data;
			byte[] buffer= new byte[1024];//1024byteũ���� ���� ����	
			
			while((data=fis.read(buffer, 0, 1024))!=-1){//�ش� ������ �ִ� ������ �����͸� 0��°���� 1024��°���� ��� �о��
				fos.write(buffer, 0, data); 			//data�� byte
			}
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
			
		Test08 ob = new Test08();
		Scanner sc= new Scanner(System.in);
		
		String file1, file2;
		
		System.out.print("��������?:");
		file1 =sc.next();
					
		System.out.print("�������?:");
		file2 =sc.next();
		
		if(ob.flieCopy(file1, file2)){
			System.out.println("���� ���� ����!");
		}else{
			System.out.println("���� ���� ����!");
		}

		sc.close();
	}

}
