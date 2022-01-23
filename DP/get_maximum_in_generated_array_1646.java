class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int ans = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < n+1; i++){
            if (i % 2 == 0){
                dp[i] = dp[i/2];
            }
            else{
                int j = i/2;
                dp[i] = dp[j+1] + dp[j];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
