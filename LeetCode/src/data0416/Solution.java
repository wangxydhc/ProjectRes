package data0416;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode temp = headA, temp1;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		temp = headB;
		while (temp != null) {
			temp = temp.next;
			count--;
		}
		if (count >= 0) {
			temp = headA;
			temp1 = headB;
		} else {
			count = -count;
			temp = headB;
			temp1 = headA;
		}

		while (count-- > 0)
			temp = temp.next;
		while (temp != null && temp1 != null) {
			if (temp == temp1)
				return temp;
			else {
				temp = temp.next;
				temp1 = temp1.next;
			}
		}
		return null;
	}

	/**
	 * 79. Word Search
	 */
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				if (exist(board, word, i, j, 0))
					return true;

		}
		return false;
	}

	public boolean exist(char[][] board, String word, int x, int y, int pos) {
		if (pos >= word.length())
			return true;
		if (x < 0 || y < 0 || x == board.length || y == board[x].length)
			return false;
		if (board[x][y] != word.charAt(pos))
			return false;
		char c = board[x][y];
		board[x][y] = '*';
		boolean next = exist(board, word, x + 1, y, pos + 1)
				|| exist(board, word, x, y + 1, pos + 1)
				|| exist(board, word, x - 1, y, pos + 1)
				|| exist(board, word, x, y - 1, pos + 1);
		if (next) {
			return true;
		} else
			board[x][y] = c;
		return false;
	}

	public int countPrimes(int n) {
		boolean[] res = new boolean[n];
		int count = 0;
		for (int i = 2; i < n / 2; i++) {
			if (res[n] == false)
				count++;
			for (int j = 2; i * j < n; j++)
				res[n] = true;
		}
		return count;
	}

}
