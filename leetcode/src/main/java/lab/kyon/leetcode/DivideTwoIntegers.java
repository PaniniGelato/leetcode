/*
 * File Name: DivideTwoIntegers.java
 * Creation Date: 2015年6月23日 下午12:30:33
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
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor){
		if(divisor==0)return Integer.MAX_VALUE;
		if(dividend==0)return 0;
		if(divisor == -1){
			if(dividend==Integer.MIN_VALUE)
				return Integer.MAX_VALUE;
			return -dividend;
		}
	    if(divisor == 1) return dividend;
	    
	    
		long _dividend = dividend;
		long _divisor = divisor;
		boolean isNegative = false;
		if(divisor<0){
			_divisor = -_divisor;
		}
		if(_dividend<0){
			_dividend = -_dividend;
		}
		if((dividend<0 || divisor<0) && !(dividend<0 && divisor<0)){
			isNegative = true;
		}	
		long result = this._divide(_dividend, _divisor);
		if(isNegative){
			result = -result;
		}
		return (int)result;
	}
	
	
	public long _divide(long dividend, long divisor){
		if(dividend==0 || divisor>dividend)return 0;
		long temp = divisor;
		long result = 1, res = 0;
		while(temp <= dividend){
			res = (int) (dividend - temp);
			temp <<= 1;			
			if(temp > dividend){
				break;
			}else{
				result <<= 1;
			}
		}
		return result += _divide(res, divisor);
	}
	
	@Test
	public void test(){
		int a = -2147483648, b = -1;
		System.out.println(divide(a, b));
	}
	
}
