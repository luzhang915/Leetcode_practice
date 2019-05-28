class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        if (candidates==null || candidates.length==0) return sol;
        combSum(candidates, target, sol, new ArrayList<Integer>(), 0);
        return sol;
    }
    
    private void combSum(int[] candidates, int target, List<List<Integer>> sol, List<Integer> temp, int start) {
        if (target < 0) return;
        // declare a new list every time we add solution so that we dont modify the added solution 
        if (target == 0) sol.add(new ArrayList<Integer>(temp)); 
        // to prevent repetition of same combination in different orders so we dont go back every iteration 
        for (int i=start; i<candidates.length; i++) {
        temp.add(candidates[i]);
        combSum(candidates, target-candidates[i], sol, temp, i);
        temp.remove(temp.size()-1);
        }
    }
}
