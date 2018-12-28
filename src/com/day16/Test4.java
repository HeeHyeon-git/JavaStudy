package com.day16;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//Externalizable: Serializable �������̽��� ���� �������̽�
//���� ����� �ϵ� �� �� �Ϻ��� ��� ������
//writeExternal(), readExternal() �޼ҵ带 �����ؾ� ��
//Externalizable���� Serializable�� ���� ����ϱ� �� 

class DataTest implements Externalizable{

	String name;
	int age;
	
	public DataTest(){}//�⺻������
	
	public DataTest(String name, int age){//�����ε��� ������
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
	//ȣ�� ���� �ʾƵ� �ڵ������� ����Ǵ� �޼ҵ� : readExternal(), writeExternal()
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		
		name = (String)in.readObject();//downcast
		age = in.readInt();//downcast ���ص� ��. �޼ҵ忡�� ���������� ��ȯ
		System.out.println("readExternal....");
	
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeObject(name);
		out.writeInt(age);
		System.out.println("writeExternal....");
	
	}
	
}

public class Test4 {
	
	public static void main(String[] args) {
		try {
			
			DataTest ob = new DataTest("�����", 25);//���� �� �����ε��� �����ڷ� ��ü ����.
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out8.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ob);
			
			fos.close();
			oos.close();
			
			FileInputStream fis = new FileInputStream("d:\\doc\\out8.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);//����ȭ �Ǿ��� ������ ObjectInputStream�� ���������
			
			DataTest ob1 = (DataTest)ois.readObject();//���� ���� �⺻�����ڷ�! 
			
			System.out.println(ob1.toString());
			
			fis.close();
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
