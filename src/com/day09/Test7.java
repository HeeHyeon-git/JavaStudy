package com.day09;

public class Test7 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("����");
		sb.append("�λ�");
		sb.append("�뱸");
		
		System.out.println(sb);
		String str = sb.toString(); //object.toString�� override�� ��. ����� ����. 
		System.out.println(str); //StringBuffer�� StringBuilder���� �̷��� ���� �� ������ָ� ��
		
		//Integer(int�� ������ �ڷ���) double�� �����ڷ����� Double
		//int a = 10; //�Ϲ��ڷ���
		//Integer b = new Integer(10); //�ڷ����� ������ �ڷ��� 8������. (String�� class�̹Ƿ� ����)
		
		int a = 24;
		System.out.println(a); //���� 10
		System.out.println(Integer.toString(a)); //���� 10
		System.out.println(Integer.toString(a,2)); //2����
		System.out.println(Integer.toString(a,8)); //8����
		System.out.println(Integer.toString(a,16)); //16����
		
		
		
	}

}
