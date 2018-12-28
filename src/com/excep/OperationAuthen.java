package com.excep;

//AuthenException ����ó�� Ŭ����
//OperationAuthen �˻��ϴ� ���� �޼ҵ� ���� ��
//main�� ���� ���� try-catch���� ����ϱ⵵ ������, �˻��ϴ� �޼ҵ带 ����ؼ� �����޼����� ��� ��

public class OperationAuthen {
	
	public void inputFormat(String str) throws AuthenException{
		
		String temp[] = str.split(",");
		if(temp.length!=2){ //�ΰ��� ���ڸ� �Է��� ��. split ������ �迭 ������� 2�� ���;� ��
			throw new AuthenException("�����Է� ���Ŀ���: " + str );
		}
	}
	
	@SuppressWarnings("unused") //������̼�. ������� ���� ������ ���ؼ� �ߴ� �����޼����� ���� �ʰڴ�.
	public void number(String str) throws AuthenException{
		
		try {
			if(str.indexOf(".")!=-1){//�Ҽ����� �Է��� �����Ͱ� ������ double���·� ����ȯ
				double num = Double.parseDouble(str);
			}else{//�������̸� integer
				int num = Integer.parseInt(str);
			}

		} catch (NumberFormatException e) {
			throw new AuthenException("���� ��ȯ �Ұ�: " + str);//�����߻��� AuthenException�� String������ ã�ư�
		}
		
	}
	
	public void operator(char ch) throws AuthenException{
		
		switch(ch){
		case '+': 
		case '-': 
		case '/': 
		case '*':
			return; //�����ڰ� �װ����� �ϳ��� �ش��ϸ� ��������. return���� ����.
		default:
			throw new AuthenException("������ ���� : " + ch);
		}
		
		
	}
	
	
}
