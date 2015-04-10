/*
 * File Name: DistinctSubsequences.java
 * Creation Date: 2015年4月9日 下午2:39:51
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import org.junit.Test;

/**
 * @author kyon
 *
 */
public class DistinctSubsequences {

	/**
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S. A subsequence of a string is a new string which
	 * is formed from the original string by deleting some (can be none) of the
	 * characters without disturbing the relative positions of the remaining
	 * characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
	 */
	public int numDistinct(String S, String T) {
		if (T.length() == 0)
			return 0;

		int[] counts = new int[T.length()];
		for (int indexS = 0; indexS < S.length(); indexS++) {
			char charS = S.charAt(indexS);
			for ( int indexT = Math.min(T.length() - 1, indexS); indexT >= 0; indexT--) {
				if (T.charAt(indexT) == charS) {
					if (indexT == 0)
						counts[0]++;
					else
						counts[indexT] += counts[indexT - 1];
				}
			}
		}
		return counts[counts.length - 1];
	}
	
	@Test
	public void test(){
		String s = "rabbitt";
		String t = "abit";
		int gg = numDistinct(s, t) ;
		System.out.println(gg);
	}
}
