package com.day17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test8 extends Frame {

	private int x,y;
	private Label lbl = new Label("",Label.CENTER);
	
	public Test8(){
		
		add(lbl,BorderLayout.SOUTH);//��� �ϴܿ� lbl�� �߰�
		
		addMouseListener(new MouseHandler());//���콺�� ���������� ����
		addMouseMotionListener(new MouseMotionHandler());
		
		setBackground(new Color(150,150,150));//���� ����
		setForeground(new Color(0,0,255));//���ڻ� ����
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("��ǥ���");
		setSize(400,400);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		String str;
		str= "(" + x +"," + y +")"; 
		g.drawString(str, x, y);//��ǥ���
	}

	@Override
	public void update(Graphics g) {//��ǥ ������ �Ű� ����
		paint(g);//�̺�Ʈ�� �߻��ϸ� paintȣ��
	}
	
	class MouseHandler extends MouseAdapter{//Ŭ��, ����Ŭ��, Ŭ���� ���� ���� event
		
		@Override
		public void mousePressed(MouseEvent evt) {

			x = evt.getX();
			y = evt.getY();
			
			repaint();//updateȣ��
			
		}
	}

	class MouseMotionHandler extends MouseMotionAdapter{

		@Override
		public void mouseDragged(MouseEvent evt) {//���콺�� ���� ���·� �����ϋ�

			x = evt.getX();
			y = evt.getY();
			repaint();
		
		}

		@Override
		public void mouseMoved(MouseEvent e) {//���콺�� ������ ��

			String str = String.format("(%d,%d)", e.getX(), e.getY());
			lbl.setText(str);
		
		}
		
	}
	
	public static void main(String[] args) {
		new Test8();
	}

}
