package com.day01;
class Test3  {
	
	public static void main(String[] args) {
		//main �޼ҵ�� ���α׷��� ������ �ǹ�

		////���� ������ �ѷ��� ���ϱ� ���� ���� ����. �ʱⰪ ���� ���ؼ� �����Ⱚ �������
		int r = 10;
		float area;
		float length; 
		//float area, length; ���ٷ� ���� ����
		// �Ǽ��� : float(100�ڸ����� ����), double(�� �̻� ���� ����) - ���尡�ɹ����� ������ �ι�!

		area = r * r * 3.14f; // float���� �ν��϶�� f�ٿ���!
		length = 2 * r * (float)3.14; // float���� �ν��϶�� (float)�ٿ���!
		
		//System.out.println(area);
		System.out.printf("������: %d, ����: %f\n",r, area); // %d ���� %f �÷� %g ����
		//�Ǽ��� ǥ���� �� �ִ� �������� 6��. ��ȣǥ�÷� �ϳ� �����ؼ� �ټ��� ǥ��
		//System.out.println(length);
		System.out.printf("������: %d, �ѷ�: %.2f\n",r, length);		//float�� �Ҽ������� �����ϴ°Ŵ� printf������ ������ println������ �ȵ�
		System.out.println("������: " + r + ", ����: " + area + ", �ѷ�: " + length );

/*	
		String�� Ŭ����. ���ڿ�. ""�� ��������� 
		char�� �ڷ���. ����. ''�� ��������� 

		�⺻�ڷ����� �� 8�� ����. boolean char byte short int long float double
		�����ڷ��� -> Ŭ����.  �迭, Ŭ����, �������̽� ���� �ֽ��ϴ�.
		���� �ƴ� �׿� ���� ���� �� �ּҸ� ������ �ֽ��ϴ�
*/
		

	}

}


