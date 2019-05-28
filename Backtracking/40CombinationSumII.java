class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        if (candidates==null || candidates.length==0) return sol;
        Arrays.sort(candidates);
        combSum(candidates, target, sol, new ArrayList<Integer>(), 0);
        return sol;
    }
    
    private void combSum(int[] candidates, int target, List<List<Integer>> sol, List<Integer> temp, int start) {
        if (target < 0) return;
        if (target == 0) sol.add(new ArrayList<Integer>(temp));
        for (int i=start; i<candidates.length; i++) {
            if (i>start && candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            combSum(candidates, target-candidates[i], sol, temp, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}
