package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Score ob = new ScoreImpl(); //upcast
		int ch;
		
		while (true) { //�����ϱ� ������ ��� ����
			
			do {
				System.out.print("1.�Է� \n2.��� \n3.�й��˻� \n4.�̸��˻� \n5.���������������� \n6.�й������������� \n7.����\n");
				System.out.print("-----------------------------------------------\n����:");
				ch = sc.nextInt();
			}while (ch < 1);

			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.searchHak();break;
			case 4:
				ob.searchName();break;
			case 5:
				ob.descSortTot();break;
			case 6:
				ob.ascSortHak();break;
			default:
				System.exit(0);
			}

		}
		
/*				 
		ScoreVO vo = new ScoreVO();
		vo.setHak("111");//�ʱ�ȭ�޼ҵ�
		vo.setName("�����");
		vo.setKor(60);
		vo.setEng(80);
		vo.setMat(80);
			
		System.out.println(vo.getHak());
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
*/
		
	}

}
