package com.day02;
import java.util.Scanner;

class Test7 {

	public static void main(String[] args) {

		//�ܶ������� ������ ����� �з�
		//����Ʈ �ܶ��� ����

		Scanner sc = new Scanner(System.in); //sc��ü ����. ������ �� �� sc.close(); �ۼ������ ��

		String name;
		int kor, eng, mat;

		//suzi 40 60 70 - �������� ������ �����ؼ� �Է�
		//System.out.print("�̸� ���� ���� ����?");
		//����� �ϳ��� �������� ������ �ڵ����� �ν��ϴ°� Scanner�� Ư�� - �� ���� �Ѳ����� �Է��� �� �ִ�.

		//suzi,40,60,70 
		System.out.print("�̸� ���� ���� ����?");

		//������ �ƴ� �ٸ� ���� ������ ����ϰ� ������ ��� : �޸��� �κе� ������ �б�
		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*"); 
		//suzi,40,60,70 �� ��ä�� �о �� 
		//�޼ҵ� .useDelimiter("\\s*,\\s*");  ������� ,�� �����ض� : ����ȭ ǥ����
		//������ �⺻���� �ν��ϱ� ������ 'suzi, 40, 60, 70'�� �ۼ��ϸ� ���� �߻�.

/*		
		api Ȯ���ϱ�
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input);
		s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
		MatchResult result = s.match();
		for (int i=1; i<=result.groupCount(); i++)
         System.out.println(result.group(i));
		s.close(); 
*/		

		name = sc.next(); //������ ������ ���߰� �ű������ ���� �����ϹǷ� suzi�� name�� �����
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		sc.close();

		System.out.println(name + ":" + (kor+eng+mat)+"��");




	}
}
