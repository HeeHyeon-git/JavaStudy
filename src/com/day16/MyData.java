package com.day16;

import java.io.Serializable;

// implements Serializable�� �ݵ�� �ۼ��Ǿ�� ��.
// ���������� �ʴ´ٸ� ����ȭ�� ���� �ʾ� writeObject�� �Է� �Ұ���

public class MyData implements Serializable{//VO���� �ϸ� ���� GETTER, SETTER, �����鸸 �־�� ������, ������ �߰��� ����.

	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient int age;
	private int score;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MyData(String name,int age ,int score){//�����ε��� ������. �ʱ�ȭ
		this.name = name;
		this.score = score;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("%6s %4d %4d��",name,age,score);
	}
	
}
