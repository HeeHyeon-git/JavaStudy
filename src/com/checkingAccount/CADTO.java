package com.checkingAccount;

public class CADTO {
	
	//Member���̺�
	String id;
	String pwd;
	String name;
	String inputdate;
	
	//Account���̺�
	String accDiv;		//���� : �����/������
	String bank; 		//�����
	String accName;		//������
	String accno;		//���¹�ȣ
	String bankNick;	//���� ���� �̸�
	int accAmount;		//���±ݾ�
	
	//Card���̺�
	String card;		//ī����
	String cardName;	//������
	String cardno;		//ī���ȣ
	String cardNick;	//ī�� ���� �̸�
	int cardAmount;
	
	//CardWithdraw���̺�, AccountDisposit ���̺�, AccountWithdraw���̺�
	String CADate;		//��� ����
	String category;	//�������(�Ĵ�, ���� ��)
	int CAAmount;		//��/��� �ݾ�
	String CANick;		//ī��/���� ���� �̸�
	
	
	//Member���̺�
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
	//Account���̺�
	public String getAccDiv() {
		return accDiv;
	}
	public void setAccDiv(String accDiv) {
		this.accDiv = accDiv;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	
	public String getBankNick() {
		return bankNick;
	}
	public void setBankNick(String bankNick) {
		this.bankNick = bankNick;
	}
	
	public int getAccAmount() {
		return accAmount;
	}
	public void setAccAmount(int accAmount) {
		this.accAmount = accAmount;
	}
	
	//Card���̺�
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	
	public String getCardNick() {
		return cardNick;
	}
	public void setCardNick(String cardNick) {
		this.cardNick = cardNick;
	}
	
	public int getCardAmount() {
		return cardAmount;
	}
	public void setCardAmount(int cardAmount) {
		this.cardAmount = cardAmount;
	}
	
	//CardWithdraw���̺�, AccountDisposit ���̺�, AccountWithdraw���̺�
	public String getCADate() {
		return CADate;
	}
	public void setCADate(String cADate) {
		CADate = cADate;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getCAAmount() {
		return CAAmount;
	}
	public void setCAAmount(int cAAmount) {
		CAAmount = cAAmount;
	}
	
	public String getCANick() {
		return CANick;
	}
	public void setCANick(String cANick) {
		CANick = cANick;
	}
	
	public void printAcc() {
		System.out.printf("%6s����\t%10s\t%10s\t%20s\t%10d\t%8s\n",accDiv,bank,accName,accno,accAmount,bankNick);
		
	}
	
	public void printCard() {
		String str = "ī��";
		System.out.printf("     %6s\t%10s\t%10s\t%20s\t%10d\t%8s\n",str,card,cardName,cardno,cardAmount,cardNick);
		
	}
	
	public void print(){
		System.out.printf("%s %s %5s %10d %6s \n", id, CADate, CANick, accAmount, category);	
	}

}
