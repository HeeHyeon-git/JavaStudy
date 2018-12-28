package com.day14;

import java.util.Random;
import java.util.Scanner;

class MyThread12 extends Thread {
	
	@Override
	public void run() {
		
		for(int i=0;i<15;i++){
			System.out.print(".");
		
			try {
				sleep(200);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}

public class Test12 {

public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		MyThread12 t12 = new MyThread12();
		
		String name[] = {"������", "������", "������", "������", "������", "�迵��", 
						 "���ؿ�", "������", "������", "������", "������", "������", 
						 "������", "�ڻ���", "��â��", "�ּ�ȭ", "Ȳ����", "�ֺ���" };
		
		String presenter[];//��ǥ�� ������� ��. ��ü ������.
		int num, su, checkName;
	
		do{
			System.out.print("��ǥ�� �ο����� �Է����ּ���[1~18]:");
			num = sc.nextInt();
		}while(num<1 || num>18);
		
		presenter = new String[num];//�迭ũ�� ����
		
		su=0;
		while(su<num){
			
			checkName = rd.nextInt(18);
			presenter[su] = name[checkName];
			
			for(int i=0;i<su;i++){
				if(presenter[i].equals(presenter[su])){
					su--;
					break;
				}
			}
			su++;
			
		}
		
		System.out.print("�����");
		t12.start();
		
		try {
			
			t12.join();//main���� ������ �ʵ��� ��ٷ���.
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		System.out.println();
		System.out.println("\n***�����մϴ�! ��ǥ�� �Դϴ�***");
		System.out.println("*                             *");
	
		int k=1;
		for(String i:presenter){
			
			System.out.printf("*%6d�� ��ǥ�� : %s     *\n" ,k, i);
			k++;
			Thread.sleep(50);
		}
		
		System.out.println("*                             *");
		System.out.println("*******************************");
		sc.close();
		
	}

}
