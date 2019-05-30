package com.score6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class Score {
	
	Scanner sc = new Scanner(System.in);
	//getter, setter ����ϴ� �� �Ϲ��������� DB���� �����̹Ƿ� ����� �����ϰ� ����
	String hak,name;
	int kor,eng,mat;
	int tot,avg;
	
	//1.�Է�
	public int insertData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//Ŭ������ �ʱⰪ�� null �̹Ƿ� Statement�� null�� �ʱ�ȭ
		//Statement�� sql���� �������ָ� �����ٰ� �����ϴ� ���� ����
		String sql;
		
		try {
			
			System.out.print("�й�? ");
			hak = sc.next();
			
			System.out.print("�̸�? ");
			name = sc.next();
			
			System.out.print("����? ");
			kor = sc.nextInt();
		
			System.out.print("����? ");
			eng = sc.nextInt();
			
			System.out.print("����? ");
			mat = sc.nextInt();
			
			sql = "insert into score (hak,name,kor,eng,mat) values(";
			sql += "'" + hak + "'," ;
			sql += "'" + name + "'," ;
			sql += kor + ",";
			sql += eng + ",";			
			sql += mat + ")";			
			
			//System.out.println(sql);//Ȯ�ο�
			stmt = conn.createStatement();//statement�� connection�� ������
			result = stmt.executeUpdate(sql);//executeUpdate�� insert, update, delete(DML�����϶�) ���
			stmt.close();

			System.out.println("�����Ͱ� �ԷµǾ����ϴ�.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;		
	}
	
	//2.����
	public int updateData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//Ŭ������ �ʱⰪ�� null �̹Ƿ� Statement�� null�� �ʱ�ȭ
		String sql;
		
		try {
			
			System.out.print("������ �й�? ");
			hak = sc.next();
			
			
			System.out.print("����? ");
			kor = sc.nextInt();
		
			System.out.print("����? ");
			eng = sc.nextInt();
			
			System.out.print("����? ");
			mat = sc.nextInt();
			
			sql = "update score set kor="+kor+", eng="+eng+", mat="+mat + " where hak = '"+hak+"'";

			System.out.println(sql);//Ȯ�ο�
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);//executeUpdate�� insert, update, delete(DML�����϶�) ���
			stmt.close();

			System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;		
	}
	
	//3.����
	public int deleteData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//Ŭ������ �ʱⰪ�� null �̹Ƿ� Statement�� null�� �ʱ�ȭ
		String sql;
		
		try {
			System.out.print("������ �й�? ");
			hak = sc.next();
			
			sql = "delete score where hak = '"+hak+"'";
			
			System.out.println(sql);//Ȯ�ο�
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);//executeUpdate�� insert, update, delete(DML�����϶�) ���
			stmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	//4.��ü���
	public void selectAll(){
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null; //statement�� ����ǰ� �� �� ���̺��� ��ȯ��. ��ȯ�� ���̺��� ���� ���� 
		String sql;
		String str;
		
		try {
						
			sql = "select hak,name,kor,eng,mat,";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql += "from score order by hak";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//���̺��� ��ƾ��ϴµ� �ش� ���̺��� ���ڵ��� ���� �� �� ����. �׷��� ������ �ݺ��� ����ؾ���
			//Ŀ���� BOF(BEGIN OF FILE) ~ EOF(END OF FILE) ȸ���� �ؾ���.
			
			//rs.next�� �����Ҷ����� �ݺ�
			while(rs.next()){
				hak = rs.getString(1); //ù��° �÷��� ��, �÷����� ����ص� ��
				name = rs.getString("name");	
				kor = rs.getInt("kor");
				eng = rs.getInt(4);
				mat = rs.getInt("mat");
				tot = rs.getInt(6);
				avg = rs.getInt("avg");
				
				str = String.format("%5s %8s %4d %4d %4d %4d %4d", 
						hak, name, kor, eng, mat, tot, avg);
				System.out.println(str);
			}
			
			rs.close();
			stmt.close();
			DBConn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	//5.�̸��˻�
	public void searchName(){
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null; //statement�� ����ǰ� �� �� ���̺��� ��ȯ��. ��ȯ�� ���̺��� ���� ���� 
		String sql;
		String str;
		
		try {
			
			System.out.print("�˻��� �̸�? ");
			String searchName = sc.next();
			
			sql = "select hak,name,kor,eng,mat,";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql += "from score ";
			sql += "where name like '%" + searchName +"%' "; 
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				hak = rs.getString(1); //ù��° �÷��� ��, �÷����� ����ص� ��
				name = rs.getString("name");	
				kor = rs.getInt("kor");
				eng = rs.getInt(4);
				mat = rs.getInt("mat");
				tot = rs.getInt(6);
				avg = rs.getInt("avg");
				
				str = String.format("%5s %8s %4d %4d %4d %4d %4d", 
						hak, name, kor, eng, mat, tot, avg);
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}
