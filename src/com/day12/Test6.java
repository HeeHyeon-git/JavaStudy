package com.day12;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {

	private static final String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>(); //���� v�� String���� �ְڴ�. �������� �� ���ϼ�
		for(String s : city){
			v.add(s);
		}
		
		//v.add(10); int�� ������ ���� �� ����. ��ü������ String���� �ְڴ� ����
		
		String str;
		str = v.get(0); 
		System.out.println(str);
		
		str = v.firstElement(); //ù��° ������ ������ ��. second, third������ ����
		System.out.println(str);
		
		str = v.lastElement(); //������ ������ ������ ��
		System.out.println(str);
		
		for(int i=0; i<v.size();i++){ //������ ũ��:7
			System.out.print(v.get(i)+" ");
			
		}
		System.out.println();
		//----------------------------------------------
		for(String s: v){ //���͵� Ȯ�� for�� ����
			System.out.print(s + " ");
		}
		System.out.println();
		//----------------------------------------------
		
		
		//Iterator : �ݺ���
		Iterator<String> it = v.iterator(); //copy�� ����
		
		while(it.hasNext()){ //move�� ����
			
			str = it.next();
			System.out.print(str + " " );
			
		}
		
		
		
		
		
	}

}
