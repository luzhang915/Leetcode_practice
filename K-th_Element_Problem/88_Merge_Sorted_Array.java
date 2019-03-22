// Brute force: insert nums2 into the end of nums1, and sort
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

// keep inserting from the end of nums1 until finishing nums2 
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n>0) nums1[m+n-1] = (m==0||nums2[n-1] > nums1[m-1]) ? nums2[--n] : nums1[--m];
        // m==0: when the smallest in nums2 is smaller than in nums1, avoid index=-1 at the end checking nums1[m-1]
    }
}
