package com.day16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test2 {

	public static void main(String[] args) {

		try {
		
			//�� ����ȭ
			FileInputStream fis = new FileInputStream("d:\\doc\\out7.txt");//out7���Ͽ� ����Ȱ� Hashtable
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Hashtable<String, String> h = (Hashtable<String, String>)ois.readObject();//downcast
			
			Iterator<String> it = h.keySet().iterator();
			
			while(it.hasNext()){
				String key = it.next();
				String value = h.get(key);
				System.out.println( key + " " + value);
			}
			
			fis.close();
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
