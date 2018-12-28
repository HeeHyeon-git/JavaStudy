package com.day12;

import java.util.Iterator;
import java.util.Vector;

//Collections Framework(�����) : �����͸� �����ϴ� �����
//������ ������ �پ�. �Ʒ� �ΰ��� ���� ��ǥ��. 
//���� �������̽�. 
//List(Vector, ArrayList) - ArrayList : ����ȭ��������. �׷��� �ӵ� �� ����
//Map(HashSet, HashTable, TreeSet)
//Collections�� ó������ � ������ ���Ǿ��ص���. 10�� �������

//�������̽��� ��ü�� ������ �� ����. �������̽��� �����ؼ� ����ϴ� ���� ��.

//List(I)
public class Test5 {

	public static void main(String[] args) {

		Vector v =new Vector(); //Collections Framework(���� ����)�� ������ Ÿ���� Object. 
		
		v.add("����"); 		//String -> Object Upcast
		v.add(30);			//int -> Object Upcast
		v.add('c'); 		//char -> Object Upcast
		
		//��� �ڷ��� add�� ������. -> Vector�� ������ Ÿ���� Object
		
		String str;
		Integer i;
		char c;
		
		str = (String) v.get(0); //Downcast Object�� String���� ����ȯ���Ѽ� str�� �Ҵ�. ���͵� 0~ �ε��� �ϷĹ�ȣ�� �����
		System.out.println(str);
		i = (Integer) v.get(1);  //Downcast
		System.out.println(i);
		c = (char)v.get(2);	     //Downcast
		System.out.println(c);
		
		Iterator it = v.iterator();
		
		while(it.hasNext()){ //� �ڷ����� ������ �𸣴ϱ� downcast�ϴ� �ݺ��� �ۼ�
		//�׷��� Collections ���� � �ڷ������� �����ִ� ����.
		//eof, bof�� �������� �����Ͱ� �ִ��� Ȯ��
			
			Object o = it.next();
			
			if(o instanceof String){
				str = (String)o;
				System.out.println();
			}else if(o instanceof Integer){
				i = (Integer)o;
				System.out.println(i);
			}else if(o instanceof Character){
				c = (char)o;
				System.out.println(c);
			}
			
		}
	}

}
