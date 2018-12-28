package com.score1;

import java.util.Scanner;

public class Score {
	
	int inwon ;
	
	//int[] inwon = new int[3] //instance����. �迭
	//idx : 0 1 2
	//{����,����,����}
	
	Record[] rec;//Record��� ������ Ÿ���� ������ ������ �� �ִ� rec �迭 ����. Class�� �ڷ����̶�� ����. 
				 //{name, str[3], tot, ave, rank}�� ������ �� �ִ� �ڷ���
	
	//Record[] rec = new Record[3];
	//�迭�ε� classȰ���ؼ� ���� �� ����. ���ڵ� Ŭ���� ������ �����Ͱ� �迭�� �������.
	//idx : 0 1 2
	//{[name, score[3], tot, ave, rank], [name, score[3], tot, ave, rank], [name, score[3], tot, ave, rank]}
	//{record�� ù��° �ּ�,record�� �ι�° �ּ�,record�� ����° �ּ� }
	
	//ù��°�� ���� rec�� �̸��� ȣ���ϰ� �ʹ� : rec[0].name
	//����°�� ���� rec�� ���������� ȣ���ϰ� �ʹ� : rec[2].score[1]
	//�ι�°�� ���� rec�� ������ ȣ���ϰ� �ʹ� : rec[1].tot
	
	
	Scanner sc = new Scanner(System.in);
	//�ѹ��� set()�� input()�� ���ÿ� ������ �� �����Ƿ� ������ ������ �����ϰ� ����ص� ���� ����
		
	public void set(){
			
		do{
			System.out.print("�ο���?");//3
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		rec = new Record[inwon]; //��ü�� �����ؼ� �迭�ȿ� �ּҸ� ����. inwonũ���� �迭�� �������
		
	}
	
	public void input(){
		
		String[] title = {"����","����","����"};
		
		
		for(int i=0;i<inwon;i++){
		
			rec[i] = new Record(); //Record�� �ּҸ� ���� �� �ִ� �迭�� ������ ��. �ο����� ���� ��ü ����. �ݺ��� �ȿ� �־�� ��
		
			//rec[i] ���ÿ��� / new Record() heap����
			//{Record�ּ�, Record�ּ�, Record�ּ�} 
			System.out.print("�̸�?");//�̸�
			rec[i].name =sc.next();
			
			for(int j=0;j<3;j++){

				System.out.print(title[j]);
				rec[i].score[j] =sc.nextInt();//������
				rec[i].tot += rec[i].score[j];//���� 		
			}			
			
			rec[i].ave = rec[i].tot/3;//���
			
		}
		
	}
	
	private void ranking(){ //��ȯ�� ����. 	
		int i, j;
		for(i=0;i<inwon;i++){
			rec[i].rank = 1; //���� �� 1�� �ʱⰪ ����	
		}
		
		for(i=0;i<inwon-1;i++){
			for(j=i+1;j<inwon;j++){
				if(rec[i].tot >rec[j].tot){
					rec[j].rank++;					//������ ���� �ʿ� ���� +1				
				}else if(rec[i].tot<rec[j].tot){
					rec[i].rank++;					//������ ���� �ʿ� ���� +1
				}
			}
		}		
		
	}

	public void print(){
		
		ranking(); //print �޼ҵ忡�� ranking �޼ҵ带 ȣ���� �� �ִ�. �ܺη� ������� ���ϹǷ� ���� Ŭ�����ȿ��� ȣ��
		
		for (int i = 0; i < inwon; i++) {
			System.out.printf("%6s", rec[i].name);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%4d", rec[i].score[j]);
			}
			System.out.printf("%4d", rec[i].tot);
			System.out.printf("%4d", rec[i].ave);
			System.out.printf("%4d", rec[i].rank);
			System.out.println();
		}		
		
	
	}
	

}
