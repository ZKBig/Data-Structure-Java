package com.victor.strategymode;
/**
 * 策略模式
 * 1，说明：
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得他们可以相互替换。
 * 策略模式可以使得算法在不影响到客户端的情况下发生变化。
 * 
 * 策略模式是对算法的包装，是把使用算法的责任和算法本身分割开来，委派给不同的对象管理。策略模式通常把一个系列的算法包装到
 * 一系列的策略类里面，作为一个抽象策略类的子类。用一句话来说，就是：“准备一组算法，并将每一个算法封装起来，使得它们可以
 * 互换”。
 *
 * 2，这个模式涉及到三个角色：
 *　●　　环境(Context)角色：持有一个Strategy的引用。
 *　●　　抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 *　●　　具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 *
 *
 * @Description 
 * @author Victor
 * @date 2020年8月29日下午12:32:57.
 */

public class StrategyMode {
	
	/*
	 * 假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。
	 * 比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。
	 * 
　　  *  根据描述，折扣是根据以下的几个算法中的一个进行的：
　　  *  算法一：对初级会员没有折扣。
　　  *  算法二：对中级会员提供10%的促销折扣。
　　  *  算法三：对高级会员提供20%的促销折扣。
	 */

	//初级会员折扣类
	public static class PrimaryMemberStrategy implements MemberStrategy {

	    @Override
	    public double calcPrice(double booksPrice) {
	        
	        System.out.println("对于初级会员的没有折扣");
	        return booksPrice;
	    }
	}
	
	//中级会员折扣类
	public static class IntermediateMemberStrategy implements MemberStrategy {

	    @Override
	    public double calcPrice(double booksPrice) {

	        System.out.println("对于中级会员的折扣为10%");
	        return booksPrice * 0.9;
	    }
	}
	
	//高级会员折扣类
	public static class AdvancedMemberStrategy implements MemberStrategy {
		
	    @Override
	    public double calcPrice(double booksPrice) {
	        
	        System.out.println("对于高级会员的折扣为20%");
	        return booksPrice * 0.8;
	    }
	}
	
	//价格类
	public static class Price{
		private MemberStrategy strategy;
		
		public Price(MemberStrategy strategy) {
			this.strategy = strategy;
		}
		
		public double quote(double booksPrice) {
			return this.strategy.calcPrice(booksPrice);
		}
		
	}
	
	
	public static void main(String[] args) {
		//选择要创建的策略对象
		//创建环境
		Price price = new Price( new AdvancedMemberStrategy());
		//计算价格
		double quote = price.quote(300);
		
		System.out.println("图书的最终价格为"+quote);
	}
	
	
}


