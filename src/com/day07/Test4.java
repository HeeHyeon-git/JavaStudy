package com.day07;

import java.util.Calendar;

public class Test4 {

	public static void main(String[] args) {		
		
		Data ob = new Data();	//��ü����
		ob.print();				
		
		Data.print(); //Ŭ�����̸�.�޼ҵ�� 
		//���� ������ ��ó�� �ϳ��� �ٷ� ȣ�� ����. �̸� �޸𸮻� �ö��ִ� static �޼ҵ�
		
		//Calendar now = new Calendar(); Calendar ��������� ��¥�� �ð��� �̿��ϴ� Ŭ����. static class. new �� ���� �� ����
		Calendar now1 = Calendar.getInstance(); //���� ȣ���ص� ���� ��. ���� �Ȱ��� ���� ������ ����� �޸� ������ �ʿ� ����.
				
	}

}
