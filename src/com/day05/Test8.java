package com.day05;

import java.util.Random;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		// 1~3������ ������ �߻����� ����,����,�� ���� ���α׷� �ۼ�
		// 1:����, 2:����, 3:��

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int me, com;
		String game[] = { "����", "����", "��" };

		com = rd.nextInt(3) + 1;
		
		do{
			System.out.print("1:����, 2:����, 3:�� �Դϴ�. ���ڸ� �Է��ϼ���. : ");
			me = sc.nextInt();
		}while(me<1||me>3);
		
		System.out.println("��ǻ��: " + game[com - 1] + ", ���: " + game[me - 1]);

		if (me == com) {
			System.out.println("�����ϴ�.");
		} else if ((me == 1 && com == 3) || (me == 2 && com == 1)|| (me == 3 && com == 2)) {
			System.out.println("����� �̰���ϴ�.");
		} else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}
/*		
 		//���������� ���� ����
		if (me == com) {
			System.out.println("�����ϴ�.");
		}else if((me+2)%3==com){
			System.out.println("����� �̰���ϴ�.");
		}else{
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}
*/
		
		sc.close();
	}
}
