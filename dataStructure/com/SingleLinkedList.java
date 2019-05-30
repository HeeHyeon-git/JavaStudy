package com;

public class SingleLinkedList {
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retieve();
		ll.delete(2);
		ll.retieve();
	}
}

//�ܹ��� LinkedList �����
class LinkedList{
	Node header;
	static class Node{
		int data;
		Node next = null;
	}
	LinkedList(){
		header = new Node();
	}

	//������ �߰�
	void append(int d){
		Node end = new Node();
		end.data = d; 			//������
		Node n = header;
		while(n.next!=null){ 	//������ ��尡 �ƴҶ����� �ݺ�
			n=n.next;
		}
		n.next = end;			//������ ���� ������ �߰�
	}
	//������ ����
	void delete(int d){
		Node n = header; 				//������
		while(n.next != null){ 			//������ ��尡 �ƴҶ����� �ݺ�
			if(n.next.data == d){
				n.next = n.next.next; 	//�����͸� �ٴ��� ���� ����, ������ �ٲ����
			}else{
				n = n.next;
			}
		}
	}
	//��ü ��带 ���
	void retieve(){
		Node n = header.next;//����� ������ �����ͺ��� ���
		while(n.next!=null){
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}


