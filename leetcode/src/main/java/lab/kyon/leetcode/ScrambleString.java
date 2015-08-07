/**
 * 
 */
package lab.kyon.leetcode;

import java.util.Arrays;

/**   
 * @author Kyon
 * @description   
 * @email soswindyday@gmail.com
 * @date 2015年8月4日 下午4:48:25 
 *   
 */
public class ScrambleString {

	
	/**
	 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. 
	 * Below is one possible representation of s1 = "great":
	 *         great
	 *        /    \
	 *      gr    eat
	 *     / \    /  \
	 *    g   r  e   at
	 *               / \
	 *              a   t
	 * 
	 * To scramble the string, we may choose any non-leaf node and swap its two children.
	 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
	 * 
	 *         rgeat
	 *         /    \
	 *        rg    eat
	 *       / \    /  \
	 *      r   g  e   at
	 *                 / \
	 *                a   t
	 * 
	 * We say that "rgeat" is a scrambled string of "great".
	 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
	 *         rgtae
	 *         /    \
	 *        rg    tae
	 *       / \    /  \
	 *      r   g  ta  e
	 *             / \
	 *            t   a
	 * 
	 * We say that "rgtae" is a scrambled string of "great".
	 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		if(s1.equals(s2))return true;
		if(s1.length()!=s2.length())return false;
		//if exists different characters, return false;
		//yet it dosen't mean they are scramble
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);
		String sortedS1 = String.valueOf(c1);
		String sortedS2 = String.valueOf(c2);
		if(!sortedS1.equals(sortedS2))return false;
		//recurse check if scramble
		for(int i=1; i<s1.length(); i++){
			String s1s = s1.substring(0, i);
			String s1e = s1.substring(i);
			
			String s2s = s2.substring(0, i);
			String s2e = s2.substring(i);
			
			String s1ss = s1.substring(0, s1.length()-i);
			String s1ee = s1.substring(s1.length()-i);			

			if(isScramble(s1s, s2s) && isScramble(s1e, s2e) || isScramble(s1ss, s2e) && isScramble(s1ee, s2s)){
				return true;
			}
		}		
		return false;
	}

	public static void main(String[] arg){
		ScrambleString ss = new ScrambleString();
		boolean gg = ss.isScramble("abcd", "bdac");
		System.out.println(gg);
	}
}
