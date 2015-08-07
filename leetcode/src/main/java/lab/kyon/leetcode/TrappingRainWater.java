/**
 * 
 */
package lab.kyon.leetcode;

import org.junit.Test;

/**   
 * @author Kyon
 * @description   
 * @email soswindyday@gmail.com 
 * @date 2015年7月30日 下午6:42:27 
 *   
 */
public class TrappingRainWater {

	
	/**
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	 * compute how much water it is able to trap after raining.
	 * For example, 
	 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
	 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	 * In this case, 6 units of rain water (blue section) are being trapped. 
	 * Thanks Marcos for contributing this image! http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
	 * 
	 */
    public int trap(int[] height) {
    	int left=0;
    	int right=height.length-1;    	
    	int level = 0;
    	int water = 0;
    	if(height==null || height.length==0){
    		return 0;
    	}
    	//first, we get the lowest height called level, calculated by left and right 
    	level = height[left] <= height[right] ? height[left] : height[right];
    	//move the tow pointers until they meet
    	while(right>left){
    		//while moving, it can trap water if the current bar is lower than level
    		//if the new bar is higher, update level 
    		while(height[right] >= height[left] && left<right){    			
    			left++;
    			if(height[left] < level){
    				water += level - height[left];
    			}
    			if(height[left]>level){
    				level = height[left] <= height[right] ? height[left] : height[right];
    			}
    		}
    		//same as right
    		while(height[right] < height[left] && left<right){    			
    			right--;
    			if(height[right] < level){
    				water += level - height[right];
    			}
    			if(height[right]>level){
    				level = height[left] <= height[right] ? height[left] : height[right];
    			}
    		}    		
    	}
        return water;
    }
	
	@Test
	public void gg(){
		TrappingRainWater trw = new TrappingRainWater(); 
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
		int gg = trw.trap(array);
		System.out.println(gg);
	}
}
