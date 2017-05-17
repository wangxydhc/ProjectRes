package data0316;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushAll(root);
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (stack.isEmpty()){
			System.out.println();
			return false;}
		return true;
	}
	/** @return the next smallest number */
	public int next() {
		TreeNode temp = stack.pop();
		pushAll(temp.right);
		return temp.val;
	}

	private void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	


	public void postOrder(TreeNode p1) { // 网上找到的后续遍历的非递归算法 ，方法和下面的差不多，但格式不太统一
		Stack<TreeNode> stackPost1 = new Stack<TreeNode>();
		TreeNode node1 = p1, prev1 = p1;
		while (node1 != null || stackPost1.size() > 0) {
			while (node1 != null) {
				stackPost1.push(node1);
				node1 = node1.left;
			}
			if (stackPost1.size() > 0) {
				TreeNode temp1 = stackPost1.peek().right;
				if (temp1 == null || temp1 == prev1) {
					node1 = stackPost1.pop();
					System.out.print(node1.val + " ");
					prev1 = node1;
					node1 = null;
				} else {
					node1 = temp1;
				}
			}
		}
		System.out.println();
	}

	
	
	/*下面这三个方法前、中、后采取的方法其实是一样的
	共同点:
	循环条件为栈不为null
	先将从root开始的所有Leftnode入栈
	对栈顶节点一次进行处理
	在检查right可用后，将从right开始的所有leftNode依次入栈	
	*/
	public void preOrderSd(TreeNode p) { // 前序遍历的非递归算法                                                             //在每次压栈时访问节点
		Stack<TreeNode> stackPre = new Stack<TreeNode>();
		while (p != null) {
			stackPre.push(p);
			System.out.print( p.val+" ");
			p = p.left;
		}
		while (!stackPre.isEmpty()) {
			p = stackPre.pop().right;
			while (p != null) {
				stackPre.push(p);
				System.out.print(p.val+" ");
				p = p.left;
			}
		}
		System.out.println();
	}
	public void postOrderSd(TreeNode p1) { // 网上找到的后续遍历的非递归   修改版      //需要标记，每次pop时做标记
		Stack<TreeNode> stackPost1 = new Stack<TreeNode>();                  //使用peek检查是否为null节点或子节点都压入栈
		TreeNode node1 = p1, prev1 = p1;									 //每次pop时访问节点 
		while (node1 != null) {
			stackPost1.push(node1);
			node1 = node1.left;
		}
		while (stackPost1.size() > 0) {
				TreeNode temp1 = stackPost1.peek().right;
				if (temp1 == null || temp1 == prev1) {
					node1 = stackPost1.pop();
					System.out.print(node1.val + " ");
					prev1 = node1;
				} else {
					while (temp1 != null) {
						stackPost1.push(temp1);
						temp1 = temp1.left;
					}
				}
			}		
		System.out.println();
	}
	public void inOrderSd(TreeNode p) { // 中序遍历的非递归算法                        //直接pop,直接访问，无需peek
		Stack<TreeNode> stackPre = new Stack<TreeNode>();            //每次检查是否存在right,若存在，直接压入所有left
		while (p != null) {
			stackPre.push(p);
			p = p.left;
		}
		while (!stackPre.isEmpty()) {
			p=stackPre.pop();
			System.out.print(p.val+" ");
			p=p.right;
			while (p != null) {
				stackPre.push(p);
				p = p.left;
			}
		}
		System.out.println();
	}
	
	
	//前序遍历最简答版本
	public void preOrderEasy(TreeNode p){        
		Stack <TreeNode>stack=new Stack<TreeNode>();
		TreeNode temp=new TreeNode();
		stack.push(p);
		while(!stack.isEmpty()){
			temp=stack.pop();
			System.out.print(temp.val+" ");
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
		System.out.println();
	}
	
	
	//后序遍历非一次压入版本，使用pre对上一个弹出的node做标记
	public void postOrderEasy(TreeNode p){       
		Stack <TreeNode>stack=new Stack<TreeNode>();
		TreeNode temp=new TreeNode();
		TreeNode pre=null;
		stack.push(p);
		while(!stack.isEmpty()){
			temp=stack.peek();
			if((temp.left==null&&temp.right==null)||(pre!=null&&((temp.left==pre)||(temp.right==pre))))
				{System.out.print(temp.val+" ");
				stack.pop();
				pre=temp;
				}
			else{
				if(temp.right!=null)
					stack.push(temp.right);
				if(temp.left!=null)
					stack.push(temp.left);
			}			
		}		
		System.out.println();
	}
/*
	public void iterativePostorder(TreeNode p) { // 后序遍历的非递归算法复杂版，主要是在每次进行右node的pushAll
												//时做一个标记，这个是最开始自己写的，所有做的标记使另外压如一个Node，
  												//效率很低很麻烦
		TreeNode node = new TreeNode(8);
		Stack<TreeNode> stackPost = new Stack<TreeNode>();
		while (p != null) {
			stackPost.push(p);
			p = p.left;
		}
		while (!stackPost.isEmpty()) {
			p = stackPost.peek();
			if (p != node) {
				stackPost.push(node);
				p=p.right;
				while (p != null) {
					stackPost.push(p);
					p = p.left;
				}
			} else {
				stackPost.pop();
				p = stackPost.pop();
				System.out.print(p.val+" ");
			}
		}
		System.out.println();
	}
	*/
	public void broadOrderEasy(TreeNode p){        //广度优先遍历，主要是用队列
		Queue <TreeNode>queue=new LinkedList<TreeNode>();
		TreeNode temp=new TreeNode();
		queue.add(p);
		while(!queue.isEmpty()){
			temp=queue.poll();
			System.out.print(temp.val+" ");			
			if(temp.left!=null)
				queue.offer(temp.left);	
			if(temp.right!=null)
				queue.offer(temp.right);				
		}
		System.out.println();
	}
	public static void main(String[] args) {
		TreeNode[] n = new TreeNode[7];
		for (int i = 0; i < 7; i++) {
			TreeNode temp = new TreeNode(i);
			n[i] = temp;
		}
		n[0].left = n[1];
		n[0].right = n[2];
		n[1].left = n[3];
		n[1].right = n[4];
		n[2].left = n[5];
		n[2].right = n[6];		
		
		BSTIterator lst = new BSTIterator(n[0]);
		System.out.println("中序遍历：");
		while (lst.hasNext())
			System.out.print(lst.next() + " ");
		
		System.out.println("postOrder：");
		lst.postOrder(n[0]);
		
		System.out.println("preOrder Standard：");
		lst.preOrderSd(n[0]);		
		System.out.println("inOrder Standard：");
		lst.inOrderSd(n[0]);		
		System.out.println("postOrder Standard：");
		lst.postOrderSd(n[0]);
		
		System.out.println("前序遍历非一次性压入：");
		lst.preOrderEasy(n[0]);
		
		System.out.println("后序遍历非一次压入版本，");
		lst.postOrderEasy(n[0]);
	}
}
