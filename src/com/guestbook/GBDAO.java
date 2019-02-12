package com.guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GBDAO {


	// ������ȸ
	public List<GBDTO> selectbang() {
		
		List<GBDTO> lists = new ArrayList<GBDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select tableno, id, to_char(inputdate,'yyyy-mm-dd'), text ";
			sql += "from bang order by tableno ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// ���ڵ忡 �ִ� ������ dto�� �Է�
				GBDTO dto = new GBDTO();
				dto.setTableno(rs.getInt("tableno"));
				dto.setId(rs.getString("id"));
				dto.setInputdate(rs
						.getString("to_char(inputdate,'yyyy-mm-dd')"));
				dto.setText(rs.getString("text"));
				// dto�� ����Ʈ�� �߰�
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	// ȸ��Ż��
	public int deletedata(String id, String pwd) {

		int result1 = 0, result2 = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete detaildata where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result2 = pstmt.executeUpdate();
			pstmt.close();
			
			sql = "delete basicdata where id=? and pwd =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			result1 = pstmt.executeUpdate();
			pstmt.close();
			
			conn.commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		if (result1==1 && result2==1) {
			return 1;
		} else {
			return 0;
		}

	}

	// 1.inserMember
	public int insertMember(GBDTO dto) {

		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into basicdata (id,pwd,name) ";
			sql += "values (?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();

			sql = "insert into detaildata (id,tel,birth,gender) ";
			sql += "values (?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getGender());
			result = pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	// 2.login
	public String login(String id, String pwd) {

		String login = null;

		List<GBDTO> lists = new ArrayList<GBDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select id,pwd from basicdata where id=? and pwd=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next())
				login = id;
			else
				login = "";

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
			return login;
		}

		return login;

	}

	public int insertGB(GBDTO dto) {

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into bang (tableno,id,text,inputdate) ";
			sql += "values (tableno.nextval,?,?,sysdate)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getText());

			result = pstmt.executeUpdate();
			pstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	public int deleteGB(int dn, String id) {
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "delete bang where id=? and tableno =?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setInt(2, dn);

			result = pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

}
