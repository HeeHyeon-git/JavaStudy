package com.score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {

	// private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();
	// �����Ͱ� ��ǻ�͸������ ��������
	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>(); // �����Ͱ� �� ������� ����
																		
	Scanner sc = new Scanner(System.in);
	String hak; //key �� ����� �� 

	@Override
	public void input() {
		System.out.print("�й�?");
		hak = sc.next();

		if (searchHak(hak)) {
			System.out.println("�й��� �����մϴ�.");
			return; // ScoreVO ��ü���� ���� �� ������� �ʰ� input�޼ҵ常 ����
		}

		ScoreVO vo = new ScoreVO(); // ���ο� ScoreVO ��ü����

		System.out.print("�̸�");
		vo.setName(sc.next());
		System.out.print("����");
		vo.setKor(sc.nextInt());
		System.out.print("����");
		vo.setEng(sc.nextInt());
		System.out.print("����");
		vo.setMat(sc.nextInt());

		hMap.put(hak, vo); //< key,value > ->Map�� �߰�
		System.out.println("�߰� ����!!");
	}

	@Override
	public boolean searchHak(String hak) {

		if (hMap.containsKey(hak)) {// key�� ������
			return true;
		}
		return false;

		// return hMap.containsKey(hak); //key�� ���� -> T, ������ -> F. ���ٷ� ǥ�� ����
	}

	@Override
	public void print() {
		Iterator<String> it = hMap.keySet().iterator();

		System.out.println();

		while (it.hasNext()) {
			String key = it.next();
			ScoreVO vo = hMap.get(key);

			System.out.println(key + " " + vo.toString());
		}
	}

	@Override
	public void update() {

		System.out.print("�̸�, ������ ������ �й�?");
		hak = sc.next();

		if (!searchHak(hak)) {
			
			System.out.println("�Էµ��� ���� �й��Դϴ�.");
			return;
		}
		
			String key = hak;
			
			ScoreVO vo1 = hMap.get(key); 
			String preName = vo1.getName();
			
			vo1.setName(preName); //�̸��� ��������� �־����� ������ NULL���� �����ǰ� ��	
			
			System.out.print("����");
			vo1.setKor(sc.nextInt());
			System.out.print("����");
			vo1.setEng(sc.nextInt());
			System.out.print("����");
			vo1.setMat(sc.nextInt());

			hMap.put(key, vo1);
			System.out.println("���� ����!");
	}

	@Override
	public void delete() {

		String del;
		System.out.print("������ �й�?");
		del = sc.next();

		if (hMap.containsKey(del)) {
			hMap.remove(del);
			System.out.println("�����Ϸ�");
		} else {
			System.out.println("�ش� �й� ����");
		}

	}

	@Override
	public void findHak() {

		System.out.print("�˻��ϰ� ���� �й�?");
		hak = sc.next();
		
		if (hMap.containsKey(hak)) {
		
			ScoreVO value = hMap.get(hak);
			System.out.println(hak + ":" + value);
			return;
		
		} else {
		
			System.out.println(hak + ": �ش� �й� ���� ����");
		
		}
		
/*		//���1 : key���� hak�� ���� vo ��ü ����. Ŭ������ �ʱⰪ�� null. �ش��ϴ� �й��� ���� ��� vo��ü�� null��
 
		ScoreVO vo = hMap.get(hak);
		
		if(vo==null){	
			System.out.println("�й��� �����ϴ�!");
			return;
		}
		System.out.println(hak + " " + vo.toString());
*/		



	}

	@Override
	public void findName() {

		System.out.print("�˻��ϰ� ���� �̸�?");
		String fName = sc.next();

		Iterator<String> it2 = hMap.keySet().iterator();
		boolean flag = false; //ã�� �̸��� �ִ��� flag ���

		while (it2.hasNext()) { //���� �̸��� �������� �� ����. break ���� �ȵ�. ������ �ִ� ������ �� �������� ��.
		
			String key = it2.next();
			ScoreVO vo = hMap.get(key);
			
			if (vo.getName().equals(fName)) { 
			
				System.out.println("�й�:" + key + "���� :" + vo);
				flag = true; //�ѹ��̶� ������ �̸��� ������ flag�� true�� ����
			
			}
		
		}
		
		if (!flag) {
			System.out.println("�ش��ϴ� �̸��� �����");
		}

	}

}
