import java.io.*;
import java.util.*;

public class Main {
    
    public static int helper(int n, int[] dp){
        if (n <= 2){
            return n;
        }
        if (n == 3){
            return 4;
        }
        
        if (dp[n] != 0){
            return dp[n];
        }
        
        int n1 = helper(n-1, dp);
        int n2 = helper(n-2, dp);
        int n3 = helper(n-3, dp);
        int m = n1+n2+n3;
        dp[n] = m;
        return m;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        
        int ans = helper(n,dp);
        System.out.println(ans);
    }

}
