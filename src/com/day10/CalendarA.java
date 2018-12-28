package com.day10;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarA {

	public static void main(String[] args) {

		// Calendar Ŭ������ ����ؼ� ���� �޷� �����
		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		int i, y, m, w, lastday;
		do {
			System.out.print("�⵵?");
			y = sc.nextInt();
		} while (y < 1);

		do {
			System.out.print("��?");
			m = sc.nextInt();
		} while (m < 1 || m > 12);

		now.set(y, m - 1, 1);

		w = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DATE);

		// ���
		System.out.println(y + "�� " + m + "��");
		System.out.println("\n  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("------------------------------");

		for (i = 1; i < w; i++) {
			System.out.print("    ");
		}

		for (i = 1; i <= lastday; i++) {
			System.out.printf("%4d", i);
			w++;
			if (w % 7 == 1) {
				System.out.println();
			}
		}

		if (w % 7 != 1) {
			System.out.println();
		}

		System.out.println("------------------------------");
	}
}
