package com.excep;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;//��Ŭ�������� exception�� �뷮�� �ʹ� Ŀ�� �޸� �Ҵ��� ��û��. �׷��� �ۼ����ִ� �ҽ�
	
	public MyException (String msg){ //������
		super(msg); //Exception�� String�� msg�� ����
	}
	
}
