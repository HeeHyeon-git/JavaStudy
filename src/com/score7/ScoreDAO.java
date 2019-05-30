package com.score7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

//PreparedStatement

public class ScoreDAO {
//SQL �� ���� Ŭ������ ������ ����
//DAO : data access Object

	//1.insert
	public int insertData(ScoreDTO dto){
		//DTO�� ���޹޾� �Է� ����. dto�� ���޸� ���ְ� �����
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		
		try {
			//try������ �����߻��� sql�� ��ü�� �����ų�, ����� ����
			
			sql = "insert into score (hak, name, kor, eng, mat) ";
			sql += "values (?,?,?,?,?)"; //�μ��� ������ŭ ����ǥ�� ����. ������ ��ȣ
			
			pstmt = conn.prepareStatement(sql); 
			// prepareStatement: sql���� �̸� �������� ��ȿ�� �������� Ȯ���� �� pstmt�� ����. 
			// �ٸ� �����ʹ� ���� ����.
			
			pstmt.setString(1, dto.getHak()); 
			//Sets the designated parameter to the given Java String value
			//sql���� ù��° �ε����� ����ǥ �ڸ��� dto�� hak �Է�
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());

			result = pstmt.executeUpdate();//PreparedStatement���� �̹� �˻縦 ���������Ƿ� �Ű����� ���� ����
			pstmt.close();
		
		} catch (Exception e) {
			try { pstmt.close();} catch (Exception e2) {}
			try { DBConn.close();} catch (Exception e2) {}
		}
		
		return result;
	}
	
	//2.update
	public int updateData(ScoreDTO dto){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update score set kor=?, eng=?, mat=? ";
			sql += "where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//3.delete
	public int deleteData(String hak){//������ dto ���� ���� �ʿ����. �й� string�ϳ��� �Է¹޾Ƶ� ��������.  
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "delete score where hak=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hak);//�Ű����� �й��ϳ��̹Ƿ� �ٷ� �Ҵ����ָ� ��
			result = pstmt.executeUpdate();
			pstmt.close();
	
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
		PreparedStatement pstmt = null;
		ResultSet rs=null; //select���� ��� ���̺��� ��ȯ�ϱ� ������ RESULTSET�� ����ؾ� �Ѵ�.
		String sql;
		
		try {
			
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg, ";
			sql +="rank() over (order by (kor+eng+mat) desc) rank ";
			sql +="from score";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
				dto.setRank(rs.getInt("rank"));
				
				//dto�� ����Ʈ�� �߰�
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
			
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	//5.searchname
	public List<ScoreDTO> getList(String searchname){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql +="from score where name like ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,searchname + "%");		
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lists;
	}
	
	//6.searchhak
	public ScoreDTO searchHak(String hak){
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto = null;//�˻��� �����Ͱ� ����� �������� �־ ��ü�� null�� �����ص� ��
		PreparedStatement pstmt = null; 
		ResultSet rs=null;
		String sql;
		
		
		try {
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql +="from score where hak = ? ";
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, hak); 
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
}
