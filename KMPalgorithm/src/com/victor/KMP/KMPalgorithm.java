package com.victor.KMP;

import java.util.Arrays;

public class KMPalgorithm {
	
	public static void main(String[] args) {
		
		String str1 = "AAACBBCAABCCBABAA";
		String str2 = "ABCCBAAB";
		int [] next = CreateNextArray(str2);
		
		for(int i=0; i<next.length; i++) {
			System.out.print(next[i]);
		}
		
		System.out.print(KMP(str1, str2, next));
		
	}
	
	public static int KMP(String str1, String str2, int[] next) {
		for(int i=0, j=0; i<str1.length(); i++) {
			
			while(j>0 && str1.charAt(i)!=str2.charAt(j)) {
				j=next[j-1];
			}
			
			if(str1.charAt(i)==str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i-j+1;
			}
				
		}
		return -1;
	}
	
	//首先求出next数组
	public static int[] CreateNextArray(String s) {
		
		int[] next = new int[s.length()];
		next[0]=0;
		
		for(int i=1, j=0; i<s.length(); i++) {
			
			while(j>0 && s.charAt(i)!=s.charAt(j)) {
				j=next[j-1];
			}
			
			if(s.charAt(i)==s.charAt(j)) {
				j++;
			}
			next[i]=j;
		}
		
		return next;
	}

}
