import java.io.*;
import java.util.*;

public class Main{

public static int helper(int n, int[] dp){
    if (n == 0 || n == 1){
        return n;
    }
    
    if (dp[n] != 0){
        return dp[n];
    }
    
    int fib = helper(n-1,dp) + helper(n-2,dp);
    dp[n] = fib;
    return fib;
}

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int dp[] = new int[n+1];
    int ans = helper(n,dp);
    System.out.println(ans);
 }

}
