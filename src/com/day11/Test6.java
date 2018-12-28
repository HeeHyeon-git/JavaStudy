package com.day11;

interface Test{
	
	public int total();
	public void write();
	
}

class TestImpl implements Test{
	private String hak;	
	private String name;
	
	private int kor;
	private int eng;
	
	public TestImpl(){}	
	public TestImpl(String hak, String name, int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
/*	
	public void set(String hak, String name, int kor, int eng){
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
*/
	@Override
	public boolean equals(Object ob){//�Ű������� Object�� upcast��. ob2�� TestImpl Ŭ�������� ������Ʈ�� ��
		
		boolean flag = false;
		
		if(ob instanceof TestImpl){//object�� �����⸦ ���� ����Ÿ���̳�
			
			TestImpl t = (TestImpl)ob;//downcast. TestImpl�� ����ȯ���Ѽ� t�� ����
			
			if(this.hak.equals(t.hak) && this.name.equals(t.name)){	//���⿡���� equals�� String�� �޼ҵ�. hak�� name�� String Ÿ���̴ϱ�. this-ob1, t-ob2
				flag = true;
			}
		
		}	
		return flag;
	
	}
	
	@Override
	public int total() {
		return kor+eng;
	}

	@Override
	public void write() {
	
		System.out.println(hak + "," + name + "," + total());
	}
	
}

public class Test6 {

	public static void main(String[] args) {
		
		Test ob1 = new TestImpl("111","�����",80,90); //�ڽ�Ŭ������ ��ü ���� & �ʱ�ȭ
		//�������̽�    �������̽���������Ŭ����
		Test ob2 = new TestImpl("111", "�����", 100, 100);
		//�ڽ��� �޼ҵ� ���ȵ�
		
		TestImpl ob3 = new TestImpl();
		//�ڽ��� �޼ҵ� ����
		
		if(ob1.equals(ob2)){ //Override�� �޼ҵ尡 ���ٸ� Object�� equals ��� - �ּҺ�
			System.out.println("ob1�� ob2�� ���� �ι�");
		}else{
			System.out.println("ob1�� ob2�� �ٸ� �ι�");
		}
		
		ob1.write();
		ob2.write();
		ob3.write();
		
	}

}
