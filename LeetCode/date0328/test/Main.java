package test;

import java.util.Scanner;

public class Main {
	public static boolean isFlower(int n) {
		if (n < 100 || n > 999)
			return false;
		int temp = n;
		int m = 0;
		while (temp != 0) {
			m += Math.pow(temp % 10,3);
			temp /= 10;
		}
		if (m == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int m = input.nextInt();
			int n = input.nextInt();
			boolean no=true;
			for (int i = m; i <= n; i++) {
				if (isFlower(i)){
					no=false;
					System.out.print(i);
					System.out.print(" ");
				}				
			}
			if(no)
			System.out.println("no");
			else
				System.out.println();
		}
		input.close();
	}
}
