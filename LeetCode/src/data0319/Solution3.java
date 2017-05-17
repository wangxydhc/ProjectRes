package data0319;

import java.util.Iterator;
import java.util.Stack;
import data0319.TreeNode;

public class Solution3 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode res = null;
		;
		Stack<TreeNode> listP = iterativePreorder(root, p);
		Stack<TreeNode> listQ = iterativePreorder(root, q);
		Iterator<TreeNode> iterP = listP.iterator();
		Iterator<TreeNode> iterQ = listQ.iterator();
		while (iterP.hasNext() && iterQ.hasNext()) {
			TreeNode pN = iterP.next();
			TreeNode qN = iterQ.next();
			if (pN == qN) {
				res = pN;
			} else {
				return res;
			}
		}
		return res;
	}

	public Stack<TreeNode> iterativePreorder(TreeNode root, TreeNode q) {

		Stack<TreeNode> stackPost1 = new Stack<TreeNode>();
		TreeNode node1 = root, prev1 = root;
		while (node1 != null || stackPost1.size() > 0) {
			while (node1 != null) {
				stackPost1.push(node1);
				node1 = node1.left;
			}
			if (stackPost1.size() > 0) {
				TreeNode temp1 = stackPost1.peek().right;
				if (temp1 == null || temp1 == prev1) {
					node1 = stackPost1.peek();
					if (node1 == q) {
						return stackPost1;
					}
					stackPost1.pop();
					prev1 = node1;
					node1 = null;
				} else {
					node1 = temp1;
				}
			}
		}
		return null;
	}

}
