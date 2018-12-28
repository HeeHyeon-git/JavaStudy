package com.day09;

//String 
//String�� class�̴�.(�ڷ����� �ƴϴ�.)
//�ٸ�, String�� �ڷ���ó�� ����ϴ� ������ �����ϴ� ���� ����ϰ� ���󵵰� ���� ����
//stack������ ������ �� ���� heap������ �����ؾ� �� -> �׷��ٺ��� class������ 
//�׷��� ���󵵰� ���ٺ��� new ���� ���ŷο� -> �׷��� �ڷ������� ó�� ��

//String�� �Һ��� ��Ģ�� ������ �ִ�.
//String�� equals�� ���Ѵ�.

public class Test5 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul"; //heap������ "Seoul"�� �����
		String ob2 = "Seoul"; //Call by reference
		String ob3 = new String("Seoul"); //���󵵰� ���ٺ��� �̷��� ���� �����
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); //�ּҸ� ���ϸ� false�� ���;��ϴµ� true�� ����
		//ob1, ob2 ��ü ������ new�� ����Ѱ� �ƴϱ� ������ Call by reference. �ּҸ� ��������
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob3)); //false
		//new�� ���� ��ü ����, ������ heap������ ���ο� �޸� �Ҵ�. �ּҰ� �����ϹǷ� false����
		
		System.out.println("ob1.equals(ob3) : " + ob1.equals(ob3)); //true
		//String�� Ŭ�������� �ڷ����� �䳻�� ������. 
		//ob1�� �ּҸ� ã�ư����� ���� ob3�� �ּҸ� ã�ư����� ���� ���ؾ� ��
		//object.equals() : �� �޼ҵ�� �ּҰ� ��. 
		//object�� equals �޼ҵ带 ���� �ƴ϶� String�� equals �޼ҵ带 ��� (override : �ڽ�Ŭ�������� �޼ҵ�������) 
		
		ob2 = "korea"; //���Ӱ� �޸� �Ҵ���
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//false
		
		ob2 = "japan"; //korea�ʹ� �ٸ��� �� ���ο� �޸� �Ҵ���
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//false
		//�̰� �ٷ� String �Һ��� ��Ģ
		
		ob2 = "Seoul"; //�̹� Seoul�� �Ҵ��ص� �� ������ �� �ּҷ� ����
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//True		
		//�����Ⱚ�� ������ ���� �����ִ�. 
		//�Ϲ������� ���� ���ڿ��� �Է��� ��� ����ϴ°� ���� ����
		
		System.out.println(ob1); //hashcode�� �ƴ� Seoul�� ����
		System.out.println(ob1.toString()); //Seoul. override��. String�� toString()�޼ҵ� ���
		
		//String�� �������ִ� Ŭ���� 2�� ���� -> Test6
		
	}

}
