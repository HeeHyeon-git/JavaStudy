package com.score2;

public class ScoreMain {

	public static void main(String[] args) {
		
		ScoreImpl ob = new ScoreImpl();
		//Score ob = new ScoreImpl(); �̰ŵ� ����. ����Ŭ������ Score�� upcast
		ob.set();
		ob.input();
		ob.print();
		
	}

}
