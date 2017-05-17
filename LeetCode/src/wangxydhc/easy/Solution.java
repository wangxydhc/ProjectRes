package wangxydhc.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public boolean isPerfectSquare(int num) {
		int i = 1, j = num;

		while (i <= j) {
			int med = (i + j) / 2;
			if (med == i)
				return false;
			if (med * med == num)
				return true;
			else if (med * med < num) {
				i = (int) med + 1;
			} else {
				j = (int) med - 1;
			}
		}
		return false;
	}


	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
		int key = 0;
		ListNode tp = head;
		for (ListNode node = head; node != null; node = node.next) {
			if (!temp.containsValue(node.val)) {
				temp.put(key++, node.val);
				tp = node;
				continue;
			} else {
				tp.next = node.next;

			}
		}
		return head;
	}

	public ListNode removeElements(ListNode head, int val) {

		while (head != null && head.val == val)
			head = head.next;
		if (head == null)
			return head;
		ListNode temp = head;
		while (temp.next != null) {
			if (temp.next.val == val)
				temp.next = temp.next.next;
			else
				temp = temp.next;
		}
		return head;
	}

	/* �Լ�д�ģ�̫��û�������� ,����HashMap */
	public ListNode detectCycle(ListNode head) {
		Map<Integer, ListNode> temp = new HashMap<Integer, ListNode>();
		int key = 0;
		while (head != null) {
			if (temp.containsValue(head.next))
				return head.next;
			temp.put(key++, head);
			head = head.next;

		}
		return null;
	}

	/* �Լ�д�ģ�̫��û�������� */
	public ListNode detectCycle2(ListNode head) {
		ListNode temp = head, insi = head;
		if (head == null)
			return null;
		while (temp.next != null) {
			for (insi = head; insi != temp; insi = insi.next) {
				if (insi == temp.next)
					return insi;
				if (temp.next == insi)
					return insi;
			}
			temp = temp.next;
		}
		return null;
	}

	/* leetcode �ϵĽ�� */
	public ListNode detectCycle3(ListNode head) {
		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		char m, n;
		while (i < j) {
			m = s.charAt(i);
			n = s.charAt(j);
			if (!((m >= 'a' && m <= 'z') || (m >= 'A' && m <= 'Z') || (m >= '0' && m <= '9'))) {
				i++;
				continue;
			}
			if (!((n >= 'a' && n <= 'z') || (n >= 'A' && n <= 'Z') || (n >= '0' && n <= '9'))) {
				j--;
				continue;
			}
			n = Character.toLowerCase(n);
			m = Character.toLowerCase(m);
			if (m == n) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		if (head.next == null)
			return true;
		ListNode slow = head, fast = head;
		while (true) {
			if (fast.next == null) {
				break;
			}
			if (fast.next.next == null) {
				fast = fast.next;
				slow = slow;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right = reverseList(slow);
		while (fast != slow) {
			if (fast.val != head.val)
				return false;
			fast = fast.next;
			head = head.next;
		}
		return true;
	}

	public int maxSubArray(int[] nums) {
		int maxSum = nums[0],soFar=nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSum = Math.max(nums[i], maxSum + nums[i]);
			soFar=Math.max(maxSum,soFar);
		}
		 return soFar;
	}
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head, p2 = head.next, p3 = p2.next;
		p1.next = null;
		while (p3 != null) {
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p2.next;
		}
		p2.next = p1;
		return p2;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		ListNode list = head;

		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}

		return head;
	}

	
	
   
	public void x() {
		for (int a = 46336; a * a > 0; a = a + 1) {
			System.out.println(a + "ff" + a * a);
	}
	}


}
