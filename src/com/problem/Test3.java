/*
 	3 �� ���� ������ �Է� �ް�, ���� ū ���ڿ� ���� ���� ���ڸ� �����ؼ� ���.(if�� �̿�)
	//��) 20, 30, 40, 50 �Է½� -> ���� ū ���� 50, ���� ���� ���� 20
*/
package com.problem;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		int i, j, k, l;
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �� ���ڸ� �Է��ϼ���:"); // 60 20 30 40
		i = sc.nextInt(); // ����ȯ
		j = sc.nextInt();
		k = sc.nextInt();
		l = sc.nextInt();

		if (i >= j && i >= k && i >= l) {
			System.out.printf(" %d�� ���� ū �� �Դϴ�.\n", i);
		} else if (j >= i && j >= k && j >= l) {
			System.out.printf(" %d�� ���� ū �� �Դϴ�.\n", j);
		} else if (k >= i && k >= j && k >= l) {
			System.out.printf(" %d�� ���� ū �� �Դϴ�.\n", k);
		} else if (l >= i && l >= j && l >= k) {
			System.out.printf(" %d�� ���� ū �� �Դϴ�.\n", l);
		} else {
			System.out.printf("Ȯ�ο��");
		}

		if (i <= j && i <= k && i <= l) {
			System.out.printf(" %d�� ���� ���� �� �Դϴ�.\n", i);
		} else if (j <= i && j <= k && j <= l) {
			System.out.printf(" %d�� ���� ���� �� �Դϴ�.\n", j);
		} else if (k <= i && k <= j && k <= l) {
			System.out.printf(" %d�� ���� ���� �� �Դϴ�.\n", k);
		} else if (l <= i && l <= j && l <= k) {
			System.out.printf(" %d�� ���� ���� �� �Դϴ�.\n", l);
		} else {
			System.out.printf("Ȯ�ο��");
		}

		sc.close();
		
/*
		����if������ ���� max,min�� ����� �ۼ�
		int a,b,c,d,max=0,min=0;
		System.out.print("���� �� ���ڸ� �Է��ϼ���:");		

		a = sc.nextInt(); // ����ȯ
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		max=min=a;
		
		if(a>max)
		  max=a;
		if(b>max)
		  max=b;
		if(c>max)
		  max=c;
		if(d>max)
		  max=d;
		
		if(a<min)
		  min=a;
		if(b<min)
		  min=b;
		if(c<min)
		  min=c;
		if(d<min)
		  min=d;
		
		System.out.println("ū����:"+max+"��������:"+min);		
		
*/		

	}

}
