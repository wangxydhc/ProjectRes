package date0324;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public int[] plusOne(int[] digits) {

		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}

	int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}

	public int countNodes(TreeNode root) {
		int h = height(root);
		if(h<0)
			return 0;
		if(height(root.right)==h-1)
			return countNodes(root.right)+(1<<h);
		if(height(root.right)==h-2)
			return countNodes(root.left)+(1<<h)-1;
		return 0;
	}
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
    	if (root!=null){
        	temp=root.left;
        	root.left=root.right;
        	root.right=temp;
        	invertTree(root.left);
        	invertTree(root.right);
    	}
    	return root;        
    }
    public List<Integer> diffWaysToCompute(String input) {
    	List<Integer>res=new LinkedList<Integer>();
    	int len=input.length();
    	String subLeft,subRight;
    	for(int i=0;i<len;i++){
    		if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
    			subLeft=input.substring(0, i);
    			subRight=input.substring(i+1);
    			List<Integer> left=new ArrayList<Integer>();
    			List<Integer> right=new ArrayList<Integer>();
    			left=diffWaysToCompute(subLeft);
    			right=diffWaysToCompute(subRight);
    			for(int leftNum:left)
    				for(int rightNum:right){
    					if (input.charAt(i)=='+')
    						res.add(leftNum+rightNum);
    					if (input.charAt(i)=='-')
    						res.add(leftNum-rightNum);
    					if (input.charAt(i)=='*')
    						res.add(leftNum*rightNum);
    				}
    		}
    	}
    	if (res.size() == 0) {						//这个别忘了，最底层都是这个
            res.add(Integer.valueOf(input));                     
        }                              
    	return res;
    }
}
