package com.day11;

//�߻�Ŭ���� �ȿ��� ������ �߻�޼ҵ尡 1�� �̻� �����ؾ� ��. 
//�Ϲ� �޼ҵ常 �ִٸ� ������ �ȳ����� �߻�Ŭ������ ���� �ʿ䰡 ����
abstract class SortInt{ //������ �����ϴ� Ŭ����
	
	private int[] value; //�迭�� ���� �� �ִ� ������ ����

	protected abstract void sorting(); //�߻� �޼ҵ�
	
	public void sort(int[] value){//�Ű������� �迭.

		this.value = value;
		sorting();//sort �޼ҵ�ȿ��� �߻�޼ҵ� sorting ȣ�� ����
		//�ڽ��� �θ�Ŭ������ ���� ��밡�������� �θ�� �ڽ�Ŭ������ ���� ����� �� ����.
		//abstract�� ���� ���������� �ڽ�Ŭ������ ���� ����Ѵ�.
		//�żҵ常�� ���ܰ� ����. 
	}
	
	public int length(){
		
		if(value==null){ //��ü������ new�� ����. �ʱⰪ�� null�� �Ǿ�����. �迭 ���� int���� 0. [0,0,0]
			return 0;
		}	
		return value.length; //�迭�ȿ� �ؽ��ڵ尡 ����ִٸ� �迭�Ǳ��̸� ��ȯ
	}

	protected final int compare(int i, int j) { //final�޼ҵ� : �ڽ�Ŭ������ �������̵� �Ҽ�����
		
		//compare�� 1�̸� ������������ -1�̸� ������������
		if(value[i]==value[j])
			return 0;
		else if(value[i]>value[j])	//����� �� 3���� ����. �ʿ��� �� 31,32�� �ڵ�
			return 1;
		else
			return -1;
	}
	
	protected final void swap(int i , int j) {
		int temp;
		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
	
	public void print() {
		if(value == null){
			return;
		}

		for(int n: value){
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
	
}

class SortTest extends SortInt{
	
	@Override
	protected void sorting() { //Override�� ������ �ڽ��� �޼ҵ� ȣ��
	
		//Selection sort
		for(int i=0; i<length()-1; i++){
			for(int j=i+1; j<length();j++){
				if(compare(i, j)>0){ //0���� ū ���� return���� 1 �϶� �ۿ� ����. �̶� swap�޼ҵ� �����ض�
					 swap(i, j);
				}
			}
		}		
	
	}

}

public class Test2 {

	public static void main(String[] args) {

		int value[] = {50,20,6,58,99};
		SortTest ob = new SortTest();
		ob.sort(value);
		ob.sorting();
		ob.print();
		
	}

}
