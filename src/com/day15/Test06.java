package com.day15;

import java.io.FileOutputStream;

//FileOutputStream
//������ ����.
//A file output stream is an output stream for writing data to a File or to a FileDescriptor.

public class Test06 {

	public static void main(String[] args) {

		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out.txt");
			int data;
			
			System.out.print("���ڿ� �Է�: ");
			
			while((data=System.in.read())!=-1){// System.in.read() �ƽ�Ű�ڵ�� ���� 
				fos.write(data);//�Է½� ��� ������ ��. ctrl+z�� ����
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
