package com.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class TestTest {

	public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	
	double i, exp;
	System.out.print("��.���Է��غ�!");
	
	i = Integer.parseInt(br.readLine());

	exp = i * i;

	System.out.printf("������ %g�Դϴ�.\n\n\n", exp);

	}
}