package date0410;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/**
	 * 118. Pascal's Triangle
	 */
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return res;
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		res.add(temp);
		while (numRows > 1) {
			Integer[] a = new Integer[temp.size()];
			for (int j = 0; j < a.length; j++)
				System.out.println(a[j]);
			temp.toArray(a);
			List<Integer> tem = new ArrayList<Integer>();
			tem.add(1);
			for (int i = 0; i < a.length - 1; i++)
				tem.add(a[i] + a[i + 1]);
			tem.add(1);
			res.add(tem);
			temp = tem;
			numRows--;
		}
		return res;
	}

	public List<List<Integer>> generate_0(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);

			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}

	/**
	 * @119. Pascal's Triangle II
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		while (rowIndex-- > 0) {
			list.add(0, 1);
			for (int i = 1; i < list.size() - 1; i++)
				list.set(i, list.get(i) + list.get(i + 1));
		}
		return list;
	}

	/**
	 * @41. First Missing Positive 在原数组进行排序，使num[i]=i+1;
	 */
	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		int i = 0;
		while (i < nums.length) { // 这里不能用for循环，因为当交换完一次以后，可能nums[i]仍然是一个有效正Integer，需要继续进行swap
			if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1)
				i++;
			else if (nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
			else
				i++;
		}
		int j = 0;
		for (j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
			if (nums[j] != j + 1)
				return j + 1;
		}
		return nums[j - 1] + 1;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * @param nums
	 *            448. Find All Numbers Disappeared in an Array
	 *            这道题和41题一样，稍微改动即可，也可以用简单的办法，把见过的数字先作为下标都标注为负数,但是要注意需要使用abs函数
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (i < nums.length) { // 这里不能用for循环，因为当交换完一次以后，可能nums[i]仍然是一个有效正Integer，需要继续进行swap
			if (nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
			else
				i++;
		}
		int j = 0;
		for (j = 0; j < nums.length; j++) {
			if (nums[j] != j + 1)
				list.add(j + 1);
		}
		return list;
	}

	public List<Integer> findDisappearedNumbers_0(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (i < nums.length) {
			nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1])
					* (-1);
			i++;
		}
		i = 0;
		while (i < nums.length) {
			if (nums[i] > 0)
				list.add(i + 1);
			i++;
		}
		return list;
	}

	/**
	 * @268. Missing Number
	 */
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return nums.length * (nums.length - 1) / 2 - sum;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.generate_0(4);
	}
}
