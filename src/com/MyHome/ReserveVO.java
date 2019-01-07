package com.MyHome;

import java.io.Serializable;

public class ReserveVO implements Serializable, Runnable {

	private static final long serialVersionUID = 1L;

	String buyerId;
	String sellerId;
	String buyerName;		//������
	String sellerName;		//�Ǹ���
	String buyerPhone;
	String sellerPhone;
	String item;
	String term;
	String local;
	long price;
	
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
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
		
		String str = String.format("�Ǹ���:%s[%s] \n������:%s[%s] \n%s���� %s[%s] %s \n�Ǹ��� ��ȭ��ȣ:%s \n������ ��ȭ��ȣ:%s", 
								sellerName, sellerId, buyerName, buyerId, local, item, term, won.priceWon(price), sellerPhone, buyerPhone);
		
		return str;
		
	}

	@Override
	public void run() {
		Won won = new Won();
		
		try {
		    System.out.println(".------------------------------------------------------.");
		    System.out.println("|                                                      |");
			Thread.sleep(100);
		    System.out.println("|                                                      |");
		    System.out.println("|        ��  ��  ��  ��  ��  ��  ��  ��  û  ��        |");
		    Thread.sleep(100);
			System.out.println("|                                                      |");
			System.out.printf("|   ���� : %3s                  �ְ����� :%4s   |\n",local, item);
			Thread.sleep(100);
			System.out.printf("|   ������� : %3s              ���� : %4s        |\n", term, won.priceWon(price));
			Thread.sleep(100);
			System.out.printf("|   �Ǹ��� : %4s              ��û�� : %4s     |\n", sellerName, buyerName);
			Thread.sleep(100);
			System.out.printf("|   �Ǹ��� ����ó:%10s                        |\n", sellerPhone);
			Thread.sleep(100);
			System.out.printf("|   ��û�� ����ó:%10s                        |\n", buyerPhone);
			Thread.sleep(100);
			System.out.println("|                	��� ������ �Ϸ� �Ǿ����ϴ�.   |");
			Thread.sleep(100);
			System.out.println(".-.     .-.     .-.     .-.     .-.     .-.     .-.    |");
			Thread.sleep(100);
		    System.out.println("   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'   `._.'");
			System.out.println("\n");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
