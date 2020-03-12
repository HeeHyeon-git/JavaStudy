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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Frame implements ActionListener, Runnable{//�����������̽� 
	
	private static final long serialVersionUID = 1L;
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//������ �������ϰ� ���� �Ѵ� �ʿ�
	private ServerSocket ss = null;
	private Socket sc = null;
	//Socket�� ��ܼ� �����ؾ� �ϴ� ���� : ����ip, ��ip, data, port
	//Port��ȣ 0~65535. 0~2000�� ��κ� OS���� ���
	//TCP-IP�� ������� IP�� �ݵ�� �޾ƿ��� �Ǿ�����
	
	/**
	 * ������. ActionListener ���� 
	 */
	public ServerTest(){
		
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
		
		setTitle("ä�ü���");
		setSize(300,400);
		setVisible(true);
	}
	
	/**
	 * ���ø����̼��� �����Ǹ� main���� ���� ���� ã�ư��� �ǰ� serverStart�޼ҵ��� �����Ѵ�. 
	 */
	public static void main(String[] args) {
		new ServerTest().serverStart();
	}
	
	/**
	 * ���� ���� �� Ŭ���̾�Ʈ�� ��û�� ��ٸ���. ������ �����Ǹ� Thread�� �Ҵ��Ѵ�.
	 */
	public void serverStart(){
		
		try {
			ss = new ServerSocket(5555); //������Ʈ��ȣ
			ta.setText("��������!!");
			
			//Ŭ���̾�Ʈ�� ������ �ؾ� ������. ���������� ������ ����
			sc = ss.accept(); //accept(): �������ϰ� ������ ����
			
			Thread th = new Thread(this);//ä�ý� �����϶�� ������ ����
			th.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ä��â �����͸� �����Ѵ�.  
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText();
		if(str.trim().equals("")){//�������� �� ���ڿ� ���� null�̸� ����������
			return;
		}
		
		if(sc==null){
			return;
		}
		
		try {
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);//���⼭ true�� auto flush�� �ش�. flush�� enter�� ������ �� 
			pw.println("[����]" + str);
			
			ta.append("\r\n [����] " + str);
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {				//�����͸� �����ٰ� ���� �߻���
			ta.append("\r\n Ŭ���̾�Ʈ�� ���� ����!!");
			sc = null;							//������ ���۽� ���ϸ� ����ϹǷ� ���ϸ� �ʱ�ȭ
		}
	}
	
	/**
	 * ä��â �����͸� �����Ѵ�.	
	 */
	@Override
	public void run() {
		String str;
		String ip;
		
		try {
			if(sc==null){//������ null�̸� Ŭ���̾�Ʈ�� ������ ���� ����
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			ip = sc.getInetAddress().getHostAddress();//client IP
			
			ta.append("\r\n["+ip+"] ����!");//�ٹٲ��۾�+��������Ӿ˸�
			
			while((str=br.readLine())!=null){
				ta.append("\r\n" +str);
			}
			
		} catch (Exception e) {
			ta.append("\r\n Ŭ���̾�Ʈ ���� ����!");
		
			//��Ʈ��ũ���� ���ϵ� �ʱ�ȭ ���� ���������� �����Ⱚ �������.  
			sc = null; 
			ss = null;
		}
	}

}
