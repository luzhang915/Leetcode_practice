// a dfs solution
class Solution1 {

    public int findTargetSumWays(int[] nums, int S) {
        int numSols = 0; 
        int sum = 0; 
        if (nums.length==0 || nums==null) return 0;
        if (nums.length==1) {
            if (sum + nums[0] == S) numSols++;
            if (sum - nums[0] == S) numSols++;
        }
        else {
            numSols += findTargetSumWays(Arrays.copyOfRange(nums, 1, nums.length), S-(sum+nums[0]));
            numSols += findTargetSumWays(Arrays.copyOfRange(nums, 1, nums.length), S-(sum-nums[0]));
        }
        return numSols;
        
    }   
}


// dp solution faster
class Solution {
        
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (S>sum || S<-sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i=0; i<nums.length; i++) {
            int[] temp = new int[2 * sum + 1];
            for (int j=0; j<2 * sum + 1; j++) {
                if (dp[j]!=0) {
                    temp[j + nums[i]] += dp[j];
                    temp[j - nums[i]] += dp[j];
                }
            }
            dp = temp;
        }
        return dp[sum + S];
    }
    
}
