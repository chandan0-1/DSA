class Solution {
    public String longestPalindrome(String s) {
        String ans = s.substring(0, 1);
        int n = s.length();
        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++ ) {
            for (int j = i; j < n; j++) {
                boolean isPalindrome = longestPalindromeHelper(i, j, s, cache);
                if (isPalindrome) {
                    int curStringLen =  j - i + 1;
                    if (curStringLen > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    private boolean longestPalindromeHelper(int si, int ei, String s, int[][] cache) {
        if (si >= ei) return true;

        if (s.charAt(si) != s.charAt(ei)) return false;

        if (cache[si][ei] == 0) {
            boolean isPalindrome = longestPalindromeHelper(si + 1, ei - 1, s, cache);
            cache[si][ei] = isPalindrome ? 1 : -1; 
            return isPalindrome;
        }

        return cache[si][ei] == 1 ? true : false;
    }
}
