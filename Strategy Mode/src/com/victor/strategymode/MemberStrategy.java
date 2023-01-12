package com.victor.strategymode;


/**
 * 
 * @Description
 * @author Victor
 * @date 2020年8月29日下午10:33:01.
 */

//抽象折扣类
public interface MemberStrategy {
	
	public double calcPrice(double booksPrice);

}


