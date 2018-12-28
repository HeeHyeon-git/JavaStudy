package com.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//������ȭ�� ������ ������ ���� �� ����. password�� ���� ������ �׶� �׶� ����� �ؾ���
//�ش� ���������� age������ transient�� �����ϸ� -> default ���� ����

public class Test3 {

	public static void main(String[] args) {
		
		try {
			
			//����ȭ
			FileOutputStream fos = new FileOutputStream("d:\\doc\\score.txt");			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//MyData ob = new MyData("�����", 30);
			oos.writeObject(new MyData("�����",25,60));//Ŭ���� ��ü �����ؼ� �ٷ� �־��ַ��� �����ε��� �����ڸ� ���� ��
			oos.writeObject(new MyData("�ڽ���",29,60));
			oos.writeObject(new MyData("���¸�",29,90));
			oos.writeObject(new MyData("õ����",40,80));
			
			oos.close();
			fos.close();
			
			//������ȭ
			FileInputStream fis = new FileInputStream("d:\\doc\\score.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			MyData ob = null;//Ŭ������ �ʱⰪ�� null
			
			while(true){
				
				ob = (MyData)ois.readObject();//downcast
				
				if(ob==null){//null�̸� ���̻� ����� MyData����
					break;
				}
				
				System.out.println(ob.toString());
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
