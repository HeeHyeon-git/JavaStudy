package com.day10;

import java.util.Calendar;
import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		//�⵵?2016
		//��?4
		//��?20
		//��ĥ ��? 100
		//������: 2016�� 4�� 20�� ������
		//100����: 2016�� 7�� 29�� ������
		Scanner sc = new Scanner(System.in);
		int y, m , d, k, w;
		char[] yoil = {'��','��','ȭ','��','��','��','��'};
		
		Calendar now = Calendar.getInstance();
		do {
			System.out.print("�⵵?");
			y = sc.nextInt();
		} while (y < 1);
		do {
			System.out.print("��?");
			m = sc.nextInt();
		} while (m < 1 || m > 12);
		do {
			System.out.print("��?");
			d = sc.nextInt();
		} while (d < 1 || d > 31);

		System.out.print("��ĥ��?");
		k = sc.nextInt();
	
		now.set(y,m-1,d);
		w = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("������: "+y + "-" + m + "-"+ d + "-" + yoil[w-1]+"����"); 

		now.add(Calendar.DATE,k);
		int yy = now.get(Calendar.YEAR);			
		int mm = now.get(Calendar.MONTH)+1;  	
		int dd = now.get(Calendar.DAY_OF_MONTH); 
		int ww = now.get(Calendar.DAY_OF_WEEK);		
		System.out.println(k +"�� ��: "+yy + "-" + mm + "-"+ dd + "-" + yoil[ww-1]+"����"); 
	}

}
