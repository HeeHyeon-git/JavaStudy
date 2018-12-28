package com.day11;

//�߻�Ŭ����
//�޸��� ���� ���� Ŭ������ �̸� ����
//�޼ҵ带 ������(override)�ؼ� ����Ѵ�.
//�޼ҵ���� ������ ����ϸ� ��. �������� ������ �޼ҵ�� ����µ� ���x
//�޼ҵ���� �����Ͽ� ���ϼ�.

abstract class ShapeClass{ //�߻�Ŭ������ �θ�Ŭ������ ������ ��

	abstract void draw(); //Ʋ�� ����� ������ �����ٰ� �������Ͽ� ����ض�. interface�� �Ȱ���
						  //������ return���� void�� �޼ҵ���� draw
}

class Circle extends ShapeClass{

	@Override
	public void draw() {
		System.out.println("���� �׸���..");
	}
	
}

class Rect extends ShapeClass{ //�߻�Ŭ������ �޼ҵ��� unimplement method ����� ���� 

	@Override
	public void draw() {
		System.out.println("�簢���� �׸���..");
	}
}

class Tri extends ShapeClass{
	
	@Override
	public void draw() {
		System.out.println("�ﰢ���� �׸���..");
	}
	
}

public class Test1 {

	public static void main(String[] args){
	
		Circle ob1 = new Circle();
		Rect ob2 = new Rect();
		Tri ob3 = new Tri();
		
		ob1.draw();
		ob2.draw();
		ob3.draw();
		
	}
}
