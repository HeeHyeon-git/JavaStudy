package com.day02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Test5 {
	
	public static void main(String[] args) throws IOException {
			
		//��� : if, switch, for, while, do~while
		//�ݺ��� : for, while, do~while 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		String str = ""; //null

		System.out.print("���Է�?");
		num = Integer.parseInt(br.readLine());

		//if(������)

		//���� IF��
/*
		if�� �ۼ��� �߰�ȣ ���� �����̸� �߰�ȣ ���� ����
		else�� ���� ���� If���� �ʱ�ȭ�� ���� ������ ���� �߻�.

		if(num%2==0){
			str = "¦��";
		}

		if(num%2!=0){
			str = "Ȧ��";
		}
*/

		//if~else��
		if(num%2==0) {
			str = "¦��";
		}else{
			str = "Ȧ��";
		}

		System.out.println(num + ":" + str);
	}
}
