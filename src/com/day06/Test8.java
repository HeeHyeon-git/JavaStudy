package com.day06;

import java.util.Scanner;

//�ϳ��� Ŭ�������� ���� Ŭ������ ���� ��� public ���� �ȵ�
// Hap h = new Hap(); -> Class ���� �� ���ο� ��ü�� ������ ������ �״�� ����. �ݺ� ���� ����. �̰� �ٷ� ���뼺

class Hap{
	
	int su, sum;
	public void input(){
		
		Scanner sc =new Scanner(System.in);	
		System.out.print("����?");//100
		su=sc.nextInt();
		
	};
	
	public int cnt(){
		
		for(int i=1;i<=su;i++){
			sum+=i;		//sum�� �ʱ�ȭ �Ƚ��ѵ� �����ȳ�. ���������� 0���� �ʱ�ȭ�� �Ǿ�����
		}	
		return sum;
	}
	
	public void print(int sum){
		
		System.out.println("1~"+su+ "������ �հ�: "+sum);
	
	}
}

public class Test8 {

	public static void main(String[] args) {
		Hap h = new Hap();
		h.input();
		int sum = h.cnt();
		h.print(sum);

	}

}
