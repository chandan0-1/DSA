class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int pist = 0;
        int ans = 0;
        for (int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            pist = prices[i] - min;
            ans = Math.max(ans, pist);
        }
        return ans;
    }
}

//------------------------OR---------------------------

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int pist = 0;
        int op = 0;
        for(int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            pist = prices[i] - min;
            if (pist > op){
                op = pist;
            }
        }
        return op;
    }
}
