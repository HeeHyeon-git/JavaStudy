package com.day06;

import java.util.Scanner;

public class Rect {

	int w,h; //instance����. Ŭ���� �� ��𼭳� ��� ������ ��������
	
	//�Ű������� ���ÿ� ������ ��������
	public void input() {
		Scanner sc = new Scanner(System.in); // Scanner��ü����. �Ű������� �ݵ�� �ʿ���. apiȮ��!!
		
		//�Է�
		System.out.print("����?");//10
		w = sc.nextInt();		
		System.out.print("����?");//10
		h = sc.nextInt();	
		//return; void��� �����س��⶧���� return �ۼ����ص���
	}
	
	public int area(){//return���� ������
	
		int result;//��������. �ٸ� �޼ҵ忡�� �ν��� �� ����
		result = w*h;
		return result;
	
	}
	
	public int length(){//return���� ������
	
		return 2*(w+h); //���������� ���� ��ȯ�ص� ������, �̷��� return���� �ٷ� ������� �־ ������ ����
	
	}
	
	public void print(int a, int l){ //��ȯ������, �Ű����� 2�� �ʿ�, �޼ҵ带 �����ϰ� ����-����Ʈ�۾�.
		
		System.out.println("����: "+w);
		System.out.println("����: "+h);
		System.out.println("����: "+ a);
		System.out.println("�ѷ�: "+ l);
		
	}	
}//endclass
