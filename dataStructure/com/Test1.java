package com;

import java.util.EmptyStackException;

class Stack<T>{
	class Node<T>{ //���� Ÿ���� �޴� ��� ����
		private T data;
		private Node<T> next;
		public Node(T data){ //�����ڸ� ���� ���κ����� ����
			this.data = data;
		}
	}
	
	private Node<T> top;//������
	
	public T pop(){//������ �ִ� �����͸� ��ȯ�ϴ� �޼ҵ�
		if (top == null){
			throw new EmptyStackException();
		}
		T item = top.data; //�������ִ� �����͸� ��ȯ�ϱ����� �״��� �����͸� top���� �Ű���
		top = top.next;
		return item;
	}
	
	public void push(T item){//�������Է�
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}
	
	public T peek(){//������ �ִ� �����͸� ��ȯ�ϴ� �޼ҵ�. �� �����Ͱ� ������� ����
		if (top == null){
			throw new EmptyStackException();
		}
		return top.data;
	}
}

public class Test1 {
	public static void main(String[] args){
	Stack<Integer> st = new Stack<Integer>();
	st.push(1);
	st.push(2);
	st.push(3);
	st.push(4);
	System.out.println(st.pop());
	System.out.println(st.pop());
	System.out.println(st.peek());
	System.out.println(st.pop());
	System.out.println(st.peek());
	System.out.println(st.pop());
	System.out.println(st.pop());

	}
}