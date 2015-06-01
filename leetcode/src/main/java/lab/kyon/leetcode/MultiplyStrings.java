/*
 * File Name: MultiplyStrings.java
 * Creation Date: 2015年4月21日 上午9:12:54
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author kyon
 *
 */
public class MultiplyStrings {
	
	public String multiply(String num1, String num2) {
	    int len1 = num1.length();
	    int len2 = num2.length();
	    //由经验可知，两个数字相乘结果的长度最大为两个数字的长度之和
	    int[] product = new int[len1 + len2];
	    //倒序循环
	    for (int i = len1 - 1; i >= 0; i--) {
	        for (int j = len2 - 1; j >= 0; j--) {
	        	//假设两个数字长度均为1，那么product的长度就是2，index算出来是0
	        	//假设两个数字长度均为2，那么product的长度就是4，index为0,1,2
	            int index = len1 + len2 - i - j - 2;
	            product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');	           
	            product[index + 1] += product[index] / 10;
	            product[index] %= 10;
	        }
	    }
	    StringBuilder stringBuilder = new StringBuilder();
	    for (int i = product.length - 1; i > 0; i--) {
	        if (stringBuilder.length() == 0 && product[i] == 0)
	            continue;
	        stringBuilder.append(product[i]);
	    }
	    stringBuilder.append(product[0]);
	    return stringBuilder.toString();
	}


}
