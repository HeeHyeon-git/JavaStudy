package com.day19;

//Class Ŭ���� : �ٸ� Ŭ������ ���� Ŭ���� ������ ������ 

class Test{
	
	public void write(){
		System.out.println("�׽�Ʈ....");
	}
	
}

public class Test2 {

	public static void main(String[] args)  {
		
		try {
			Class c = Class.forName("com.day19.Test");//ClassŬ������ �޼ҵ尡 �ϳ� > forName
			Object ob = c.newInstance();
			Test t = (Test)ob;
			t.write();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
