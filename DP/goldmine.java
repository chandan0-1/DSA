import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[row][col];
        for (int j = col-1; j >= 0; j--){  // First iterating over col
            for (int i = row-1; i >= 0; i--){ // Iterating overl row
                if (j == col-1){
                    dp[i][j] = arr[i][j];
                }
                else{
                    if (i == 0){
                        dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                        
                    }
                    else if(i == row-1 ){
                        dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                    }
                    else{
                        dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1])); 
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < row; i++){
            ans = Math.max(ans,dp[i][0]);
        }
        System.out.println(ans);
    }
}
