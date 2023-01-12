package com.victor.dp;

import java.util.Stack;

import org.junit.Test;

/**
 * 一，动态规划题目的特点
 * 1),计数型
 * 	  有多少种方式走到右下角
 * 	  有多少种方式选出k个数使得和是Sum
 * 2),求最大值和最小值
 *    从左上角走到右下角路径的最大数字和
 *    最长上升子序列长度
 * 3),求存在性问题
 *    取石子游戏，先取是否必胜
 *    能不能选出k个数使得和是Sum
 *    
 * 二，动态规划的解题思路
 * step1: 确定状态
 * 		  研究最优策略的最后一步
 * 		  化为子问题
 * step2: 转移方程
 *        根据子问题直接定义
 * step3: 初始条件和边界情况
 * 		  要细心，考虑周全
 * step4: 计算顺序
 * 		  如果要利用之前的计算结果，则要从序号小的开始计算，到最终序号大的结果
 * 
 * @Description Dynamic Programming
 * @author Victor
 * @date 2020年10月20日上午10:47:10.
 */

public class DynamicProgramming {
	
	//Coin Change
	/* You are given coins of denominations and a total amount of memory amount. 
	 * Write a function to compute the fewest number of coins that you need to 
	 * make up that amount. If that amount of memory cannot be make up by any 
	 * combination of the coins, return -1.
	 */
	@Test
	public void test1() {
		int[] A =new int[]{2, 5, 7};
		int M = 27;
		int n=coinNumber(A, M);
		System.out.print(n);
	}
	
	public int coinNumber(int[] A, int B){
		//0~n: n+1
		int[] f = new int[B+1];
		int n = A.length; //number of the available coins.
		
		//initialization
		f[0]=0;
		for(int i=1; i<=B; i++) {
			//先假设都拼不出来
			f[i]=Integer.MAX_VALUE;
			//last coin A[j]
			//f[j] = min{f[i-A[0]+1,~f[i-A[n]+1}
			for(int j=0; j<n; j++) {
				//无穷大+1会造成越界，也就是拼不出来（i-A[j]）
				if(i-A[j]>=0 && f[i-A[j]]!=Integer.MAX_VALUE) {
					f[i]=Math.min(f[i], f[i-A[j]]+1);
				}
			}
		}
		
		if(f[B]==Integer.MAX_VALUE) {
			return -1;
		}
		
		return f[B];
	}
	
	//Unique Path
	/*A robot is located at the top-left corner of a m*n grid.
	 * The robot can only move either down or right at any point in time.
	 * The robot is trying to search the bottom-right corner of the grid.
	 * How many possible unique paths are there?
	 * 
	 */
	@Test
	public void test2() {
		int a = uniquePaths(6, 5);
		System.out.print(a);
	}
	
	public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 || j==0) {
					f[i][j]=1;
				}
				else {
					f[i][j]=f[i-1][j]+f[i][j-1];
				}
			}
		}
		return f[m-1][n-1];
	}
	
	//Jump game
	/*Given an array of non-negative integers, you are initially positioned at the first
	 * index of the array.
	 * Each element in the array represents your maximum iump length at that position.
	 * Determine if you are able to reach the last index.
	 * 
	 */
	@Test
	public void test3() {
		int[] A = {2,3,1,1,4};
		if(canJump(A)) {
			System.out.print("it can jump.");
		}
	}
	
	public boolean canJump(int[] A) {
		int n=A.length;
		boolean[] f= new boolean[n];
		f[0]=true;
		
		for(int i=1; i<n; i++) {
			f[i]=false;
			for(int j=0; j<i; j++) {
				if(f[j] && j+A[j]>=i) {
					f[i]=true;
					break;
				}
			}
		}
		return f[n-1];
	}
	
	@Test
	public void test4() {
		System.out.print(removeKdigits("10200", 1));
		
	}
	
	  public String removeKdigits(String num, int k) {
	        if(num.length()==k){return "0";}
	        char[] ch = num.toCharArray();
	        char[] temp=new char[num.length()];
	        int count=0;

	        Stack<Character> s = new Stack<>();
	        s.push(ch[0]);
	        for(int i=1; i<ch.length; i++){
	            if(ch[i]<ch[i-1] && count!=k){
	                s.pop();
	                count+=1;
	                if(ch[i]=='0' && s.empty()){
	                    if(i+1==ch.length){
	                        return "0";
	                    }else{
	                        continue;
	                    }
	                }else{
	                    s.push(ch[i]);
	                }
	            }else{
	                s.push(ch[i]);
	            }
	        }

	        for(int i=0; i<num.length(); i++){
	            temp[i]=s.pop();
	        }
	        
	        
	        
	        return new String(temp);
	    }
	
}
