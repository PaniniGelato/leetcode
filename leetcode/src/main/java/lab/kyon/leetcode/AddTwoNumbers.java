/*
 * File Name: AddTwoNumbers.java
 * Creation Date: 2015年4月9日 下午1:39:28
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
public class AddTwoNumbers {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list. Input:
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int v1 = l1==null?0:l1.val;
		int v2 = l2==null?0:l2.val;
		ListNode ret = new ListNode(v1 + v2);
		ListNode n1 = l1==null?null:l1.next;
		ListNode n2 = l2==null?null:l2.next;
		if(n1!=null || n2!=null){
			ret.next = addTwoNumbers(n1, n2);
			if(ret.val>=10){
				ret.val = ret.val%10;
				ret.next = addTwoNumbers(new ListNode(1), ret.next);
			}
		}
		if(n1==null && n2==null){
			if(ret.val>=10){
				ret.val = ret.val%10;
				ret.next = addTwoNumbers(new ListNode(1), null);
			}
		}
		return ret;
	}
	
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(9);
		
		ListNode gg = addTwoNumbers(l1, l2);
		System.out.println(gg.val);
		System.out.println(gg.next.val);
		System.out.println(gg.next.next.val);
	}
}
