package com.day16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//��ü�� ����ȭ : DB������ ������������ ������ ��� �̿� ���� ������
//�޸𸮿� ������ Ŭ������ ��ü�� ��������� ���� ���¸� 
//�״�� �����ؼ� ���Ͽ� �����ϰų� ��Ʈ��ũ�� ���� ������ �� �ִ� ���
//������ ����Ʈ �����θ� �����͸� �ۼ��� �����ϴ�.

//������ ��ü ��ü�� ������ ����� ���Ŀ� ���ֹ��� �ʰ�
//��ü�� ���������ν� ���Ӽ�(���α׷��� �����ص� ����Ǿ� ����)�� ������ �� �ְ� 
//��ü ��ü�� ��Ʈ��ũ�� ���ؼ� �ս��� ��ȯ�� �� �ִ�.

//implements Serializable(�������̽�)�� ����(��, �޼ҵ尡 ����). ���� �ϸ� ��

//�÷����� �⺻������ Serializable ������ �������̽��� ����.
//�׷��� �Ʒ� �ڵ忡 ���� ������ ��� ����
public class Test1 {

	public static void main(String[] args) {
		
		try {
			
			//Map ����
			Hashtable<String, String> h = new Hashtable<String, String>();
			
			h.put("1", "�����");
			h.put("2", "���¸�");
			h.put("3", "õ����");//����ȭ
			
			//�ƿ�ǲ���� ����(������ character����̶� h�� �ٷ� ���� �� ����. �����ڵ�� �� �����͸� ����)
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out7.txt");
			
			//������ �޸𸮻� �ִ� binary �������� ����.
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(h);//upcast. Ŭ������ ������ Ÿ���� Object
			
			oos.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
