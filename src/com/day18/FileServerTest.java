package com.day18;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//��Ʈ�� ������ ���� �� ���� ������ �����ϴ� ���� Ŭ���� 
//����ȭ�� �����͸� �����ϹǷ� ObjectOutputStream, ObjectInputStream �ʿ�(Serializable �ʼ�)
//��Ʈ��ũ���� �����͸� ���� ���� getInputStream, getOutputStream �޼ҵ� Ȱ��
public class FileServerTest {

	/**
	 * ������ �����ϴ� �۾��� �ϴ� ������ ��ü 
	 */
	class WorkThread extends Thread {// ���� Ŭ����. �̳� Ŭ���� 
	
		// ��������� ������ ������. 
		private Socket sc = null;

		// ������ 
		public WorkThread(Socket sc){
			this.sc = sc;
		}
		
		// WorkThread.start() �� �۾��� �����Ѵ�.
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

						// 100 : �������� ����(���ϸ� ����)
						if (info.getCode()==100) {
							String str =new String(info.getData());
							fos = new FileOutputStream(str);//���ϸ�
							
							System.out.println(str + "���� ���� ����!!");
						
						}
						// 110 : ���� ������ ����
						else if (info.getCode()==110) {
							if(fos==null)
								break;//���Ͼ����� ����
							
							fos.write(info.getData(), 0 ,info.getSize());//������ ������. 0~�����ŭ
							
							System.out.println(info.getSize() + "bytes �޴� ��...");
						
						}
						// 200 : �������� ����(���ϸ� ����)
						else if(info.getCode()==200) {
							if(fos==null)
								break;
							String str = new String(info.getData());//data���� ���ϸ� ����
							fos.close();
							System.out.println(str + "���� ���� ��");
						}
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���� ���� �� Ŭ���̾�Ʈ�� ��û�� ��ٸ���. ������ �����Ǹ� WorkThread�� �Ҵ��Ѵ�.
	 */
	public void serverStart(){
	
		try (//��Ʈ ���� �� ���� ���� ��ü ����.
			ServerSocket serverSocket = new ServerSocket(5555); 
			//Ŭ���̾�Ʈ�� ��û�� �ִ��� listen �ϴ� ���°� �ȴ�. ������ �����Ǵ� ���� ������ �����Ѵ�.
			Socket socket = serverSocket.accept();) {
			
			System.out.println(">> ���� ���� ����");
			WorkThread wt = new WorkThread(socket);
			wt.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ���ø����̼��� �����Ǹ� main���� ���� ���� ã�ư��� �ǰ� serverStart�޼ҵ��� �����Ѵ�. 
	 */
	public static void main(String[] args) {
		new FileServerTest().serverStart();
	}

}