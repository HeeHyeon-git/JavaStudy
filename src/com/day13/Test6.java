package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//Exception Ŭ���� (����ó��)

//�ڵ��󿡴� ������ ���� �� �����ϴٰ� ������ �߻��ϴ� ���� Runtime Error
//���� �Է��ؾߵǴµ� ���� �Է� or ������ �߸� �Է�

public class Test6 {

	public static void main(String[] args) {

		int a, b, result;
		String oper;

		// Scanner sc= new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// try{}���� ������ �߻��ϰ� �Ǹ� catch �� ��Ƴ�.
		// Exception�� ����ó���� ����� �Ű����� e �� �Ҵ�
		// ���� ����ڿ����� �߻���Ű�� ��쵵 ����

		try {

			System.out.print("ù��° ��? ");
			// a = sc.nextInt();
			// b = sc.nextInt();
			a = Integer.parseInt(br.readLine());
			System.out.print("ù��° ��? ");
			b = Integer.parseInt(br.readLine());

			System.out.print("������? ");
			// oper = sc.next();

			oper = br.readLine();

			result = 0;

			if (oper.equals("+"))
				result = a + b;
			else if (oper.equals("-"))
				result = a - b;
			else if (oper.equals("/"))
				result = a / b;
			else if (oper.equals("*"))
				result = a * b;

			System.out.printf("%d %s %d  = %d \n", a, oper, b, result);

		} catch (NumberFormatException e) {
			System.out.println("������ �Է��ض�!");

		} catch (ArithmeticException e) {
			System.out.println("0���� ������ �ȵ�!");

		} catch (Exception e) {
			System.out.println("���ڰ� �ƴϾ�!");
			// System.out.println(e.toString());
			e.printStackTrace();// ���� �ߴ� ���� ȭ��. default���µ� try catch ����� ��
		} finally {//�����߻��� �ش��ϴ� �����κ��� catch���� ����ǰ� finally�� �׻� ����.
			System.out.println("�� �׻� ���δ�");
		}
		System.out.println("����� try��...");

	}

}
