package com.day18;

import java.io.Serializable;

//����ȭ �ݵ�� �ʿ�

public class FileInfo implements Serializable{

	/*	
	code(���Ƿ� ����)
	100 : �������� ����(���ϸ� ����)
	110 : ���� ������ ����
	200 : �������� ����(���ϸ� ����)
	size : �ѹ��� �����ϴ� ũ��
	data : ����
	*/	
	
	private int code;
	private int size;
	private byte[] data = new byte[1024];//�ѹ��� ���۰����� �������� ���� 1024byte�� ����
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
