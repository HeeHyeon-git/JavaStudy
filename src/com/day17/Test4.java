package com.day17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//WindowAdapter Ŭ������ Ȱ���� �̺�Ʈ �ν�
//1. ���ο� Ŭ������ ���� ��ӹ��� �� ��� ����
//2. �͸��� ����Ŭ������ �����ؼ� ����ص� ��

public class Test4 extends Frame{

	public Test4(){
		
		setTitle("����������");
		setSize(500,500);
		//addWindowListener(new MyWindowAdapter());//Ŭ������ ������. ��ü ���� �� �ٷ� ���. �̸� �ʿ����
		
		//�͸��� ����Ŭ������ ���� �ٷ� �������̵� �ص� ��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//������ �����ӿ��� �νĵǴ� �̺�Ʈ�� 7~10�� ���� ����
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test4();
	}
	
/*
	class MyWindowAdapter extends WindowAdapter {//����Ŭ����. (������ ����� �̷��� ��)

		//WindowAdapter�� ��ӹ޾� ����ϸ� ���� �����ϴ� �޼ҵ带 ������ ������ �ʿ� ����
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	
	}
*/	
	
}
