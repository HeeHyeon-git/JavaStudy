package com.day19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//regex : ����ȭǥ������ �ٷ�� ���� Ŭ����
//�ܾ ġȯ, �����ּ�����, ������ ����� ����, ���ϰ˻�

public class Test4 {
	
	public static void main(String[] args) {

		/*
		 *�ʿ��� �� ���ٽ��� api�� Ȯ���ؼ� Ȱ��
		 
			c[a-z]* : c�� �����ϴ� ���ܾ�(c, ca, caaa)
			c[a-z] : c�� �����ϴ� �α��� ���ܾ�(ca, ck)
			c[a-zA-Z0-9] : ca, cA, c4
			c. : c�� �����ϴ� �α���(ca,cB,c&)
			c.* : c�� �����ϴ� ��� ���� 
			c.*t : ct, chhhhhht, c77777t
			[b|c].* �Ǵ� [bc].* �Ǵ� [b-c].* : b, c, bbb, cccc
			[^b|c].* �Ǵ� [^bc].* �Ǵ� [^b-c].* : b�Ǵ�c�� ���۵Ǹ� �ȵ�
			.*c.* : c�� ���Ե� ��� ���ڿ�
			
			[\\d]+�Ǵ� [0-9]+ : �ϳ� �̻��� ���� 
		*/
		
		String[] str = {"bat", "baby", "bonus", "c", "cA", "c.", "c0", "car", "combat","count", "date","disc"};
		
		Pattern p;
		p = Pattern.compile("c[a-z]*");
		
		System.out.println("c[a-z]* ���....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("c[a-z]+");//2���� �̻�
		
		System.out.println("c[a-z]+ ���....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("c.");//2����
		
		System.out.println("c. ���....");
		for(String s:str){
			Matcher m = p.matcher(s);
			
			if(m.matches())
				System.out.print(s+" ");
		}
		
		System.out.println("\n------------------------");
		p = Pattern.compile("[\\w]+@[\\w]+(\\.[\\w]+)+");
		
		//�̸��ϰ���
		String[] mails = {"aaa@aaa.com", "@aaa.co.kr", "@bbb.com", "aaa@vvv.co.kr", "sss.co.kr", "abc@bbb"};
		
		// [\\w]+ : �ѱ��� �̻��� ��, ����
		// @
		// (\\.[\\w]+) : ��ȣ�ȿ� �ִ� ���� �ݵ�� �ѹ��� ��µǾ� ��
		// \\. : ��Ʈ
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		System.out.println("�̸��� ���� ���.... [\\w]+@[\\w]+(\\.[\\w]+)+");
		for(String s:mails){
/*
			Matcher m = p.matcher(s);
			if(m.matches())
				System.out.println(s);
*/
			if(Pattern.matches(pat, s))//Matcher ���ٷ� ����
				System.out.println(s);
		}
		
		
	}

}
