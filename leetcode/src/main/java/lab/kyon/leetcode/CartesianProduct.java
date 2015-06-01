/*
 * 版权所有 (C) 2014 中国南方航空股份有限公司。
 * 本文件可能包含有南方航空公司的机密或专有信息。
 * 未经许可不得擅自公开、复制这些机密资料及其中任何部分，
 * 只可按照其使用许可协议，在南方航空公司内部使用。
 *
 * File Name: CartesianProduct.java
 * Creation Date: 2015-5-22 下午5:34:24
 * Author: kyon
 */
/**
 * 
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.List;

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
	
	
	public static void main(String[] arg) throws Exception {
		
	}
	
}
