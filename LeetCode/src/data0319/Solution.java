package data0319;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import data0319.TreeNode;

public class Solution {
	TreeNode tem = null;
	TreeNode res = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<Stack<TreeNode>> listP = iterativePreorder(root, p.val);
		List<Stack<TreeNode>> listQ = iterativePreorder(root, q.val);
		System.out.println("listP.size " + listP.size() + "  listQ.size "
				+ listQ.size());
		int count = 0;

		for (int i = 0; i < listP.size(); i++) {
			Stack<TreeNode> stackP = listP.get(i);
			System.out.println("run pp.next");
			for (int j = 0; j < listQ.size(); j++) {
				System.out.println("run qq.next");
				Stack<TreeNode> stackQ = listQ.get(j);
				int n = compare(stackP, stackQ);
				if (n > count) {
					res = tem;
					count = n;
				}
			}
		}
		return res;
	}

	public int compare(Stack<TreeNode> p, Stack<TreeNode> q) {
		tem = null;
		int n = 0;
		Iterator<TreeNode> iterP = p.iterator();
		Iterator<TreeNode> iterQ = q.iterator();
		while (iterP.hasNext() && iterQ.hasNext()) {
			TreeNode pN = iterP.next();
			TreeNode qN = iterQ.next();
			System.out.println("pN:" + pN.val + " qN: " + qN.val);
			n++;
			if (pN.val == qN.val) {
				tem = pN;

			} else {
				System.out.println("compared time " + n);
				return n;
			}
		}
		if (!iterP.hasNext() && !iterQ.hasNext())
			n = 0;
		System.out.println("compare time: " + n);
		return n;
	}

	public List<Stack<TreeNode>> iterativePreorder(TreeNode p, int target) {
		List<Stack<TreeNode>> list = new ArrayList<Stack<TreeNode>>();
		Stack<TreeNode> stackPost1 = new Stack<TreeNode>();
		TreeNode node1 = p, prev1 = p;
		while (node1 != null || stackPost1.size() > 0) {
			while (node1 != null) {
				stackPost1.push(node1);
				node1 = node1.left;
			}
			if (stackPost1.size() > 0) {
				TreeNode temp1 = stackPost1.peek().right;
				if (temp1 == null || temp1 == prev1) {
					node1 = stackPost1.peek();
					if (node1.val == target) {
						Stack<TreeNode> stackPost0 = (Stack<TreeNode>) stackPost1
								.clone();
						list.add(stackPost0);
					}
					stackPost1.pop();
					prev1 = node1;
					node1 = null;
				} else {
					node1 = temp1;
				}
			}
		}
		return list;
	}
}
