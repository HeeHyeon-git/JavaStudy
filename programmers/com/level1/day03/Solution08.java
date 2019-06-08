package com.level1.day03;

import java.util.HashMap;
import java.util.Iterator;


//�Լ��� �ԷµǴ� �ð��� 12�ð� ǥ������� am,pm���� ǥ��ȴ�.
//ù��° �ð����� �ι�° �ð��� �� ������ �ɸ��� �ð��� ���϶�.
public class Solution08 {
	public int[] changeTimetoIntArr(String time){
		time = time.replaceAll(" ","");//
		String stringTime[] = new String[3];
		stringTime = time.substring(2).split(":");
		int intTime[] = new int[3];
		
		for(int i=0; i<3; i++){
			intTime[i] = Integer.parseInt(stringTime[i]);
		}
		
		//������ ��� 12�� ���ؼ� int�迭�� ��ȯ
		if(time.substring(0, 2).equals("PM")){
			intTime[0] += 12;
		}
		return intTime;
	}
	
	public String solution(String start, String end){
		String answer = "";
		int endTime[] = changeTimetoIntArr(end);
		int startTime[] = changeTimetoIntArr(start);
		int result[] = {0,0,0};
		
		for(int k=2;k>0;k--){
			result[k] += endTime[k] - startTime[k];
			if(result[k]<0){
				result[k-1]--;
				result[k] += 60;
			}
		}
		
		result[0] = endTime[0] - startTime[0];
		if(result[0]<0){
			result[0] += 24;
		}
		
		for(int i=0; i<3; i++){
			if(result[i]<10){
				answer += "0"+result[i];
			}else{
				answer += result[i];
			}
			if(i!=2)
				answer +=":";
		}
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Solution08 gapCalculator = new Solution08();
		String start = "AM 01:30:50";
		String end = "PM 05:00:00";
		gapCalculator.solution(start, end);
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();		
		System.out.println("----------------------------");
		
	}
}
