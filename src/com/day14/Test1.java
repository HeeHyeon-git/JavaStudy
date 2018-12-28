package com.day14;

//Thread(������) : �ڹٷ� ��Ƽ�½�ŷ �ϴ� ���� �����ϰ� ����� ��ü
//������ => ���μ��� ���ο��� ����Ǵ� ��� ����
//CPU�� �����ؼ� ������ �ϳ��ϳ����� �۾��� ��Ŵ. ��������� �۾��� �Ҷ� ���� �ߺ����� ���� 

//V3 ���̷����˻��(�̰� �ϳ��� ���μ���) ���͸� �ѹ��� �� �˻縦 �ϰԵǸ� �ʹ� �����ɸ�.
//�������� ���͸� �����Ͽ� ���ÿ� �˻���. -> �̶� ���Ǵ� ������ ������

//���߽����� ���ÿ� ����� ���డ��. �����帶�� �����Ƽ� ������ ����Ǽ� ���ý������� ����
//Ŭ������ ���߻���� �ȵ�. ClassA extends ClassB,Thread <- �Ұ���! �̷��� Runnable �������̽� �̿�


//�����尡 �����̴� �⺻���� ����
class MyThread extends Thread {// ThreadŬ���� ��ӹ޾Ƽ� ��� ����
	private int num;
	private String name;

	public MyThread(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {// ThreadŬ����. �پ��� �޼ҵ� ����. ���� �߿��� �� run!. ������ ���� �ݵ�� ���� ��������� ��
		int i = 0;
		while (i < num) {

			System.out.println(this.getName() + ":" + name + i);
			i++;

			// run() �ȿ��� ������ try�ȿ� sleep�� �־�� ��!
			try {

				sleep(100); // 100-> 0.1��, 1000->1��. �޼ҵ尡 0.1�� ��ŭ ���� �ð��� ��

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}

public class Test1 {//t1�� t2�� ������ ���α׷�

	public static void main(String[] args) {

		System.out.println("main ����......");
		MyThread t1 = new MyThread(100, "ù��° : "); //t1�� ���� sleep 0.1�� ������ �ð��� t2�� �ö�. �׷��� ��ü���� �帧�� �����Ƽ� ����� �Ǵ� ��
		MyThread t2 = new MyThread(200, "�ι�° : ");
		
		t1.start();//������ȣ��޼ҵ�(run()�޼ҵ�)
		t2.start();
		
		//������ 3���� ����� �� (main, t1, t2)
		
		
		System.out.println("main ����......");

	}

}
