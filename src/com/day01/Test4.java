package com.day01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.io.*;

/*
	import�� C������ #include�� ����.
	C:\Program Files\Java\jdk1.8.0_191\src.zip\java package ��ġ�� �˷���� �ؼ� import�ϴ� �Ŷ�� ����!
	import java.io.* - io��Ű���� �ִ°� ��� ������. �޸𸮳���. �ǵ����̸� �ϳ��� �����ִ°� ����
	io�� input�� output�� ���õ� ��Ű��
	��Ŭ���� ����� �� �˾Ƽ� ���� import ������. ���� �ܿ� �ʿ�� ����
*/

class Test4 {
	public static void main(String[] args) throws IOException {
/*	
	������ �������� ����.
	throws Ű����� ����ð��� ���ܰ� �߻����� ���, �ش� ���ܸ� ����ó������ �ʰ� �ٸ� ������ ó���ϵ��� ���ܸ� �����ڴ�
*/

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
/*	
	BufferedReader �� class. 
	System.in : Ű����� �Է��� 1���� ���� ����.
	InputStreamReader : System.in�� ���ؼ� ���� ���ڸ� 2byte�� �����Ŵ. 10�� '1'�� '0'�� �ƴ϶� '10'���� �ν��ϰ� ����
	���ʿ��� ���� �����͸� �ٸ������� �Ѱ��ִ� ������ �ϴ°� �긴��Ŭ����
	BufferedReader : ���۷� �Է� �޾� ó���ӵ��� ����

	 -> ���� �� �������� �����ٸ� ������ Ŭ������ �����س��� ��밡��. �̹� api�� ��ϵǾ� �ִ�.	
	API : ��뼳�� ����. ���� Ŭ������ �޼ҵ带 �����س���. 
	��ũ : https://docs.oracle.com/javase/8/docs/api/
	
	java > javalang > �� ��Ű���ȿ� String, System ����. ���󵵰� ���� �͵��� �޸𸮿� ������ �÷����� 
	�Ź� import ��Ű���ʾƵ� �ٷ� ����� �� �ֵ���!
*/

	int r;
	double area, length;

	System.out.println("������?"); //�ٹٲ� prinfln. print�� �ٹٲ޾���. 
	r = Integer.parseInt(br.readLine()); 
/*	
	����ڰ� �Է��ϴ� ���� �о���� ��ɾ�. ���ڷ� ������. br.readLine();
	enter�� �ƽ�Ű���̹Ƿ� br�� ����ִ� '10'�� enter���� �����´�
	�̰� ���������� ��ȯ�ϱ� ���� ����ϴ� �� Integer.parseInt();
	Ŭ�����ȿ� ���� method ����. BufferedReader�� method �� �ϳ��� readLine �� ��.
*/
	area = r * r * 3.14f;  //�ڹٴ� �Ǽ����� �Է��ϸ� double�� ������ ��. ������ area�� double�� �����س��� ���� �Ȼ���
	length = r * 2 * 3.14;
	
	System.out.printf("������: %d, ����: %g, �ѷ�: %g\n", 
		r, area, length);	//�ٹٲ��� ',' �� '+' �ڿ��� �ؾ� �̾ �νĵ�

	}

}
