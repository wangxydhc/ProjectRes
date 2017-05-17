package date0315;

import java.util.Stack;

public class Solution {
	/**
	 * $1
	 * 
	 * @param n
	 * @return 左移：<< 帶符號右移：>> 無符號右移：>>>
	 * @leetCode上有 运行multiple 次的优化方案
	 */
	public int reverseBits(int n) {
		int num = 0, res = 0;
		while (n != 0) {
			num = n % 2;
			n = n >>> 1;
			res = (res << 1) + num;
		}
		return res;
	}

	/**
	 * $2
	 * 
	 * @param n
	 * @return 下面的更快一些
	 */
	public int hammingWeight(int n) {
		int count = 0;
		if ((n & 1) == 1)
			count++;
		for (int i = 0; i < 32; i++) {
			count += (n = n >>> 1) & 1;
		}
		return count;
	}

	public static int hammingWeightLT(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}

	/**
	 * $3k
	 * 
	 * @param n
	 * @return 下面的解法太赞了
	 */
	public boolean isPowerOfTwo(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			if (count == 2)
				return false;
			n = n >> 1;
		}
		if (count == 0)
			return false;
		return true;
	}

	public boolean isPowerOfTwoLT(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

	/**
	 * $4 这道题简单，用亦或就好
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
		int res = x ^ y;
		return Integer.bitCount(res);
	}

	/**
	 * $5 简单，下面两个思路一样，进行了一点儿优化 注意 +的优先级要高于&，这里需要加括号
	 * 
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
		int res[] = new int[num + 1];
		res[0] = 0;
		for (int i = 1; i <= num; i++) {
			if ((i & 1) == 0)
				res[i] = res[i / 2];
			if ((i & 1) == 1)
				res[i] = res[i / 2] + 1;
		}
		return res;
	}

	public int[] countBitsLT(int num) {
		int res[] = new int[num + 1];
		for (int i = 1; i <= num; i++)
			res[i] = res[i / 2] + (i & 1); // 注意 +的优先级要高于&，这里需要加括号
		return res;
	}

	/**
	 * $6
	 * 
	 * @这道题好难。 DP,根据前三个点的状态计算下一个点
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int leni = matrix.length, lenj = matrix[0].length, max = 0;
		int[][] count = new int[leni + 1][lenj + 1]; // 要假设矩阵左、上都多出了1行1列，才能方便计算真正第一行第一列的count值

		for (int i = 1; i < leni + 1; i++)
			for (int j = 1; j < lenj + 1; j++) {
				if (matrix[i - 1][j - 1] == '1')
					count[i][j] = Math.min(count[i - 1][j - 1],
							Math.min(count[i - 1][j], count[i][j - 1])) + 1;
				max = Math.max(max, count[i][j]);
			}
		return max * max;
	}

	/**
	 * 有一些繁琐
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head.next == null || m == n)
			return head;
		int count = 0;
		ListNode virNode = new ListNode(0);
		virNode.next = head;
		ListNode leftPoint = virNode, node_minus_1 = null, left_plus2 = null, left_plus1 = null, node_m = null;
		while (count != m) {
			count++;
			node_minus_1 = leftPoint;
			leftPoint = leftPoint.next;
		}
		node_m = leftPoint;
		left_plus1 = node_m.next;
		left_plus2 = left_plus1.next;
		while (count++ != n) {
			left_plus1.next = leftPoint;
			leftPoint = left_plus1;
			left_plus1 = left_plus2;
			if (left_plus2 != null)
				left_plus2 = left_plus2.next;
		}
		node_m.next = left_plus1;
		System.out.println("m:" + node_m.val);
		node_minus_1.next = leftPoint;
		return virNode.next;
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> bottle = new Stack<Integer>();
		int res = 0;
		for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				res = bottle.pop() + bottle.pop();
				bottle.push(res);
				break;
			case "-":
				res = -1 * bottle.pop() + bottle.pop();
				bottle.push(res);
				break;
			case "*":
				res = bottle.pop() * bottle.pop();
				bottle.push(res);
				break;
			case "/":
				int a = bottle.pop(),
				b = bottle.pop();
				bottle.push(b / a);
				break;
			default:
				int x = Integer.valueOf(tokens[i]);
				bottle.push(x);
			}
		}
		return bottle.pop();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;

		ListNode node = s.reverseBetween(n1, 1, 3);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
