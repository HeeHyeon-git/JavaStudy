package com.day12;

//����Ŭ����
//�͸���, Annonymous, ������ Ŭ����
//�޸� ���� ����. �ѹ� ����ϰ� ������ �ݺ�.
//�ȵ���̵忡�� ���� ���
//������ �� ��� Test4$1.class �� �������

public class Test4 {
	
	public Object getTitle(){

		return new Object(){//return���� ��ü. ��ü�� �̸��� ����. �޸��� ���� ������. �Ź� ����ϰ� ����. �ּҰ� ����Ǿ� ���� �ʾ� garbage collector�� ����.
			@Override
			public String toString() {
				return  "�͸���Ŭ����";
			}					
		};		
				
	}
	
	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		System.out.println(ob.getTitle());
	}

}
