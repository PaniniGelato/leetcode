/**   
 * @author Kyon
 * @description
 * @email zhoujing1@yy.com 
 * @date 2015年9月1日 下午4:37:22 
 *   
 */
package lab.kyon.leetcode;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * @author Kyon
 *
 */
public class BitwiseANDofNumbersRange {
	
	/**
	 * Bitwise AND -> 1|0=0, 0|0=0, 1&1=1, 0&1=0
	 * so the bit will always be zero once there is one zero in the binary of all the numbers  
	 * we can get the same part of the higher level of the binaries by right shifting the numbers
	 * the lower part should be different for the numbers, so the bitwise AND of lower part should be zero
	 * then we can get the final answer by left shifting the higher part back to 32bits
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int diffBits = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			diffBits++;
		}
		return n << diffBits;
	}
	
	public static void main(String[] arg){
		BitwiseANDofNumbersRange s = new BitwiseANDofNumbersRange();
		int ret = s.rangeBitwiseAnd(105, 107);
		System.out.println(ret);
	}
}
