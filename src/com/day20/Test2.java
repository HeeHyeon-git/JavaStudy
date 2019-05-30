package com.day20;

import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test2 {

	public static void main(String[] args) {
		
		//1. DBConn Ŭ������ �����س����Ƿ� �����ؾ� �ɶ����� �����ٰ� ����ϸ� ��.
		Connection conn = DBConn.getConnection();
		if(conn==null){
			System.out.println("���� ����!!");
			System.exit(0);
		}
		
		//DB���� ���
		//1.DriverManager�� Connection�� ����
		//2.Connection�� Statement�� ����(SQL������ �����ϴ� �������̽�)
		//3.Statement�� query�� ����(execute)
		
		try {
			
			//2.
			Statement stmt = conn.createStatement();
			String sql;
			
			//insert��
//			sql = "insert into score (hak,name,kor,eng,mat) ";
//			sql += "values ('222','�̼���',50,20,80)";
			
			//update��
//			sql = "update score set name = '���¸�', kor=10, eng=10, mat=10 ";
//			sql += "where hak = '222'";			

			//delete��
			sql = "delete score where hak='222'";
			
			//3.
			int result = stmt.executeUpdate(sql); //stmt�� sql�Ű������� �������� db�� ������ ��û�Ѵ�. 
												  //executeUpdate: �� ����Ǹ� 1, ���� �߻��� 0 �� ��ȯ�Ѵ�
			
			if(result==1){
				System.out.println("���� ����!!");//�� ������� �ԷµǴ� �����ʹ� �ڵ�Ŀ��
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close();
	}
}
