package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

//Ŭ���̾�Ʈ ���� ���� ���� 
// [Ŭ���̾�Ʈ] fis �����б� > oos ����ȭ >>> ���� >>> [����] ois ������ȭ > fos���ϻ���

public class FileClientTest {

	public static void main(String[] args) {
		
		int port = 5555;
		
		String host = "127.0.0.1";//�ڽ� ip�� ���൵ ��
		Socket sc= null;
		
		ObjectOutputStream oos= null;
		
		Scanner scn = new Scanner(System.in);
		String file;
		
		try {
			
			System.out.print("������ ���� ��θ�? :");//d:\\doc\\test.txt
			file = scn.next();
			File f = new File(file);
			
			if(!f.exists()){
				System.out.println("������ �����ϴ�.");
				System.exit(0);
			}
			
			sc = new Socket(host, port);
			oos = new ObjectOutputStream(sc.getOutputStream());
			oos.flush();
			
			//�������۽���
			FileInfo info;

			info = new FileInfo();//FileInfo Ŭ���� ��ü ����
			info.setCode(100);
			info.setData(f.getName().getBytes());//������ �̸��� ���� �� byte������ �޾ƾ� ��
			info.setSize((int)f.length());
			
			oos.writeObject(info);//��Ʈ��ũ�� ���� ���� ������ ��
			System.out.println(f.getName() + "���� ���� ����!!");
			
			Thread.sleep(300);//�ѹ��� �������� �ʰ� �߰��� �޽�. jam ���� ����
			
			//���ϳ�������
			FileInputStream fis = new FileInputStream(f);//Ŭ���̾�Ʈ������ �о �����°� �ʿ�
			
			int data = 0 ;
			byte[] buffer = new byte[1024];
			
			while((data=fis.read(buffer,0,1024))!=-1){//1024 -> buffer.length�� ����
				
				info = new FileInfo();
				
				info.setCode(110);
				info.setData(buffer);
				info.setSize(data);
				
				System.out.println(data + "bytes ������.....");
				oos.writeObject(info);//���� object�� ������
				
				buffer = new byte[1024];//���ۿ� �ִ� ������ �����. ��� �� ���θ���
				Thread.sleep(300);
			}
			fis.close();
			
			//������������
			info = new FileInfo();//FileInfo Ŭ���� ����
			info.setCode(200);
			info.setData(f.getName().getBytes());//������ �̸��� ���� �� byte������ �޾ƾ� ��
			info.setSize((int)f.length());
			
			oos.writeObject(info);//��Ʈ��ũ�� ���� ���� ������ ��
			System.out.println(f.getName() + "���� ���� ����!!");
			
			Thread.sleep(300);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
