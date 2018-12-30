package day01;

import java.util.Scanner;

/*
 	��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
	�� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
	������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3���� (����^1 , ����^2 , ����^3 )���� ���ȴ�.
	�ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
	��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
	Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
	��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.
	0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
 */

public class Sol2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��Ʈ ���� �Է� :");
		String val = sc.nextLine();
		
		int len = val.length(); 	//�Էµ� ������ ����
		int step = 1;				//1:���� 2:���ʽ� 3:�ɼ�(#|*)
		int lenPos = 0;				//�Էµ� ���� ����
		
		int[] score = new int[3];	//����
		int scorePos = 0; 			//������ ������
		
		//1S2D*3T = 37 
		
		//�Էµ� ���̸�ŭ �ݺ� ����
		while(lenPos<len){
			String target = val.substring(lenPos, lenPos+1);
			
			if(step ==1){
				try {
					//1.1 1�ܰ� ����ó��. ���ڸ� �� �� �ִ�.
					score[scorePos] = Integer.parseInt(target);
					step++;
				} catch (Exception e) {
					//1.3 3�ܰ� �ɼ�ó��.
					if("*".equals(target)){
						//1.3.1 ��Ÿ��
						score[scorePos-1] = score[scorePos-1]*2;
						if(scorePos>1){
							score[scorePos-2] = score[scorePos-2]*2;
						}
						
					}else if("#".equals(target)){
						//1.3.2 ������
						score[scorePos-1] = score[scorePos-1]*(-1);
					}else{
						System.out.println("��ȿ�� ��Ʈ ������ �ƴմϴ�.");
						return;
					}
				}
				
			}else if(step==2){
				//1.2 2�ܰ� ����ó��. Single(S), Double(D), Triple(T) ������ ����
				if("S".equals(target)){
					//1.2.1 Single
					score[scorePos] = (int)Math.pow(score[scorePos], 1);
				}else if("D".equals(target)){
					//1.2.2 Double
					score[scorePos] = (int)Math.pow(score[scorePos], 2);
				}else if("T".equals(target)){
					//1.2.3 Triple
					score[scorePos] = (int)Math.pow(score[scorePos], 3);
				}else if("0".equals(target)){
					//1.1.1 10�� ó��
					//������ 0~10 ������ �����̱� ������ 0 �� ���� �� �ִ�.
					if(score[scorePos]==1){
						score[scorePos]=10;
						//2�ܰ� ó���� �ٽ��ϱ� ���ؼ� ���� ����
						scorePos--;
						step++;
					}
				}else{
					System.out.println("��ȿ�� ��Ʈ ������ �ƴմϴ�.");
					return;
				}
				scorePos++;
				step--;
			}
			//��������ó��
			lenPos++;
		}
		System.out.println(score[0]+score[1]+score[2]);
	}

}
