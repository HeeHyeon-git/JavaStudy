package com.day15;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//[File Ŭ����]
//���� �� ������ ������ �� �ֵ��� ����� �������ִ� Ŭ����
//������ ���� �Ǵ� �̸� ���� ���� ������ �� ��쿡�� ���ǰ�
//������ ������ ������ϴ� �޼ҵ�� �������� �ʴ´�.(���� ���� �Ұ�)

public class Test12 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("d:\\doc\\test.txt");//f�� ���,���ϸ�,������� ��. �⺻��ο� �ִ� ������ �̿��� ��� file�̸����� ����.
		
		// \\.. �������丮 
		//getAbsolutePath() : ���� ��ġ �Ǵ� ����̺긦 ������� ��θ� �ذ��մϴ�.
		//getCanonicalPath() : �ý��� �����Ѵ�. ��ΰ� ��Ÿ���� ���� �� ��ġ�� �ذ�˴ϴ�. ���� ��ο� "."�� ������ �Ϲ������� ���ŵ˴ϴ�.
		
		System.out.println("��������.............");
		System.out.println("���ϸ�: " + f.getName());
		System.out.println("����ũ��: " + f.length());//���ϱ���
		System.out.println("���ϰ��: " + f.getAbsolutePath());
		System.out.println("ǥ�ذ��: " + f.getCanonicalPath());
		System.out.println("���糯: " + new Date(f.lastModified()));//lastModified() f�� ���������� ����� ����
		System.out.println("���ϻ������: " + f.getParent());
		System.out.println("�б�Ӽ�: " + f.canRead());
		System.out.println("����Ӽ�: " + f.canWrite());
		
		//���� �۾����
		String path = System.getProperty("user.dir");//user.dir�� �ý��� ����. 
		System.out.println("���� �۾���� : " + path);//��Ŭ������ ����Ǵ� ���� �۾���� ��
		
	}

}
