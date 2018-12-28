package com.day15;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//DataOutputStream
//DataInputStream
//boolean, byte, char���� �ڷ����� ���� ���� �� �ְ� ���ְ�
//�̷��� �б� ������ ����ϴ� �÷������� �����ϰ� �����Ѵ�.

public class Test19 {

	public static void main(String[] args) {

		try {
			
			//������ �б� ���ؼ� �ݵ�� �ʿ� : FileInputStream
			//������ ����� ���ؼ� �ݵ�� �ʿ� : FileOutputStream
			
			//DataInputStream. �ؽ�Ʈ������ ���� ������ �������� ������ �� ����Ȱ�. os�� �޶� �� ����
			FileOutputStream fos = new FileOutputStream("d:\\doc\\data.txt");//file ��������
			DataOutputStream dos = new DataOutputStream(fos); //�ѹ��� DataOutputStream���� �����ذ�. �� ������ Ÿ�Դ�� �����ض�
			
			dos.writeUTF("���ѹα�");
			dos.writeByte(10);
			dos.writeChar('A');
			dos.writeInt(20);
			dos.writeUTF("����");
			
			fos.close();
			dos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\data.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			//���� ������� ȣ��
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			
			fis.close();
			dis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}

}
