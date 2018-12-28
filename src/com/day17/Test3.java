package com.day17;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// WindowListener �������̽�. ���������� ���� ��� �̺�Ʈ ����. 
// ����: ������� �ʴ� �޼ҵ�鵵 ��� �������̵� �ؾ���
public class Test3 extends Frame implements WindowListener{
	
	public Test3(){
		
		setTitle("������");
		setSize(200,300);
		setBackground(new Color(242,0,36));
		addWindowListener(this);//Listener. event�� �߻��ϴ��� ���Ѻ��� ����. Test3 �ڱ��ڽſ��� �̺�Ʈ�� �˷��� �ϹǷ� this.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test3();
	}

	@Override
	public void windowActivated(WindowEvent e) {//â Ȱ��ȭ
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {//�����ư Ŭ����
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {//ȭ���� �ΰ��̻��� �� ��Ȱ��ȭ
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//�������� Ŀ������
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {//â�� ó�� ���� ��
	}

	
}
