package date0407;

import java.util.Stack;

public class Solution {
	/**
	 * 492. Construct the Rectangle
	 */
	public int[] constructRectangle(int area) {
		int width = 1, height = area;
		for (int i = 2; i <= area; i++) {
			if (i > area / i)
				break;
			if (area % i == 0) {
				width = i;
				height = area / width;
			}
		}
		int[] res = new int[2];
		res[0] = height;
		res[1] = width;
		return res;

	}

	/**
	 *  @ 74.Search a 2D Matrix @ //这个方法太麻烦
	 */
	public boolean searchMatrix_2(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int i = 0, j = 0;
		if (matrix[0][0] > target)
			return false;
		while (i < matrix.length) {
			if (matrix[i][0] == target)
				return true;
			if (matrix[i][0] > target) {
				i--;
				break;
			} else
				i++;
		}
		if (i == matrix.length)
			i--;
		if (i < 0)
			return false;
		while (i < matrix.length && j < matrix[0].length) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				j++;
			else if (matrix[i][j] > target)
				return false;
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = matrix.length, column = matrix[0].length;
		int begin = 0, end = row * column - 1, mid = 0;
		while (begin != end) {
			mid = (begin + end) >> 1;
			if (matrix[mid / column][mid % column] < target)
				begin = mid + 1;
			else if (matrix[mid / column][mid % column] > target)
				end = mid; // end不+1，因为每次都是取左边
			else
				return true;
		}
		return matrix[begin / column][begin % column] == target;
	}

	/**
	 * @112.Path Sum
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.val == sum;
		if ((root.left != null && hasPathSum(root.left, sum - root.val))||(root.right != null && hasPathSum(root.right, sum - root.val)))
			return true;
		else
			return false;
	}
}
