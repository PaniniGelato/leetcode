/*
 * File Name: CartesianProduct.java
 * Creation Date: 2015-5-22 下午5:34:24
 * Author: kyon
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author kyon
 *
 */
public class CartesianProduct<T> {

	/**
	 * 计算完整笛卡尔积
	 * @param matrix 要计算笛卡尔积的矩阵
	 * @return
	 */
	public List<List<T>> run(List<List<T>> matrix) {
		List<List<T>> result = null;
		result = new ArrayList<List<T>>();
		this.run(matrix, result, 0, new ArrayList<T>());
		return result;
	}
	
	
	
	/**
	 * 从指定层数开始递归计算笛卡尔积
	 * @param matrix
	 * @param result
	 * @param layer
	 * @param current
	 */
	public void run(List<List<T>> matrix, List<List<T>> result, int layer, List<T> current){
		for (int i = 0; i < matrix.get(layer).size(); i++) {
			List<T> _list = new ArrayList<T>();
			_list.addAll(current);
			_list.add(matrix.get(layer).get(i));
			//如果还没到矩阵最后一层，递归之
			if (layer < matrix.size() - 1) {
				run(matrix, result, layer + 1, _list);
			}
			//到了最后一层，把结果插进去，结束
			else if (layer == matrix.size() - 1){
				result.add(_list);
			}
		}
	}
	
	@Test
	public void test(){
		Integer[][] m = new Integer[3][3];
		m[0][0] = 111;
		m[0][1] = 112;
		m[0][2] = 113;
		m[1][0] = 221;
		m[1][1] = 222;
		m[1][2] = 223;
		m[2][0] = 331;
		m[2][1] = 332;
		m[2][2] = 333;
		
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for(Integer[] arr : m){
			List<Integer> list = new ArrayList<Integer>();
			for(Integer ii : arr){
				list.add(ii);				
			}
			matrix.add(list);
		}		
		
		CartesianProduct<Integer> cp = new CartesianProduct<Integer>();
		List<List<Integer>> ret = cp.run(matrix);
		System.out.println(ret);
	}
	
}
