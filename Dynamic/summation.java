/*
find the sume of the first N numbers

f(i) is the sum of first i elements

f(n) = f(n - 1) + n;

*/

public class summation {
    
    public int sum(int n){
        int [] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < n + 1; i++){
            dp[i] = dp[i - 1] + i;
        }
        return dp[n];
    }

    public static void main (String [] args){
        summation test = new summation();
        System.out.println(test.sum(0));
        System.out.println(test.sum(1));
        System.out.println(test.sum(2));
        System.out.println(test.sum(3));
        System.out.println(test.sum(20));
        System.out.println(test.sum(1000));
    }
}