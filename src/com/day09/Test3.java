package com.day09;

class SuperA{
	
	private String title;
	protected double area;
	
	public SuperA(){} //�⺻������
	public SuperA(String title){ //�����ε��� ������
		this.title = title;
	} 
	
	//�޼ҵ�
	public void write(){
		System.out.println(title + " : " + area);
	}
	
}


//CircleŬ������ RectaŬ������ �ƹ� ��� ����. 
class Circle extends SuperA{
	private int r;
	protected static final double PI = 3.14; //static�̹Ƿ� ��Ʈ ��￩��. �޸𸮻� �˾Ƽ� �ö�
	
	public Circle(int r){
		super("��"); //SuperAŬ������ �⺻�����ڸ� ã�ư��µ� �װ��� �⺻�����ڰ� ���ٸ�. ����
		this.r=r;
	}
	
	public void circleArea(){
		area=r*r*PI; //PI�� double�̹Ƿ� ����ȯ��
	}

}

class Recta extends SuperA{
	
	private int w,h;
	public void rectArea(int w, int h){
		this.w= w; //�̰Ծ����� �ʱⰪ 0���� ó��
		this.h= h;
		area = w*h;
		//super.write();
	}
	
	//���콺��Ŭ�� - Source > Override > �θ�Ŭ�����߿� ��� �޼ҵ带 ���������� ������̼� ��� ��� ����
	//Annotation : �޼ҵ���̳� �Ű����� ����,�ڷ������� �޶����� �˷���
	//�θ�Ŭ������ ���������� ���� �� �� ����
	@Override
	public void write() {
		//super.write(); //�ڽ�Ŭ������ �޼ҵ�ȿ��� �θ��� �޼ҵ带 ���������� ��� ����. main�������� �ۼ��ȵ�.  
		System.out.println("����:"+w);
		System.out.println("����:"+h);
		System.out.println("����:"+area);
	}
	
	//override(�������̵�, ������, ������) : ��������� �ٸ��� ������ �޼ҵ��̸��� �����ص� ������. 
	//��Ӱ��迡�� �θ��� �޼ҵ�� �Ȱ��� �����...(�޼ҵ��, �Ű����� ��) ���븸 �ٸ��� ����
	//�ϴ� ������ ����. �ڽ��� ������� ������ ����. ���α׷����� �ǵ��� �ݿ�
	//@Override ������̼�(Annotation)
	
}

public class Test3 {

	public static void main(String[] args) { 
		
		Circle ob1 = new Circle(10);
		ob1.circleArea();
		ob1.write();
		
		System.out.println("------------------------------------");
		
		Recta ob2 = new Recta();//�⺻�����ڷ� ����
		ob2.rectArea(10, 20); //�Ű������� �ʿ�
		ob2.write(); //5. �θ� ������ �ְ� ���� ������ ������ ���� ����. ������!!
		//��� ������ε� �θ� �޼ҵ带 ����� �� ����. ������ ö���ϱ� ����. Ŭ���� ���ǽ� �޼ҵ� �ȿ����� ����(53��).
		//�޼ҵ�� �ϴ��� ���ʳ��� �ڽ� ���� �����. �׸�ŭ ������ ö��.
	}

}
