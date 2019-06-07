package com.level1.day01;

/*
 * ���� ������ �Ǻ�
 ���� ����
 ������ ���� n�� ����, n�� � ���� x�� �������� �ƴ��� �Ǵ��Ϸ� �մϴ�.
 n�� ���� x�� �����̶�� x+1�� ������ �����ϰ�, n�� ���� x�� ������ �ƴ϶�� -1�� �����ϴ� �Լ��� �ϼ��ϼ���.

 ���� ����
 n�� 1�̻�, 50000000000000 ������ �����Դϴ�.
 * */
public class Solution11 {
	public long solution(long n) {
		long sqrt = (long) Math.sqrt(n);

		if (sqrt * sqrt == n)
			return (sqrt + 1) * (sqrt + 1);

		return -1;
	}
}
