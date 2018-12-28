package com.day10;

public class Test1 {

	public static void main(String[] args) {
		
		String s1 = "����,�λ�,�뱸";
		String ss[] = s1.split(","); //split�޼ҵ� : ,�� �������� ������ �߶� ss�迭�� �����ض�
	
		for(String s:ss){
			System.out.print(s + " ");
		}
		
		String s2 = "seoul";
		String s3 = "Seoul"; //s2 s3�� �ּҴ� ������. ����ҹ��� ����.
		
		System.out.println(s2.equals(s3)); //false 
		System.out.println(s2.equalsIgnoreCase(s3)); //true
		//equalsIgnoreCase�޼ҵ� : ��ҹ��� �������� �ʰ� ���븸 ��
		
		String s4 = "abc.def.hij";
		//index      01234567890
		
		System.out.println(s4.indexOf(".")); 		// 3 : "."�� ������ index���� ��ȯ�� 
		System.out.println(s4.lastIndexOf(".")); 	// 7 : "."�� ������ ������ index���� ��ȯ��
		System.out.println(s4.indexOf("deff"));		// -1 : �ش��ϴ� ���� �����Ƿ� -1 ��ȯ. def �Է½� ���� ù��° �ε����� 4 ��ȯ 
		System.out.println(s4.indexOf("x"));		//a != -1 �̸� �ݺ������� ������ ���� �̿�
		
		String s5 = "�츮���� ���ѹα� �������� ���ѹα�";
		//String s6 = s5.replaceAll(regex, replacement); regex: ����ȭǥ����. '//s' ����� ���� Ư����ȣ
		String s6 = s5.replaceAll("����", "����"); //replace�� ���ڸ� ����. replaceAll�� ����ȭǥ���ĵ� ��밡��
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim()); 					//�ǿ��ʰ� �ǿ������� ���� ����
		System.out.println(s7.replaceAll(" ", "")); 	//������ null�� �ٲ��
		System.out.println(s7.replaceAll("\\s", ""));	//������ null�� �ٲ��
														//web������ enter�� �νĸ���. <br>�� �ۼ�. �̶� replace�޼ҵ� ���� ����.
		
		char ch = "abcdefg".charAt(2); //string������ ������ �ʾ����� String������ 2���� �ִ� �Ѱ��� ���ڸ� �����ض�
		//idx      0123456
		System.out.println(ch); //c
		System.out.println("abcdefg".startsWith("abc")); //true. String�� "abc"�� �����ϴ���. ajax�� ���þ� �� ����. ���� �����˻���
		System.out.println("abcdefg".startsWith("abd")); //false.
		System.out.println("abcdefg".length()); //7
		
		//������ �迭 ����.(ASCII���� ��) �����ټ����� 
		String s8 = "abcdefg";
		String s9 = "abcefgh";
		
		System.out.println(s8.compareTo(s9)); //-1
		System.out.println(s9.compareTo(s8)); //1
	
	
		
		
	}
}
