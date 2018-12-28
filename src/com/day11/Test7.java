package com.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

interface FruitA{
	String Won = "��"; //�տ� public static final ����
	public int getPrice();
	public String getName();
}

interface ItemFruit extends FruitA{ //�������̽��� �������̽��� ��ӹ��� �� �ִ�.
	public String getItems();	
}

class Orange implements ItemFruit{ //�������̵� 3�� �ؾ� ��. ItemFruit, FruitA �������̽��� �޼ҵ��.

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public String getName() {
		return "������";
	}

	@Override
	public String getItems() {
		return "����";
	}

}

class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "���";
	}

	@Override
	public String getItems() {
		return "����";
	}
		
}

public class Test7 {
	
	public void packing(ItemFruit ob){
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Test7 t = new Test7();
		System.out.print("1.������ 2.��� : "); // 1 or 2 �Է�
		int ch = sc.nextInt();
		
		if(ch==1){
			t.packing(new Orange()); //������Ŭ���� ��ü�� �����ؼ� �Ű������� ���
		}else if(ch==2){
			t.packing(new Apple());
		}
		
		//new �� �Ű������� ���� �� �̹� ���� ���� 
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
/*		
 * �������̽� ����
  		ItemFruit ob; 
		ob = new Orange();
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);

		ob = new Apple();
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
*/
		
/*
 * �ڷ��� ����
		int a;
		a = 10;
		System.out.println(a);
		
		int a;
		a = 20;
		System.out.println(b);	
		
*/
	
	}
}
