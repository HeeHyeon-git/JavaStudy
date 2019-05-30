package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

//db�� �����ϴ� �ҽ��ڵ�. db������ ���� ����

public class DBConn {
	
	private static Connection dbConn; //db�����ڸ� ���� �� �ִ� ����
	
	public static Connection getConnection(){
		//�̹� �޸𸮿� �ö������Ƿ� ������ ����ϸ� ��
		
		if(dbConn==null){//null�� ��� ������ ���� ���� ����
			
			try {
			
				String url = "jdbc:oracle:thin:@192.168.16.16:1521:TestDB"; 
				//jdbc������� type4����(thin:���� �������̰� ������), �ش� ip�ּҸ� ���� 1521��Ʈ�� TestDB�� �����ϰڴ�.
				//@192.168.16.16 -> @localhost Ŭ���̾�Ʈpc�� ���ӽ�.
				//EXPRESS�� ��ġ�ϸ� TestDB�� �ƴ϶� ������ xe�� ������
				
				
				String user = "SUZI";
				String password = "A123";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");//�ٸ�Ŭ������ ������ �о�� �� ���
				//oracle.jdbc.driver��ġ�� OracleDriverŬ������ �о�´�.
				//����Ŭ�� �ִ� ����̹��� �ִ��� Ȯ���ϴ� ����. �� ����̹��� �־�� ����̹��Ŵ����� ������ �� �ִ�
				//�������� Ŭ������ �ε��Ѵ�. �� �� ���� ������ ����.
				
				dbConn = DriverManager.getConnection(url, user, password);
				//DriverManager�� ���ؼ� ���� ������ url, user, password�� ��Ʈ���� �����ؼ� dbConn�� ��� ��
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}
/*
 	public static Connection getConnection1(){

		if(dbConn==null){
			
			try {
			
				String url = "jdbc:oracle:thin:@���ϴ¾�����:1521:���ϴµ��"; 
				String user = "SUZI";
				String password = "A123";
				Class.forName("oracle.jdbc.driver.OracleDriver");

				dbConn = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}
 */
	
	public static void close(){
		
		if(dbConn!=null){//null�� �ƴϸ� ����Ǿ� �ִ� ����

			try {
				
				if(!dbConn.isClosed()){
					dbConn.close();//�ݵ�� close�޼ҵ带 ȣ���ؼ� dbConn.close()�� ���ǵ��� ó���ؾ��Ѵ�.
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		dbConn = null;
		//������������ ����Ǿ� �ִ� ���¿��� ������ ���� �Ǹ� ��Ʈ���ȿ� �����Ⱚ�� ���Ե�
		//�ι�° ����� �����Ⱚ���� ���Ͽ� adapter ���� �߻�
		//���� ���� ����� �׻� �ʱ�ȭ�� �����ؾ��Ѵ�.	
	}
}
