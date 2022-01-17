class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        dp[n-1] = true;
        
        for (int i = n-2; i >= 0; i--){
            Boolean b = false;
            for (int j = 1; j <= nums[i] && i+j < n; j++){
                b = dp[i+j] || b;
                if (b == true){
                    break;
                }
            }
            dp[i] = b;
        }
        return dp[0]; 
    }
}


