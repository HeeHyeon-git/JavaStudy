package com.naver3;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import oracle.jdbc.internal.OracleTypes;

public class Naver {
	
	Scanner sc = new Scanner(System.in);
	NaverDAO dao = new NaverDAO();
	MyAuthenticator my = new MyAuthenticator();
	
	//1.INSERT ȸ������
	public void input(){
		
		try {
			String id, tel; 
			String gen;
			NaverDTO dto = new NaverDTO();
			System.out.print("id�� �Է��ϼ���. ");
			id = sc.next();
			my.inputFormat(id);
			dto.setId(id);
			
			System.out.print("PW�� �Է��ϼ���. ");
			dto.setPw(sc.next());
			
			System.out.print("Name�� �Է��ϼ���. ");
			dto.setName(sc.next());
			
			System.out.print("������ �Է��ϼ���. [����/����] : ");
			gen = sc.next();
			my.inputFormatGender(gen);
			dto.setGender(gen);
			
			System.out.print("��������� �Է��ϼ���. ");
			dto.setBirth(sc.next());
			
			System.out.print("email�� �Է��ϼ���. ");
			dto.setEmail(sc.next());
			
			System.out.print("tel�� �Է��ϼ���. ����ȭ��ȣ �Է� ������ [XXX-XXXX-XXXX]�Դϴ�. ");
			tel = sc.next();
			my.inputFormatTel(tel);
			dto.setTel(tel);
			
			int result = dao.insertData(dto);
			
			if(result!=0){
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�!");
				
				System.out.println(dto.toString());
			}else{
				System.out.println("ȸ�������� �����Ͽ����ϴ�!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	//2.UPDATE ȸ����������
	public void update(){
		try {
			NaverDTO dto = new NaverDTO();
			System.out.print("id�� �Է��ϼ���");
			dto.setId(sc.next());
			
			System.out.print("PW�� �Է��ϼ���");
			dto.setPw(sc.next());
			
			System.out.print("Name�� �Է��ϼ���");
			dto.setName(sc.next());
			
			System.out.print("������ �Է��ϼ���");
			dto.setGender(sc.next());
			
			System.out.print("��������� �Է��ϼ���");
			dto.setBirth(sc.next());
			
			System.out.print("email�� �Է��ϼ���");
			dto.setEmail(sc.next());
			
			System.out.print("tel�� �Է��ϼ���");
			dto.setTel(sc.next());
			
			int result = dao.updateData(dto);
			
			if(result!=0){
				System.out.println("ȸ������ ������ �Ϸ�Ǿ����ϴ�!");
				
				System.out.println(dto.toString());
			}else{
				System.out.println("ȸ������ ������ �����Ͽ����ϴ�!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	//3.DELETE ȸ��Ż��
	public void delete(){
		try {
			
			String delId, delPw;
			System.out.print("Ż���� ���̵� �Է��ϼ���? ");
			delId = sc.next();
			System.out.print("��й�ȣ�� �Է��ϼ���? ");
			delPw = sc.next();
			
			int result = dao.deleteData(delId,delPw);
			
			if(result!=0){
				System.out.println("���������� Ż���Ͽ����ϴ�!");
			}else{
				System.out.println("Ż�� ����");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	//4.SELECTALL ȸ����ü���
	public void print(){
		try {
			List<NaverDTO> lists = dao.getList();
			Iterator<NaverDTO> it = lists.iterator();
			//lists ���
			while(it.hasNext()){
				NaverDTO dto = it.next();
				System.out.println(dto.toString());
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		
	}
	//5.SEARCHID ���̵�˻�
	public void searchId(){
		try {
			String findId, findPw;
			System.out.print("�˻��� ���̵� �Է��ϼ���? ");
			findId = sc.next();
			System.out.print("��й�ȣ�� �Է��ϼ���? ");
			findPw = sc.next();
			
			NaverDTO dto = dao.searchID(findId, findPw);
			
			if(dto!=null){
				System.out.println(dto.toString());
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
	


