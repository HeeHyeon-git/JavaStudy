package com.day10;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test5 {

	public static void main(String[] args) {		
		//CalendarŬ����. ���� ���� �޼ҵ�
		//���� ��ǻ�� �ý����� ��¥ �� �ð��� ����
		
		//Calendar now = new Calendar();�� �Ʒ����� �ǹ̰� ����
		Calendar now = Calendar.getInstance(); //instance -> ��ü�� ����ؾ߸� �� �� �ִ� ����
		
		//Calendar now = new GregorianCalendar();  // upcast
		//�θ�                �ڽ�
		//GregorianCalendar now1 = new GregorianCalendar(); GregorianCalendar�� �θ�Ŭ������ Calendar�̹Ƿ� 
		//�θ�Ŭ������ �޼ҵ� ��� ���� 
		
		int y = now.get(Calendar.YEAR);					//��
		int m = now.get(Calendar.MONTH)+1;  			//��. 0-11�� ���ڸ� ������ ����
														//�������� +1 (�־��ٶ��� ��-1 ���ָ��)
		int d = now.get(Calendar.DAY_OF_MONTH);			//��
		int w = now.get(Calendar.DAY_OF_WEEK);			//���Ǽ�(1-7: 1�Ͽ��� ~ 7�����)
		
		char[] yoil = {'��','��','ȭ','��','��','��','��'};
		
		System.out.println(y + "-" + m + "-"+ d + "-" + yoil[w-1]);
		
		//���� ��������
		int firtDay = now.getActualMinimum(Calendar.DATE); //1. �Ź� �Ȱ����� �׳� ���� 1���°� ����
		int lastday = now.getActualMaximum(Calendar.DATE); //�Ŵ� ������ �ٸ�
		
		System.out.println(firtDay + " : " + lastday);
		//CalendarŬ������ �����ϱ� �Ŵ� ������ ������ ����� �ʿ䰡 ����.
			
		System.out.printf("%tF \n",now);					//2018-12-12
		System.out.printf("%tT \n",now);					//14:04:54
		System.out.printf("%1$tF %1$tT \n",now);			//2018-12-12 14:04:54. 1$�� �ڿ� �ִ� �μ��� �ϳ��ϱ� �����ŷ� ���
		
		//����ڰ� �Է��� ����, ��, �ϼ�
		now.set(2019,10-1,10);//�����ε��� �޼ҵ� ����. ��������� -1����� ��(0~11���� ����)
		y = now.get(Calendar.YEAR);			
		m = now.get(Calendar.MONTH)+1;  	
		d = now.get(Calendar.DAY_OF_MONTH); 
		w = now.get(Calendar.DAY_OF_WEEK);
			
		System.out.println(y + "-" + m + "-"+ d + "-" + yoil[w-1]); //����10��10���� �����
		
	
	
	
	}

}
