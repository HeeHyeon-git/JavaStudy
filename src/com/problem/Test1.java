/*
 	1.������ �Է� �޾Ƽ� ¦��, Ȧ���� �����ؼ� ���.
	��) 3 �Է½� -> 3 => Ȧ��
	��) 4 �Է½� -> 4 => ¦��
*/

package com.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i;
		String ch;

		System.out.print("������ �Է��ϼ��� : ");
		i = Integer.parseInt(br.readLine());

		ch = i%2==0 ? "¦��" :"Ȧ��";

		System.out.println(i+"�� "+ch+"�Դϴ�.");

	}

}
