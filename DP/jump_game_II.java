class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[n-1] = 0;
        
        for (int i = n-2; i >= 0; i--){
            int ans = dp[i];
            for(int j = 1; j <= nums[i] && i + j < n; j++){
                ans = Math.min(ans,dp[i+j]);
            }
            dp[i] = ans + 1;
        }
        return dp[0]; 
    }
}
