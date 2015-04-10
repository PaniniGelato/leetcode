/*
 * File Name: PartitionList.java
 * Creation Date: 2015年4月9日 下午4:56:47
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
public class PartitionList {

	/*
	 * Given a linked list and a value x, 
	 * 
	 * partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 *
	 * For example,
	 * 
	 * Given 1->4->3->2->5->2 and x = 3,
	 * 
	 * return 1->2->2->4->3->5.
	 */	
	
	/**
	 * Definition for singly-linked list.
	 * */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	
	public ListNode partition(ListNode head, int x) {
		/*
		 * 大概原理是就是循环list
		 * 小于x的分在一个list，大于等于x的分在另外一个list
		 * 然后合并两个list
		 */
		ListNode less = null;
		ListNode greater = null;
		ListNode n = head;
		
		//temp1 will be the last node of less
		ListNode temp1 = null;
		//temp2 will be the last node of greater
		ListNode temp2 = null;
		while(n!=null){
			if(n.val<x){
				if(less==null){
					less = new ListNode(n.val);
					temp1 = less;
				}else{
					temp1.next = new ListNode(n.val);
					temp1 = temp1.next;
				}
			}else{
				if(greater==null){
					greater = new ListNode(n.val);
					temp2 = greater;
				}else{
					temp2.next = new ListNode(n.val);
					temp2 = temp2.next;
				}
			}
			n = n.next;
		}
		
		//找到less的最后一个脸上greater
		if(less==null){
			return greater;
		}else{			
			temp1.next = greater;
		}
		return less;
	}
	
	@Test
	public void test(){
		ListNode gg = null;
		gg = new ListNode(1);
		gg.next = new ListNode(4);
		gg.next.next = new ListNode(3);
		gg.next.next.next = new ListNode(2);
		gg.next.next.next.next = new ListNode(5);
		gg.next.next.next.next.next = new ListNode(2);
		ListNode aa = partition(gg, 3);
		System.out.println(aa.val);
		System.out.println(aa.next.val);
		System.out.println(aa.next.next.val);
		System.out.println(aa.next.next.next.val);
		System.out.println(aa.next.next.next.next.val);
		System.out.println(aa.next.next.next.next.next.val);
	}
}
