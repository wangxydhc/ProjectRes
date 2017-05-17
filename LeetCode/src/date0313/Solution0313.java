package date0313;

public class Solution0313 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return subEqual(p, q);
	}

	public boolean subEqual(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val && this.subEqual(p.left, q.left)
				&& this.subEqual(p.right, q.right))
			return true;
		return false;
	}

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}

	/* 这个看不懂 */
	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			System.out.println("one:"+ones);
			twos = (twos ^ A[i]) & ~ones;
			System.out.println("two:"+twos);
			System.out.println();
		}
		System.out.println(ones);
		return ones;
	}
	public static void main(String[] args) {
		Solution0313 s=new Solution0313();
		int[]A={14,7,14,14};
		s.singleNumber2(A);
		System.out.println(0^13);
		System.out.println(0^14);
	}
}
