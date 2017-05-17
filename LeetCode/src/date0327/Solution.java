package date0327;

public class Solution {
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int count = 0;
		for (int j = 1; j <= n; j++) {
			for (int i = 0; i < n + 1; i++) {
				if (nums[i] == j) {
					count++;
					if (count == 2)
						return i;
				}
			}
			count = 0;
		}
		return n;
	}

	/**
	 * 289. Game of Life
	 */
	public void gameOfLife(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				board[i][j] = everyCell(board, i, j);
			}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				board[i][j] = board[i][j] >> 1;
			}
	}

	public int everyCell(int[][] board, int i, int j) {
		int n = board.length;
		int m = board[0].length;
		int res = 0;
		for (int x = i - 1; x < i + 2; x++)
			for (int y = j - 1; y < j + 2; y++) {
				if (x >= 0 && x < n && y >= 0 && y < m) {
					res += board[x][y] & 1;
				}
			}
		res -= board[i][j] & 1;
		if (res == 2 && board[i][j] == 0)
			return 0;
		if (res == 2 && board[i][j] == 1)
			return 3;
		if (res == 3)
			return board[i][j] | 2;
		return board[i][j];
	}

	public static void main(String[] args) {
		System.out.println((0 << 1));
	}
}
