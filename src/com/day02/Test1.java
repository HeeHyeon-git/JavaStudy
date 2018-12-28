package com.day02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; //��Ŭ�������� ��� import�ؾ� �Ǵ��� �ڵ����� ���� �ۼ�����

//������ ����

class Test1  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
/*		
		System.in: stream .��ǻ�� ���� ��Ž� ����ϴ� ���������� ����. Ű����� �Է��� 1byte�� ������ �ν�
		String a 
		System.out.printf("ù��° �� �Է�?"); //50
		a = br.readLine();	
		num1 = Integer.parseInt(a);
		�� �ܰ踦 �ϳ��� ���� ��~ �Ʒ�ó��!
*/
		
		int num1, num2 ;

		System.out.printf("ù��° �� �Է�?"); 
		num1 = Integer.parseInt(br.readLine());
		//num1 = Double.parseDouble(br.readLine());
		
		System.out.printf("�ι�° �� �Է�?");
		num2 = Integer.parseInt(br.readLine());

		//����
		//int num3 = num1 + num2;
		//System.out.println(num3);
		
		//���+����
		System.out.printf("%d + %d = %d\t",num1,num2,(num1+num2));	
		System.out.printf("%d - %d = %d\n",num1,num2,(num1-num2));	
		System.out.printf("%d * %d = %d\t",num1,num2,(num1*num2));	
		System.out.printf("%d / %d = %d\n",num1,num2,(num1/num2));	
		System.out.printf("%d %% %d = %d\n",num1,num2,(num1%num2)); //�������� ���Ҷ� %	

		System.out.println("-------------------------------------------");
		
		//���ڸ� �ε�ȣ�� �񱳸� �ϸ� true(1), false(0) ���ڰ� ����.
		System.out.println("num1>num2:" + (num1>num2) ); // println������ �ε�ȣ�� �����ϴµ� ȥ���� �ü�����. ��ȣ�� �� �����ֱ�

		String str;

		//���׿����� a ? true : false -> a���� true�� �տ��� ���� false�� �ڿ��� ����
		str = num1%2==0?"¦��":"Ȧ��";
		//������ ������ ���� ���� ����. ������ �����ϱ� 2�� ����. �ڷ������� �ϳ��� ���� ����
		str = num1>0?"���":(num1<0?"Ȧ��":"0"); 		

		//A &&(and) B
		//A ||(or) B
		// == ���� != �����ʳ� 
		//���� ���ϴ� ����
		str = num1%4==0 && num1%100!=0 || num1%400==0? "����":"���";
		
		System.out.println(num1 + ":" + str);
		

	}
}
