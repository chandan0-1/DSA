class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int m = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 1){
                m = Math.max(m,temp);
                temp = 0;
            }else{
                temp += 1;
            }
        }
        
        m = Math.max(temp,m);
        
        return m;
    }
}
