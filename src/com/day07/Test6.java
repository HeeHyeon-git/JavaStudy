package com.day07;

import java.io.IOException;

public class Test6 {

/*	[����1]
			System.in.read()�� ����ؼ� ���ڸ� �Է¹ް�
			�Է¹��� �������� �հ踦 ���Ͻÿ�

			����
			1.BufferedReader X
			2.Scanner X

			���
			���Է�? 10
			1-10������ ��: 55
*/
	
	public static void main(String[] args) throws IOException {
/*			
		//���1
		char ch = 0;
	    String str = "";
	    
		int sum, i , j ;
		sum = i = 0;

		System.out.print("���ڸ� �Է��ϼ���: ");
		while (true) {
			ch = (char) System.in.read();

			for (i = 0; i <= 9; i++) {
				if (ch % 48 == i) {
					str = str + ch;
				}
			}
			
			if (ch == 13) {
				break;
			}
		}
		
		j = Integer.parseInt(str);
		
		for(i=0;i<=j;i++){		
			sum = sum + i;			
		}
		System.out.printf("1���� %d������ �հ�� %d �Դϴ�.",j, sum);
*/		
		//���2
		int n=0, s=0;
		int data;
		
		System.out.print("���ڸ� �Է��ϼ���: ");//1(49)2(50)3(51)
												//System.in.read() ����ڰ� �Է��� ���ڸ� byte������ �о ������
		while((data=System.in.read())!=13){ 	
			n=n*10+data-48;						//char������ ���� ������ ��ȯ.		
		}
		
		// 1 = 0 * 10 + 49 - 48
		// 12 = 1 * 10 + 50 - 48
		// 123 = 12 * 10 + 51 - 48
		
		for(int i=1;i<=n;i++){		
			s = s + i;			
		}
		System.out.printf("1���� %d������ �հ�� %d �Դϴ�.",n,s);
		
	}

}
