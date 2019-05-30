package com;

import java.util.NoSuchElementException;

class Queue<T>{//��ü�� ���鶧 ������Ÿ���� ����ϵ��� T �� ����
	
	class Node<T>{//���� Ÿ���� �޴� ��� ����
		private T data;
		private Node<T> next; //������ ���
	
		public Node(T data){//�����ڸ� ���� ���κ����� ����
			this.data = data; 
		}
	}
	
	//queue�� first in first out. ���Լ�����
	
	private Node<T> head; 	//ù��°���� ���� ���� ����
	private Node<T> last;	//���������� ���� �ֽ� �Է� ���
	
	//add : last ������ �߰�
	public void add(T item){
		Node<T> t = new Node<T>(item);
		if(last != null){
			last.next = t; //��������尡 ���� ��� ������ ��忡 t�� �߰�
		}
		last = t; //��������尡 ���� ��� �Է�
		if(head == null){//ù��° ��尡 ����� ��� �翬�� ������ ��嵵 ������ �������� ����
			head = last;
		}
	}

	//remove : first ������ ����
	public T remove(){
		if(head == null){
			throw new NoSuchElementException();
		}
		T data = head.data;
		head = head.next;
		if (head == null){
			last = null; //ù��° ��忡 �����Ͱ� ���� ��� ��������忡�� ����
		}
		return data;
	}

	//peek : first ������ ��ȸ
	public T peek(){
		if(head == null){
			throw new NoSuchElementException();
		}
		return head.data;
	}
}
	
public class Test2 {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}
}



	


