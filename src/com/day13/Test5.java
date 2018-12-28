package com.day13;
//���ʸ��� �⺻���� ���� ����. �÷����� �� ���·� �̷���� ����
class Box2<T>{
	
	private T t;//T�� �������� ����
	
	public void set(T t){
		this.t = t;
	}
	
	public T get(){
		return t; 
	}
	
	public <U> void print(U u){// �޼ҵ忡�� ���ʸ� ��밡��. U�� print �޼ҵ忡���� ��� ������ �ڷ���
		System.out.println(u);
		System.out.println("tŬ������ �ڷ���: "+ t.getClass().getName()); //.getClass().getName() � Ŭ�����ǰ��� ���������� ������ �ִ� �޼ҵ� 
		System.out.println("u�޼ҵ��� �ڷ���: "+ u.getClass().getName());
	}
}

public class Test5 {

	public static void main(String[] args) {

		Box2<Integer> b = new Box2<Integer>();
		b.set(new Integer(30)); //T�� �ʱ�ȭ. T -> Integer
		b.print("test");		//�޼ҵ��ʱ�ȭ(String). print �޼ҵ��� �Ű������� test��� ���ڿ��� ��. ��ȯ���� ���ڿ��� ��
		b.print(50);			//�޼ҵ��ʱ�ȭ(Integer). T�� Ŭ������ ����. ���� �޼ҵ��� �ڷ����� ������ �� �� ����. U�� �ڷ��� ���������� �ٲ� Integer ����
	}

}
