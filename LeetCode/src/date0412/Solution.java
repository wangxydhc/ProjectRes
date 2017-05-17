package date0412;

public class Solution {
	static int[][] ways = new int[100][100];

	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			ways[m - 1][n - 1] = 1;
		else
			ways[m - 1][n - 1] = ((ways[m - 2][n - 1] == 0) ? uniquePaths(
					m - 1, n) : ways[m - 2][n - 1])
					+ ((ways[m - 1][n - 2] == 0) ? uniquePaths(m, n - 1)
							: ways[m - 1][n - 2]);
		return ways[m - 1][n - 1];
	}

	/**
	 * 9. Palindrome Number
	 */
	public boolean isPalindrome(int x) { 									// 这道题自己想到了解法，但是没有考虑到x%10=0的特殊情况
		if (x != 0 && x % 10 == 0 || x < 0)
			return false;
		if (x / 10 == 0)
			return true;
		int res = 0;
		while (x > 0) {
			res = res * 10 + x % 10;
			if (x == res)
				return true;
			x = x / 10;
			if (x == res)
				return true;
		}
		return false;
	}

	/**
	 * 223. Rectangle Area
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {

		int sum = (C - A) * (D - B) + (G - E) * (H - F);

		int x1 = Math.max(A, E);
		int x2 = Math.max(C, G);
		if (x2 <= x1)
			return sum;

		int y1 = Math.max(B, F);
		int y2 = Math.max(D, H);
		if (y2 <= y1)
			return sum;
		return sum - (x2 - x1) * (y2 - y1);
	}

	/**
	 * 507. Perfect Number
	 */
	public boolean checkPerfectNumber(int num) {
		if (num == 1)
			return false; 									// num==1是特殊情况
		int sum = 1, i;
		for (i = 2; i < num; i++) { 						// 这里可以直接 约束条件 i<=Math.sqrt(num)
			if (num / i < i) 								// 和sqrt效果是一样的
				break;
			if (num % i == 0)
				sum = sum + i + num / i;
		}
		if (sum == num)
			return true;
		else
			return false;
	}

	/**
	 * 400. Nth Digit
	 */
	public int findNthDigit(int n) {
		int bit = 1, start = 1;
		long count = 9;
		while (n > count * bit) {
			n -= count * bit;
			bit++;
			count *= 10;
			start *= 10;
		}
		int res = (n - 1) / bit + start;         //把n变成n-1进行处理
		int t = (n - 1) % bit;
		String s = Integer.toString(res);
		return Character.getNumericValue(s.charAt(t));
	}

	/**
	 * 415. Add Strings
	 */
	public String addStrings(String num1, String num2) {        //用stringbuffer有可能更好一些，但不知道reverse的复杂度、
		int len = Math.max(num1.length(), num2.length());
		char[] res = new char[len + 1];
		int x = 0, k = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; len >= 0; i--, j--, len--) {
			k = (i < 0 ? 0 : num1.charAt(i) - '0')
					+ (j < 0 ? 0 : num2.charAt(j) - '0') + x;
			x=k/10;
			k=k%10;
			res[len] = (char) (k + '0');
		}
		if (res[0] == '1')
			return String.valueOf(res);
		else
			return String.valueOf(res).substring(1);
	}
    public String addStrings_0(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            System.out.println(sb.toString());
            carry = (x + y + carry) / 10;
        }
        
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		s.addStrings_0("44", "55");
	}
}
