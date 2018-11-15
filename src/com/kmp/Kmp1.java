package com.kmp;

public class Kmp1 {

	/**
	 * 
	 * �����ƽⷨ
	 * 
	 * @param ts
	 *            ����
	 * 
	 * @param ps
	 *            ģʽ��
	 * 
	 * @return ����ҵ��������������е�һ���ַ����ֵ��±꣬����Ϊ-1
	 */

	public static int bf(String ts, String ps) {

		char[] t = ts.toCharArray();

		char[] p = ps.toCharArray();

		int i = 0; // ������λ��

		int j = 0; // ģʽ����λ��

		while (i < t.length && j < p.length) {

			if (t[i] == p[j]) { // �������ַ���ͬ���ͱȽ���һ��

				i++;

				j++;

			} else {

				i = i - j + 1; // һ����ƥ�䣬i����

				j = 0; // j��0

			}

		}

		if (j == p.length) {

			return i - j;

		} else {

			return -1;

		}

	}

}
