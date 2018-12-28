package com.day09;

// ��� �����ھȿ��� super()�� �����Ǿ� �ִ�.
// A class - B class - C class �θ�-�ڽ� ������ ��
// ���� ��� ���� ������ D class���� C class�� ��ü�� �����Ҷ� �⺻�����ھȿ��ִ� super�� ����
// �θ�Ŭ������ �޸𸮸� ���� �Ҵ���� �� �������� �ڽ�Ŭ���� ����.
// �̶� �ֻ����� �ִ� A class�� �θ�Ŭ������? Object .
// java���� ���� ū �ڷ��� = Object . �����̵��� ���� �� �ִ�. �ڵ����� �ű� ��쿡�� ������ object�� �ű�. ���� ũ�ϱ�.

class Test{
	
	private String title;
	protected int area;
	
	//public Test(){}//�⺻������
	
	public Test(String title){ //�����ε��� ������
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + " : " + area);
		
	}
}
class Rect extends Test{ //�����߻�. 
	//�⺻������ �����Ǿ�����. 
	//�� �⺻�����ھȿ��� super(); ����
	//�θ�Ŭ������ �⺻�����ڸ� �����ϰ� �Ǹ�, ������� �ʰڴٴ� �ǹ�. 
	//�ڽ�Ŭ�������� �θ�Ŭ������ �⺻�����ڸ� �����ؼ� ����
	
	private int w,h;
	public Rect(int w, int h){
		
		//default���� �⺻�������� super(); 
		//-> �׷��� �θ�Ŭ������ �⺻�����ڸ� ���������Ƿ� �����ε��� �����ڸ� ���� ��ü �����ؾ���
		super("�簢��"); //super�� �Ű������� �Ҵ��ϸ� ���� �����. �θ�Ŭ������ �����ε��� �����ڸ� ȣ��
		//�θ�Ŭ������ ���� ��������� �ڽ�Ŭ������ ���� ����
		this.w =w;
		this.h =h;	
		//super("�簢��"); �ؿ� ���� ������. �θ�Ŭ���� ���µ� �Ű������� �Է¹޾� ó�� �Ұ���. �ι��Էµ� �Ұ���
	}
	
	public void rectArea(){
		area=w*h; //�θ�Ŭ���� ������ �����̹Ƿ� �θ�Ŭ������ ���� ��� ����		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10,20); 
		ob.rectArea();
		ob.print(); //�θ�Ŭ�������� ������ �� 

	}

}
