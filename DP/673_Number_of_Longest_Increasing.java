class Solution {
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        int maxLength = 0;
        int mcount = 0;
        int[] len = new int[l];
        int[] count = new int[l];
        for (int i=0; i<l; i++){
            count[i] = len[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j]){
                    if (len[i]==len[j]+1) 
                        count[i] = count[j] + count[i];
                    if (len[i]<len[j]+1){
                        len[i] = len[j] + 1;
                        count[i] = count[j]; 
                    }
                }
            }
            if (maxLength==len[i])
                mcount += count[i];
            else if (maxLength<len[i]){
                maxLength = len[i];
                mcount = count[i];
            }
        }
        return mcount;
    }
}
