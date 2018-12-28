package com.day12;

//����Ŭ����(��ø)
//Ŭ�����ȿ� static Ŭ������ ����

class Outer3{
	
	static int a = 10;
	int b = 20;
	
	public static class Inner3{ 
		int c = 30;
		public void write(){
			System.out.println(a);
			//System.out.println(b); //static�� �ƴ� instance������ ����� �� ����.
			System.out.println(c);
		
			Outer3 out = new Outer3(); //staticŬ������ �޸� �Ҵ� �˾Ƽ� ��. �׷��� �Ųٷ� Outer ��ü������ ���⼭ �ۼ�
			System.out.println(out.b);
		}		
	}
	
	public void print(){ //�� ����� �ǹ̰� ����. �̹� static�̹Ƿ� ��ü���� �Ǿ�����
		Inner3 ob = new Inner3();
		ob.write();
	}
}

public class Test3 {

	public static void main(String[] args) {
		Outer3 out = new Outer3();
		out.print();
		
		Outer3.Inner3 inner = new Outer3.Inner3(); //�� ����� �ǹ̰� ����. �̹� static�̹Ƿ� ��ü���� �Ǿ�����
		inner.write();

	}

}
