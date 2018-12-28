package com.day15;

import java.io.File;
import java.io.FileFilter;

//FileFilter �������̽� : ������ ��ü�� �����ִ� ������ ��
class MyFileList implements FileFilter{

	private File f;
	//Spring ����������
	public MyFileList(String filePath) {//�����ڿ��� Ư�� ������ ��ü�� ������ �� ����. �߿�
		f = new File(filePath);//���ϰ�θ� �Է¹޾� ���� f ��ü ����
	}
	
	public void result(){
		
		try {
			
			if(!f.exists()){//���� ������ �޼��� ���� ����.
				System.out.println("������ �����ϴ�.");
				return;
			}
			
			System.out.println("������: " + f.getAbsolutePath());
			System.out.println("���ϻ�����: " + f.length());

			//���丮(����)�� ��� ����
			if(f.isDirectory()){//isDirectory�޼ҵ�. boolean��ȯ. ������ T, ������ F
			
				//File[] : D����̺긦 Ŭ�� ������ ���� �پ�. ������ �迭���� �־���� ����  
				//accept�޼ҵ忡�� FileFilter �������̽��� ������ ����� ����
				File[] lists = f.listFiles(this);	//accept�޼ҵ带 ���� ����� ������ this�� ����
				
				System.out.println("\n������ ����.........");

				for(int i=0;i<lists.length;i++){
					System.out.print(lists[i].getName());
					System.out.println("\t" + lists[i].length());
				}
			
			}
			
			System.out.println("\n���丮 ����....");
			
			File[] root = File.listRoots();//FileŬ������ static�޼ҵ� : listRoots
			
			for(int i=0;i<root.length;i++){
				System.out.println(root[i].getPath());
			}
			//C:
			//D: �������� ������ ��
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	@Override
	public boolean accept(File pathname) {	//accept()�޼ҵ� ȣ������ �ʾƵ� ������ �����. �ϵ��ũ�� ���� ����ڰ� �Է��� ���ϰ� ������ ������ ����. �޾Ƽ� this�� ���ϰ� ��ȯ.
		return pathname.isFile() || pathname.isDirectory() ;
	}
	
}

public class Test14 {

	public static void main(String[] args) {
		MyFileList m = new MyFileList("c:\\windows");
		m.result();
	}

}
