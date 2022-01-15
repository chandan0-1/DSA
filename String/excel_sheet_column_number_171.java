class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        
        for (int i = 0; i < s.length(); i++){
            int rem = s.charAt(i) - 64;
            
            if (i == s.length() -1){
                num += rem;
                continue;
            }
            num = (num + rem) * 26;
        }
        return num;
    }
}

