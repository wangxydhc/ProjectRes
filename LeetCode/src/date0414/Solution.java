package date0414;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
	/**
	 * 64. Minimum Path Sum
	 */
	public int minPathSum(int[][] grid) {
		int sum = 0;
		if (grid.length == 0 || grid[0].length == 0)
			return sum;
		int[][] res = new int[grid.length][grid[0].length];
		res[0][0] = grid[0][0];
		for (int j = 1; j < res[0].length; j++) {
			res[0][j] = res[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < res.length; i++) {
			res[i][0] = res[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < res.length; i++)
			for (int j = 1; j < res[0].length; j++) {
				res[i][j] = Math.min(res[i][j - 1] + grid[i][j], res[i - 1][j]
						+ grid[i][j]);
			}
		return res[res.length - 1][res[0].length - 1];
	}

	/**
	 * 3. Longest Substring Without Repeating Characters
	 */
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		String last = "";
		for (Character c : s.toCharArray()) {
			int i;
			if (last.length() == 0)
				last = String.valueOf(c);
			else {
				for (i = last.length() - 1; i >= 0; i--) {
					if (last.charAt(i) == c) {
						i++;
						break;
					}
				}
				last = last.subSequence(i, last.length()) + String.valueOf(c);
			}
			if (last.length() >= res)
				res = last.length();
		}
		return res;
	}

	/**
	 * 91. Decode Ways
	 */
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		int[] res = new int[len + 1];
		res[0] = 0;
		if (s.charAt(0) == '0')
			res[1] = 0;
		else
			res[1] = 1;
		for (int i = 2; i < res.length; i++) {
			int m = s.charAt(i - 1);
			int n = s.charAt(i - 1) - '0' + ((s.charAt(i - 2) - '0') * 10);
			res[i] = res[i - 1] * (m == '0' ? 0 : 1) + res[i - 2]
					* ((n > 9 && n < 27) ? 1 : 0);
		}
		return res[len];
	}

	/**
	 * 43. Multiply Strings
	 * 
	 * @return
	 */
	public String multiply(String num1, String num2) { // 两个String表示的正数相乘
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		String res = "";
		String last = "";
		int len1 = num1.length();
		int len2 = num2.length();
		if (len1 < len2) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		for (int i = num2.length() - 1; i >= 0; i--) {
			String singleMul = multiplySingle(num1, num2.charAt(i));
			singleMul += last;
			res = addStrings(res, singleMul);
			last += "0";
		}

		return res;
	}

	public String multiplySingle(String num1, char c) { // 乘法运算，其中一个小于10
		StringBuffer sb = new StringBuffer();
		int k = c - '0';
		int next = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int j = (num1.charAt(i) - '0') * k + next;
			sb.append(j % 10);
			next = j / 10;
		}
		if (next != 0)
			sb.append(next);
		return sb.reverse().toString();
	}

	public String addStrings(String num1, String num2) { // 两个用string表示的正数相加
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0
				|| carry == 1; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}

		return sb.reverse().toString();
	}

	/**
	 * 88. Merge Sorted Array
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1, p2 = n - 1, p = m + n - 1;
		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] >= nums2[p2])
				nums1[p--] = nums1[p1--];
			else
				nums1[p--] = nums2[p2--];
		}
		if (p2 < 0)
			return;
		else {
			while (p >= 0)
				nums1[p--] = nums2[p2--];
		}
	}


	public TreeNode sortedArrayToBST(int[] nums) {

		return sortedArrayToBST_single(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST_single(int[] nums, int i, int j) {
		if (i > j)
			return null;
		if (i == j) {
			return new TreeNode(nums[i]);
		}
		int val = (i + j) >> 1;
		int iLeft = i, jLeft = val - 1;
		int iRight = val + 1, jRight = j;
		TreeNode root = new TreeNode(nums[val]);
		root.left = sortedArrayToBST_single(nums, iLeft, jLeft);
		root.right = sortedArrayToBST_single(nums, iRight, jRight);
		return root;
	}

	/**
	 * 160. Intersection of Two Linked Lists
	 */

}
