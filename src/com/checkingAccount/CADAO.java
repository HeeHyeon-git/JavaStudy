package com.checkingAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class CADAO {

	// 2.ȸ������
	public int insertMember(CADTO dto) {

		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into member (id,pwd,name,inputdate) ";
			sql += "values (?,?,?,sysdate)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			result=pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	// 3.�α���
	public String login(String id, String pwd) {

		String login = null;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select id,pwd from member where id=? and pwd=?";

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

	//4.ȸ��Ż��
	public int deleteMember(String id, String pwd) {

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete member where id=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}


	//5.����/ī�� ���
	public int insertAsset(CADTO dto, String id, int BC){

		int result=0;
		int result1=0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		if(BC==1){
			try {
				sql = "select * from account where id=? and nickname = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, dto.getBankNick());
				result=pstmt.executeUpdate();	

				if (result == 1) {
					System.out.println();
					System.out.println("�����ϴ� ��Ī�Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println();
				} else{
					sql = "insert into account(id,accdiv,bank,accname,accno,accamount,nickname) ";
					sql += "values (?,?,?,?,?,?,?)";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, id);
					pstmt.setString(2, dto.getAccDiv());
					pstmt.setString(3, dto.getBank());
					pstmt.setString(4, dto.getAccName());
					pstmt.setString(5, dto.getAccno());
					pstmt.setInt(6, dto.getAccAmount());
					pstmt.setString(7, dto.getBankNick());
					result1=pstmt.executeUpdate();

					pstmt.close();
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		if(BC==2){
			try {
				sql = "select * from card where id=? and nickname = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, dto.getBankNick());
				result=pstmt.executeUpdate();	

				if (result == 1) {
					System.out.println();
					System.out.println("�����ϴ� ��Ī�Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println();
				} else{
					sql = "insert into card(id,card,cardname,cardno,nickname,cardamount) ";
					sql += "values (?,?,?,?,?,0)";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, id);
					pstmt.setString(2, dto.getCard());
					pstmt.setString(3, dto.getCardName());
					pstmt.setString(4, dto.getCardno());
					pstmt.setString(5, dto.getCardNick());
					result1=pstmt.executeUpdate();

					pstmt.close();
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		return result1;	
	}

	//6.����/ī�� ����
	public int deleteAsset(String id, String CAname, String CAno, int BC){

		int result=0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql="";


		try {

			if(BC==1)
				sql = "delete account where id=? and bank=? and accno=?";
			if(BC==2)
				sql = "delete card where id=? and card=? and cardno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, CAname);
			pstmt.setString(3, CAno);
			result=pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}


	//8. ����/ī�� ��ȸ
	public List<CADTO> selectAsset(String id, int BC) {

		List<CADTO> lists = new ArrayList<CADTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			if(BC==1){
				sql = "select accdiv, bank, accname, accno, accamount, nickname ";
				sql+= "from account where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					CADTO dto = new CADTO();
					dto.setAccDiv(rs.getString("accdiv"));
					dto.setBank(rs.getString("bank"));
					dto.setAccName(rs.getString("accname"));
					dto.setAccno(rs.getString("accno"));
					dto.setAccAmount(rs.getInt("accamount"));
					dto.setBankNick(rs.getString("nickname"));

					lists.add(dto);
				}
			}

			if(BC==2){
				sql = "select card, cardname, cardno, nickname, cardamount ";
				sql+= "from card where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					CADTO dto = new CADTO();
					dto.setCard(rs.getString("card"));
					dto.setCardName(rs.getString("cardname"));
					dto.setCardno(rs.getString("cardno"));
					dto.setCardNick(rs.getString("nickname"));
					dto.setCardAmount(rs.getInt("cardamount"));

					lists.add(dto);
				}
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	//4.1 �������ȸ - �Ϻ�
	public void selectday(String id, String date) {

		List<CADTO> lists = null; 
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int deposit = 0;
		int withdraw = 0;

		try {

			//����ݳ��� ��ü��ȸ
			sql = "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from cardwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')=?";//ī���̿볻��
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),amount,category,nickname "
					+ "from accountdeposit where id=? and to_char(cadate,'yyyy-mm-dd')=?";//�����Աݳ���
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from accountwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')=?";//������ݳ���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date);
			pstmt.setString(3, id);
			pstmt.setString(4, date);
			pstmt.setString(5, id);
			pstmt.setString(6, date);
			rs = pstmt.executeQuery();

			if(rs != null){
				lists = new ArrayList<CADTO>();
			}else{
				System.out.println("�Էµ� ����� ������ �������� �ʽ��ϴ�.");
				System.exit(0);
			}

			while (rs.next()) {	
				CADTO dto = new CADTO();
				dto.setId(rs.getString("id"));
				dto.setCADate(rs.getString("to_char(cadate,'yyyy-mm-dd')"));
				dto.setCANick(rs.getString("nickname"));
				dto.setAccAmount(rs.getInt("-(amount)"));
				dto.setCategory(rs.getString("category"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

			//�Ա��Ѿ� ���ϱ�
			sql = "select sum(amount) from accountdeposit where id=? and to_char(cadate,'yyyy-mm-dd')=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deposit = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

			//����Ѿ� ���ϱ�
			sql = "select -sum(amount) from (select * from cardwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')=? ";
			sql += " union all ";
			sql += " select * from accountwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')=?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date);
			pstmt.setString(3, id);
			pstmt.setString(4, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				withdraw = rs.getInt(1);	
			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		if(lists != null){
			System.out.println("---------------------------------------------------");
			System.out.println("  ���̵�   ������   ���º�Ī    ��  ��    ī�װ�");
			System.out.println("---------------------------------------------------");
			Iterator<CADTO> it = lists.iterator();
			while (it.hasNext()) {
				CADTO dto = it.next();
				dto.print();
			}
			System.out.println("\n------------------------------------------------");
			System.out.println("\t"+date +"�� ����� �Ѱ�");
			System.out.println("���� :" + withdraw);
			System.out.println("���� :" + deposit);
			System.out.println("����-���� :" + (deposit+withdraw));
			System.out.println("------------------------------------------------\n");
		}

	}

	//4.2 �������ȸ - �Ⱓ��
	public void selectweek(String id, String date1, String date2) {

		List<CADTO> lists = null; 
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int deposit = 0;
		int withdraw = 0;

		try {

			//����ݳ��� ��ü��ȸ
			sql = "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from cardwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=?";//ī���̿볻��
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),amount,category,nickname "
					+ "from accountdeposit where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=?";//�����Աݳ���
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from accountwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=?";//������ݳ���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date1); //fromdate
			pstmt.setString(3, date2); //todate
			pstmt.setString(4, id);
			pstmt.setString(5, date1); //fromdate
			pstmt.setString(6, date2); //todate
			pstmt.setString(7, id);
			pstmt.setString(8, date1); //fromdate
			pstmt.setString(9, date2); //todate
			rs = pstmt.executeQuery();

			if(rs != null){
				lists = new ArrayList<CADTO>();
			}else{
				System.out.println("�Էµ� ����� ������ �������� �ʽ��ϴ�.");
				System.exit(0);
			}

			while (rs.next()) {	
				CADTO dto = new CADTO();
				dto.setId(rs.getString("id"));
				dto.setCADate(rs.getString("to_char(cadate,'yyyy-mm-dd')"));
				dto.setCANick(rs.getString("nickname"));
				dto.setAccAmount(rs.getInt("-(amount)"));
				dto.setCategory(rs.getString("category"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

			//�Ա��Ѿ� ���ϱ�
			sql = "select sum(amount) from accountdeposit "
					+ "where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date1);
			pstmt.setString(3, date2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deposit = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

			//����Ѿ� ���ϱ�
			sql = "select -sum(amount) from "
					+ "(select * from cardwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=? ";
			sql += " union ";
			sql += " select * from accountwithdraw where id=? and to_char(cadate,'yyyy-mm-dd')>=? and to_char(cadate,'yyyy-mm-dd')<=?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, date1); //fromdate
			pstmt.setString(3, date2); //todate
			pstmt.setString(4, id);
			pstmt.setString(5, date1); //fromdate
			pstmt.setString(6, date2); //todate
			rs = pstmt.executeQuery();
			while (rs.next()) {
				withdraw = rs.getInt(1);	
			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		if(lists != null){
			System.out.println("---------------------------------------------------");
			System.out.println("  ���̵�   ������   ���º�Ī    ��  ��    ī�װ�");
			System.out.println("---------------------------------------------------");
			Iterator<CADTO> it = lists.iterator();
			while (it.hasNext()) {
				CADTO dto = it.next();
				dto.print();
			}
			System.out.println("\n----------------------------------------");
			System.out.println(date1+" ~ "+date2+" �� ����� �Ѱ�");
			System.out.println("���� :" + withdraw);
			System.out.println("���� :" + deposit);
			System.out.println("����-���� :" + (deposit+withdraw));
			System.out.println("----------------------------------------\n");
		}

	}

	//4.3 �������ȸ - ����
	public void selectmonth(String id, String year, String month) {

		List<CADTO> lists = null; 
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int deposit = 0;
		int withdraw = 0;

		try {

			//����ݳ��� ��ü��ȸ
			sql = "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from cardwithdraw where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? ";//ī���̿볻��
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),amount,category,nickname "
					+ "from accountdeposit where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? ";//�����Աݳ���
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from accountwithdraw where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? ";//������ݳ���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, year); 
			pstmt.setString(3, month); 
			pstmt.setString(4, id);
			pstmt.setString(5, year); 
			pstmt.setString(6, month);
			pstmt.setString(7, id);
			pstmt.setString(8, year);
			pstmt.setString(9, month); 
			rs = pstmt.executeQuery();

			if(rs != null){
				lists = new ArrayList<CADTO>();
			}else{
				System.out.println("�Էµ� ����� ������ �������� �ʽ��ϴ�.");
				System.exit(0);
			}

			while (rs.next()) {	
				CADTO dto = new CADTO();
				dto.setId(rs.getString("id"));
				dto.setCADate(rs.getString("to_char(cadate,'yyyy-mm-dd')"));
				dto.setCANick(rs.getString("nickname"));
				dto.setAccAmount(rs.getInt("-(amount)"));
				dto.setCategory(rs.getString("category"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

			//�Ա��Ѿ� ���ϱ�
			sql = "select sum(amount) from accountdeposit where id=? and  to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, year); 
			pstmt.setString(3, month); 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deposit = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

			//����Ѿ� ���ϱ�
			sql = "select -sum(amount) from (select * from cardwithdraw where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =?  ";
			sql += " union all ";
			sql += " select * from accountwithdraw where id=? and  to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, year); 
			pstmt.setString(3, month); 
			pstmt.setString(4, id);
			pstmt.setString(5, year); 
			pstmt.setString(6, month);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				withdraw = rs.getInt(1);	
			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		if(lists != null){
			System.out.println("---------------------------------------------------");
			System.out.println("  ���̵�   ������   ���º�Ī    ��  ��    ī�װ�");
			System.out.println("---------------------------------------------------");
			Iterator<CADTO> it = lists.iterator();
			while (it.hasNext()) {
				CADTO dto = it.next();
				dto.print();
			}
			System.out.println("\n----------------------------------------");
			System.out.println("\t"+year +"�� "+ month +"���� ����� �Ѱ�");
			System.out.println("���� :" + withdraw);
			System.out.println("���� :" + deposit);
			System.out.println("����-���� :" + (deposit+withdraw));
			System.out.println("----------------------------------------\n");
		}
	}

	//4.4 �������ȸ - ī�װ���
	public void selectcategory(String id, String category) {

		List<CADTO> lists = null; 
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int deposit = 0;
		int withdraw = 0;

		try {

			//����ݳ��� ��ü��ȸ
			sql = "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from cardwithdraw where id=? and category like ? ";//ī���̿볻��
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),amount,category,nickname "
					+ "from accountdeposit where id=? and category like ? ";//�����Աݳ���
			sql += " union ";
			sql += "select id,to_char(cadate,'yyyy-mm-dd'),-(amount),category,nickname "
					+ "from accountwithdraw where id=? and category like ? ";//������ݳ���
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, category+"%"); 
			pstmt.setString(3, id);
			pstmt.setString(4, category+"%"); 
			pstmt.setString(5, id);
			pstmt.setString(6, category+"%");
			rs = pstmt.executeQuery();

			if(rs != null){
				lists = new ArrayList<CADTO>();
			}else{
				System.out.println("�Էµ� ����� ������ �������� �ʽ��ϴ�.");
				System.exit(0);
			}

			while (rs.next()) {	
				CADTO dto = new CADTO();
				dto.setId(rs.getString("id"));
				dto.setCADate(rs.getString("to_char(cadate,'yyyy-mm-dd')"));
				dto.setCANick(rs.getString("nickname"));
				dto.setAccAmount(rs.getInt("-(amount)"));
				dto.setCategory(rs.getString("category"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

			//�Ա��Ѿ� ���ϱ�
			sql = "select sum(amount) from accountdeposit where id=? and category like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, category+"%"); 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deposit = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

			//����Ѿ� ���ϱ�
			sql = "select -sum(amount) from (select * from cardwithdraw where id=? and category like ? ";
			sql += " union all ";
			sql += " select * from accountwithdraw where id=? and category like ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, category+"%"); 
			pstmt.setString(3, id);
			pstmt.setString(4, category+"%"); 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				withdraw = rs.getInt(1);	
			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		if(lists != null){
			System.out.println("---------------------------------------------------");
			System.out.println("  ���̵�   ������   ���º�Ī    ��  ��    ī�װ�");
			System.out.println("---------------------------------------------------");
			Iterator<CADTO> it = lists.iterator();
			while (it.hasNext()) {
				CADTO dto = it.next();
				dto.print();
			}
			System.out.println("\n----------------------------------------");
			System.out.println("\t"+category +"�� ����� �Ѱ�");
			System.out.println("���� :" + withdraw);
			System.out.println("���� :" + deposit);
			System.out.println("����-���� :" + (deposit+withdraw));
			System.out.println("----------------------------------------\n");
		}


	}

	//4.5.1 �������ȸ - �Աݴ޷�
	public void selectcalendar1(String id, String year, String month) {

		int i, y, m, w, lastday;
		y = Integer.parseInt(year);
		m = Integer.parseInt(month);
		Calendar now = Calendar.getInstance();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int deposit[] = new int[32];

		now.set(y, m - 1, 1);
		w = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DATE);

		try {
			//�Ա��Ѿ� ���ϱ�
			sql = "select to_char(cadate,'dd'),sum(amount) from accountdeposit "
					+ "where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? group by to_char(cadate,'dd') ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, year); 
			pstmt.setString(3, month); 
			rs = pstmt.executeQuery();
			//�Ϻ��Աݾ� �迭�� ����
			while (rs.next()) {
				String cnt = rs.getString(1);
				int idx = Integer.parseInt(cnt);
				deposit[idx] = rs.getInt(2);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// ���
		System.out.println(" �� "+ y + "�� " + m + "�� ����� �� ");
		System.out.println("\n     ��                  ��                  ȭ                  ��                     ��                  ��                  ��");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

		for (i = 1; i < w; i++) {
			System.out.print("                     ");//1���� ĭ ���߱�
		}

		for (i = 1; i <= lastday; i++) {
			System.out.printf("%4d (�Ա�%8d��)", i, deposit[i]);
			w++;
			if (w % 7 == 1) { //����� �ٹٲ�
				System.out.println("\n");
			}
		}

		if (w % 7 != 1) {
			System.out.println("\n");//������ �ٹٲ�
		}

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	//4.5.1 �������ȸ - ��ݴ޷�
	public void selectcalendar2(String id, String year, String month) {

		int i, y, m, w, lastday;
		y = Integer.parseInt(year);
		m = Integer.parseInt(month);
		Calendar now = Calendar.getInstance();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int withdraw[] = new int[32];
		now.set(y, m - 1, 1);
		w = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DATE);

		try {

			//����Ѿ� ���ϱ�
			sql = "select to_char(cadate,'dd'),-sum(amount) from "
					+ "(select * from cardwithdraw where id=? and to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =?  ";
			sql += " union all ";
			sql += " select * from accountwithdraw where id=? and  to_char(cadate,'yyyy')=? and to_char(cadate,'mm') =? ) "
					+ "group by to_char(cadate,'dd') ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, year); 
			pstmt.setString(3, month); 
			pstmt.setString(4, id);
			pstmt.setString(5, year); 
			pstmt.setString(6, month);
			rs = pstmt.executeQuery();
			//�Ϻ����� �迭�� ����
			while (rs.next()) { 
				String cnt = rs.getString(1);
				int idx = Integer.parseInt(cnt);
				withdraw[idx] = rs.getInt(2);	
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// ���
		System.out.println(" �� "+ y + "�� " + m + "�� ����� �� ");
		System.out.println("\n     ��                  ��                  ȭ                  ��                     ��                  ��                  ��");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

		for (i = 1; i < w; i++) {
			System.out.print("                     ");//1���� ĭ ���߱�
		}

		for (i = 1; i <= lastday; i++) {
			System.out.printf("%4d (���%8d��)", i, withdraw[i]);
			w++;
			if (w % 7 == 1) { //����� �ٹٲ�
				System.out.println("\n");
			}
		}

		if (w % 7 != 1) {
			System.out.println("\n");//������ �ٹٲ�
		}

		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

	}	

	public int outputCardCA(CADTO dto) { // ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			//ī�� ����
			sql = "insert into cardwithdraw (ID,CADATE,AMOUNT,CATEGORY,NICKNAME) ";
			sql += "values (?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			//ī�� ����� �ۼ�
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();
			
			//ī�� ���� 
			sql = "update card set cardamount=(cardamount-?) where NICKNAME = ? ";
			pstmt = conn.prepareStatement(sql);		

			pstmt.setInt(1, dto.getCAAmount());//�ݾ�
			pstmt.setString(2, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	public int outputAccountCA(CADTO dto) {// ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			//���� ����

			sql = "insert into Accountwithdraw (ID,CADATE,AMOUNT,CATEGORY,NICKNAME) ";
			sql += "values (?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();


			sql = "update account set ACCAMOUNT=(ACCAMOUNT-?) where NICKNAME = ? ";
			pstmt = conn.prepareStatement(sql);		


			pstmt.setInt(1, dto.getCAAmount());//�ݾ�
			pstmt.setString(2, dto.getCANick());//���� ��Ī 


			result = pstmt.executeUpdate();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	public int inputAccountCA(CADTO dto) { // ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			//���� �Ա�

			sql = "insert into Accountdeposit (ID,CADATE,AMOUNT,CATEGORY,NICKNAME) ";
			sql += "values (?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();


			sql = "update account set ACCAMOUNT=(ACCAMOUNT+?) where NICKNAME = ? ";
			pstmt = conn.prepareStatement(sql);		


			pstmt.setInt(1, dto.getCAAmount());//�ݾ�
			pstmt.setString(2, dto.getCANick());//���� ��Ī 


			result = pstmt.executeUpdate();
			pstmt.close();



		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	public int deleteOutAccountCA(CADTO dto) { // ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "select FROM Accountwithdraw WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();	
			pstmt = null;
			
			if(result == 1){
				sql = "DELETE FROM Accountwithdraw WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";
				pstmt = conn.prepareStatement(sql);
	
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getCADate ());//��¥
				pstmt.setInt(3, dto.getCAAmount());//�ݾ�
				pstmt.setString(4, dto.getCategory());//ī�װ�
				pstmt.setString(5, dto.getCANick());//���� ��Ī 
	
				result = pstmt.executeUpdate();
				pstmt.close();	
				pstmt = null;
				//
	
				sql = "update ACCOUNT set ACCAMOUNT= ";
				sql+= "(ACCAMOUNT+(?)) ";
				sql+= "where NICKNAME = ? ";
				pstmt = conn.prepareStatement(sql);		
	
				pstmt.setInt(1, dto.getCAAmount());//�ݾ�
				pstmt.setString(2, dto.getCANick());//���� ��Ī 
	
				result = pstmt.executeUpdate();
				pstmt.close();
			}//
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	public int deleteInAccountCA(CADTO dto) { // ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "select * FROM Accountdeposit WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 
			result = pstmt.executeUpdate();
			pstmt.close();	
			pstmt = null;
			
			if(result == 1){
				sql = "DELETE FROM Accountdeposit WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";	
				pstmt = conn.prepareStatement(sql);	
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getCADate ());//��¥
				pstmt.setInt(3, dto.getCAAmount());//�ݾ�
				pstmt.setString(4, dto.getCategory());//ī�װ�
				pstmt.setString(5, dto.getCANick());//���� ��Ī 
	
				result = pstmt.executeUpdate();
				pstmt.close();	
				pstmt = null;
				//	
				sql = "update ACCOUNT set ACCAMOUNT= ";
				sql+= "(ACCAMOUNT-(?)) ";
				sql+= "where NICKNAME = ? ";
				pstmt = conn.prepareStatement(sql);		
	
				pstmt.setInt(1, dto.getCAAmount());//�ݾ�
				pstmt.setString(2, dto.getCANick());//���� ��Ī 
				result = pstmt.executeUpdate();
				pstmt.close();
			}
			//
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	public int deleteInCardCA(CADTO dto) { // ���� 

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			
			sql = "select * FROM cardwithdraw WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getCADate ());//��¥
			pstmt.setInt(3, dto.getCAAmount());//�ݾ�
			pstmt.setString(4, dto.getCategory());//ī�װ�
			pstmt.setString(5, dto.getCANick());//���� ��Ī 

			result = pstmt.executeUpdate();
			pstmt.close();	
			pstmt=null;			

			if(result ==1){
				sql = "DELETE FROM cardwithdraw WHERE ID=? AND CADATE=? AND AMOUNT=? AND CATEGORY=? AND NICKNAME=? ";
				pstmt = conn.prepareStatement(sql);
	
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getCADate ());//��¥
				pstmt.setInt(3, dto.getCAAmount());//�ݾ�
				pstmt.setString(4, dto.getCategory());//ī�װ�
				pstmt.setString(5, dto.getCANick());//���� ��Ī 
	
				result = pstmt.executeUpdate();
				pstmt.close();	
				pstmt=null;
				
				sql = "update card set CARDAMOUNT= ";
				sql+= "(CARDAMOUNT+(?)) ";
				sql+= "where NICKNAME = ? ";
				pstmt = conn.prepareStatement(sql);		
	
				pstmt.setInt(1, dto.getCAAmount());//�ݾ�
				pstmt.setString(2, dto.getCANick());//���� ��Ī 
	
				result = pstmt.executeUpdate();
				pstmt.close();
			}
			//
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	//������ü
	public int changeAsset(String id, String str, String str2, int money){

		int result = 0;
		String nick;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		ResultSet rs = null;

		try {
			sql = "select nickname from account where id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()){
				nick = rs.getString("nickname");
				if(str.equals(nick))
					result = result+1;
				if(str2.equals(nick))
					result = result+1;
			}	

			rs.close();

			if(result==2){
				sql = "update account set accamount=(accamount-?) where nickname=? and id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, money);
				pstmt.setString(2, str);
				pstmt.setString(3, id);

				result = result + pstmt.executeUpdate();

				sql = "update account set accamount=(accamount+?) where nickname=? and id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, money);
				pstmt.setString(2, str2);
				pstmt.setString(3, id);
				result = result +pstmt.executeUpdate();
				pstmt.close();	
			}


		} catch (Exception e) {	
			System.out.println(e.toString());
		}
		return result;
	}

	//������ü
	public int cardPayment(String id, String str, String str2, int money){

		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "select * from card where id=? and nickname = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, str);
			
			result+=pstmt.executeUpdate();	
			pstmt.close();
			
			sql = "select * from account where id=? and nickname = ? and accamount>=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, str2);
			pstmt.setInt(3, money);
			result+=pstmt.executeUpdate();
			pstmt.close();

			if(result==2){
				sql = "update card set cardamount=(cardamount+?) where nickname=? and id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, money);
				pstmt.setString(2, str);
				pstmt.setString(3, id);
				result = result + pstmt.executeUpdate();
				pstmt.close();
				
				sql = "update account set accamount=(accamount-?) where nickname=? and id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, money);
				pstmt.setString(2, str2);
				pstmt.setString(3, id);
				result = result +pstmt.executeUpdate();
				pstmt.close();	
			}


		} catch (Exception e) {	
			System.out.println(e.toString());
		}
		return result;
	}
}
