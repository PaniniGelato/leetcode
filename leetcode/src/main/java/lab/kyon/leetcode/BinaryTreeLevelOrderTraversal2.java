/*
 * File Name: BinaryTreeLevelOrderTraversal2.java
 * Creation Date: 2015年4月20日 下午4:29:17
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \  
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author kyon
 *
 */
public class BinaryTreeLevelOrderTraversal2 {
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	void _travel(List<TreeNode> lvlSet, Stack<List<Integer>> stack){
		List<Integer> thisLvlAccessList = new ArrayList<Integer>();
		List<TreeNode> nextLvlSet = null;
		if(lvlSet!=null && lvlSet.size()>0){
			nextLvlSet = new ArrayList<TreeNode>();
			for(TreeNode n : lvlSet){
				//生成访问队列
				thisLvlAccessList.add(n.val);
				//把直接点丢到临时集合里
				if(n.left!=null){
					nextLvlSet.add(n.left);
				}
				if(n.right!=null){
					nextLvlSet.add(n.right);
				}
			}
		}
		stack.add(thisLvlAccessList);
		//如果下一层有节点集合，继续跑
		if(nextLvlSet!=null && nextLvlSet.size()>0){
			_travel(nextLvlSet, stack);
		}
	}
	
	
	/**
	 * 因为是bottom-up，所以用stack会比较方便
	 * 原理就是做一个N层的节点集合，生成访问队列之后，再生成N+1层的子节点集合，如此递归
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {			
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		if(root!=null){			
			List<TreeNode> lvlSet = new ArrayList<TreeNode>();			
			//先找到Root集合
			lvlSet.add(root);
			_travel(lvlSet, stack);
		}	
		//生成返回结果
		List<List<Integer>> ret = new ArrayList<List<Integer>>();	
		while(stack.size()>0){
			ret.add(stack.pop());
		}
		return ret;
	}
	
	@Test
	public void gg(){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> access = this.levelOrderBottom(root);
		System.out.println(access);
	}
}
