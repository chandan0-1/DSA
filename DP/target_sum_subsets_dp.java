import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        
        boolean[][] dp = new boolean[n+1][tar+1];
        
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < tar+1; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }
                else{
                    dp[i][j] = dp[i-1][j]; 
                    int val = arr[i-1];
                    if (j >= val){
                        dp[i][j] = dp[i-1][j-val] || dp[i][j];
                    }                   
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}
