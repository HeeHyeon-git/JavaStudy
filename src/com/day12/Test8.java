package com.day12;

import java.util.Vector;

class Test{
	String name;
	int age;
}

public class Test8 {

	public static void main(String[] args) {
		
		Vector<Test> v =new Vector<Test>(); //������ �ڷ����� Object. Ŭ������ �� �� �ִ�.
		//Collection �ȿ� Test��� Ŭ������ ���� �ְڴ�. �迭�� Ŭ������ ���� �Ͱ� ��������.
		
		Test ob;
		ob = new Test(); //���� �����͸� �����Ŷ�� �ݵ�� ��ü������ ������ ����� ��
		ob.name = "�����";
		ob.age = 25;
		
		v.add(ob);
		
		ob = new Test(); //���ο� ��ü�� �������� ������ �����ּҰ��� �ִ� �����Ͱ� ����ǹ���.
		ob.name = "�ڽ���";
		ob.age = 27;
		
		v.add(ob);
		
		//Test ob�� ������ �ִ� �ּҰ��� �ѹ� ���� �ʿ䰡 ����. ���� v�� �� �־����
		for(Test t: v){
			System.out.println(t.name + ":" + t.age);
		}	
	}
}
