class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        
        int cache[][] = new int[n][n];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean isPalindrome = countSubstringsRecurMemo(i, j, s, cache);
                if (isPalindrome) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean countSubstringsRecur(int si, int ei, String s) {
        if (si >= ei) return true;

        if (s.charAt(si) != s.charAt(ei)) return false;

        return countSubstringsRecur(si + 1, ei - 1, s);
    }

    private boolean countSubstringsRecurMemo(int si, int ei, String s, int[][] cache) {
        if (si >= ei) return true;

        if (s.charAt(si) != s.charAt(ei)) return false;

        if (cache[si][ei] == -1) {
            boolean ans = countSubstringsRecurMemo(si + 1, ei - 1, s, cache);
            cache[si][ei] = ans ? 1 : 0;
        }
            
        return cache[si][ei] == 1 ? true : false;
    }
}
