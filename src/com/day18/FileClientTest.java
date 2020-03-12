package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

// ������ �����ϰ��� �ϴ� Ŭ���̾�Ʈ Ŭ�� 
// [Ŭ���̾�Ʈ] fis �����б� > oos ����ȭ >>> ���� >>> [����] ois ������ȭ > fos���ϻ���
public class FileClientTest {

	public static void main(String[] args) {
		
		int port = 5555;
		String host = "127.0.0.1";					// �ڽ� ip�� ���൵ �ȴ�.
		
		Socket sc = null;		
		ObjectOutputStream oos = null;
		Scanner scn = new Scanner(System.in);
		String file;
		
		try {
			
			// 1. ������ ���ϰ�θ� �Է� �޴´�.
			System.out.print("������ ���� ��θ�? :");	// d:\\doc\\test.txt
			file = scn.next();
			File f = new File(file);
			
			// 2. ���� ���� ���� Ȯ��
			if(!f.exists()){
				System.out.println("������ �����ϴ�.");
				System.exit(0);
			}
			
			// 3. ������ ���� ���� �� ��Ʈ�� ����
			sc = new Socket(host, port);
			oos = new ObjectOutputStream(sc.getOutputStream());
			oos.flush();
			
			// �����ϴ� ���ϰ� ���õ� ������ ��� Ŭ���� ��ü ����
			FileInfo info = new FileInfo();
			info.setCode(100);
			info.setData(f.getName().getBytes());//������ �̸��� ���� �� byte������ �޾ƾ� ��
			info.setSize((int)f.length());
			oos.writeObject(info);// ��õ� fileinfo ��ü�� ObjectOutputStream ���� �ۼ��Ѵ�. ��Ʈ��ũ�� ���� ���� ������ ��
			
			System.out.println(f.getName() + "���� ���� ����!!");
			Thread.sleep(300);//�ѹ��� �������� �ʰ� �߰��� �޽�. ó���Ǵ� ������ Ȯ���ϱ� ����.
			
			// 4. ���� ���� ����
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
			// 5. ���� ���� ����
			fis.close();
			
			// 6. ���� ���� ���Ḧ �˸��� ���� FileInfo Ŭ���� ����
			info = new FileInfo();//FileInfo Ŭ���� ���Ҵ� 
			info.setCode(200);
			info.setData(f.getName().getBytes());
			info.setSize((int)f.length());		
			oos.writeObject(info);
			
			System.out.println(f.getName() + "���� ���� ����!!");
			Thread.sleep(300);
			
			oos.close();
			scn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
