package com.day02;
import java.io.IOException;

class Test4 {
	public static void main(String[] args) throws IOException {	
/*		
		boolean : ���� 
		char : ������. �⺻�� \u0000 �����ڵ�. ǥ������ 0~65535
		ASCII CODE : A -> 65 a -> 97 ����ҹ��ڷ� �ٲ���ϸ� +-32
		enter : �ΰ��� ��ɾ�� �����Ǿ����� 10(LF-Ŀ���� ��������), 13(CR-Ŀ���� ������ ������)
		char ch = 'a'; // ��������ǥ���. �� ���ڸ� ���� ����. 'abc'�� ���� �߻�. ch���� 97�̶�� �ƽ�Ű�ڵ尡 ����Ǿ�����
*/	

		//����
		char ch,result;

		//�Է�
		System.out.print("�Ѱ��� ����?");

/*
		ch = System.in.read(); �Ѱ��� ���ڸ� �о. 
		�аԵǸ� 97�̶�� �ƽ�Ű�ڵ带 �ν�. intŸ���̶� char�� ����ȵ�
		api�� Ȯ���ϸ�
		�Է� ��Ʈ���κ��� �������� ������ ����Ʈ�� �о���Դϴ�. ���� ����Ʈ��,0 ~ 255 �� ������ int �μ� �����־����ϴ�
		adsflsdflksd �̷��� �Է��ϴ��� 'a' �Ǿ��ϳ��� ���� ����
*/

		ch = (char)System.in.read(); //���������� ���� ����ȯ
		
/*		
		System.out.println(ch);
		System.out.println(Integer.toString(ch)); //String���� �ٲ㼭 �״�� �����޶�
		����ڰ� �빮�ڸ� �Է������� �ƽ�Ű�ڵ� ���� ch>=65 && ch<=90
		(char)(ch+32) ����ȯ�� ������ �ʴ´ٸ� result�� �������̹Ƿ� ���� �߻�
*/
		result = ch>=65 && ch<=90 ? (char)(ch+32) : (ch>='a'&&ch<='z' ? (char)(ch-32) : ch);
		
		System.out.println(ch + ":" + result);

	}



}
