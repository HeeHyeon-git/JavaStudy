package com.day08;

//�Ǻθ� �Լ�(����Լ�)
//���� : �ҽ��� ��������. �ҽ��� ª��
//���� : ó���ӵ��� ����(stack�� �����ߴٰ� ����ϱ� ������)

//�������μ�
public class Test4 {

	public void print(int n){		
		if(n!=1){
			print(n-1); //�Ǻθ��Լ�, �޼ҵ�ȿ��� �Լ�ȣ��� �ڱ� �ڽ��� �θ�	
		}
		System.out.printf("%5d",n);
	}
	
	public int sum(int n){
		//1-10������ ��
		return n>1 ? n+sum(n-1) : n;
	}
	
	public int pow(int a , int b){
		return b>=1 ? a*pow(a,b-1) : 1;//�޼ҵ�ȿ��� �ڱ��ڽ� ȣ�� = �Ǻθ��Լ�
		
	}
	
	//�������μ�
	int sum(int...args){
		
		int sum=0;
/*
 		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
*/
		for(int su: args){ //Ȯ��for�����ε� ��밡��
			sum += su;
		}	
		return sum;
	}
	
	public static void main(String[] args) {
		
		Test4 ob = new Test4();
		
		ob.print(5);
		System.out.println();
		
		int s = ob.sum(100);
		System.out.println(s);
		
		System.out.println("pow(2,10): " + ob.pow(2,10));
		
		//�������μ�
		int result;
		result = ob.sum(2,4,6,8,10); //�迭 �����ÿ��� ũ�⸦ �����ؾ� �Ǵµ� �������μ��� ������ �����ʾƵ� �迭ó�� ���갡��
		System.out.println(result);
		
		result = ob.sum(1,3,5,7,9,11,13,15,17);
		System.out.println(result);
		
	}

}
