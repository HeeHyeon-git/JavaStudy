package com.day15;

import java.io.File;
import java.io.FileOutputStream;

//���� �� ���ڸ� �Է��ϸ� ������ �Բ� ������ ������

public class Test13 {

	public static void main(String[] args) {

		String str = "d:\\doc\\java\\stream\\text.txt";
		//idx		  012 3456 78901 2345678 90			
		
		//[���1]
		String path = str.substring(0, str.lastIndexOf("\\"));
		//System.out.println(path); 	//d:\doc\java\stream ������ ���⿣ \\�ΰ����� ��ǻ�Ϳ����� \�� �νĵ�
		
		File f = new File(path);
		
		if(!f.exists()){//f�� ������ ���丮�� ������. Creates the directory named by this abstract pathname.
			f.mkdirs();
		}
		
		//----------------------------------------------------------
		//[���2]		
/*		
  		File d = new File(str);
		if(!f.getParentFile().exists()){ //f�� ������ ���丮�� ������ 
			d.getParentFile().mkdirs();
		}
*/		
		try {
			
			FileOutputStream fos = new FileOutputStream(str);
			System.out.print("���ڿ� �Է�:");
			
			int data;		//�����ڵ�(�ƽ�Ű�ڵ�)�� �����ϱ� int��
			while((data=System.in.read())!=-1){
				fos.write(data);
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
