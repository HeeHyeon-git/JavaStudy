package com.day02;
import java.io.*;

class Test2 { 

	public static void main(String[] args) throws IOException {
	
		//�غ�(width)�� ����(height)�� �Է¹޾� �ﰢ���� ����(area)�� ���ϱ�

		//����
		int width, height;
		double area;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�Է�
		System.out.printf("�غ�?");
		width = Integer.parseInt(br.readLine());

		System.out.printf("����?");
		height = Integer.parseInt(br.readLine());

		//����
		//area = (double)width * (double)height / 2 ; //���� ����ȯ 
		area = width * height / 2.0 ; //�Ͻ��� ����ȯ : �ڹ� ����� �Ҽ����� ������ �Ǽ������� ����. 
		//���
		System.out.printf("����: %g", area);


	}


}
