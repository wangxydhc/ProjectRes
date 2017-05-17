package date0326;

public class Solution {
	public int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		int fac2 = 2, fac3 = 3, fac5 = 5;
		ugly[0] = 1;
		int num2 = 0, num3 = 0, num5 = 0;
		for (int i = 1; i < n; i++) {
			int min = Math.min(fac5, Math.min(fac2, fac3));
			ugly[i] = min;
			if (min == fac2)
				fac2 = 2 * ugly[++num2];
			if (min == fac3)
				fac3 = 3 * ugly[++num3];
			if (min == fac5)
				fac5 = 5 * ugly[++num5];
		}
		return ugly[n - 1];
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int[] index = new int[primes.length];
		int[] fac = new int[primes.length];
		for (int i = 0; i < primes.length; i++) {
			fac[i] = primes[i];
		}
		for (int i = 1; i < n; i++) {
			int min = fac[0];
			for (int k = 1; k < primes.length; k++) {
				min = Math.min(min, fac[k]);
			}
			ugly[i] = min;
			for (int j = 0; j < primes.length; j++) {
				if (min == fac[j])
					fac[j] = primes[j] * ugly[++index[j]];
			}
		}
		return ugly[n - 1];
	}

	public boolean uglyNumber(int m) {
		int n = m;
		while (n % 2 == 0)
			n = n / 2;
		while (n % 3 == 0)
			n = n / 3;
		while (n % 5 == 0)
			n = n / 5;
		if (n == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber(1352));
	}
}
