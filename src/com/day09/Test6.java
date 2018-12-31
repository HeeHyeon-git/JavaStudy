package com.day09;

//StringBuffer - ����ȭ����O(builder���� ����)
//StringBuilder - ����ȭ����X(�������� �ʾ� ����)
//���� �� Ŭ������ import���� �ʾƵ� ��밡��! -> ��, �Ѵ� lang�� �ִ�. 
//���� �ϴ� ������ �ٸ�
//����ȭ ���� ���ο� ���� �����Ͽ� ����ϸ� ��

public class Test6 {
	
	public void stringTime(){ //�����Ⱚ�� ���̻���, a, aa, aaa, aaaa ... ��� �����.
		
		System.out.println("stringTime...");
		//long start = System.currentTimeMillis(); //�ý����� �ʽð��� ��ڴ�
		long start = System.nanoTime(); //���۽ð� 
		String str = "A";
		for(int i=1;i<50000;i++){
			str+="A";
		}
		long end = System.nanoTime(); //����ð�
		System.out.println("����ð� : "+ (end-start));	

	}

	public void stringBufferTime(){ //������Ű�� ��. append�޼ҵ� �̿�.
	
		System.out.println("stringBufferTime...");
		long start = System.nanoTime(); //���۽ð� 
		
		StringBuffer str = new StringBuffer("A");
		
		for(int i=1;i<50000;i++){
			str.append("A");
		}
		long end = System.nanoTime(); //����ð�
		System.out.println("����ð� : "+ (end-start));	
	
	}
	
	public void stringBuilderTime(){
		System.out.println("stringBuilderTime...");
		long start = System.nanoTime(); //���۽ð� 
		
		StringBuilder str = new StringBuilder("A");
		
		for(int i=1;i<50000;i++){
			str.append("A");
		}
		long end = System.nanoTime(); //����ð�
		
		System.out.println("����ð� : "+ (end-start));	
	}
	
	public static void main(String[] args) {
		
		Test6 ob = new Test6();
		ob.stringTime();
		ob.stringBufferTime();
		ob.stringBuilderTime();
	}

}
