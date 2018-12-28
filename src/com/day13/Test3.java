package com.day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {

		//Set : �ߺ��� ������� �ʴ´�.
		//Set�̶�� �������̽��� ������ HashSet Ŭ����
		Set<String> s = new HashSet<String>(); 
		
		s.add("����");
		s.add("�λ�");
		s.add("�뱸");
		
		System.out.println(s);
		Iterator<String> it = s.iterator();
		
		while(it.hasNext()){
			String str= it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		//�ߺ�������
		s.add("����"); //�ߺ����� �߰��ص� �������.
		System.out.println(s); 	
		
		System.out.println("---------------------------");
		
		
		//Stack
		System.out.print("����: ");
		Stack<String> st = new Stack<String>();
		
		//�Է½� push, add �޼ҵ� ����. push�� �� ���� ���. ���ÿ��� �� �޼ҵ���� move�� ����
		st.push("����");
		st.add("�λ�");
		st.push("�뱸");
		st.push("����");
		
		//���۰� ���� ������������ for, ���� �𸦶� while, �ѹ��� ������ �����ؾߵǸ� Do~while
		while(!st.empty()){ //stack�� ������������� �ݺ� ����.(������ �����ض�
			System.out.print(st.pop()+ " "); //stack�� �����͸� ������ �Ǹ� ������
		}
		
		
		//����� �����ʹ� ������
		while(!st.empty()){
			System.out.print(st.pop()+ " ");
		}
		
		System.out.println("\n------------------------------");
		
		//Queue 
		Queue<String> q = new LinkedList<String>();
		q.add("����");
		q.offer("�λ�");
		q.offer("�뱸");
		q.offer("����");
		
		System.out.print("Queue : ");
		while(q.peek()!=null){
			System.out.print(q.poll() + " ");
		}
		System.out.println("\n------------------------------");
		
		List<String> list1 = new LinkedList<String>();
		
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		list1.add("F");
		list1.add("G");
		list1.add("H");
			
		List<String> list2 = new LinkedList<String>();
		
		list2.add("����");
		list2.add("�λ�");
		list2.add("�뱸");
		
		list2.addAll(list1); //�÷��Ǿȿ� �÷����� ���� ���� �� �ִ�.
		
		System.out.print("LinkedList : ");
		for(String ss:list1){
			System.out.print(ss + " ");	
		}
		System.out.println();
		
		System.out.print("�÷��ǿ� �÷����� ���� LinkedList : ");
		for(String ss:list2){
			System.out.print(ss + " ");	
		}		
		System.out.println("\n------------------------------");
		
		//��������
		list2.subList(2, 5).clear();
		for(String ss:list2){
			System.out.print(ss + " ");	
		}
		System.out.println("\n------------------------------");
		
		String[] str = {"��","��","��","��","��","��"};
		System.out.print("�����迭: ");
		for(String ss : str){
			System.out.print(ss + " ");
		}
		System.out.println();
		
		//�迭 ����
		Arrays.sort(str);
		System.out.print("���ĵ� �迭: ");
		for(String ss : str){
			System.out.print(ss + " ");
		}
		System.out.println();
		
	}

}


/* 

�������� �����ʹ� ����Ʈ, key�� value�� �����ؾ��� ������ map ���

[List] 
����ȭ�� �����ϳĿ� ���� �ӵ����̰� ���̳�. ArrayList : ����ȭ��������. �׷��� �ӵ� �� ����
List<������ �ڷ���> lists = new ArrayList<������ �ڷ���>();
List<������ �ڷ���> lists = new Vector<������ �ڷ���>();

ArrayList<������ �ڷ���> lists = new ArrayList<������ �ڷ���>();
Vector<������ �ڷ���> lists = new Vector<������ �ڷ���>();

**�޼ҵ�
add : �߰�
size : ��Ұ���
remove(index) : ����
clear : ��ü������ ����
trimtoSize : ����� ����

Iterator<����� �ڷ���> it = lists.iterator();
while(it.hasNext()){
	������ڷ��� value = it.next();
}

--------------------------------------------------------------------------------------------
[Map]

hashmap�� hashtable�� �ӵ����̰� ���� ���� ����
Map<Ű�ڷ���, �������ڷ���> map = new HashMap<Ű�ڷ���, �������ڷ���>();
Map<Ű�ڷ���, �������ڷ���> map = new Hashtable<Ű�ڷ���, �������ڷ���>();

HashMap<Ű�ڷ���, �������ڷ���> map = new HashMap<Ű�ڷ���, �������ڷ���>();
Hashtable<Ű�ڷ���, �������ڷ���> map = new Hashtable<Ű�ڷ���, �������ڷ���>();

put(key,value) : �߰�
remove : ����
clear : ��ü����

Iterator<����� �ڷ���> it = map.keySet().iterator();
while(it.hasNext()){
	Ű�ڷ��� key = it.next();
	������ڷ��� value = map.get(key);
}

*/