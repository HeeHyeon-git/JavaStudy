package com.day08;

//���(�θ� �ڽ����� �ִ� ��)
//1. �θ𲨴� ���Ŵ�
//2. private �� ������ ���� ����� �Ұ���
//3. protected �� ������ ���� ����� ����. ���� ��Ű���ȿ������ ��� ����
//4. ������ ���Ŵ�. �θ� �����ٰ� �� �� ����. �̼����� Ư¡�� �̼��Ÿ� ��� ����!
//5. �θ� ������ �ְ� ���� ������ ������ ���� ����.

class SuperClass{
	
	private String title;
	private int area;
	
	public void set(String title, int area){
		this.area=area;
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + ":" + area);
	}
}

class SubClass extends SuperClass{ //���߻���� �ȵǱ� ������ �ϳ��� ��������(���ϻ��)
	
	private int w;
	private int h;
	
	public SubClass(int w, int h){ //������ �ʱ�ȭ
		this.w = w;
		this.h = h;
	}
	
	public void rectArea(){
		int a = w*h;
		//area = w*h; �ٷ� area�� �Է��� �� ����. private�̱� ���� //2.private�� ������ ���� ����� �Ұ���
		set("�簢��", a); //1.�θ𲨴� ���Ŵ�
		
	}
	
	
}

public class Test7 {

	public static void main(String[] args) {
		
		SubClass ob = new SubClass(10,20);
		ob.rectArea();
		ob.print();//1.�θ𲨴� ���Ŵ�
	
	}

}
