package com.day02;
import java.util.Scanner;

class Test6 {


	public static void main(String[] args) {
			//java���� ����ڰ� �Է��� ���� �д� ����� 2���� ����.
			//BufferedReader , Scanner

			Scanner sc = new Scanner(System.in); 
			//BufferedReader�� �ٸ� Ư������! -> Test7 
			//�ܶ����ڸ� �����ϴ� ���.
			//��������� Scanner�� ���� ���� �幰��

			//����
			String name;
			int kor;
			
			System.out.print("�̸��� ����?"); //����
			name = sc.next();

			System.out.print("����?"); //60
			kor = sc.nextInt(); //����ȯ�� ����

			String pan; //else if �� ������ ��� �ʱ�ȭ�� ������� ��. 
			
			//else~if���� ������ ������ �϶�.
			//������ �������϶� ���ʿ� ���ִ°� ����
			if(kor==100 || kor>=90){
				pan = "��";
			}else if(kor>=80){
				pan = "��";
			}else if(kor>=70){
				pan = "��";
			}else if(kor>=60){
				pan = "��";
			}else{
				pan = "��";
			}
			
			System.out.println(name + ":" + kor + ":" + pan );
			
			sc.close();
	}
}
