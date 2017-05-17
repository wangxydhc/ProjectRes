package date0411;

public class Solution {
	public double pow(double x, int n) {

		if (n == 0)
			return 1;
		if (n < 0) {
			if (n == Integer.MIN_VALUE)
				return (pow(x, n + 1) / x);
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
	}


    /**    
     * 7. Reverse Integer
     */
    public int reverse(int x) {                 //不用特意处理负数       
        int test=0,i=0,res=0;
    	while(x!=0){
        	i=x%10;
        	x=x/10;
        	test=res*10+i;
        	if ((test-i)/10!=res)                //判断是否越界
        		return 0;
        	res=test;
        }
    	return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.pow(2, Integer.MIN_VALUE));
	}
}
