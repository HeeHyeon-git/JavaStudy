package com.level1.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * ���ڿ� �� ������� �����ϱ�
���� ����
���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, 
�� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. 
���� ��� strings�� [sun, bed, car]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� u, e, a�� strings�� �����մϴ�.

���� ����
strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
��� strings�� ������ ���̴� n���� Ů�ϴ�.
�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
����� ��
strings	n	return
[sun, bed, car]	1	[car, bed, sun]
[abce, abcd, cdx]
 * */

public class Solution06 {

	public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
		int cnt = 0;
		for (int i = 0; i < strings.length; i++) {
			hm.put(i, strings[i].charAt(n-1));
		}
		
		Iterator it = sortByValue(hm).iterator();
        
        while(it.hasNext()){
            int idx = (Integer)it.next();
            //System.out.println(idx + " = " + hm.get(idx));
            answer[cnt++] = strings[idx];
        }

		return answer;
	}
	
    public static List<String> sortByValue(final Map map){
        List<String> list = new ArrayList<String>();
        list.addAll(map.keySet());
         
        Collections.sort(list,new Comparator(){
             
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v1).compareTo(v2);
            }
             
        });
        
        return list;
    }
    
    public static void main(String[] args) {
    	Solution06 s = new Solution06();
    	String strings[] = {"sun", "bed", "car"};
    	String answer[] = s.solution(strings, 2);
    	for(String str : answer){
    		System.out.print(str + " " );
    	}
	}

}