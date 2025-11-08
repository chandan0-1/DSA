class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if( i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else{
                    if (i == 0){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j == 0){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }


public int uniquePaths2(int m, int n) {
        // return uniqPathsRecur(m - 1, n - 1);
        int[][] cache = new int[m][n];

        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return uniqPathsMemo(m - 1, n - 1, cache);
    }

    private int uniqPathsMemo(int m, int n, int[][] cache) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 || n == 0) {
            return 1;
        }

        // Bring value from previous back index
        int backStep;
        if (cache[m - 1][n] != -1) {
            backStep = cache[m - 1][n];
        } else {
            backStep = uniqPathsMemo(m - 1, n, cache);
        }

        // Bring value from above path
        int upStep;
        if (cache[m][n - 1] != -1) {
            upStep = cache[m][n - 1];
        } else {
            upStep = uniqPathsMemo(m, n - 1, cache);
        }

        int ans = backStep + upStep;
        cache[m][n] = ans;
        return ans;
    } 

    int uniqPathsRecur(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }

        int backStep = uniqPathsRecur(m - 1, n);
        int upStep = uniqPathsRecur(m, n - 1);

        return backStep + upStep;
    }
}


// 0 1 1
// 1 2 3
// 1 3 6
