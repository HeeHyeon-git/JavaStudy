package com.day15;

import java.io.IOException;
import java.io.OutputStream;

//�⺻ ��� ��Ʈ��(out)

public class Test02 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;
		//��½� ����ϴ� ���� �������� ��Ʈ��. ��Ʈ���ȿ� ��Ʈ���� ���� �� ����
		//System.out�� 1byte���� ����� �� ����. �̰� OutputStream �� ���� ��.
		
		//buffer ����
		byte[] b = new byte[3]; //�迭�� �����͸� ����ְ� �迭�� ��ä�� �����ϴ� ��� -> Buffer
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		//����� �ƽ�Ű�ڵ�� �ٲ�
		
		os.write(b);//OutputStream�� write�޼ҵ带 �̿��ؼ� �ѹ��� ���
		
		os.close();
		
		//System.out�� ������ �޸𸮻󿡼� ������.
		//�����ص� �Ʒ����� ������ ����.
		System.out.println("�����̳�?");
	}

}
