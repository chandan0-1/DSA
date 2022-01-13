class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int prev = -1;
        int cur = -1;
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n + m) / 2;
        while (i < n && j < m && i+j <= mid){
            prev = cur;
            if (nums1[i] < nums2[j]){
                cur = nums1[i];
                i++;
            }
            else{
                cur = nums2[j];
                j++;
            }
        }
        while (i < n && i+j <= mid){
            prev = cur;
            cur = nums1[i];
            i++;
        }
        
        while (j < m && i+j <= mid){
            prev = cur;
            cur = nums2[j];
            j++;
        }
        
        if ((n+m) % 2 == 0){
            return (float)(prev+cur)/2;
        }       
        return cur;
        
    }
}
