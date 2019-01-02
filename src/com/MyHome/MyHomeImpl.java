package com.MyHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class MyThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0;i<15;i++){
			System.out.print(".");
		
			try {
				sleep(100);
			} catch (Exception e) {
		
			}
		}
		System.out.println();
	}
	
}

class Thread1 {

	public static void th(){
		MyThread t = new MyThread();
		System.out.print("�˻���");
		t.start();

		try {
			t.join();
		} catch (Exception e) {

		}
	}
}

public class MyHomeImpl extends Thread implements MyHome {
	
	private List<JoinVO> joinLists;
	private List<MyHomeVO> myhomeLists;
	private List<ReserveVO> reserveLists;
	private String path = System.getProperty("user.dir");
	private File joinf = new File(path,"\\Join.txt");
	private File myhomef = new File(path,"\\Myhome.txt");
	private File reservef = new File(path, "\\Reserve.txt");
	Scanner sc = new Scanner(System.in);
	
	MyHomeException my = new MyHomeException();
	Find find = new Find();
	Won won = new Won();
	Thread1 t = new Thread1();
	
	public MyHomeImpl() {
		
		try {
			
			//ȸ������ ���� ���� Ȯ��
			if(!joinf.getParentFile().exists()){
				joinf.getParentFile().mkdirs();
			}
			
			if(joinf.exists()){
				FileInputStream joinFis = new FileInputStream(joinf);
				
				ObjectInputStream joinOis = new ObjectInputStream(joinFis);
				
				joinLists = (ArrayList<JoinVO>)joinOis.readObject();
				joinFis.close();
				joinOis.close();
				
			}
			
			//�Ź����� ���� Ȯ��
			if(!myhomef.getParentFile().exists()){
				myhomef.getParentFile().mkdirs();
			}
			
			if(myhomef.exists()){
				FileInputStream myhomeFis = new FileInputStream(myhomef);
				
				ObjectInputStream myhomeOis = new ObjectInputStream(myhomeFis);
				
				myhomeLists = (ArrayList<MyHomeVO>)myhomeOis.readObject();
				myhomeFis.close();
				myhomeOis.close();
				
			}
			
			//�������� ���� Ȯ��
			if(!reservef.getParentFile().exists()){
				reservef.getParentFile().mkdirs();
			}
			
			if(reservef.exists()){
				FileInputStream reserveFis = new FileInputStream(reservef);
				
				ObjectInputStream reserveOis = new ObjectInputStream(reserveFis);
				
				reserveLists = (ArrayList<ReserveVO>)reserveOis.readObject();
				reserveFis.close();
				reserveOis.close();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean login(String id, String pw) {
		
		boolean idCheck=false;
		boolean pwCheck=false;
		
		try {
			
			Iterator<JoinVO> it = joinLists.iterator();
			
			while(it.hasNext()){
				JoinVO vo = it.next();
				
				if(id.equals(vo.getId()))
					idCheck=true;
				
				if(pw.equals(vo.getPw()))
					pwCheck=true;
			}
			
			if(!idCheck)
				my.loginCheck(id);
		
			if(!pwCheck)
				my.pwCheck(pw);
			
			if(idCheck && pwCheck)
				return true;
			
		} catch (AuthenException e) {
			System.out.println(e.toString());
			return false;
		}
			
		return true;
		
	}
	
	@Override
	public void iteminput(String id) {
		
		JoinVO vo1 = new JoinVO();
		MyHomeVO vo = new MyHomeVO();

		try {
			System.out.println("********����� �Ź��� �Է��ϼ���*********");
			MyHomeVO reserveVO = new MyHomeVO();
			
			find.item();
			find.term();
			find.local();
			find.price();
			
			vo.setItem(find.item);
			vo.setTerm(find.term);
			vo.setLocal(find.local);
			vo.setPrice(find.price);
			vo.setId(id);
			
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			Iterator<JoinVO> it1 = joinLists.iterator();

			while(it1.hasNext())
			{
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					vo.setName(compareVO.getName());
					vo.setPhone(compareVO.getPhone());
				}
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(myhomeLists==null)//ó�� ���� 
			myhomeLists = new ArrayList<MyHomeVO>();
		
		myhomeLists.add(vo);
		System.out.println(vo);
		
		try {
			if(myhomeLists!=null){	
				FileOutputStream fos = new FileOutputStream(myhomef);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(myhomeLists);
				fos.close();
				oos.close();
				System.out.println("�Ź��� ���������� ��� �Ǿ����ϴ�.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void search() {
		
		//�Ź��˻�
		SearchHome searchHome = new SearchHome();
		int ch = 0;
		boolean search = true;
		System.out.println("********�˻��� �Ź��� �Է��ϼ���*********");
		try {
			
			while(search){
				
				do{
					System.out.println("�˻������� �Է����ּ���");
					System.out.println();
					System.out.println("1.�ְ�����");
					System.out.println("2.�������");
					System.out.println("3.������");
					System.out.println("4.����");
					System.out.println("5.�˻�����");
					System.out.print("�Է�:");
					ch = sc.nextInt();
					
				}while(ch<1);
			
				my.searchCheck(ch);
				
				switch(ch){
					case 1:
						find.item(); 
						t.th();
						searchHome.itemSearch(find.item);
						break;
					case 2:
						find.term(); 
						t.th();
						searchHome.termSearch(find.term);
						break;
					case 3:
						find.local(); 
						t.th();
						searchHome.localSearch(find.local);
						break;
					case 4:
						find.price();
						t.th();
						searchHome.priceSearch(find.price);
						break;
					case 5:
						System.out.println("�˻��� �����մϴ�");
						search = false;
				}
				
			}
				
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (AuthenException e) {
			System.out.println(e.toString());
		}
		
	}
	
	@Override
	public void reserve(String id) {//��㿹��
		
		boolean flagrv = false;
		
		try {
			
			System.out.println("*******��� ������ �Ź��� �Է��ϼ���********");
			
			//�˻��� �Ź� ���
			ReserveVO  reserveVO = new ReserveVO();
			find.item();
			find.term();
			find.local();
			find.price();

			
			//���� ���� �б�(�α��ε� id ���� �̸� ã��)
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			Iterator<JoinVO> it1 = joinLists.iterator();
			while(it1.hasNext()){
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					reserveVO.setBuyerName(compareVO.getName());
					reserveVO.setBuyerPhone(compareVO.getPhone());
				}
			}
			
			
			//���� �Ź� VO ����
			reserveVO.setBuyerId(id);
			reserveVO.setItem(find.item);
			reserveVO.setTerm(find.term);
			reserveVO.setLocal(find.local);
			reserveVO.setPrice(find.price);
			
			//���� �Ź� ����Ʈ �˻�
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			myhomeLists = (List<MyHomeVO>)ois.readObject();
			Iterator<MyHomeVO> it2 = myhomeLists.iterator();
						
			//���� ����Ʈ ����
			
			while(it2.hasNext()){		
				MyHomeVO myhomeVO  = it2.next();
				
				if((reserveVO.item.equals(myhomeVO.getItem()) && reserveVO.term.equals(myhomeVO.getTerm()) &&
						reserveVO.local.equals(myhomeVO.getLocal()) && reserveVO.price==myhomeVO.getPrice())){
					
					reserveVO.setSellerName(myhomeVO.getName()); //�Ź� ��� �� �����(�Ǹ����� �̸�) 
					reserveVO.setSellerPhone(myhomeVO.getPhone());
					reserveVO.setSellerId(myhomeVO.getId());
					flagrv = true;
					reserveVO.run();
				}
			}

			if(reserveLists==null)	//ó�� ����� ����Ʈ ����
				reserveLists = new ArrayList<ReserveVO>();
			
			reserveLists.add(reserveVO);
			
			try {

				if(reserveLists!=null){	
					FileOutputStream fos = new FileOutputStream(reservef);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(reserveLists);
					fos.close();
					oos.close();
				}
			} catch (Exception e) {

			}
			
			if(!flagrv){
				System.out.println("�ش� �Ź��� �����ϴ�");
			}
			
			fisjoin.close();
			oisjoin.close();
			fis.close();
			ois.close();
		
		} catch (Exception e) {
			
		}
	
	}

	@Override
	public void readingReserve(String id) {
		
		boolean flag = false;
		System.out.println("*************��� ���� ����*************");
		if (reserveLists == null) {// lists�� ������ �ȵǾ� ������ ��ü ���� ����.
			reserveLists = new ArrayList<ReserveVO>();
		}
		
		Iterator<ReserveVO> it = reserveLists.iterator();
		
		while(it.hasNext()){
			ReserveVO vo = it.next();
/*			System.out.println(id);
			System.out.println(vo.getBuyerId());
			System.out.println(vo.getSellerId());*/
			if(id.equals(vo.getBuyerId()) || id.equals(vo.getSellerId())){
				System.out.println(vo.toString());
				flag = true;
			}
			System.out.println();
		}
		
		if(!flag)
			System.out.println("������ �����ϴ�.");
	
	}

	
	@Override
	public void contract(String id) {//��� �� ����
		boolean flagrv = false;
		
		try {
			
			System.out.println("********ü��� �Ź��� �Է��ϼ���*********");
			MyHomeVO contractVO = new MyHomeVO();
			find.item();
			find.term();
			find.local();
			find.price();
			
			String name = "";
			
			FileInputStream fisjoin = new FileInputStream(joinf);
			ObjectInputStream oisjoin = new ObjectInputStream(fisjoin);
			joinLists = (List<JoinVO>)oisjoin.readObject();
			
			Iterator<JoinVO> it1 = joinLists.iterator();//ȸ����������

			while(it1.hasNext())
			{
				JoinVO compareVO = it1.next();
				if(id.equals(compareVO.id)){
					name = compareVO.getName();
				}
			}		
			
			contractVO.setItem(find.item);
			contractVO.setTerm(find.term);
			contractVO.setLocal(find.local);
			contractVO.setPrice(find.price);
			contractVO.setName(name);
			
			FileInputStream fis = new FileInputStream(myhomef);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			myhomeLists = (List<MyHomeVO>)ois.readObject();
			Iterator<MyHomeVO> it2 = myhomeLists.iterator();//�Ź�����
			
			while(it2.hasNext()){		
				MyHomeVO compareVO = it2.next();
				if((contractVO.item.equals(compareVO.getItem()) && contractVO.term.equals(compareVO.getTerm()) &&
						contractVO.local.equals(compareVO.getLocal()) && contractVO.price==compareVO.getPrice()&& 
						contractVO.name.equals(compareVO.getName()))){

					System.out.println("���� �Ź� ���� : \n"+contractVO.toString2());

					try {
						
						myhomeLists.remove(compareVO);
						System.out.println();
						System.out.println(".------------------------------------------------------.");
						sleep(500);
						System.out.println("|                                                      |");
						sleep(500);
						System.out.println("|               �� �� �� �� �� �� �� ��                |");
						sleep(500);
						System.out.println("|                                                      |");
						sleep(500);
						System.out.println("|"+" "+contractVO.toString2()    +"    "       +             "     |" );
						sleep(500);
						System.out.println("|                                                      |");
						sleep(500);
						System.out.println("|       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  @@@@   |");
						sleep(500);
						System.out.println("|                                              @ ü @  |");
						sleep(500);
						System.out.println("|       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ @ �� @  |");
						sleep(500);
						System.out.println("|                                               @@@@   |");
						sleep(500);
						System.out.println(".-.     .-.     .-.     .-.     .-.     .-.     .-.    |");
						sleep(500);
						System.out.println("   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'");
						sleep(500);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
						if(myhomeLists!=null){	
							FileOutputStream fos = new FileOutputStream(myhomef);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(myhomeLists);
							fos.close();
							oos.close();
							System.out.println("�Ź� ������ ���������� ���� �Ǿ����ϴ�.\n");
							flagrv = true;
							return;
						}
				}
				
			}
			if(!flagrv)
				System.out.println("�ش� �Ź��� �����ϴ�");
			
			fisjoin.close();
			oisjoin.close();
			fis.close();
			ois.close();
		
		} catch (Exception e) {
			
		}
		
	}
	
}
