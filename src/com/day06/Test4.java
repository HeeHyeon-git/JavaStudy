package com.day06;

public class Test4 {
	
	public static void main(String[] args) {
		
		//�迭�� �迭
		//  1 2 3 4 5 
		// 10 9 8 7 6
		// 11 12 13 14 15
		//�̷��� ��µǵ��� �����
		
		int[][] arr = new int[6][6]; //�̷��� ����ԵǸ� �迭�ȿ��� ��� 0�� �������	
		int i,j = 0 ; 
		int n=0;

		for (i = 0; i < 5; i++) {
						
			switch(i){
				case 0:
				case 2:
				case 4:
					for(j=0; j<5; j++){
						n++;
						arr[i][j] = n;
						arr[i][5] += n;
						arr[5][j] += n;
						arr[5][5] += n;	
					}break;
				
				case 1:
				case 3:
					for(j=4; j>=0; j--){
						n++;
						arr[i][j] = n;
						arr[i][5] += n;
						arr[5][j] += n;
						arr[5][5] += n;	
					}break;
			}
		}
	
		//���
		System.out.println("switch�� ����� ���");
		for(i=0;i<arr.length;i++){ //����� 6*6
			for(j=0;j<arr.length;j++){			
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		
		//���2
		int a[][] = new int[6][6];	//���ڸ� ���� �迭
		int k=0;					//����� ���� ���� ����	
		int sw=1;					//����,���� �����ϱ� ���� ����ġ����
		
		for(int x=0;x<5;x++){
			
			for(int y=0;y<5;y++){
				k++;
				if(sw==1){
					a[x][y] = k;
					a[5][y] += k;
				}else{
					a[x][4-y] = k;
					a[5][4-y] += k;
				}
				a[x][5] += k;
				a[5][5] += k;
			}
			sw = sw*(-1);
		}
		
		//���
		System.out.println("sw������ ����� ���");
		for(int x=0;x<6;x++){
			for(int y=0; y<6;y++){
				System.out.printf("%4d", a[x][y]);
			}
			System.out.println();
		}
		
		
	}//endmain

}//endclass
