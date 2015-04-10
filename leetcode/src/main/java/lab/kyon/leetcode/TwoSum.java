/*
 * File Name: TwoSum.java
 * Creation Date: 2015年4月9日 上午10:53:29
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author kyon
 *
 */
public class TwoSum {

/*
	Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target, 
	where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.
	You may assume that each input would have exactly one solution.
	
	Input: numbers={2, 7, 11, 15}, target=9	
	Output: index1=1, index2=2
*/
	public int[] twoSum(int[] numbers, int target) {
		int[] ret = {-1, -1};
 		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++){
			int diff = target - numbers[i]; 
			if(map.containsKey(diff) && map.get(diff)!=i){
				int j = map.get(diff);
				ret = new int[]{i+1, j+1};
				Arrays.sort(ret);
				break;
			}
			map.put(numbers[i], i);
		}
		return ret;
	}
	
	@Test
	public void test(){
		int[] array = {2,1,9,4,4,56,90,3};
		int target = 8;
		int[] gg = this.twoSum(array, target);
		System.out.println(gg[0]);
		System.out.println(gg[1]);
	}
}
