/*
 * File Name: PascalTriangle2.java
 * Creation Date: 2015年4月20日 下午2:05:43
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author kyon
 *
 */
public class PascalTriangle2 {

	/*
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3,
	 * 
	 * Return [1,3,3,1].
	 * 
	 * Note:
	 * 
	 * Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * 帕斯卡三角形，是一个三角形矩阵，其顶端是 1,视为(row0).
	 * 第1行(row1)(1&1)两个1,这两个1是由他们上头左右两数之和 (不在三角形内的数视为0).
	 * 依此类推产生第2行(row2):0+1=1;1+1=2;1+0=1.
	 * 第3行(row3):0+1=1;1+2=3; 2+1=3;1+0=1. 
	 * 循此法可以产生以下诸行。
	 * 
	 * 第0列 11^0 = 1, 1
	 * 第1列 11^1 = 11, 1 1
	 * 第2列 11^2 = 121, 1 2 1
	 * 第3列 11^3 = 1331, 1 3 3 1
	 * 第4列 11^4 = 14641, 1 4 6 4 1
	 * 第5列 11^5 = 161051, 1 5 10 10 5 1
	 * 第6列 11^6 = 1771561, 1 6 15 20 15 6 1
	 * 第7列 11^7 = 19487171, 1 7 21 35 35 21 7 1
	 * 第8列 11^8 = 214358881, 1 8 28 56 70 56 28 8 1
	 */
	public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<>();
        Integer[] ans = new Integer[rowIndex + 1];
        for (int lvl = 1; lvl <= rowIndex + 1; lvl++) {
            for (int row = lvl - 1; row >= 0; row--) {
                if (row == 0 || row == lvl - 1) ans[row] = 1;
                else {
                    ans[row] = ans[row] + ans[row - 1];
                }
            }
        }
        return Arrays.asList(ans);
    }
		 
	@Test
	public void test(){		
		List<Integer> gg = this.getRow(8);
		System.out.println(gg);
	}

}
