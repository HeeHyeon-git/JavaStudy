package com.day06;

import java.util.Random;
import java.util.Scanner;

class Game{

	int me, com;
	String game[] = { "����", "����", "��" };
		
	public int rd(){
		
		Random rd = new Random();
		com = rd.nextInt(3)+1;	
		return com;
	
	}
	
	public int input(){
		
		Scanner sc = new Scanner(System.in);	
		do{
		
			System.out.print("1:����, 2:����, 3:�� �Դϴ�. ���ڸ� �Է��ϼ���. : ");
			me = sc.nextInt();
		
		}while(me<1||me>3);	
		
		return me;
	
	}
		
	public void output(int com, int me){
	
		System.out.println("��ǻ��: " + game[com-1] + ", ���: " + game[me-1]);
		if (me == com) {
			System.out.println("�����ϴ�.");
		} else if ((me == 1 && com == 3) || (me == 2 && com == 1)|| (me == 3 && com == 2)) {
			System.out.println("����� �̰���ϴ�.");
		} else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}

	}
		
}

public class Test9 {

	public static void main(String[] args) {
		// 1~3������ ������ �߻����� ����,����,�� ���� ���α׷� �ۼ�
		// 1:����, 2:����, 3:��
		
		Game g = new Game();
		int computer = g.rd();
		int user = g.input();
		g.output(computer, user);
	
	}
}
