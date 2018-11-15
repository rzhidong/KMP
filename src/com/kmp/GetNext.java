package com.kmp;

public class GetNext {

	public static int[] getNext(char[] strKey) {
		//char[] strKey = ps.toCharArray();
		int[] next = new int[strKey.length];

		// ��ʼ����
		int j = 0;
		int k = -1;
		next[0] = -1;

		// ������֪��ǰjλ�Ʋ��j+1λ
		while (j < strKey.length - 1) {
			if (k == -1 || strKey[j] == strKey[k]) {
				next[++j] = ++k;
			} else {
				// �Ƚϵ���K���ַ���˵��p[0����k-1]�ַ�����p[j-k����j-1]�ַ�����ȣ���next[k]��ʾ
				// p[0����k-1]��ǰ׺�ͺ�׺������г��ȣ�������������ֱ�ӱȽ�p[next[k]]��p[j]

				k = next[k];
			}
		}

		return next;
	}

}
