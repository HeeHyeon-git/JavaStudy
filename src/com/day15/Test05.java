package com.day15;

import java.io.FileInputStream;

//FileInputStream
//������ ã�Ƽ� �д� ��Ʈ��

public class Test05 {

	public static void main(String[] args) {
		
		//Stream��� �� �ݵ�� try�� ������� ��. �ƴϸ� ����ó���� �־� ��� ��
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt"); 
			
			int data;
			while((data=fis.read())!=-1){//Reads a byte of data from this input stream. 
				
				//System.out.print((char)data);
				System.out.write(data);//���͸� �������� ������. 
				System.out.flush();//����ġ�� ���� �����͵� ������
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
