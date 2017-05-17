package data0316;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public String reverseVowels(String s) {
		char temp;
		char[] a = s.toCharArray();
		int i = 0, j = a.length - 1;
		while (i < j) {
			if (isVowel(a[i])) {
				if (isVowel(a[j])) {
					temp = a[i];
					a[i++] = a[j];
					a[j--] = temp;
					continue;
				} else {
					j--;
					continue;
				}
			} else {
				i++;
			}
		}
		return String.valueOf(a);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		/*
		 * 对root节点的左右子节点进行处理，将两个节点分别亚入栈内 *
		 */
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.empty()) { // 到栈空为止，栈底两个分别是左右两根节点
			if (stack.size() % 2 != 0) // 左右只压入一个，false
				return false;
			right = stack.pop(); // 这里left、right指向的node发生变化
			left = stack.pop();
			if (right.val != left.val) // 对比被押入栈的两Node的val
				return false;

			if (left.left != null) {
				if (right.right == null) // 判断左左、右右是否都有
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}

			if (left.right != null) {
				if (right.left == null)
					return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}
		}

		return true;
	}

	public int maxDepth(TreeNode root) {
		return maxDepth(root);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode temp;
		stack = pushAll(stack, root);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			list.add(temp.val);
			stack = pushAll(stack, temp.right);
		}
		return list;
	}



	private Stack<TreeNode> pushAll(Stack<TreeNode> stack, TreeNode right) {
		while(right!=null){
			stack.push(right);
			right=right.left;
		}
		return stack;
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		else
			return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
	}

	public boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
				|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		return false;
	}

	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		long tempVal;
		long min = Long.MIN_VALUE;
		TreeNode temp;
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			tempVal = temp.val;
			if (tempVal <= min)
				return false;
			min = tempVal;
			while (temp.right != null) {
				stack.push(temp.right);
				temp.right = temp.right.left;
			}
		}
		return true;
	}

	public int[] findMode(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		int count = 0, countInner = 0;
		TreeNode temp;
		int tempVal = 0;
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			if (temp.val == tempVal) {
				countInner++;
				if (countInner > count) {
					list.clear();
					count = countInner;
				}
				if (countInner == count)
					list.add(tempVal);
			} else {
				tempVal = temp.val;
				countInner = 1;
				if (countInner > count) {
					list.clear();
					count = countInner;
				}
				if (countInner == count)
					list.add(tempVal);
			}
			while (temp.right != null) {
				stack.push(temp.right);
				temp.right = temp.right.left;
			}
		}
		int[] a = new int[list.size()];
		int c = 0;
		for (int i : list)
			a[c++] = i;
		return (int[]) a;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode[] node=new TreeNode[7];
		for (int i=0;i<7;i++){
			node[i]=new TreeNode(i);
		}
		node[0].left=node[1];
		node[0].right=node[2];
		node[1].left=node[3];
		node[1].right=node[4];
		node[2].left=node[5];
		node[2].right=node[6];
		
		List<Integer> l=s.inorderTraversal(node[0]);
		for(int i:l)
			System.out.println(i);

	}

}
