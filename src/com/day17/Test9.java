package com.day17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//Swing.
//AWT�� 80% ����.
//OS�� ������ ���� �ʴ´�.
public class Test9 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test9(){
		lbl = new JLabel("�޼���",JLabel.CENTER);
		getContentPane().add(lbl);
		
		JMenuBar mbar = new JMenuBar();//�޴��ٴ� �ϳ�, �޴��� �޴��������� ������ ����
		JMenu menu;					   //��Ŭ���������� file, Edit, Source, Refactor�� ���� �޴�
		JMenuItem mi;				   //�޴�Ŭ���� ���θ޴�
		
		menu = new JMenu("�޼��� ��ȭ����");//�޴�
		
		//�޼��� ��ȭ����(menu) Ŭ���� �޴��ȿ� ������ ������(MenuItem) ��
		mi = new JMenuItem("�޼���");
		menu.add(mi);
		mi.addActionListener(this);
		mi = new JMenuItem("�Է�");
		menu.add(mi);
		mi.addActionListener(this);
		mi = new JMenuItem("����");
		
		menu.add(mi);
		mi.addActionListener(this);
		
		mbar.add(menu);
		setJMenuBar(mbar);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("��ȭ����");
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test9();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();//Ŭ���� �޴��� �̸��� �ؽ�Ʈ�� ������
		
		if(str.equals("�޼���")){
		
			JOptionPane.showMessageDialog(this,"������ ũ��������!!","��ź��",JOptionPane.INFORMATION_MESSAGE);//�˾� ��. this-> �� form���� �����
		
		}else if(str.equals("�Է�")){
		
			String age = JOptionPane.showInputDialog(this,"����� ���̴�?","���� �Է�",JOptionPane.QUESTION_MESSAGE);
			lbl.setText("����� ���̴� " +age +"�� �̱���!");
		
		}else if(str.equals("����")){
		
			int result;
			result = JOptionPane.showConfirmDialog(this, "���α׷��� �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);//��,�ƴϿ�,��� ���
			
			System.out.println(result);//��0 �ƴϿ�1 ���2 -> �� ���ý� System.exit(0);
			
			if(result==JOptionPane.YES_OPTION){//result==0�� ����
				System.exit(0);
			}
		}
		
	}

}
