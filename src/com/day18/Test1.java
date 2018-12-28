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
import java.net.URL;

public class Test1 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private TextField tf;
	private TextArea ta;
	
	public Test1(){
		
		ta = new TextArea();
		add(ta);
		
		tf = new TextField();
		tf.addActionListener(this);
		add(tf,BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("HTML Viewer");
		setSize(400,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//https://www.naver.com : URL 
		//www->ȣ��Ʈ, naver.com->������
		
		try {
			String str;
			URL url = new URL(tf.getText());//tf�� ����ڰ� �Է��� ���� url�� ������
			
			ta.setText("");//���������� �ʱ�ȭ
			
			InputStream is = url.openStream();//url�� ���� ������ ��Ʈ���� inputstream�� �ٽ� ��Ƶΰڴ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(is));//��Ʈ��ũ�� ������ �����͸� 1byte�� �о br�� �Ҵ�
			
			while((str=br.readLine())!=null){
				if(ta.getText().equals(null)){
					ta.setText(str);
				}else{
					ta.setText(ta.getText() + "\r\n" +str);//���� �ؽ�Ʈ�� �о�ͼ� �����ؼ� ����ض� append�� ����
				}
			}
			is.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

}
