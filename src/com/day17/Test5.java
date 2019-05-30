package com.day17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private TextField tf;	//�ؽ�Ʈ �Է¹޴� �κ�
	private TextArea ta;	//�ؽ�Ʈ ���̴� �κ�
	private Button btn;		//��ư

	public Test5(){
		
		tf = new TextField();
		ta = new TextArea();
		btn = new Button("Ȯ��");
		
		add(tf,BorderLayout.NORTH);		//BorderLayout �ټ����� ��ġ���� ������ ����
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		tf.addActionListener(this);		//�ؽ�Ʈ �ʵ�,��ư���� �̺�Ʈ ���� Ȯ��
		btn.addActionListener(this);	//Listener�� Ư�� �̺�Ʈ�� ����� ��� ActionListener�� ������ �ִ� actionPerformed�޼ҵ忡 ����
		
		setTitle("������");
		setSize(200, 300);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new Test5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();//ActionEvent e �޾Ƽ� ob�� �Ҵ�
		
		if(ob instanceof Button || ob instanceof TextField){
			String str = tf.getText();
			if(!str.equals("")){//���� equals �޼ҵ�� �ν� �ȵ� �� ���� ->(!(str.equals("")||str==""))
				ta.append(str + "\r\n");
			}
			
			//�ؽ�Ʈ�ʵ� �ʱ�ȭ �� Ŀ��
			tf.setText("");
			tf.requestFocus();
			
		}
	}
	
}
