package com.day07;

import java.util.Scanner;

import com.score1.Manage;

class Record {

	String name;
	String[] level = new String[3];
	int[] score = new int[3];
	int tot, ave;

}

class Score {

	int inwon;
	Record[] rec;
	Scanner sc = new Scanner(System.in);
	String[] title = { "����", "����", "����" };
	
	public void set() {

		do {
			System.out.print("�ο���?");
			inwon = sc.nextInt();
		} while (inwon < 1 || inwon > 10);
		rec = new Record[inwon];

	}

	public void input() {


		for (int i = 0; i < inwon; i++) {

			rec[i] = new Record();
			System.out.print("�̸�?");// �̸�
			rec[i].name = sc.next();

			for (int j = 0; j < 3; j++) {

				System.out.print(title[j]);
				rec[i].score[j] = sc.nextInt();// ������
				rec[i].tot += rec[i].score[j];// ����
			}

			rec[i].ave = rec[i].tot / 3;// ���

		}

	}

	public void print() {

		for (int i = 0; i < inwon; i++) {
			System.out.printf("%d��° �̸� %6s", i+1, rec[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%s:%d%s  ", title[j],  rec[i].score[j],rec[i].level[j]);
			}
			System.out.printf("����:%d  ", rec[i].tot);
			System.out.printf("���:%d  ", rec[i].ave);
			System.out.println();
		}

	}

	public void pan() {

		for (int i = 0; i < inwon; i++) {
			
			for (int j = 0; j < 3; j++) {
				if (rec[i].score[j] == 100 || rec[i].score[j] >= 90) {
					rec[i].level[j] = "(��)";
				} else if (rec[i].score[j] >= 80) {
					rec[i].level[j] = "(��)";
				} else if (rec[i].score[j] >= 70) {
					rec[i].level[j] = "(��)";
				} else if (rec[i].score[j] >= 60) {
					rec[i].level[j] = "(��)";
				} else {
					rec[i].level[j] = "(��)";
				}

			}

		}

	}
}

public class Test7 {

	public static void main(String[] args) {
		/*
		 * [����2] �ο����� �Է� �޾� �ο�����ŭ ���� ������ �Է��ϰ� �� ���� ������ �Ͻÿ� 
		 * �ο��� : 2 
		 * 1��° �̸� :������ ���� ? : 100 ���� ? : 100 ���� ? : 100
		 * 
		 * 2��° �̸� :������ ���� ? : 80 ���� ? : 80 ���� ? : 80
		 * 
		 * ������ 100(��) 100(��) 100(��) 300 100
		 * 
		 * ������ 80(��) 80(��) 80(��) 240 80
		 */
		
		Score ob1 = new Score();		
		ob1.set();
		ob1.input();
		ob1.pan();
		ob1.print();

	}
	
	

}
