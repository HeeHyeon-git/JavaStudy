package com.day05;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {
		// 1~10������ ������ �߻����� �߻���Ų ������ 3���ȿ� �˾� ���ߴ� ����
		// (3���ȿ� �˾Ƹ����� ���ϸ� �߻��� ������ ���)
		int i, j, k;
		char play;

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		do {
			i = rd.nextInt(10) + 1;
			for (j = 1; j <= 3; j++) {
				System.out.printf("1~10�߿� ������ �Է��ϼ���. [%d��° ��ȸ] :", j);
				k = sc.nextInt();
				if (k == i) {
					System.out.printf("������ %d. �����Դϴ�!\n",i);
					break;
				} else {
					System.out.printf("�����Դϴ�!\n");
				}
			}
			System.out.printf("������ %d �Դϴ�. ", i);
			System.out.println("����ҷ�?[Y/N]");
			play = (char) System.in.read();

		} while (play == 'y' || play == 'Y');
		sc.close();
		
	}//end main
}//end class
