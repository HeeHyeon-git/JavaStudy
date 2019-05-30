package com.score8;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score { //������ �Է�
//����ڰ� �Է��ϴ� ���� ������ Ŭ����

	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();
	
	//�Է�
	public void insert(){
		
		try {			
			ScoreDTO dto = new ScoreDTO();//����� �Էµ����͸� ���� dto ��ü ����
			
			System.out.print("�й�? ");
			dto.setHak(sc.next());
			
			System.out.print("�̸�? ");
			dto.setName(sc.next());
			
			System.out.print("����? ");
			dto.setKor(sc.nextInt());
			
			System.out.print("����? ");
			dto.setEng(sc.nextInt());
			
			System.out.print("����? ");
			dto.setMat(sc.nextInt());
			
			//DAO�� �Էµ� ��(dto)�� �����ؼ� ���� ����
			int result = dao.insertData(dto);
			
			if(result!=0){
				System.out.println("�߰� ����!");
			}else{
				System.out.println("�߰� ����!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//����
	public void update(){
		
		try {
			ScoreDTO dto = new ScoreDTO();
			
			System.out.print("�й�? ");
			dto.setHak(sc.next());
			
			System.out.print("����? ");
			dto.setKor(sc.nextInt());
			
			System.out.print("����? ");
			dto.setEng(sc.nextInt());
			
			System.out.print("����? ");
			dto.setMat(sc.nextInt());
			
			int result = dao.updateData(dto);
			
			if(result!=0){
				System.out.println("���� ����!");
			}else{
				System.out.println("���� ����!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//����
	public void delete(){
		
		try {
			
			String delhak;
			System.out.print("������ �й�? ");
			delhak = sc.next();
			
			int result = dao.deleteData(delhak);
			
			if(result!=0){
				System.out.println("���� ����!");
			}else{
				System.out.println("���� ����!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//��ü���
	public void selectAll(){
		
		List<ScoreDTO> lists = dao.getList(); //����Ʈ���� ��ȯ�Ǹ� lists�� ����
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		//lists ���
		while(it.hasNext()){
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	//�̸��˻�
	public void searchName(){
		try {
			System.out.print("�˻��� �̸�? : ");
			String searchName = sc.next();
			
			List<ScoreDTO> lists = dao.getList(searchName); 
		
			Iterator<ScoreDTO> it = lists.iterator();
			
			//lists ���
			while(it.hasNext()){
				ScoreDTO dto = it.next();
				System.out.println(dto.toString());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//�й��˻�
	public void searchHak(){
		try {
			
			System.out.print("�˻��� �й�? : ");
			String searchHak = sc.next();
			
			ScoreDTO dto = dao.searchHak(searchHak);
			
			if(dto!=null){
				System.out.println(dto.toString());
			}
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
