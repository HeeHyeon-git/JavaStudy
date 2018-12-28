package com.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Ŭ������[java.lang.String]: ");//Ŭ���� �� �Է½� ��Ű���� �̿� ���� �Է������ ��  
			String str = br.readLine();
			
			Class cls = Class.forName(str);
			
			//����������
			Constructor<?>[] c = cls.getConstructors(); //���ʸ��� �Ⱦ��Ÿ� ?�� �θ� ��

			System.out.println("������.....");
			for(int i=0;i<c.length;i++){
				System.out.println(c[i]);
			}
			
			//�ʵ�(����)����
			Field[] f = cls.getFields();

			System.out.println("�ʵ�.....");
			for(int i=0;i<f.length;i++){
				System.out.println(f[i]);
			}
			
			//�޼ҵ� ����
			Method[] m = cls.getMethods();
			
			System.out.println("�޼ҵ�.....");
			for(int i=0;i<m.length;i++){
				System.out.println(m[i]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
