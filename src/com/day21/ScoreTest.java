package com.day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class ScoreTest {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		Scanner sc = new Scanner(System.in);
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		int ch;
		
		try {
			sql = "select hak,name from score";
			
			//stmt = conn.createStatement();//���������θ� �̵�.(���̺��� ���ڵ� ������� ����)
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//INSERT���� �ڵ�Ŀ���ε�, UPDATE�� ��쿡�� COMMIT�� ����Ǿ��� �׷��� SENSITIVE,INSENSITIVE ����
			//TYPE_SCROLL_SENSITIVE : ���� ��� �ٷ� �ݿ� �ȵ�
			//TYPE_SCROLL_INSENSITIVE : ���� ��� �ٷ� �ݿ�(��/������ �˻� ����)
			//CONCUR_READ_ONLY : �б� ����
			//CONCUR_UPDATABLE : ���� ����
			
			rs = stmt.executeQuery(sql);
			while(true){
				
				do{
					System.out.println("1.ó�� 2.���� 3.���� 4.������ 5.����: ");
					ch = sc.nextInt();
				}while(ch<1||ch>5);
				
				switch(ch){
				
				case 1: 
					if(rs.first()){
						System.out.println("ó��: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
				
				case 2:
					if(rs.previous()){
						System.out.println("����: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
					
				case 3:
					if(rs.next()){
						System.out.println("����: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;	
					
				case 4:
					if(rs.last()){
						System.out.println("������: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
					
				default:
					rs.close();
					stmt.close();
					DBConn.close();
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
