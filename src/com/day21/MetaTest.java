package com.day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.db.DBConn;

//�ش� �����Ϳ� ���� ������ �����ִ� ������
//DB���� �����Ϳ� ���� ������, ������ ũ�� ����

public class MetaTest {

	public static void main(String[] args) {
		
		Connection conn =DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql;
		try {
			sql = "select * from score";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			
			//�ʵ��
			int cols = rsmd.getColumnCount();
			
			//�ʵ��������
			for(int i=1;i<=cols;i++){
				System.out.print("�ʵ��: "+ rsmd.getColumnName(i));
				System.out.print(", �ʵ�Ÿ��: " +rsmd.getColumnType(i));
				System.out.print(", �ʵ�Ÿ�Ը�: " +rsmd.getColumnTypeName(i));
				System.out.print(", �ʵ���: " +rsmd.getPrecision(i));
				System.out.println();
			}			
			System.out.println();
			
			//���������
			while(rs.next()){
				for(int i=1; i<=cols; i++){
					System.out.print(rs.getString(i)+ " ");
				}
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			DBConn.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
