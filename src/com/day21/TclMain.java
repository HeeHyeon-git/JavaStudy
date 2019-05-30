package com.day21;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

//Ʈ����� ó��
//������ �߿�. ��ü���� �帧�߿� ������ �߻��Ѵٸ� rollback ������ ����ܰ���� �Ǿ����� ��Ȯ�ؾ���
public class TclMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
		
		int ch;
		int id;
		String name, birth, tel;
		
		try {
			while(true){
				
				do{
					System.out.print("1.�Է� 2.��� 3.���� :");
					ch = sc.nextInt();
				}while(ch<1||ch>3);

				switch(ch){
					case 1:
					conn.setAutoCommit(false);//�Է½� autocommit�ǹǷ� ���� ����
					//test1,test2,test3 ���̺� ��� ���������� �ԷµǾ� commit�ǵ��� �����ϱ� ����
					//�߰��� �Է½� ������ ���ٸ� rollback ����
					
					System.out.print("���̵�[����]? ");
					id = sc.nextInt();
					System.out.print("�̸�? ");
					name = sc.next();
					System.out.print("����[yyyy-mm-dd]? ");
					birth = sc.next();
					System.out.print("��ȭ");
					tel = sc.next();
					
					//������ sql�� �ϳ��� �߸����� rollback ����ȴ�.
					//test1���̺� �Է�
					sql= String.format("insert into test1 (id, name) values(%d,'%s')",id, name);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();

					//test2���̺� �Է�
					sql= String.format("insert into test2 (id, birth) values(%d,'%s')",id, birth);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					//test3���̺� �Է�
					sql= String.format("insert into test3 (id, tel) values(%d,'%s')",id, tel);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					conn.commit();
					break;
					
					case 2:
						//���
						
					case 3:
						DBConn.close();
						System.exit(0);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
