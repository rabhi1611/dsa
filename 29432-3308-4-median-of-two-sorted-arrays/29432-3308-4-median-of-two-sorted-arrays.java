class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] t = new int[n + m];

        int i = 0, j = 0, k = 0;

        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                t[k++] = nums1[i++];
            } else {
                t[k++] = nums2[j++];
            }
        }

        while(i < n){
            t[k++] = nums1[i++];
        }

        while(j < m){
            t[k++] = nums2[j++];
        }

        if((n + m) % 2 == 0){
            return ((double)t[(n + m - 1) / 2] + t[(n + m) / 2]) / 2;
        }

        return t[(n + m - 1) / 2];
    }
}