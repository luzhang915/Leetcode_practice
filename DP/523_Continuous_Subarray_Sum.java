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
class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> rem2index = new HashMap<Integer, Integer>(){{put(0, -1);}};;
        int runningSum = 0;
        for (int i=0; i<nums.length; i++){
            if (k!=0) runningSum  = (runningSum + nums[i]) % k;
            else runningSum += nums[i];
            if (rem2index.containsKey(runningSum)){
                int li = rem2index.get(runningSum);
                // when sum from li+1 to i is n*k, li and i have the same remain
                if (i-li>1) return true;
            }
            else rem2index.put(runningSum, i);
        }
        return false;
    }
}
