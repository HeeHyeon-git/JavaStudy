package com.day18;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//����. ��Ʈ�� ������ ���� �� ���� ����
//����ȭ�� �����͸� �����ϹǷ� ObjectOutputStream, ObjectInputStream �ʿ�(Serializable �ʼ�)
//��Ʈ��ũ���� �����͸� ���� ���� getInputStream, getOutputStream �޼ҵ� Ȱ��

public class FileServerTest {

	class WorkThread extends Thread{//����Ŭ����
		
		private Socket sc= null;

		public WorkThread(Socket sc){
			this.sc=sc;
		}
		
		@Override
		public void run() {
		
			try {
				
				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());//������ InputStream�� �־���
				System.out.println(sc.getInetAddress().getAddress() + "����....");
				
				FileOutputStream fos = null; //���������� ������ �����ϱ� ���ؼ� FileOutputStream �ʿ�
				Object ob = null;
				
				while((ob=ois.readObject())!=null){
					
					if(ob instanceof FileInfo){
						FileInfo info = (FileInfo)ob;//downcast

						if(info.getCode()==100){//100 : �������� ����(���ϸ� ����)
							
							String str =new String(info.getData());
							fos = new FileOutputStream(str);//���ϸ�
							
							System.out.println(str + "���� ���� ����!!");
							
						}else if(info.getCode()==110){//110 : ���� ������ ����
							
							if(fos==null)
								break;//���Ͼ����� ����
							
							fos.write(info.getData(), 0 ,info.getSize());//������ ������. 0~�����ŭ
							
							System.out.println(info.getSize() + "bytes �޴� ��...");
						
						}else if(info.getCode()==200){//200 : �������� ����(���ϸ� ����)
							
							if(fos==null)
								break;
							String str = new String(info.getData());//data���� ���ϸ� ����
							fos.close();
							System.out.println(str + "���� ���� ��");
						}
					}
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void serverStart(){
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);//���� ��ü ���� �� ��Ʈ����
			System.out.println("���� ���� ����");
			Socket sc = ss.accept();
			WorkThread wt = new WorkThread(sc);
			wt.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {

		new FileServerTest().serverStart();
	}

}
