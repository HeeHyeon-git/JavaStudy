package com.score3;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.print.attribute.standard.Compression;

public class ScoreImpl implements Score {

	private Vector<ScoreVO> lists = new Vector<ScoreVO>();// ���;��� ������ Ÿ����
															// ScoreVO Ŭ����
	Scanner sc = new Scanner(System.in);

	@Override
	public int input() {

		int result = 0; // ���߿� DB���� �����Ͱ� �� �ԷµǸ� ��ȯ�� 1�� ����. ������ �׳� void�� �ص� �������


		System.out.println("������ �Է�....");

		ScoreVO vo = new ScoreVO();
		
		System.out.print("�й�?");
		vo.setHak(sc.next()); // ��ĳ�ʷ� ������ ���ÿ� Setter �Ű�������
		System.out.print("�̸�?");
		vo.setName(sc.next());
		System.out.print("����?");
		vo.setKor(sc.nextInt());
		System.out.print("����?");
		vo.setEng(sc.nextInt());
		System.out.print("����?");
		vo.setMat(sc.nextInt());

		lists.add(vo);

		return result;
	}

	@Override
	public void print() {

		// Iterator
		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}

	}

	@Override
	public void searchHak() {// �й��˻�
		System.out.print("�˻��� �й�:");
		String searchHak = sc.next();// 111

		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) { 
			
			ScoreVO vo = it.next();
			
			if (vo.getHak().equals(searchHak)) { //searchHak.equals(vo.getHak) �й��� ������ ��츸 ���
			
				System.out.println(vo.toString());
				break;
			
			}
		
		}

	}

	@Override
	public void searchName() {// �̸��˻�
		System.out.print("�˻��� �̸�:");
		String searchName = sc.next();

		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) { 
			
			ScoreVO vo = it.next();
			
			if (vo.getName().equals(searchName)) { //searchHak.equals(vo.getHak) �й��� ������ ��츸 ���
			
				System.out.println(vo.toString());
				//break; ���������� �߻��� �� �����Ƿ� ������ �˻��ؾ� ��
			
			}
		
		}

	}

	@Override
	public void descSortTot() {// ������������ ����
		
		//Comparator interface
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {//Anonymous Inter type. ����Ŭ����

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1; //�ε�ȣ�� ���� <��������, >��������
			} 		
		
		};//�͸���Ŭ�����̹Ƿ� ; ������ �ȵ�
		
		Collections.sort(lists,comp); 
		//���
		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		
	}

	@Override
	public void ascSortHak() {// �й��������� ����

		Comparator<ScoreVO> comp1 = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getHak().compareTo(vo2.getHak()); //String method compareto()
			} 		
		
		};//�͸���Ŭ�����̹Ƿ� ; ������ �ȵ�
			
		Collections.sort(lists,comp1); 
		//���
		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		
	}

}
