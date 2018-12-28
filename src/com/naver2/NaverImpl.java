package com.naver2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.score5.ScoreVO;

public class NaverImpl implements Naver {

	Scanner sc = new Scanner(System.in);
	List<NaverVO> lists;
	private String path = System.getProperty("user.dir");	
	private File f = new File(path, "\\data\\naver2.txt");

	
	public NaverImpl() {
		
		try {

			if (!f.getParentFile().exists()) {// ������ �������� ������ ���� ���丮 ����
				f.getParentFile().mkdirs();
			}

			if (f.exists()) {//���� ������ ������ ��� fis�� �о lists�� ������ �Ҵ�.
				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (List<NaverVO>)ois.readObject();
				
				fis.close();
				ois.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@Override
	public void writeFile(){
		
		try {
			
			if (lists!=null) {
				
				FileOutputStream fos = new FileOutputStream(f);
				
				ObjectOutputStream oos = new ObjectOutputStream(fos);
								
				oos.writeObject(lists);

				fos.close();
				oos.close();
				
				System.out.println("���� ���� ����!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void input() {
	
		NaverVO vo = new NaverVO();	
		
		MyAuthenticator ma = new MyAuthenticator();
		
		String id = "";
		String pw1 = "";
		String pw2 = "";
		
		boolean flagId = true;
		boolean flagPw = true;
		
		if (lists == null) {// lists�� ������ �ȵǾ� ������ ��ü ���� ����.
			lists = new ArrayList<NaverVO>();
		}
		
		do {
			try {
				System.out.print("ID�� �Է��ϼ��� : ");
				id = sc.next();
				ma.inputFormat(id);

				Iterator<NaverVO> it = lists.iterator();

				while (it.hasNext()) {
					NaverVO vo1 = it.next();
					String compareId = vo1.getId();
					if (id.equals(compareId)) {
						System.out.println(id + ": �ش� ID�� �����մϴ�.");
						return;
					}
				}
				vo.setId(id);
				flagId = false;
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}while(flagId);
		
		do {
			try {
				System.out.print("ù��° PW�� �Է��ϼ��� : ");
				pw1 = sc.next();
				System.out.print("�ι�° PW�� �Է��ϼ��� : ");
				pw2 = sc.next();
				ma.inputFormat(pw1, pw2);

				vo.setPw1(pw1);
				vo.setPw2(pw2);
				flagPw = false;
			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}while(flagPw);
		
		System.out.print("�̸� : ");
		vo.setName(sc.next());
		System.out.print("����[��,��]: ");
		vo.setGender(sc.next().charAt(0));
		System.out.print("�������(2000-01-01) : ");
		vo.setBirth(sc.next());
		System.out.print("E-mail �Է��ϼ���. : ");
		vo.setEmail(sc.next());
		System.out.print("Tel �Է��ϼ���. : ");
		vo.setTel(sc.next());
		
		lists.add(vo);
		
	}

	@Override
	public void searchId() {

		System.out.print("�˻��� ���̵� �Է��ϼ���: ");
		String findId =sc.next();
		
		Iterator<NaverVO> it = lists.iterator();

		boolean flagId2 = false;
		
		while(it.hasNext()){
			NaverVO vo= it.next();
			String comId = vo.getId();
			if(findId.equals(comId)){
				System.out.printf("Id: %s, PW: %s, �̸�: %s, ����: %s, email: %s, �������: %s, Tel: %s"
						,vo.getId(), vo.getPw1(),vo.getName(), vo.getGender(), vo.getEmail() ,vo.getBirth(),vo.getTel());
				flagId2 = true;
			}
			System.out.println();
		}
		
		if(!flagId2){
			System.out.println("��ϵ� ID�� �������� �ʽ��ϴ�.");
		}
	}

	@Override
	public void print() {
		
		Iterator<NaverVO> it = lists.iterator();
		
		while(it.hasNext()){		
			NaverVO vo= it.next();
			System.out.printf("Id: %s, PW: %s, �̸�: %s, ����: %s, email: %s, �������: %s, Tel: %s"
			,vo.getId(), vo.getPw1(),vo.getName(), vo.getGender(), vo.getEmail() ,vo.getBirth(),vo.getTel());
			System.out.println();
		
		}
		System.out.println("\n-----------------------------------------------------------\n");
		
	}
	
}
