package com.day20;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();//��� ã�ư��� �����س��� ������������ conn�� �Ҵ�
		
		if(conn==null){
			
			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		System.out.println("�����ͺ��̽� ���� ����!!");
		DBConn.close();
	}

}
