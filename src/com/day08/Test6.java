package com.day08;

//Call By Value. 
//���� �������� ������.
//stack ������ �����Ͱ� Heap�������� ������ ��ü�� �Ѿ

//Call By Reference
//Heap������ �ִ� �����͸� �����Ҷ� ��������ü�� ����Ǵ°� �ƴ϶� �ּҰ� ����Ǵ� ��
//static�� ���� ������ �� 
//���� �ּҸ� ������. �ּҸ� ���� ������ ����
//�̹� ������� ���� ������ �� �� ���.  

class Test{
	public int x= 10;
	public void sub(int a){
		x += a; //x=x+a
	}	
}

public class Test6 {

	public static void main(String[] args) {
		Test ob = new Test();
		int a = 10;

		System.out.println("sub�޼ҵ� ������ :" + ob.x);
		ob.sub(a);// Call by value 
		System.out.println("sub�޼ҵ� ������ :" + ob.x);
		
		Test ob1;
		ob1 = ob; //Call by reference. ob�� �ּҰ��� ob1�� �־��. �ּҰ��� �����ؼ� ���� ���� ����Ű�Ƿ� ���ϰ� ����
		
		System.out.println("ob.x:" + ob.x ); //20
		System.out.println("ob1.x:" + ob1.x ); //20
		
		//�Ȱ��� ��ġ�� �� ��� �ƴ���. ���� �����ؼ� �ٽ� ��ȸ�غ��� ��
		ob1.x = 100;
		System.out.println("ob.x:" + ob.x ); //100
		System.out.println("ob1.x:" + ob1.x ); //100
	}
	
}
