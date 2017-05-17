package data0324;

public class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int [][]nMatrix=new int [len][len];
        for(int i=0;i<len;i++)
        	for(int j=0;j<len;j++)
        	{
        		nMatrix[i][j]=matrix[i][j];
        	}
        for(int i=0;i<len;i++)
        	for(int j=0;j<len;j++)
        	{
        		System.out.println(i+" "+j);
        		matrix[i][j]=nMatrix[len-1-j][i];
        	}
    }
    public int[] plusOne(int[] digits) {
    	int number=0;
        int len=digits.length;
        for(int i=0;i<len;i++){
        	number+=digits[i];
        	if(i<len-1)
        		number*=10;
        }
        len=0;
       int re=number+1;;
        while(re!=0)
        {
        	len++;
        	re=re/10;
        }
        
        int []res=new int[len];
        re=number+1;
        for(int i=len-1;i>=0;i--){
        	res[i]=re%10;
        	re=re/10;
        }
        
        return res;
    }
    public static void main(String[] args) {
    	int a[]={0};
//    	
//		int[][]c=new int[2][2];
//		c[0][0]=1;
//		c[0][1]=3;
//		c[1][0]=2;
//		c[1][1]=4;
//		for(int i=0;i<2;i++)
//			for(int j=0;j<2;j++){
//				System.out.println(c[j][i]);
//			}
		Solution s=new Solution();
//		s.rotate(c);
//		for(int i=0;i<2;i++)
//			for(int j=0;j<2;j++){
//				System.out.println(c[j][i]);
//			}
	
		System.out.println(s.plusOne(a)[0]);
	}
}
