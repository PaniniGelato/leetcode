/*
 * 版权所有 (C) 2014 中国南方航空股份有限公司。
 * 本文件可能包含有南方航空公司的机密或专有信息。
 * 未经许可不得擅自公开、复制这些机密资料及其中任何部分，
 * 只可按照其使用许可协议，在南方航空公司内部使用。
 *
 * File Name: ThreeSum.java
 * Creation Date: 2015年4月7日 下午2:16:07
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 3sum
 * @author kyon
 *
 */
public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> ret = null;
    	//sort it!
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tempArr = null;
        //loop it
        for (int i = 0; i < num.length; i++) {
        	//then get 2 pointer from both sides
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
            	//check the sum
            	//we always have i <= j <= k
            	//i is fixed
                int sum3 = num[i] + num[j] + num[k];
                if (sum3 < 0) {
                	//if it is smaller then 0, make j move right
                    j++;
                } else if (sum3 > 0) {
                	//if it is bigger then 0, make k move left
                    k--;
                } else {
                    tempArr = new ArrayList<Integer>();
                    //build a list
                    Collections.addAll(tempArr, num[i], num[j], num[k]);
                    //add it in to the set
                    //if already a list which has the same value in the set
                    //it will return false
                    //we do not care if it is added
                    set.add(tempArr);
                    j++;
                    k--;
                }
            }
        }
        ret = new ArrayList<List<Integer>>(set);
        return ret;
    }
  
	@Test
	public void gg(){
		int[] array = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> gg = this.threeSum(array);
		System.out.println(gg);
		System.out.println(gg.size());
	}

}
