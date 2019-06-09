package com.level1.day04;

import java.util.*;

public class Solution01 {

	  public int[] solution(String[] students) {
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

	    int[] answer = new int[students.length];
	    int count;
	    int minus;
	    int noShow;
	    
	    for(int i=0;i<students.length;i++){
	        count=10;//�⺻���� 10��
	        minus=0;
	        noShow=0;
	        for(int j=0; j<10;j++){
	            if(students[i].charAt(j)=='A'){
	                count++;//�⼮
	            }else if(students[i].charAt(j)=='L'){
	                minus++;//����
	            }else if(students[i].charAt(j)=='P'){
	                count--;//-1��
	                noShow++;//�Ἦ
	            }
	        }

	        if( (minus/2)>0){
	            noShow += (minus/2);//���� 2���� 1�� �Ἦó��
	            count -= (minus/2);//���� 2���� ���� 
	        }

	        if(noShow>2)
	             count = 0;//�Ἦ 3�� �̻��� 0��

	        map.put(i+1,count);
	    }

	    Iterator it = sortValue(map).iterator();

	    int k=0;
	    while(it.hasNext()){
	       answer[k] = (int)it.next();
	        System.out.print(answer[k]);
	        k++;
	    }     
	    return answer;
	  }

	    //����
	    public List sortValue(HashMap map){
	        List<Integer> list = new ArrayList();
	        list.addAll(map.keySet());

	        Collections.sort(list,new Comparator(){
	            public int compare(Object ob1, Object ob2){
	                Object val1 = map.get(ob1);
	                Object val2 = map.get(ob2);               
	                return ((Comparable) val2).compareTo(val1);
	            }
	        });
	        return list;
	    }

	}