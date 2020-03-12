package com.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServerTest {

	// Ŭ���̾�Ʈ�� ������ ������ ���� �����
	private List<Socket> client = new ArrayList<Socket>();
	
	/**
	 * ���� ���� �� Ŭ���̾�Ʈ�� ��û�� ��ٸ���. ������ �����Ǹ� WorkThread�� �Ҵ��Ѵ�.
	 */
	public void serverStart(){		
		try (//��Ʈ ���� �� ���� ���� ��ü ����.
			ServerSocket serverSocket = new ServerSocket(5555);) {		
			System.out.println("��������...");
			
			while(true){//�� ���� �������� �𸣴� ���ѷ���
				Socket socket = serverSocket.accept();//Ŭ���̾�Ʈ�� ���ӵǾ������� ����, ���� ����. ������ ���ϸ� ������ �����̹Ƿ� ���ѷ���.
				WorkThread wt = new WorkThread(socket);//�ο�����ŭ ���� �����ϵ���, �����嵵 �ο�����ŭ �������. ������� ���Ҷ����� ������ ������ ����
				wt.start();//������ ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �޼��� �ۼ��� �۾��� ���ϴ� ������ ��ü 
	 */
	class WorkThread extends Thread{
		
		private Socket sc;				//���� �ʱ�ȭ
		public WorkThread(Socket sc){	//�����ε��� ������
			this.sc = sc;
		}
		
		@Override
		public void run() {
			String ip = null;
			String msg = null;

			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				ip = sc.getInetAddress().getHostAddress();//ip�� ȣ��Ʈ �о��
				client.add(sc);//����Ʈ�� ������� ������ ����
				
				//����˸�
				msg = ip +"]�� ���� �߽��ϴ�!";
				for(Socket s: client){//����ڰ� �����ߴٴ� �޼����� ��� ����ڿ��� msg �˷��� �� 
					if(s==sc){//���� ������ �ڽŰ� ����?
						continue;//�̹��� ���
					}
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//boolean autoFlush. �������� ������ ���
					pw.println(msg);
				}
				//�������� ����˸�
				System.out.println(msg);
				
				//��ȭ : �����尡 �����ϱ� ������ ���� ��ġ�� ����
				while((msg=br.readLine())!=null){
					
					for(Socket s: client){//ä�ý� �ڽ��� ������ ����鿡�� ������ ��
						if(s==sc){//���� ������ �ڽŰ� ����?
							continue;//�̹��� ���
						}
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//boolean autoFlush
						pw.println(msg);
					}
					System.out.println(msg);//�����������
				}
			
			} catch (Exception e) {
				
				//����(�������)
				msg = ip +"]�� ���� �߽��ϴ�!";
				try {
					for(Socket s: client){
						if(s==sc){
							continue;
						}
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					System.out.println(msg);//�����������
					sc =null;//���������� ���� �ʱ�ȭ. �׷��� �������� ���� ����

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * ���ø����̼��� �����Ǹ� main���� ���� ���� ã�ư��� �ǰ� serverStart�޼ҵ��� �����Ѵ�. 
	 */
	public static void main(String[] args) {
		new MultiServerTest().serverStart();
	}

}
