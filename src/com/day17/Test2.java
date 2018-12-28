package com.day17;

import java.awt.Color;
import java.awt.Frame;

/*
 * AWT(Abstract Window Toolkit)
 * Window�� ���� ��� ������ Frame�� ������ ����. �ݵ�� ������ �������� ��. main������ �ڵ� ���� ����	
 * ������ ���α׷��� ���� C#, MFC���� �������� AWT���� �˾Ƶθ� ����
 * C#, Windows������ �ߴ� â�� �̸��� form�̶�� �θ��� �ڹٿ����� frame.
 * Event�� �������� ������
 */

public class Test2 extends Frame{
	
	public Test2(){
		
		//Frame Ŭ������ ��� �޾� ���
		setTitle("�ڹ� ������");
		setSize(200, 300);
		setBackground(new Color(255, 255, 0));//���� �����
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Test2();
		
	}

}
