package com.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test5 {
	//Ŭ������ �⺻������ ���������ڰ� public - ������ ���� ����

	public static void main(String[] args) throws IOException {
		

		//�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String name;
		int kor, eng, mat, tot;
		

		//�Էº�
		System.out.print("�̸�?"); //����ڰ� �Է�. ����
		name = br.readLine();  // �ι�°�ܾ�� �빮��!! readLine
		// String���� �Է��� �ް� ��ȯ���� String �̾ ��������. 
		
		System.out.print("����?"); //50
		kor = Integer.parseInt(br.readLine());

		System.out.print("����?"); //50
		eng = Integer.parseInt(br.readLine());

		System.out.print("����?"); //50
		mat = Integer.parseInt(br.readLine());
		
		//�����
		tot = kor + eng + mat;
		
		//��º�
		System.out.printf("�̸�:%s, ����:%d, ����: %d, ����: %d, ������ %d�Դϴ�.\n",name, kor, eng, mat, tot); // string - '%s' ������ printf�� �����! 
	
	
	// �׻� ������ ����- ���� �Է� - ���� - ��� ����� �����
	}
}
