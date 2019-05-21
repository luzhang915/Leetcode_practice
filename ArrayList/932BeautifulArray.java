/**
 *For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j]
*/
class Solution {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> ba = new ArrayList<>();
        ba.add(1);
        while (ba.size()<N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : ba) 
                if (2 * i - 1 <= N) 
                    tmp.add(2 * i - 1);
            for (int j : ba) 
                if (2 * j <= N) 
                    tmp.add(2 * j);
            ba = tmp;
        }
        int[] sol = new int[ba.size()];
        for (int i=0; i<N; i++) sol[i] = ba.get(i);
        return sol;
    }
}
