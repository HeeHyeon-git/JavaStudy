package com.day11;

class TestA{
	
	public void print(){
		System.out.println("AŬ����....");
	}
	
}

class TestB{
	
	public void print(){
		System.out.println("AŬ����....");
	}	

}

public class Test3 {

	public static void main(String[] args) {
		
		TestA a = new TestA();
		TestA b;
		TestB bb; 
		
		b = a; 
		//bb =a; ������ Ÿ���� �ٸ�. �ƿ� �ٸ� Ŭ����. �Ұ�
		//bb = (TestB)a; ����ȯ�ؼ� ���� �� �ִ°�? �Ұ�. ��Ӱ����� ��츸 upcast, downcast ��밡��
	}

}
