package com.kmp;

public class GetNext {

	public static int[] getNext(char[] strKey) {
		//char[] strKey = ps.toCharArray();
		int[] next = new int[strKey.length];

		// 初始条件
		int j = 0;
		int k = -1;
		next[0] = -1;

		// 根据已知的前j位推测第j+1位
		while (j < strKey.length - 1) {
			if (k == -1 || strKey[j] == strKey[k]) {
				next[++j] = ++k;
			} else {
				// 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
				// p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]

				k = next[k];
			}
		}

		return next;
	}

}
