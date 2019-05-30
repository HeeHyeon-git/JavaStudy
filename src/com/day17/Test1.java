package com.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/*
 * ��������. ��űԾ�
 * TCP/IP : ���� �����͸� �ְ� ���� �� ���. ���ͳ��� �⺻ ���������� ��
 * TCP:�����͸� ������ ����(��Ʈ�� ����), IP: ���� ��/�� ������ �����ϴ� ����
 * 
 * InterNIC : International Network Information Center.
 * InterNIC���� �پ��� �������� ���� com org edu net
 * 
 */
public class Test1 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String host;
			
			System.out.print("ȣ��Ʈ[www.naver.com]: ");//www.naver.com ������ www�� ������
			host = br.readLine();
			//InetAddress �̸� ���� �۾��� ����
			InetAddress ia = InetAddress.getByName(host); //This class represents an Internet Protocol (IP) address. IPv4-32bit, IPv6-128bit. 
			System.out.println("Ip�ּ�: " + ia.getHostAddress());//DNS�� �ּҸ� �������� ip�� host�� �о��
			System.out.println("ȣ��Ʈ: " + ia.getHostName());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
