/*
 5.�ܰ� 15,800��¥�� ��ǰ�� ���� ���� �̻� ���Խ� ������ ���ݴϴ�.
 �������� ������ �����ϴ�.
 10�� �̻� -> 10%
 20�� �̻� -> 15%
 30�� �̻� -> 20%
 �Ǹűݾ��� ����غ��ϴ�.
 ��) ���Լ��� 15���� ��� -> ���Լ���: 15��, �Ǹ��ѱݾ�: 213300��
 */
package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {

		int price = 15800;
		int i;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�ܰ��� 15800���Դϴ�. ������ �Է��ϼ���. : ");
		i = Integer.parseInt(br.readLine());

		if (i >= 30) {
			System.out.printf("���Լ���: %d��, �Ǹ��ѱݾ�: %d��, ���αݾ�: %d��.\n", i,
					(int) (0.8 * price * i), (int) (0.2 * price * i));
		} else if (i >= 20) {
			System.out.printf("���Լ���: %d��, �Ǹ��ѱݾ�: %d��, ���αݾ�: %d��.\n", i,
					(int) (0.85 * price * i), (int) (0.15 * price * i));
		} else if (i >= 10) {
			System.out.printf("���Լ���: %d��, �Ǹ��ѱݾ�: %d��, ���αݾ�: %d��.\n", i,
					(int) (0.9 * price * i), (int) (0.1 * price * i));
		} else {
			System.out.printf("���Լ���: %d��, �Ǹ��ѱݾ�: %d��, ���αݾ� �����ϴ�.\n", i,
					(price * i));
		}

/*
		double sum = 0;
		int qty = 15800;
				 
 		if (i >= 30) {
			sum = i*qty*0.8;
		} else if (i >= 20) {
			sum = i*qty*0.85;
		} else if (i >= 10) {
			sum = i*qty*0.9;
		} else { 
			sum = i*qty;
		}
 		System.out.printf("���Լ���: %d��, �Ǹ��ѱݾ�: %g��, ���αݾ� %g�Դϴ�.\n", i, sum,((i*qty)-sum));
*/ 		

		
		
		
	}

}
