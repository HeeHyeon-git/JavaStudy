package com.day06;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

/*
 		�ֹε�Ϲ�ȣ ���� 
		jumin : 801112-1234567
		check : 234567 892345 ������ üũ�� ����	
		���� ������ ���� Ȯ�ΰ����� üũ�� ����
		�� = (8*2)+(0*3)+(1*4)+...+(6*5) ���η� ���ؼ� ���� ����
		n = 11 - ��%11
		n = n % 10
		n == 7(�ֹε�Ϲ�ȣ�� ��������) ��ġ�Ѵٸ� �ֹε�Ϲ�ȣ�� ����.
*/		
		Scanner sc = new Scanner(System.in);
		
		String jumin;
		int[] chk = {2,3,4,5,6,7,8,9,2,3,4,5};
		int i, tot, su;
		
		System.out.print("�ֹε�Ϲ�ȣ[xxxxxx-xxxxxxx]�� �Է��ϼ���. : ");//801112-1234567 �ּ�14�ڸ�
		jumin = sc.next();
		
		if(jumin.length()!=14){
			System.out.printf("�ٽ� �Է��ϼ���");
			//System.exit(0); //�ܼ� ���α׷��� �����ϴ� ��ɾ�. main�� ��������. 0���� yes�� �ν�
			return; //stop. ��ȯ������. ��������� �����ض�. �Ʒ��κ��� ������� ����. ���������� ����. 
		}
		
		tot=0;		
		//index : 01234567890123 �迭�� �ִ� ���� �Ϸķ� �ε����� �ο��ȴ�.
		//jumin : 801112-1234567
		//check : 234567 892345	
		
		for(i=0;i<12;i++){ // '-'�� �Ǹ��������� �����ϰ� �񱳶� 12�� �ݺ�.  
			if(i>=6){
				tot+=chk[i]*Integer.parseInt(jumin.substring(i+1,i+2));	// '-' ������ ����. �ֹι�ȣ ���ڸ�
			}else{ 
				tot+=chk[i]*Integer.parseInt(jumin.substring(i,i+1));	//�������
			}
		}
		
		su = 11 - tot % 11;
		su = su % 10;
		if(su == Integer.parseInt(jumin.substring(13))){// jumin.substring(13) : 13��°���� ������ 
			System.out.println("��Ȯ�� �ֹι�ȣ!");
		}else{
			System.out.println("Ʋ�� �ֹι�ȣ!");
		}	
		sc.close();
	}

	private static void extracted() {
		return;
	}

}

/*		
	String str = "seoul korea"; //StringŬ������ method�� substring���. ���� ����
				//012345678910 �����ε���
	System.out.println(str.substring(0, 3));
	System.out.println(str.substring(6, 8));
	//Returns a string that is a substring of this string. 
	//The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
	//API Ȯ���ϸ� endIndex�Է½� -1 ����� ���� �˼�����
	
	System.out.println(str.substring(6)); //�ε��� 6���� ������

*/