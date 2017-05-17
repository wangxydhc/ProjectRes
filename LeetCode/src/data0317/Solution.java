package data0317;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	Map<Integer, Integer> map;
	int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {

		map = new HashMap<>();
		sumOfNode(root);
		List<Integer> list = new ArrayList<>();
		for (int key : map.keySet())
			if (map.get(key) == max)
				list.add(key);
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			a[i] = list.get(i);
		return a;
		// list.stream().mapToInt(i->i).toArray(); 如果用这个将列表转数组会慢很多
	}

	public int sumOfNode(TreeNode root) {
		int res;
		if (root == null) {
			res = 0;
			return 0;
		} else {
			res = root.val + sumOfNode(root.left) + sumOfNode(root.right);
			map.put(res, map.getOrDefault(res, 0) + 1);
			max = Math.max(max, map.get(res));
			return res;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		int res[] = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = i;
				res[1] = map.get(target - nums[i]);
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
	}

//	public List<List<Integer>> threeSum(int[] nums) {
//		Arrays.sort(nums);
//	}

}