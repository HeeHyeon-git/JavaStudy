package com.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//FileWriter
//����� �����ڵ� ���ڿ��� �ý��ۿ� �´� ����Ʈ ���� ���ڵ��� ����Ʈ�� ��ȯ�ؼ� ���Ͽ� ����.

//BufferedWriter
//�ٸ� ��� ��Ʈ���� �������� ���ڷ� �޾� �����ϸ�
//���ڸ� ���۸� �ϴ°Ϳ� ���� ����.�迭 �Ǵ� ��Ʈ���� ���� ���·� ����Ѵ�.
// -> ����/����Ʈ ��Ʈ���� ���۷� ����Ѵ�.

public class Test17 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		FileWriter fw = new FileWriter("d:\\doc\\out6.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String str;
		
		System.out.println("���ڿ� �Է�: ");
		
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();//str + "\r\n"(����)
		}
		
		bw.close();
		fw.close();
		
	}

}
