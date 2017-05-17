package data0319;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import data0319.TreeNode;

public class solution2 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode temp = null;
		if (p.val>q.val)
		{
			temp=p;
			p=q;
			q=temp;
		}
		temp = root;
		while (temp != null) {
			if (temp.val>p.val&&temp.val>q.val)
				temp=temp.left;
			if (temp.val<p.val&&temp.val<q.val)
				temp=temp.right;
			if(temp.val==p.val||temp.val==q.val)
				return temp;
			if (temp.val>p.val&&temp.val<q.val)
				return temp;
		}
		return null;
	}
}
