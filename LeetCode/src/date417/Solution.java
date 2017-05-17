package date417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
	/**
	 * 78. Subsets
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		backTrack(list, nums, temp, 0);
		return list;
	}

	public void backTrack(List<List<Integer>> list, int[] nums,
			List<Integer> temp, int begin) {
		list.add(new ArrayList<Integer>(temp));
		for (int i = begin; i < nums.length; i++) {
			temp.add(nums[i]);
			backTrack(list, nums, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public void sortColors(int[] nums) {
		int count0 = 0, count1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count0++;
			if (nums[i] == 1)
				count1++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < count0)
				nums[i] = 0;
			else if (i < count1 + count0)
				nums[i] = 1;
			else
				nums[i] = 2;
		}
	}

	/**
	 * 73. Set Matrix Zeroes 这个方法慢，占用的空间也有多的，用直接储存第一行的就好了。
	 */
	public void setZeroes(int[][] matrix) {
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> column = new HashSet<Integer>();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
		Iterator<Integer> irt = row.iterator();
		while (irt.hasNext()) {
			int temp = irt.next();
			for (int m = 0; m < matrix[0].length; m++)
				matrix[temp][m] = 0;
		}
		irt = column.iterator();
		while (irt.hasNext()) {
			int temp = irt.next();
			for (int m = 0; m < matrix.length; m++)
				matrix[m][temp] = 0;
		}

	}

	/**
	 * 5. Longest Palindromic Substring
	 */
	int max = 0;
	String res = "";

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len <= 1)
			return s;
		for (int i = 0; i < len - 1; i++) {
			longestPalindromeSub(s, i, i);
			longestPalindromeSub(s, i, i + 1);
		}
		return res;
	}

	public void longestPalindromeSub(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))

		{
			i--;
			j++;
		}
		i++;
		j--;
		if (j - i + 1 >= max) {
			max = j - i + 1;
			res = s.substring(i, j + 1);
		}
	}

	/**
	 * 11. Container With Most Water
	 */
	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0, j = height.length - 1; i < j;) {
			if (height[i] <= height[j]) {
				max = Math.max(max, height[i] * (j - i));
				i++;
			} else {
				max = Math.max(max, height[j] * (j - i));
				j--;
			}
		}
		return max;
	}

	/**
	 * 15. 3Sum
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int sum = 0 - nums[i];
				int m = i + 1, n = nums.length - 1;
				while (m < n) {
					if (nums[m] + nums[n] == sum) {
						res.add(Arrays.asList(nums[i], nums[m], nums[n]));
						while (m < n && nums[m] == nums[m + 1])
							m++;
						while (m < n && nums[n] == nums[n - 1])
							n--;

						m++;
						n--;

					} else if (nums[m] + nums[n] < sum) {
						m++;
					} else
						n--;
				}
			}
		}
		return res;
	}
    public int search(int[] nums, int target) {
    	if (nums.length==0)
    		return -1;
        int low =0,high=nums.length-1;
        while(low<high){
        	int mid =low+(high-low)>>1;
        	System.out.println(low+" "+mid+" "+high);
        	if(nums[mid]==target)return mid;
        	if(target>=nums[low]&&target<nums[mid])
        		high=mid-1;
        	else if(target>nums[mid]&&target<=nums[high])
        		low=mid+1;
        	else if(nums[mid]<=nums[low])
        		high=mid-1;
        	else if(nums[mid]>=nums[high])
        		low=mid+1;
        }
        if(nums[low]==target)
        	return low;
        return -1;
    }
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    	
    	int n=nums.length;
    	if(n==0)
    		return list;
    	for(int i=0;i<nums.length;i++)
    	{
    		int []tem=new int[n];
    		int m=n;
    		while(--m>=0)
    			tem[m]=nums[m];
    		List<Integer> temp=new ArrayList<>();
    		int sym=tem[i];
//    		System.out.println("head"+sym);
    		temp.add(sym);
    		permuteHandler(tem,sym,temp);
    	}
    	return list;
    }
    public void permuteHandler(int []nums,int sym,List<Integer> temp){    	
    	boolean isNull=true;
    	int n=nums.length;
    	for(int i=0;i<n;i++){ 
    		if(nums[i]!=sym){ 
//    			System.out.println(nums[i]);
    			int y=nums[i];
    			isNull=false;
    			temp.add(nums[i]);
//    			System.out.println("add"+nums[i]);
    			nums[i]=sym;
//    			System.out.println(nums[0]+" "+ nums[1]+" "+nums[2]);
    			permuteHandler(nums,sym,temp);
//    			System.out.println("remove"+temp.get(temp.size()-1));
    			temp.remove(temp.size()-1);
    			nums[i]=y;
    		}
    	}
    	if(isNull){
    		list.add(new ArrayList<Integer>(temp));
//    		System.out.println("temp.size ="+ temp.size());
//    		for(int i=0;i<temp.size();i++)
//    			System.out.print(temp.get(i)+" ");
//    		System.out.println();
    	}
    }

    public static void main(String[] args) {
		Solution s=new Solution();
		int[] nums=new int[]{1,2,3};
		s.permute(nums);
	}
}
