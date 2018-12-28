package com.day18;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest extends Frame implements ActionListener,Runnable{//�����������̽� 

	private static final long serialVersionUID = 1L;
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//Ŭ���̾�Ʈ�� ���ϸ� �ʿ�
	private Socket sc = null;
	private int port = 5555;
	private String host="192.168.16.16";//127.0.0.1(me, loopback�ּ�, ��Ʈ��ũ���� �ڱ��ڽ�)
	
	public ClientTest(){
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		//�ؽ�Ʈ�Է�â�� ������
		tf.addActionListener(this);
		
		//����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("ä��Ŭ���̾�Ʈ");
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClientTest().connect();
	}

	public void connect(){

		try {
			sc = new Socket(host, port);
			Thread th = new Thread(this);//ä�ý� �����϶�� ������ ����
			th.start();
			
		} catch (Exception e) {
			ta.append("������ �׾��ִ�!!");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ä��â �����͸� ���� �� ���
		String str = tf.getText();
		if(str.trim().equals("")){//�������� �� ���ڿ� ���� null�̸� ����������
			return;
		}
		
		if(sc==null){
			return;
		}
		
		try {
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);//���⼭ true�� auto flush�� �ش�
			pw.println("[Ŭ���̾�Ʈ]" + str);
			
			ta.append("\r\n[Ŭ���̾�Ʈ]" + str);
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {				//�����͸� �����ٰ� ���� �߻���
			ta.append("\r\n ������ ���� ����!!");
			sc = null;							//Ŭ���̾�Ʈ�� ���ϸ� ���. ���ϸ� �ʱ�ȭ
		}
	}
	
	@Override
	public void run() {
		
		//������� ä��â �����͸� ���� �� ���
		String str;
		try {
			
			if(sc==null){//������ null�̸� Ŭ���̾�Ʈ�� ������ ���� ����
				return;
			}
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			ta.append("\r\n ����!");//�ٹٲ��۾�+��������Ӿ˸�
			
			while((str=br.readLine())!=null){
				ta.append("\r\n" +str);
			}
		} catch (Exception e) {
			ta.append("\r\n ���� ���� ����!");
			
			//���� �ʱ�ȭ
			sc = null; 
		}
	
	}

}
