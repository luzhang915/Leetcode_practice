class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i=1; i<nums.length; i++){
            int sum = nums[i];
            for (int j=i-1; j>=0; j--){
                sum += nums[j];
                // corner case, [0, 0] k=0, otherwise, k!=0
                if ((sum==0 && k==0) || (k!=0 && sum%k==0)) return true;
            }
        }
        return false;
    }
}
