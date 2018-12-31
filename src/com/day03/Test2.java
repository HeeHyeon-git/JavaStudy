package com.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test2 {

	public static void main(String[] args) throws Exception {
		// throws IOException : ����ó��
		// java.lang.Exception : Exception Class Ȯ���ϸ� ����Ŭ���� ��� Ȯ�� ����
		// ���� ����ó������ Ŭ������ �𸣰ڴٸ� Exception ���� ó���ص� ��. ����Ŭ����.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int su, sum;
		char ch; // 'y' or 'n' �� �ܾ �ް��� ��

		// ���ѷ��� ���. ��� �̿��ؾߵǴ� ���
		while (true) {

			// ������ �����ϸ� ����ǰ� false�� ����.
			do {
				System.out.print("�� �Է����ּ��� : ");
				su = Integer.parseInt(br.readLine());
				// 100+enter �ԷµǸ� ���͸� ����� 100�Է�. br.readLine()�� ���ͱ��� �Է��� ��
			} while (su < 1 || su > 5000); //1���� �۰ų� 5000�� ���� ��� True�� �Ǽ� ����.

			sum = 0; // ���� �ʱ�ȭ. ������ ������ ���� �հ�� ó����

			// 1~su������ �հ�
			for (int i = 1; i <= su; i++) {
				sum = sum + i; // sum+=i
			}

			// ���
			System.out.println("1~" + su + "������ �� : " + sum);

			// ��� ���� ����
			System.out.print("��� �ҷ�?[Y/N]"); // YN,y,Y,n,N ������ enter�Է�
			ch = (char) System.in.read(); // �ϳ��� �����ڵ尪�� ���ڷ� ����ȯ���Ѽ� ch�� �����ض�

			if (ch != 'Y' && ch != 'y') {
				break;
			}// Y,y�� �ƴϸ� �����ϴ� ���ǹ� �ۼ�. ������ !=(����)�̸� &&�� �ۼ�. 2������ ���� ����

			System.in.skip(2);
			// System.in.skip(2); ������ NumberFormatException �߻�. 
			// �տ� null���� int������ ��ȯ�϶�� ��Ų�Ŵϱ�
			// Skips over and discards n bytes of data from this inputstream
			// enter�� �ش��ϴ� ASCII CODE : 10(Ŀ����������)�� 13(Ŀ���ٹٲ�). ���� ��� ����� ���ؼ� 2�� ����

		}// end~while

	}// end~main
}
