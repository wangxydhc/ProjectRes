package date0413;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	/**
	 * 60. Permutation Sequence 两个问题 1 对于数字可能重复的问题，建立一个list，取用后删去效率会高很多 2
	 * 对于每一位上的余数为零时的处理没弄清楚
	 */
	List<Integer> list = new ArrayList<Integer>();

	public String getPermutation(int n, int k) {
		k = k - 1;
		if (list.isEmpty()) {
			list.add(1);
			for (int i = 1; i <= n; i++) {
				list.add(list.get(i - 1) * i);
			}
		}
		int[] res = new int[n];
		int j = 0;
		while (n > 0) {
			int x = list.get(n - 1);
			int start = 1;
			int i = 0;
			while (i < j) {
				if (start == res[i++]) {
					start++;
					i = 0;
				}
			}
			while (k >= x) {
				k = k - x;
				start++;
				i = 0;
				while (i < j) {
					if (start == res[i++]) {
						start++;
						i = 0;
					}
				}
			}
			k = k % x;
			res[j++] = start;
			n--;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < res.length; i++)
			sb.append(res[i]);
		return sb.toString();
	}

	/**
	 * @56. Merge Intervals 这道题思路是对的，比较顺利的做了出来，但是与别人的效率相差较多。考虑个可能有几个原因。 1.每次取使用
	 *      list.get或list.remove 可能 要比 直接 (for Interval i:intervals) 慢
	 *      2.每次访问a。start a.end可能要比直接使用int start,end 要慢
	 * 
	 *      经过测试，这些影响都不大，最影响时间的是 必须在程序最前面将length为0或1的情况直接返回，这样就不需要再进行无用的排序
	 */
	public List<Interval> merge(List<Interval> intervals) {
		int i = intervals.size();
		if (i == 0 || i == 1)
			return intervals;
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		List<Interval> res = new ArrayList<Interval>(); // 为什么用arrayList特别慢

		Interval a = intervals.get(0);
		for (Interval interval : intervals) {
			if (a == interval)
				continue;
			if (a.end < interval.start) {
				res.add(a);
				a = interval;
			} else
				a.end = Math.max(a.end, interval.end);
		}
		res.add(a);
		return res;
	}

	/**
	 * 70. Climbing Stairs            简单题，动态规划
	 */
	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}

	/**
	 * 486. Predict the Winner
	 * 自己的用了递归，而且是每次算了
	 * 别人的直接算，而且是求两个的差，要方便很多
	 */
	public boolean PredictTheWinner_0(int[] nums) {
		int[][] res = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++)
			res[i][i] = nums[i];
		for (int len = 1; len <= nums.length; len++) {
			for (int i = 0; i + len < nums.length; i++) {
				int j = i + len;
				res[i][j] = Math.max(nums[i] - res[i + 1][j], nums[j]
						- res[i][j - 1]);
			}
		}
		return res[0][nums.length - 1] >= 0;
	}

	public boolean PredictTheWinner(int[] nums) {
		int[][] res = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++)
			res[i][i] = nums[i];
		int score = cal(0, nums.length - 1, res);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum - score <= score)
			return true;
		return false;

	}

	public int cal(int m, int n, int[][] res) {
		if (m > n)
			return 0;
		if (m == n)
			return res[m][n];
		int i = Math
				.max((Math.min(cal(m + 1, n - 1, res), cal(m + 2, n, res)) + res[m][m]),
						(Math.min(cal(m + 1, n - 1, res), cal(m, n - 2, res)) + res[n][n]));
		res[m][n] = i;
		return i;
	}

	/**
	 * 29. Divide Two Integers
	 */
	public int divide(int dividend, int divisor) {                     //主要是纠结越界的问题，没有什么别的办法，直接用long
		long dividend_0=dividend,divisor_0=divisor;
		int si=1;
		if(dividend<0&&divisor_0>0||(dividend_0>0&&divisor_0<0))
			si=-1;
		dividend_0=Math.abs(dividend_0);
		divisor_0=Math.abs(divisor_0);
		if (divisor_0 == 0)
			return Integer.MAX_VALUE;
		if (dividend_0 < divisor_0)
			return 0;			
		long n=1;
		long res=0;
		while (divisor_0<dividend_0) {
			if((divisor_0<<1)>dividend_0)
				break;
			n<<=1;
			divisor_0<<=1;
		}
		while(n>0){			
			if(divisor_0<=dividend_0){
				dividend_0-=divisor_0;
				res+=n;	
				
			}		
			divisor_0>>=1;
			n>>=1;
		}		
		long res_0=res*si;
		if (res_0<Integer.MIN_VALUE)
			res_0=Integer.MIN_VALUE;
		if(res_0>Integer.MAX_VALUE)
			res_0=Integer.MAX_VALUE;
		return (int)res_0;		
	}
    /**
    34. Search for a Range
     */
	  public int[] searchRange(int[] nums, int target) {
	        if(nums.length==0)
	            return new int[]{-1,-1};
	        int res=searchNum(nums,target);
	        if (res==-1)
	        	return new int[]{-1,-1};
	        int a=res,b=res;
	        while(a-1>=0){
	        	if(nums[a-1]==target)
	        		a--;
	        	else
	        		break;
	        }
	        while(b+1<nums.length){
	        	if(nums[b+1]==target)
	        		b++;
	        	else
	        		break;
	        }
	        return new int[]{a,b};
	    }
	    public int searchNum(int[]nums,int target){              //找个经典的二分查找看一下
	    	int begin=0,end=nums.length;
	    	while(begin<end){
	    		int mid=begin+((end-begin)>>1);                             //注意运算顺序，必须加括号
	    	if (nums[mid]>target)
	    		end=mid;
	    	else if (nums[mid]<target)
	    		begin=mid+1;
	    	else return mid;
	    	}
	    	return -1;	    	
	    	
	    }
	    public void moveZeroes(int[] nums) {
	        int i=0,j=0;
	        while(j<nums.length){
	        	while(i<nums.length&&nums[i]!=0)
	        		i++;
	        	if (nums[j]!=0&&i<j){
	        		swap(nums,i,j);	        		
	        	}
	        	j++;
	        }
	    }
	    public void swap(int []nums,int i,int j){
	    	int temp=nums[i];
	    	nums[i]=nums[j];
	    	nums[j]=temp;
	    }
	    public int searchInsert(int[] nums, int target) {
	        int len=nums.length;
	        int low=0,high=len;
	        while(low<high){
	        	int mid=low+((high-low)>>1);
	        	if (nums[mid]>target)
	        		high=mid;
	        	else if(nums[mid]<target)
	        		low=mid+1;
	        	else
	        		return mid;
	        }
	        if (nums[low]>target)
	        	return low;
	        else
	        	return low+1;
	    }
	public static void main(String[] args) {
		Solution s = new Solution();
		s.divide(Integer.MIN_VALUE, -1);
	}

}
