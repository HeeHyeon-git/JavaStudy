package com.day07;

class Rect{//���� instance������ instance�޼ҵ�
	
	private int w,h ; //��������, instance����
	
	public void set(int w, int h){ // ���������� �Ű������� �̸��� �Ȱ��Ƽ� ȥ���� ��. �̷��� this ���
		//��ȸ�ؼ� �ʱ�ȭ ��ų �� �ֵ�����. �ʱ�ȭ�޼ҵ�
		this.w= w;
		this.h= h;	
	}
	public int area(){
		return w*h;
	}
	
	public int length(){
		return (w+h)*2;	
	}
	
	public void print(int a, double l){ 
		System.out.println("����: "+w+", ����: "+h);
		System.out.println("����: "+a+", �ѷ�: "+l);
	}
	
	// Overload(Overloading : �޼ҵ� �ߺ�����)
	// ����: ���� Ŭ�����ȿ��� �޼ҵ��� �̸��� ���������� �Ű������� ������ �ڷ����� �޶�� �Ѵ�. -> �ٸ� �޼ҵ�� �ν��Ѵ�.
	// �޼ҵ��̸�����, �Ű�������������, �ڷ����� ���ٸ� ���� �޼ҵ�� �ν�
	// �� ����? ���� ������ �ϴ� �޼ҵ带 ���Ͻ�Ű�� ���ؼ� 
	public void print(){	
		System.out.println("����: "+w+", ����: "+h);		
	}
	
	public void print(int a){ //�Ű�����1��
		System.out.println("����: "+w+", ����: "+h);			
		System.out.println("����: "+a);		
	}

	public void print(double l){//�Ű�����1��. �ڷ��� �ٸ�
		System.out.println("����: "+w+", ����: "+h);			
		System.out.println("�ѷ�: "+l);		
	}
	
}

public class Test5 {

	public static void main(String[] args) {
		
		Rect ob1 = new Rect();
		
		ob1.set(10,20); //w,h�� �ʱ�ȭ��Ŵ
		int a = ob1.area();
		double l = ob1.length();
		
		ob1.print(a,l);
		ob1.print();
		ob1.print();
		
		//ob1.printt(l);��� �޼ҵ��̸��� �ٸ��� ������ overloading �� �ƴϴ�.

		//String str;
		//str.valueof(); ���� �޼ҵ������ 9�� ����. ��� �ڷ��� �ٸ� 
	}

}
