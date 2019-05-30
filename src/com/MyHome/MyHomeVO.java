package com.MyHome;

import java.io.Serializable;

public class MyHomeVO implements Serializable {
	
	String name; // �α����� ���� name
	String phone;// �α��� ���� phone
	String id;
	String item; // ����Ʈ/���ǽ���/����/��/����
	String term; // ����/�Ÿ�/����/�ܱ��Ӵ� 
	String local;// ������, ������, ���ʱ�
	long price;	 // 0~5õ / 5õ~1��̸� / 1���̻�~5�� / 5���̻�
	int pop;
	
	public int getPop() {
		return pop;
	}
	public void setPop(int pop) {
		this.pop = pop;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		Won won = new Won();
		
		String str = String.format("  %3s     %5s     %3s     %7s    %10s", 
				 name, local, item, term, won.priceWon(price));
		return str;
		
	}
	
	public String toString2() {
		
		Won won = new Won();
		
		String str = String.format("     ����:%s, %s, %s, �ݾ�:%s  ", 
						local, item, term, won.priceWon(price), name);
		return str;
		
	}
	
	public String toString3() {
		
		Won won = new Won();
		
		String str = String.format("����:%s \n�ְ�����:%s  \n�������:%s  \n�ݾ�:%s", 
						local, item, term, won.priceWon(price));
		return str;
	}
	
	
	
}
