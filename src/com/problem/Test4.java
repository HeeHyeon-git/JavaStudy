/*
  	4. �⵵�� �Է¹ް�, �������� �ƴ����� ���.
	��) 2010 �Է½� -> 2010 => ���
    2012 �Է½� -> 2012 => ����
*/
package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {

		int i;
		String year;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ �Է��ϼ���. : ");

		i = Integer.parseInt(br.readLine());
		year = i % 4 == 0 && i % 100 == 0 || i % 400 == 0 ? "����" : "���";

		System.out.println(i + "�⵵�� " + year + "�Դϴ�.");

	}

}
