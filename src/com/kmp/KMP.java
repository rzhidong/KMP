package com.kmp;

public class KMP {
	
	public static void main(String[] args) {
		System.out.println(indexOf("111A1SS1DAAABDD11DA1D1ADAFDA1FDA1FA1FAFAFAAABAAABAAABAAADSSDSD", "AAABAAAD"));
	}
	
	public static int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = GetNext.getNext(ptn);
        while (i < sLen && j < pLen) {
            // ���j = -1,���ߵ�ǰ�ַ�ƥ��ɹ�(src[i] = ptn[j]),����i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // ���j!=-1�ҵ�ǰ�ַ�ƥ��ʧ��,����i����,j=next[j],����patternģʽ������j-next[j]����λ
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;
    }
	
	public static int[] getNext(char[] p) {
		// ��֪next[j] = k,���õݹ��˼�����next[j+1]��ֵ
        // �����֪next[j] = k,������next[j+1]��?�����㷨����:
        // 1. ���p[j] = p[k], ��next[j+1] = next[k] + 1;
        // 2. ���p[j] != p[k], ����k=next[k],�����ʱp[j]==p[k],��next[j+1]=k+1,
        // ��������,������ݹ�ǰ׺����,�� k=next[k],�����ж�,ֱ��k=-1(��k=next[0])����p[j]=p[k]Ϊֹ
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1; // next������next[0]Ϊ-1
        
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                // �޸�next������
                if (p[j] != p[k]) {
                    next[j] = k;// KMPStringMatcher��ֻ����һ��
                } else {
                    // ���ܳ���p[j] = p[next[j]],������������������������ݹ�,�� k = next[k],
                    // k = next[[next[k]]
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
	}
}
