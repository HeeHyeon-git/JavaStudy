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
		//int start, end, sw, temp; 
		int n=0;
		//start = 0;
		//end=5; 
		//sw=1;
		
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
					}
				break;
				
				case 1:
				case 3:
					
					for(j=4; j>=0; j--){
						n++;
						arr[i][j] = n;
						arr[i][5] += n;
						arr[5][j] += n;
						arr[5][5] += n;	
					}	
				break;
			}
		}

/*		
 		for (i = 0; i < 5; i++) {		
			for (j=start; j!=end; j+=sw) {
				n++;
				arr[i][j] = n;
				arr[i][5] += n;
				arr[5][j] += n;
				arr[5][5] += n;	
			}
			
			temp = start;
			start = end;
			end = temp;
			sw=sw*(-1);	
		}	
*/
		
		//���
		for(i=0;i<arr.length;i++){ //����� 6*6
			for(j=0;j<arr.length;j++){			
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}		

		
	}//endmain

}//endclass
