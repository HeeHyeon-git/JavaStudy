package com.day17;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test6 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private TextField[] tf = new TextField[4];//�ؽ�Ʈ �ʵ尡 100�� �ʿ��ϸ� 100�� ��������. �׷��� �迭 �̿�
	private Button btn1, btn2;
	private Label result = new Label("", Label.CENTER);
	
	public Test6(){//�⺻������
		
		String[] title = {"�̸�","����","����","����","����"};
		setTitle("����ó��");
		
		setLayout(null);//�������� ��ġ�ϰڴ�
		
		for(int i=0;i<5;i++){
			
			Label lbl = new Label();//�ݺ��� ����ϹǷ� �迭 �� �ʿ����
			lbl.setText(title[i]);
			lbl.setBounds(10, (i+1)*30, 50, 20);//��ǥ(x,y)�� 50*20ũ���� �ڽ��� ����
			add(lbl);

			if(i!=4){
				tf[i] = new TextField();//�迭�� ��ü������ �Ҵ�
				tf[i].setBounds(80, (i+1)*30, 70, 20);//��ǥ(x,y)�� 70*20ũ���� �ؽ�Ʈ�ʵ� ����
				tf[i].addKeyListener(new KeyHandler());
				add(tf[i]);
			}else{
				result.setBounds(80,(i+1)*30, 70, 20);
				add(result);
			}
		}
		
		btn1 = new Button("���");
		btn1.setBounds(180,30,60,20);
		add(btn1);
		btn1.addActionListener(this);
		btn1.addKeyListener(new KeyHandler());
		
		btn2 = new Button("����");
		btn2.setBounds(180,60,60,20);
		add(btn2);
		btn2.addActionListener(this);
		btn2.addKeyListener(new KeyHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(260, 180);
		setResizable(false);//ũ�⺯ȯ�Ұ�
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test6();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob instanceof Button){
			
			Button b = (Button)ob;//downcast Object->Button
			
			if(b==btn1){
				process();//�޼ҵ� ȣ��
			}else if(b==btn2){
				System.exit(0);
			}
			
		}
		
	}
	
	private void process(){
		
		int tot=0;
		try {
			
			for(int i=1; i<=3; i++){//�迭0�� �̸�. tf[1]~tf[3]�� �����ؼ� ���ؾ� ��
				tot+=Integer.parseInt(tf[i].getText());
				result.setText(Integer.toString(tot));
				//result.setText(""+tot);//������ null �� �������� String���� �ڵ����� �ٲ�
			}
			
		} catch (Exception e2) {
			result.setText("�Է� ����!!");
		}
		
	}
	
	class KeyHandler extends KeyAdapter{//�߻�Ŭ����

		@Override
		public void keyPressed(KeyEvent evt) {//�߻�޼ҵ� �������̵�
											  //�����ʰ� Ű���带 �Է��������� �̺�Ʈ�� �����ؼ� keyPressed�޼ҵ� ����
			Object ob = evt.getSource();
			
			if(evt.getKeyCode()!=KeyEvent.VK_ENTER){//VK:�������ִ� Ű���� �Է°��� ������
				return;
			}
			
			if(ob instanceof Button){
				Button b = (Button)ob; 	//downcast
				if(b==btn1){
					process();//������ ������ ���ϴ� �޼ҵ�
					btn2.requestFocus();	////��ư1->��ư2�� ��Ŀ���� �Űܶ�
				}
				return;
			}
			
			if(ob instanceof TextField){
				TextField t = (TextField)ob; //downcast

				for(int i=0;i<tf.length;i++){
					if(i!=3&&tf[i]==t){//i��3�� �ƴϸ鼭 & tf[i]�� t �ڱ��ڽ��� �´ٸ� ����
						tf[i+1].requestFocus();//������ �ؽ�Ʈ�ʵ忡 ��Ŀ���� �Űܶ�
						return;
					}else if(tf[3]==t){
						btn1.requestFocus();//��ư1�� ��Ŀ���� �Űܶ�
						return;
					}
				
				}
			}
		}
		
	}//end-KeyHandler
	
}//end-class
