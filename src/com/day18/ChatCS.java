package com.day18;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//UDP(�ٰŸ� ��Ÿ����� ���. ��������)
//��Ʈ��� IP
//IP:32bit �ּ�ü��
//A,B,C class 
//D class(224.0.0.0 ~ 239.255.255.255): IP �Ȱ��� �����ص� �浹�ȳ�. ���ͳݿ���x�̱� ����

public class ChatCS extends Frame implements Runnable,ActionListener{

	//���� ��������ǿ� ȣ��Ʈ�� ���� ����ڸ� ��� �ټ�ä��.
	
	private MulticastSocket ms = null;
	private InetAddress xGroup = null;
	
	private String host = "230.0.0.1";
	private int port = 7777;
	private String userName = "������̸�";
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	
	
	//DatagramSocket : UDP�� �����ͱ׷� ��Ŷ�� �����ϰų� ����
	//DatagramPacket : UDP�� �̿��Ͽ� ���۵� �� �ִ� ������
	//MulticastSocket : �ټ��� Ŭ���̾�Ʈ�� �����ͱ׷� ����
	
	//MulticastSocket : �������� �����̳� �����ͺ��̽����� ������ Ư����ġ�� �����ָ� Ŭ���̾�Ʈ�� �������� �����ؼ� �޾ư�
	
	public ChatCS(){//�⺻������. Ʋ����
		
		ta.setEditable(false);//�����ȵ�. ���⸸ ����
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("�׷�ä��");
		setSize(400,400);
		setVisible(true);
		tf.requestFocus();
	}
	
	public void setup(){
		
		try {
			xGroup = InetAddress.getByName(host);//DNS�� ���� IP�ּҸ� �޾� xGroup�� �Ҵ� 
			ms = new MulticastSocket(port);
			
			//Ư�� �׷쿡 ����
			ms.joinGroup(xGroup);//230.0.0.1 ip�� ���鼭 ��Ʈ��ȣ 7777�� ����� ����� ����
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection(){
		
		try {
			ms.leaveGroup(xGroup);//�׷쿡�� ������ ���� ����
			ms.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		new ChatCS().setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {//ä������
		
		String str = tf.getText().trim();//�о���鼭 ��������
		
		if(str.equals("")){
			return;
		}
		
		byte[] buffer = (userName+"]"+str).getBytes();//���ڿ��̹Ƿ� �迭 buffer�� �ֱ����� ����ȯ
		
		try {
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, xGroup, port);//���ۿ� �ִ� ������ �� ���̸�ŭ xGroup(host), port�� ����
			ms.send(dp);
			tf.requestFocus();
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void run() {//ä�ù���
		
		try {
			//ä���� ���������� �𸣴ϱ� ������ ���� ���ѷ���
			while(true){
				byte[] buffer = new byte[512];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ms.receive(dp);
				String str = new String(dp.getData()).trim();
				ta.append(str + "\r\n");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			disConnection();//���� �߻��ؼ� ���� ����
		}
	}

}
