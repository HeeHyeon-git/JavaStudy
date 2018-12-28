package com.day11;

//Interface
//1.�߻�Ŭ������ ����(���� �ְ� ������ ����)
//2.final ��������� ���� ����
//3.�������̽��� �����ϱ� ���ؼ��� implements�� ����Ѵ�
//4.�ϳ��̻��� �������̽��� implements�� Ŭ������ �������̽��� ��� �޼ҵ带 ������ �ؾ��Ѵ�.
//5.�������̽��� �ٸ� �������̽��� ��� ������������ �̶��� extends�� ����Ѵ�.
//6.Ŭ�����ʹ� �ٸ��� �������̽��� ���� ������ �����ϴ�
//�������̽��� ����ϴ� ���� : �������� ����(�������̽��� ���´�� ������ ��������). �׷����� ���ϼ��� ���� �� �ִ�. �ڹٿ��� �������̽��� �����. 

//session : Ŭ���̾�Ʈ�� ������ �����ϸ� ����� ��. ������ ���䵵 ����. �� ����� ���� �޸𸮰���
//���ǿ� �󸶳� �޸𸮸� �Ҵ��ؾ� ���� �𸣱� ������ �ڷ����� ���� ū OBJECT 
//upcast�� ���� �Ǿ����� �˾ƾ� �ٽ� �����͸� ���� �� downcast �� �� �� ����

// ���� <---- a.jsp 
// a.jsp��� ���������� ���� �� �����ִ� �����͸� �������� �ް�
// ���� ----> b.jsp�� �ű� �� 
// �״�� object �ڷ����� ���� �뷮 ���� ŭ. �׷��� ������ downcast �� upcast �߿�

interface Fruit{	//�������̽��� �߻�Ŭ������ �ٸ� �� : �Ϲݸ޼ҵ�, �Ϲ��ν��Ͻ����� ����� �� ����. 
	
	//final����� ���� �� �ִ�. �ʱ�ȭ �� ����� ��
	//�⺻�� static����. 
	String Won = "��"; //public static final�� ����
	int getPrice(); //public abstract ����
	public String getName(); //abstract ����	
	
}


class FruitImpl implements Fruit{ //FruitImpl : Fruit�̶�� �������̽��� ������ Ŭ����. �������̽� ���� ����̵Ǹ� Fruit, �������̽���+',' ������ ���� ��
	
	@Override
	public int getPrice() {
		return 1000;
	}
	
	@Override
	public String getName() {
		return "���";
	}
	
	public String getItems(){
		return "����";		
	}
	
}

public class Test5 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		System.out.println(ob1.getItems() + ":" + ob1.getName() + ":" + ob1.getPrice() + Fruit.Won );
		Fruit ob2 = ob1; //upcast. ����ȯ�ؼ� FruitŬ������ ����
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItem()); getItem() ���ȵ�. �θ�� �ڽ��� ���� ������ �� ������
		
	}

}
