package com.checkingAccount;

import java.util.Scanner;

public class Money {

	public int inputMoney(String id, int i){
		Scanner sc = new Scanner(System.in);
		CADException cad = new CADException();

		boolean date=true;
		boolean won = true;
		boolean category=true;
		int x;
		int result=0;
		
		try {

			CADAO dao = new CADAO();
			CADTO dto = new CADTO();
			
			dto.setId(id);
	
			do{
				try {
					System.out.print("��¥: ");
					dto.setCADate(sc.next());
					cad.dateCheck(dto.getCADate());
					date = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}		
			} while(date);

			do{
				try{
					System.out.print("�ݾ�: ");
					x = cad.numberCheck1(sc.next());
					
					dto.setCAAmount(x);
					won = false;
					
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}	
			} while(won);
			

			System.out.println("��ī�װ� : [�ڱ���] [��Ȱ��] [�Ĵ�] [����] [��ȭ] [�̿�] [����] [����] [����]");
			do{
				try {
					System.out.print("ī�װ�: ");
					dto.setCategory(sc.next());
					cad.categoryCheck(dto.getCategory());
					
					category = false;
					
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}	
				
			} while(category);

			System.out.print("ī��/���� ��Ī: ");
			dto.setCANick(sc.next());
			
			if(i==1)
				result = dao.deleteInCardCA(dto);
			else if(i==2)
				result = dao.deleteInAccountCA(dto);
			else if(i==3)
				result = dao.deleteOutAccountCA(dto);
			else if(i==4)
				result = dao.outputCardCA(dto);
			else if(i==5)
				result = dao.outputAccountCA(dto);
			else
				result = dao.inputAccountCA(dto);
				
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

}
