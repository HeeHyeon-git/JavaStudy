package com.day08;

//���(�θ� �ڽ����� �ִ� ��)
//1. �θ𲨴� ���Ŵ�(�ڽĵ� �״�� �� �� ����)
//2. private �� ������ ���� ����� �Ұ���
//3. protected �� ������ ���� ����� ����
//4. ������ ���Ŵ�. �θ� �����ٰ� �� �� ����
//5. �θ� ������ �ְ� ���� ������ ������ ���� ����.

class SuperClassA{
	
	private String title;
	protected int area; // �ڽĵ� ��밡���ϵ��� ���������� ���� 
	
	public void set(String title){
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + ":" + area);
	}
}

class SubClassA extends SuperClassA{ //���߻���� �ȵǱ� ������ �ϳ��� ��������(���ϻ��)
	
	private int w;
	private int h;
	
	public SubClassA(int w, int h){ //������ �ʱ�ȭ
		this.w = w;
		this.h = h;
	}
	
	public void rectArea(){
		//int a = w*h;
		area = w*h; //3. protected �� ������ ���� ����� ����
		set("�簢��"); //1.�θ𲨴� ���Ŵ�	
	}
	
	
}

public class Test8 {

	public static void main(String[] args) {
		
		SubClassA ob = new SubClassA(100,200);
		ob.rectArea();
		
		ob.print();//1.�θ𲨴� ���Ŵ�
		ob.area = 10; //protected �϶��� ���� ����
		System.out.println("area : "+ ob.area);
	}

}
