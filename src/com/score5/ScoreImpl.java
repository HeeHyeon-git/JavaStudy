package com.score5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {

	private List<ScoreVO> lists; // new ���ο� ��ü�� �����ϸ� ��� �����Ͱ� ����
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\score.txt"); //d:\\java\\demo path�� ���� ��

	public ScoreImpl() {// �⺻������

		try {

			if (!f.getParentFile().exists()) {// ������ �������� ������ ���� ���丮 ����. //d:\\java\\demo\\data\\score				
				f.getParentFile().mkdirs();
			}

			if (f.exists()) {// �ι�° �̻� �����. ���� ������ ������ ��� fis�� �о lists�� ������ �Ҵ�.
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				lists = (ArrayList<ScoreVO>) ois.readObject();
				fis.close();
				ois.close();
			}

		} catch (Exception e) {
		
		}

	}
	
	@Override
	public void writeFile() {

		try {

			if (lists != null) {
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);

				fos.close();
				oos.close();
				System.out.println("���� ���� ����!!");

			}
		} catch (Exception e) {
		}

	}

	@Override
	public void input() {

		Scanner sc = new Scanner(System.in);
		ScoreVO vo = new ScoreVO();
		System.out.print("�̸�?: ");
		vo.setName(sc.next());
		System.out.print("����?: ");
		vo.setBirth(sc.next());
		System.out.print("����?: ");
		vo.setJumsu(sc.nextInt());

		if (lists == null) {// ó������� lists�� ������ �ȵǾ� ���� -> ��ü ���� ����. �����ڿ��� ������ ������ ������ �ҷ����� ��Ŵ. 
			lists = new ArrayList<ScoreVO>();
		}

		lists.add(vo);

	}

	@Override
	public void print() {

		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo2 = it.next();
			System.out.println(vo2.toString());

		}

	}

}
