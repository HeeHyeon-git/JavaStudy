package com.day07;

//static : �ڽ��� �˾Ƽ� �ε��� �ϰ� �Ǹ� �޸𸮿� �ö� �ִ�.
//new�� ���ؼ� ��ü�� �����ϸ� �޸𸮿� �ö�. static�� new�� �����ʾƵ� �˾Ƽ� �ö�
//1. �ڵ����� �޸� �Ҵ��� �޴´�.
//2. ��ü�� 100�� �����ص� �޸𸮰����� �ϳ��� �����ȴ�. ��� ����� �������� ����Ѵٶ�� ����

public class Test3 {
	
	//static�� �����ν� Ŭ������ �ε��Ǵ� ���� �޸𸮻� �̹� �ö����� int a �� print()
	//�������� ���� Ŭ�����ȿ��� �����ص����� 
	//int b�� write()�� �޸𸮻� �ø��� �ʾƼ� ���� �Ұ�
	
	public static int a = 10; 
	//class����. �ڽ��� �˾Ƽ� �޸𸮿� �ö�
	//static ������ Ư¡
	//Ŭ������ �ε��Ǵ� ���� �޸𸮿� �Ҵ� �Ǿ�����.
	//���ٹ�� : [Ŭ�����̸�.������] ���� �����Ѵ�
	//��, new�� ���ؼ� �޸� �Ҵ��� ���� �ʾƵ� ����� �����ϴ�.
	
	private int b = 20;
	//instance����. �޸𸮿� �ö󰡾߸� ����� �� �ִ�.
	//�޸𸮿� �ö󰡱� ���ؼ��� ���� ��ü ������ ���־�� �� 
	//�ݵ�� new�� ���ؼ� �޸� �Ҵ��� �޾ƾ� ��� �����ϴ�
	//���� Ŭ���� �޼ҵ忡�� ������ �����ϴ� 
	//-> write();�� ����������� ���ؼ��� �޸𸮿� �ε��� �ϰԵǴµ� �׶� ���ÿ� int b�� ���� �ε��ǹǷ� ����
	//Ŭ�����޼ҵ忡���� ������ �Ұ����ϴ�.
	//-> �޸𸮻� �̹� �ö� �ִ� class �޼ҵ忡�� instance������ ã�ԵǸ� ���� �޸𸮿� �ε����� �ʾ� ã�� ���ϱ� ����
	
	
	public void write(){//instance�޼ҵ�. Ŭ���������� �ν��Ͻ������� ��� ��밡��. 
		
		System.out.println("class ���� a: " + a);
		System.out.println("instance ���� b: "+ b);
		
	}
	
	public static void print(){//class�޼ҵ�. �̹� �޸𸮻� �ö� �ֱ� ������ static������ ����� �� ����  
		
		System.out.println("class ���� a: " + a);
		//System.out.println("instance ���� b: "+ b);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("main...");
		System.out.println("class ���� a: " + a); //class������ ��ü�� �����ϱ� ���� �ö󰡹Ƿ� ob.a�� ȣ������ ���� Ŭ������ �̸����� �ٿ���
		System.out.println("class ���� a: " + Test3.a); //����ٰ� this ���� �ȵ�. �̰� class����.
		
		//System.out.println("instance ���� b: "+ ob.b); ��ü������ ���� �Ͼ �Ŀ� �޼ҵ� ���� ����
		
		//write(); ����
		print(); //static�̹Ƿ� ����
		Test3.print(); //�̷��� ȣ�����ִ°� ����. class�޼ҵ�
		
		Test3 ob = new Test3(); //��ü����. �̷��� �Ǵ� ���� instance�޼ҵ�� instance������ �޸𸮻� �ö�
		
		System.out.println("instance ���� b: "+ ob.b);
		ob.write();
		System.out.println("class ���� a: " + ob.a); // ������ �ƴ����� Ŭ���������� ��ü������ �� ��...	
		ob.print();
		
		Test3 ob1 = new Test3();
		ob1.a = 100; // 10 -> 100
		ob1.b = 200; // ���� ��������Ƿ� ob.b �� ob1.b �޸𸮴� �ٸ�
				
		System.out.println("------------------------");
		
		System.out.println("ob1.a:"+ ob1.a);
		System.out.println("ob1.b:"+ ob1.b);

		System.out.println("------------------------");
		
		System.out.println("ob.a:"+ ob.a);//100  static�� ������ ���� �����̱� ������ ���� �����. 10���� 100���� �ٲ���� ����
		System.out.println("ob.b:"+ ob.b);//20		

		System.out.println("------------------------");
		ob.a=500;
		System.out.println("ob1.a:"+ ob1.a); //ob1.a �� ob.a�� ��������� ����. ���� ����Ѵ�. static�̱� ����
		System.out.println("ob.a:"+ ob.a);
		
		
	}

}
