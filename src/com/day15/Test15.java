package com.day15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

//RandomAccessFile
//������ �����ϰ� �а� ���� �ִ� Ŭ���� 
//RandomAccessFileŬ���� ������ mode�ɼ����� '�б� ����' �Ǵ� '�а� ���� ����'���� ���� ����

public class Test15 {

	public static void main(String[] args) {
		
		try {
			
			//File.createTempFile(prefix, suffix)
			//- ȯ�� ������ ������ tmp ���丮�� �ڵ����� �����ȴ�.

			File f = File.createTempFile("imsi", "tmp"); //(����, ���). ����ִ� �ӽ����� ��ü ���� 
			
			System.out.println(f.getName());
			
			f.deleteOnExit();//�ش� �޼ҵ带 ȣ�� �ϸ� jvm�� ���� �ɶ�, �ڵ����� �ӽ������� �����ȴ�.
			
			FileOutputStream fos = new FileOutputStream(f);
			
			//���� �ۼ�
			for(int i=0;i<100;i++){
				fos.write(i);
			}
			fos.close();
			
			RandomAccessFile raf = new RandomAccessFile(f, "rw"); //f����ġ, read,write��� ����
			
			for(int i=0;i<=100;i++){
				raf.seek(i);//ã�ƶ�
				System.out.println("raf.seek(" + i + "): "+raf.readByte());//�о��. Reads a signed eight-bit value from this file.
			}
			
			raf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
