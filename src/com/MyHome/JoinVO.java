package com.MyHome;

import java.io.Serializable;

public class JoinVO implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;		//���̵�
	String pw;		//��й�ȣ
	String name;	//�̸�
	String phone;	//�޴��� ��ȣ
	int type;		//1.�ε���, 2.�Ǹ���/������
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		
		String str;
		
		if(type==1){
			str = String.format("***�߰����� ȸ������ �Ϸ�*** \n���̵�:%s \n��й�ȣ:%s \n�̸�:%s \n��ȣ:%s \n", 
					id, pw, name, phone);
		}
		else{
			str = String.format("***������/�Ǹ��� ȸ������ �Ϸ�*** \n���̵�:%s \n��й�ȣ:%s \n�̸�:%s \n��ȣ:%s \n", 
					id, pw, name, phone);	
		}
		
		return str;
	}
	
	public String toPrint() {
		
		String str2;
		if(type==1){
			str2 = String.format("�߰����� \t %10s  %6s \t %10s", id,name, phone);
		}else{
			str2 = String.format("������/�Ǹ��� \t %10s  %6s \t %10s", id,name,phone);
		}
		return str2;
	}
	
}
