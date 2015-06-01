/*
 * File Name: BinaryTreePreorderTraversal.java
 * Creation Date: 2015年4月20日 下午3:10:32
 * Author: kyon
 */
/**
 * @author kyon
 */
package lab.kyon.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author kyon
 *
 */
public class BinaryTreePreorderTraversal {
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

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> accessList = new ArrayList<Integer>();
		_traver(root, accessList);
		return accessList;
	}
	
	/**
	 * 前序遍历递归解法：
	 * （1）如果二叉树为空，空操作
	 * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
	 */
	void _traver(TreeNode node, List<Integer> accessList)  {  
        if(node == null){ 
            return;  
        }
        accessList.add(node.val); // 访问根节点  
        _traver(node.left, accessList); // 前序遍历左子树  
        _traver(node.right, accessList); // 前序遍历右子树  
    }
	
	@Test
	public void gg(){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> access = preorderTraversal(root);
		System.out.println(access);
	}
}
