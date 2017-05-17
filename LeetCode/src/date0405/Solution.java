package date0405;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
	/**
	 *349. Intersection of Two Arrays
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>(); // 需要用set的时候就要用
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]); // set不需要考虑是否重复，本身就无法重复
		}
		for (int i = 0; i < nums2.length; i++)	// 数组长度不知道时应该怎么处理 :
												// LeetCode上都是先放到list里面，再变成数组

		{
			if (set.contains(nums2[i]))
				if (!list.contains(nums2[i]))
					list.add(nums2[i]); // 别人的答案不是判断两次，而是listadd以后将set里的这个已有的值删掉
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = list.get(i);
		return res;
	}

	/**
	 * @20. Valid Parentheses                简单题
	 */
	public boolean isValid(String s) {
		char[] cStr = s.toCharArray();
		Stack<Character> stackL = new Stack<Character>();
		for (int i = 0; i < cStr.length; i++) {
			char c = cStr[i];
			if (c == '(' || c == '[' || c == '{')
				stackL.push(c);
			if (c == ')')
				if (stackL.isEmpty() || stackL.pop() != '(')
					return false;
			if (c == ']')
				if (stackL.isEmpty() || stackL.pop() != '[')
					return false;
			if (c == '}')
				if (stackL.isEmpty() || stackL.pop() != '{')
					return false;
		}
		if (stackL.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * 32. Longest Valid Parentheses       
	 */
	public int longestValidParentheses(String s) {            //  这个是自己做得版本，复杂度高
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			String ss = s.substring(i);
			int res = isR(ss.toCharArray());
			len = Math.max(len, res);
		}

		return len;
	}

	public int isR(char[] s) {
		int count = 0, n = 0, max = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(') {
				max++;
				count++;
			}
			if (s[i] == ')') {
				if (count <= 0)
					return n;
				if (count == 1)
					n = max * 2;
				count--;
			}
		}
		return n;
	}

	public int longestValidParentheses_0(String s) {               // 这道题最重要的 一是想起出逻辑，二是要想到用栈
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - left);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;
	}

	

	public int myAtoi(String str) {
		int sym = 1,start=0;                        //这个地方不要用boolean，用int +1，-1 ，可以直接乘以数字。
		long res=0;
		if (str == null || str.length() == 0) 		// 这是个常用的边界条件
			return 0;
		str = str.trim();
		char c = str.charAt(0);
		if (c == '+') {
			sym = 1;
			start++;
		}
		else if (c == '-') {
			sym = -1;
			start++;
		}
		for(int i=start;i<str.length();i++){
			if (!Character.isDigit(str.charAt(i)))
				return (int)res*sym;
			else
				res=res*10+(str.charAt(i)-'0');
			if (sym==1&&res>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sym==-1&&res*(-1)<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;					
		}
		return (int)res*sym;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str="2147483648";
		System.out.println(s.myAtoi(str));

	}
}