package com.score1;

public class ScoreMain {

	public static void main(String[] args) {
		
		Score ob = new Score();//ob��� �̸����� ��ü ����
		
		ob.set();
		ob.input();
		ob.print();
		//ob.ranking(); // ��ȸ�ȵ�. ��������. Score class���ΰ� �ƴϱ� ���� (���������� private)	
		//ob1�� 12byte����(� class���� 12byte ����):heap + �ڽ�(4byte):stack = 16byte
	
	}

}
