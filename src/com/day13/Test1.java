package com.day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

	public static void main(String[] args) {

		List<String> lists = new ArrayList<String>();
		
		lists.add("����");
		lists.add("�λ�");
		lists.add("�뱸");
		
		Iterator<String> it = lists.iterator();
		while(it.hasNext()){
			String str= it.next();
			System.out.print(str+" ");
		}
		System.out.println();
		

		ListIterator<String> it2 = lists.listIterator();
		while(it2.hasNext()){
			System.out.print(it2.next() + " "); //���� �ҽ������� �ϳ��� ǥ�� ����
		}
		System.out.println();
		
		//��� 2�� �����ϴ��� ���� ����. ����� �����ʹ� NULL
		while(it2.hasNext()){
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		
		//ListIterator<String> it3 = lists.listIterator();
		//�������� ���. hasPrevious ���
		while(it2.hasPrevious()){
			System.out.println(it2.previous());
		}
		
		List<String> lists1 = new ArrayList<String>();
		lists1.addAll(lists); //collection�� add �� �� ����
		lists1.add("��õ");	//�������� �߰� 
		int n = lists1.indexOf("�λ�");//1
		lists1.add(n+1, "����");//�λ��� �ε���+1 ��ġ�� ���ָ� ����		
		
		for(String c : lists1){//Ȯ��for������ ���
			System.out.print(c + " ");
		}
		
		List<String> lists2 = new ArrayList<String>();
		lists2.add("�ڹ����α׷���");
		lists2.add("�����ӿ�ũ");
		lists2.add("��Ʈ����");
		lists2.add("����");
		lists2.add("������");
		
		String str;
		Iterator<String> it4 = lists2.iterator();
		
		while(it4.hasNext()){
			str = it4.next();
			if(str.startsWith("��")){ //����Ʈ���� �����ϴ´ܾ ������ ���� ã����� �޼ҵ�
				System.out.println(str);
			}
		}
	}
}
