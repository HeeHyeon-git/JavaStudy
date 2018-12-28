package com.excep;

//��������� ������ ����� ���
public class Test1 {

	private int value;//��������. default�� 0
	
	public void setValue(int value) throws MyException{
		
		if(value<0){
			throw new MyException("���� 0���� �������� ����.");
			
		}else{
			this.value =value ; 
		}	
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main(String[] args) {

		Test1 ob = new Test1();
		
		try {
			
			ob.setValue(-20);
			
		} catch (MyException e) {
			System.out.println(e.toString());
			System.out.println("-----------------------------");
			//e.printStackTrace();
		}
		System.out.println(ob.getValue());
	}

}
