package com.victor.greedy;

import java.util.*;

import org.junit.Test;

/**
 * 贪心算法
 * 
 * 1）在对问题进行求解时，每一步选择都采用最好或者最优的选择，从而到中最终结果是最优的选择。
 * 2）贪婪算法所得到的结果不一定是最优解，但都是相对近似地最优的结果。
 * 
 * @Description 贪心算法
 * @author Victor
 * @date 2020年10月24日上午10:37:43.
 */

public class GreedyAlgeorithms {
	/* 例题1：集合覆盖问题
	 * 假设存在下面需要付费的广播台，以及广播台信号可以覆盖的地区，如何选择最少的广播台，让所有的地区都可以接到信号
	 * 广播台             覆盖地区
	 * K1		         北京，上海，天津
	 * K2                广州，北京，深圳
	 * K3                成都，上海，杭州
	 * K4                上海，天津
	 * K5                杭州，大连
	 * 
	 * 思路分析：
	 * 1）遍历所有的广播电台，找到一个覆盖了最多未覆盖地区的电台。
	 * 2）将这个电台加到一个集合中（比如ArrayList)，想办法把该电台覆盖的地区在下次比较时去掉。
	 * 3）重复第一步指导覆盖了全部地区。
	 */
	@Test
	public void test1() {
		//创建广播电台，放入到Map
		HashMap<String, HashSet<String>> broadCasts = new HashMap<String, HashSet<String>>();
		HashSet<String> hashSet1 = new HashSet<>();
         hashSet1.add("北京");
         hashSet1.add("上海");
         hashSet1.add("天津");
         
         HashSet<String> hashSet2 = new HashSet<String>();
         hashSet2.add("广州");
         hashSet2.add("北京");
         hashSet2.add("深圳");
         
         HashSet<String> hashSet3 = new HashSet<String>();
         hashSet3.add("成都");
         hashSet3.add("上海");
         hashSet3.add("杭州");
         
         
         HashSet<String> hashSet4 = new HashSet<String>();
         hashSet4.add("上海");
         hashSet4.add("天津");
         
         HashSet<String> hashSet5 = new HashSet<String>();
         hashSet5.add("杭州");
         hashSet5.add("大连");
         
         //加入到map
         broadCasts.put("K1", hashSet1);
         broadCasts.put("K2", hashSet2);
         broadCasts.put("K3", hashSet3);
         broadCasts.put("K4", hashSet4);
         broadCasts.put("K5", hashSet5);
         
         //allAreas 存放所有的地区
         HashSet<String> allAreas = new HashSet<String>();
         allAreas.add("北京");
         allAreas.add("上海");
         allAreas.add("天津");
         allAreas.add("广州");
         allAreas.add("深圳");
         allAreas.add("成都");
         allAreas.add("杭州");
         allAreas.add("大连");
         
         //创建ArrayList,存放选择的电台集合
         ArrayList<String> selects = new ArrayList<>();
         
         //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前没有覆盖地区的交集
         HashSet<String> tempSet = new HashSet<String>();
         
         //存储上一个集合的交集和此次交集的长度进行比较
         HashSet<String> preSet = new HashSet<String>();
         String maxkey;
         while(allAreas.size()>0) {
        	 maxkey =null;
        	 preSet = null;
        	 for(String key : broadCasts.keySet()) {
        		 tempSet.clear();
        		 tempSet.addAll(broadCasts.get(key));
        		 tempSet.retainAll(allAreas);
        		 
        		 if(maxkey!=null) {
        			 preSet.addAll(broadCasts.get(maxkey));
        			 preSet.retainAll(allAreas);
        		 }
        		 
        		 //核心代码
        		 if(tempSet.size()>0 && (maxkey == null || tempSet.size() > preSet.size())) {
        			 maxkey = key;
        		 }
        	 }
        	 
        	 if(maxkey!=null) {
        		 selects.add(maxkey);
        		 allAreas.remove(broadCasts.get(maxkey));
        	 }
         }
         System.out.print(selects.toString());
	}
	
}
