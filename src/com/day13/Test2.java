package com.day13;

import java.util.Hashtable;
import java.util.Iterator;

//Map<Ű, ��> �������̽�
//list�� Map�� ���� ���� ����. �ӵ��� Map�� �� ����(�������� ����, key).
//Hashtable : Vector�� ����
//HashMap : ArrayList�� ����
//Ű�� �ߺ����� ���� �� ����.(Ű�� Set�̴�.)
//Ű�� �ߺ����� ������ ������ ���� ����ȴ�. 1 �̼���, 1 ȫ�浿 -> �Է� �� 1 ȫ�浿�� ����
// -> Ű�� ������ �����ȴ�.
//Map�� Iterator�� ����.(Set�� Iterator�� ���� ����)
//put(�Է�)
//get(���)
public class Test2 {

	public static final String tel[] = {"111-111","222-222","333-333","111-111","444-444"}; //key
	public static final String name[] = {"�����","�ڽ���","������","��ȿ��","õ����"};		//value
	
	public static void main(String[] args) {

		Hashtable<String, String> h = new Hashtable<String, String>(); //Map�� Hashtable ��ü ����. �������̽�. ��ó�� Hashtable -> Map���� ���� ����
		for(int i=0; i<name.length;i++){
			h.put(tel[i], name[i]);
		}
		
		System.out.println(h);//Map�� ��½�.. ��ǻ�Ϳ��� ������ ���·�... �ڱ⸾��� ������
		//�ߺ��� Ű �� 111-111 �̹Ƿ� ��ȿ���� ����
		//-----------------------------------------------
		
		String str; 
		str = h.get("111-111"); //key�� �ָ� value�� ��ȯ
		System.out.println(str);
		
		//Ű�� �����ϴ��� �˻�
		if(h.containsKey("222-222")){
			System.out.println("222-222 ����");	
		}else{
			System.out.println("222-222 ���� ����");
		}
		
		//Value�� �����ϴ��� �˻�
		if(h.containsValue("�� ����")){ //���� �����ϸ� ��ã�Ƴ�
			System.out.println("�־��!");
		}else{
			System.out.println("�����!");
		}
		
		//�����ͻ���
		h.remove("222-222"); //Ű���� �Ű������� ���. �ش� Ű���� value�� ����
		if(h.containsKey("222-222")){
			System.out.println("222-222 ����");	
		}else{
			System.out.println("222-222 ���� ����");
		}
		
		//Ű�� Set�̸�, Map�� Set�� �ߺ��� ������� �ʴ� �ڷᱸ���̴�.
		//Set�� Iterator�� �����ϹǷ� Hashtable �Ǵ� HashMap�� 
		//keyset()�޼ҵ�� Iterator�� ����Ѵ�.
		
		Iterator<String> it = h.keySet().iterator(); //key�� �ڷ������� �ۼ�
		//Set�� �������̽�
		
		while(it.hasNext()){
			String key = it.next();//key
			String value = h.get(key);//Map�� key���� ������ value ��ȯ
			System.out.println(key + ":" + value );

			
		}
		
		
	}

}
