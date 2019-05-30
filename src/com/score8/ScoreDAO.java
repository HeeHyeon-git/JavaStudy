package com.score8;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import oracle.jdbc.internal.OracleTypes;

import com.db.DBConn;

//CallableStatement

public class ScoreDAO {
//SQL �� ���� Ŭ������ ������ ����
//DAO : data access Object

	//1.insert
	public int insertData(ScoreDTO dto){
		//DTO�� ���޹޾� �Է� ����. dto�� ���޸� ���ְ� �����
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null; 
		String sql;
		
		try {
			
			//try������ �����߻��� sql�� ��ü�� �����ų�, ����� ����
			
			sql = "{call insertScore(?,?,?,?,?)}"; //���ν����� ȣ���ϴ� �� 
			cstmt = conn.prepareCall(sql); 
			// prepareStatement: sql���� �̸� �������� ��ȿ�� �������� Ȯ���� �� pstmt�� ����. 
			// �ٸ� �����ʹ� ���� ����.
			
			cstmt.setString(1, dto.getHak()); 
			//Sets the designated parameter to the given Java String value
			//sql���� ù��° �ε����� ����ǥ �ڸ��� dto�� hak �Է�
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());

			result = cstmt.executeUpdate();//PreparedStatement���� �̹� �˻縦 ���������Ƿ� �Ű����� ���� ����
			cstmt.close();
		
		} catch (Exception e) {
			try { cstmt.close();} catch (Exception e2) {}
			try { DBConn.close();} catch (Exception e2) {}
		}
		
		return result;
	}
	
	//2.update
	public int updateData(ScoreDTO dto){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			sql = "{call updateScore(?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			//���ν����� ��������(?,?,?,?)�� set ������ �����ؾ� �Ѵ�.
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			
			result = cstmt.executeUpdate();
			
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//3.delete
	public int deleteData(String hak){//������ dto ���� ���� �ʿ����. �й� string�ϳ��� �Է¹޾Ƶ� ��������.  
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			sql =  "{call deleteScore(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, hak);//�Ű����� �й��ϳ��̹Ƿ� �ٷ� �Ҵ����ָ� ��
			result = cstmt.executeUpdate();
			cstmt.close();
	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//4.selectAll : dto�� ��� ����Ʈ�� �ʿ��ϴ�.
	//������ �ش��ϴ� ���ڵ尡 dto�� ���� �� dto���� ����Ʈ�� ��Ƽ� ��ȯ���� ����Ʈ�� ���� 
	public List<ScoreDTO> getList(){
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "{call selectAllScore(?)}";//��ü�����͸� select�� ��� presult�� ���Ƿ� ?�� 1��. presult�� ����Ŭ���� Ŀ���� �ش�.
			cstmt = conn.prepareCall(sql);
			
			//out�Ķ������ �ڷ��� ����(Ŀ���� �޾Ƴ� ������ Ÿ���� ����)
			//cstmt.registerOutParameter(1,OracleTypes.CURSOR);
			//����Ŭ�� ȣȯ������ ������ demo > build path > configure build path > library�� ojdbc6.jar ���� ���߰� ����
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out�Ķ������ ���� �����޴´�
			rs = (ResultSet)cstmt.getObject(1); //cstmt�������� object�� �޾� downcast
			
			while(rs.next()){
				
				//���ڵ忡 �ִ� ������ dto�� �Է�
				ScoreDTO dto = new ScoreDTO();
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				dto.setRank(rs.getInt("rank"));
				
				//dto�� ����Ʈ�� �߰�
				lists.add(dto);
			}
			rs.close();
			cstmt.close();
			
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	//5.searchName
	public List<ScoreDTO> getList(String searchname){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "{call selectNameScore(?,?)}";//����ǥ ������ ������ out, in. �� ������ �ٲٷ��� ���ν����� ���� ������ �ٲ��ָ� �ȴ�.
			
			cstmt = conn.prepareCall(sql);
			
			//out �Ķ���� �ڷ��� ����
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in �Ķ���� 
			cstmt.setString(2,searchname + "%");//'ȫ��' �˻��� 'ȫ��%' ��� ��� �����Բ� % ����
			
			//���ν��� ����
			cstmt.executeQuery();
			
			//out�Ķ������ �� ���� �ޱ�
			rs = (ResultSet)cstmt.getObject(1);
			
			//���̺� ���ڵ尡 ���������� �ݺ�
			while(rs.next()){
				
				//���ڵ忡 �ִ� ������ dto�� �Է�
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				//dto�� ����Ʈ�� �߰�
				lists.add(dto);
			}
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	//6.searchhak
	public ScoreDTO searchHak(String hak){
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto = null;//�˻��� �����Ͱ� ����� �������� �־ ��ü�� null�� �����ص� ��
		CallableStatement cstmt = null; 
		ResultSet rs=null;
		String sql;
		
		
		try {
			sql = "{call selectHakScore(?,?)}";//����ǥ ������ ������ out, in 
			cstmt = conn.prepareCall(sql);
			
			//out �Ķ���� �ڷ��� ����
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in �Ķ���� 
			cstmt.setString(2,hak);
			
			//���ν��� ����
			cstmt.executeQuery();
			
			//out�Ķ������ �� ���� �ޱ�
			rs = (ResultSet)cstmt.getObject(1);
			
			//�����Ͱ� �ְų� ���ų� ���� �ϳ�
			if(rs.next()){
				
				dto = new ScoreDTO();
				//���ڵ忡 �ִ� ������ dto�� �Է�				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
			}
			
			rs.close();
			cstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
}
