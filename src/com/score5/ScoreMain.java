package com.score5;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		ScoreImpl ob = new ScoreImpl(); 
		
		int ch;
		
		while (true) { 
			
			do {
				System.out.println("**����**");
				System.out.print("1.�Է�\t 2.���\t 3.����\n");
				System.out.print("-----------------------------------------------\n����:");
				ch = sc.nextInt();
				
			}while (ch < 1);

			switch (ch) {
			case 1:
				ob.input();break;
			case 2:
				ob.print();break;
			case 3:
				ob.writeFile();
			default:
				System.exit(0);
			}

		}
	}

}
