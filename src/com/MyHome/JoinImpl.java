package com.MyHome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.excep.AuthenException;

public class JoinImpl implements Join {

	private List<JoinVO> lists;
	
	private String path = System.getProperty("user.dir");
	private File f = new File(path,"\\Join.txt");
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	JoinException jo = new JoinException();

	public JoinImpl() throws AuthenException{
		
		try {
			
			if(!f.getParentFile().exists()){
				f.getParentFile().mkdirs();
			}
			
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (ArrayList<JoinVO>)ois.readObject();
				fis.close();
				ois.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void print(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("��ϱ���\t\t���̵�\t\t�̸�\t\t�ڵ�����ȣ");
		System.out.println("---------------------------------------------------------------------");
		Iterator<JoinVO> it = lists.iterator();
		
		while(it.hasNext()){
			JoinVO vo = it.next();
			System.out.println(vo.toPrint());
		}
		System.out.println();
	}
	
	
	//ȸ������
	@Override
	public void sign()  {

		JoinVO vo = new JoinVO();
		
		String pw2=null;		//��й�ȣ Ȯ��
		String str=null;		//���̵� Ȯ��
		int type;
		boolean id=true;
		boolean pw=true;
		boolean typeCheck=true;
		
		System.out.println("             ȸ �� �� �� ");
		System.out.println("-------------------------------------");

		
		//���̵� �Է�
		do{
			try{
				System.out.print("���̵�:");
				str = br.readLine();
				jo.idFormat(str);
			
				if(lists!=null){
					Iterator<JoinVO> it = lists.iterator();
					while(it.hasNext()){
						JoinVO vo1 = it.next();
						if(vo1.getId().equals(str)){
							jo.sameId();
						}
					}	
				}
			
				id = false;
				vo.setId(str);
			
			} catch (IOException e) {
				System.out.println(e.toString());
			
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(id);
		
		
		//��й�ȣ �Է�
		do{
			try{
				System.out.print("��й�ȣ:");
				vo.setPw(br.readLine());
			
				System.out.print("��й�ȣ Ȯ��:");
				pw2 = br.readLine();
				jo.pwCheck(vo.getPw(), pw2);
			
				pw=false;
			
			} catch (IOException e) {
				System.out.println(e.toString());
			
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(pw);
		
		try{
			
			System.out.print("�̸�:");
			vo.setName(br.readLine());
			
			System.out.print("��ȭ��ȣ:");
			vo.setPhone(br.readLine());
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		do{
			try{
				System.out.println("�ش��ϴ� ��ȣ�� �Է��ּ���");
				System.out.print("1.�ε����߰����� 2.������/�Ǹ���");
				type = Integer.parseInt(br.readLine());
				System.out.println(type);
				jo.typeCheck(type);
				
				typeCheck = false;
				vo.setType(type);
				
			} catch (IOException e) {
				System.out.println(e.toString());
				
			} catch (AuthenException e) {
				System.out.println(e.toString());
			
			}
			
		}while(typeCheck);
		
		try{
			
			System.out.println();
			System.out.println("****���������� ������ �Ǿ����ϴ�!****");
			System.out.println();
		
			if(lists==null)//ó�� ���� 
				lists = new ArrayList<JoinVO>();

			lists.add(vo);
			System.out.println("-----------[ȸ������ Ȯ��]-----------");
			System.out.println(vo.toString());
			
			
			if(lists!=null){
				
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				
				fos.close();
				oos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
