package com.day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//BufferedReader
public class Test09 {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));//InputStreamReader�� �Ű������� ���� �Ҵ� ����. ������ �о br(����)�� ����. ���� ��Ű���� ���ٸ� ��θ� ����� ��
			
			String str;

			//readLine()�޼ҵ��� ���� ���� String. String ���� ���� ���� null�� �ش�
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
