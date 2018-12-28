package com.day10;
//Singleton
//��ü�� ����ؼ� �����ϴ� ���� �ƴ϶�
//�ϳ��� �����ϰ� ������ ����ϴ� ����̴�.
//Static, Call by reference 
//�� ������ ���� ��ü�� singleton ��ü��� ��.
class Sing{
	
	private static Sing ob; //Ŭ������ �ʱⰪ�� null. �� ���¿����� null. static���� ��������Ƿ� �ٷ� �޸� �Ҵ�.
	
	public static Sing getInstance(){ //��ȯ���� �ڱ��ڽ�. Call by reference 
		if(ob==null){ 
			ob=new Sing();
		}
		return ob;
	}

}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance(); //static����. getInstance �޼ҵ� ����ؼ� ����
		Sing ob2 = Sing.getInstance(); 
		//Call by Reference
		//�ּҸ� ���� ������. ob, ob1, ob2 ��� ���� �ּ� ������ ����. static ����� �̿�
		//Singleton: static, call by reference�� �� ������ ��� �˾ƾ� ��� ����		
		if(ob1 == ob2){
			System.out.println("���ϰ�ü");
		}else{
			System.out.println("�ٸ���ü");
		}
		
	}

}
