package date0401;

public class Solution {
	public int lengthOfLIS(int[] nums) {	
		if (nums.length==0)
			return 0;
		int[]count=new int[nums.length];
		count[nums.length-1]=1;
		int res=1;
		for(int i=nums.length-2;i>=0;i--){
			count[i]=1;
			for(int j=i+1;j<nums.length;j++){
				if (nums[i]<nums[j]){
					count[i]=Math.max((count[j]+1),count[i]);
//					System.out.println("count["+i+"]="+count[i]);
				}
				res=Math.max(count[i],res);
			}
		}
		return res;		
	}
	
	public static void main(String[] args) {
		Solution s=new Solution();
		int []a={1,3,6,7,9,4,10,5,6};
		int res=s.lengthOfLIS(a);
		System.out.println(res);
	}
}