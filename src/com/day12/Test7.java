package com.day12;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};

	public static void main(String[] args) {
		//Generic. ���ʸ�
		Vector<String> v = new Vector<String>();
		
		String str;
		
		System.out.println("������ �ʱ� �뷮: "+ v.capacity()); //�ʱ�뷮 10.
		
		for(String c : city){ 
			v.add(c);
		}
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()){
			str = it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		//������ ����
		v.set(0, "Seoul");
		v.set(1, "Busan");		
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
	
		//-----------------------------------------
		//����
		
		v.insertElementAt("���ѹα�", 0);//�Ǿտ� ���ѹα��� �����ض�
		for(String s: v){
			System.out.print(s + " ");	
		}
		System.out.println();
		
		//-----------------------------------------
		//�˻�
		
		int index = v.indexOf("�뱸");
		if(index != -1){ //�ε��� ��ȣ�� �ִٸ� �ش� �����Ͱ� ����.
			System.out.println("�˻� ����! : " + index);
			System.out.println(v.get(index));
		}else{
			System.out.println("�˻� ����!" + index);
		}
		
		//-----------------------------------------
		//�������� ����(1~10, ��~��)

		Collections.sort(v);
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		
		//-----------------------------------------
		//�������� ����(10~1, ��~��)

		Collections.sort(v, Collections.reverseOrder()); 
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();

		//-----------------------------------------
		//����
		
		v.remove("Busan"); //v.remove(7);�� ����
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();

		//-----------------------------------------
		//�뷮 ����
		
		System.out.println("������ �ʱ� �뷮: "+ v.capacity());	
		for(int i=1; i<=20; i++){
			v.add(Integer.toString(i));			
		}
		System.out.println("������ �뷮: "+ v.capacity());	//�˾Ƽ� �뷮�� �þ.
		
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		
		//-----------------------------------------
		//Ư�� ���� ���� : v.removeRange(5,20) ������ �޼ҵ�
		for(int i=1; i<=10; i++){
			v.remove(5);
		}
	
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("Ư�� ���� ���� �� ������ �뷮: "+ v.capacity()); //�뷮�� �ڵ����� �پ���� ����. �������� �ٿ�����
		
		//-----------------------------------------
		//����� ����
		v.trimToSize(); //����� 23���� ������
		System.out.println("����� ���� �� ������ �뷮: "+ v.capacity()); 
		
		//-----------------------------------------
		//��� ������ �����
		v.clear();
		System.out.println("������ ����: "+ v.size()); //�����͸� ���� 
		System.out.println("������ �뷮: "+ v.capacity()); 	//�����Ͱ� ������� �뷮�� �ȹٲ�
		
		
	}
	
}
