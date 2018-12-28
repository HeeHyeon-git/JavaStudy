package com.score3;

public class ScoreVO {//VO : Value Object. 
					  //Data Transfer Object : DTO (DB�� ������ ��� )
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	

	//public ScoreVO(){} �⺻������ ���� ����	

/*	
	public ScoreVO(String hak, String name, int kor, int eng, int mat){ //�������̵�� ������. �����ʱ�ȭ	
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
*/	
	//private�� ������ ������ �� �ݵ�� �� ���� �ϳ��� Setter, Getter�� �ʿ��ϴ�. �����͸� ������� �� �ֵ���.
	//���콺 ��Ŭ�� source > Generate Getter and Setter : �� �������
	
	//Getter, Setter
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	//���δ� Getter, Setter�� �ϳ��� �ʿ��� �� ����
	public int getTot() {
		return kor+eng+mat;
	}
	
	
	@Override
		public String toString() {
		
			String str = String.format("%6s %6s %4d %4d %4d %4d %4f", hak, name, kor, eng, mat, getTot(), getTot()/3.0);
			
			return str;
	}

		
		

	
	
	
}
