class Solution {
    public int numTrees(int n) {
        // create a table with n+1 entries corresponding to the input number
        int[] numtrees = new int[n+1];
        // initialize the table: when input is 0 and 1 there is 1 unique tree
        numtrees[0] = numtrees[1] = 1;
        for (int i=2; i<=n; i++){
            for (int j=1; j<=i; j++){
            // when j is selected as root
            // left tree has numtrees[j-1] kinds of arrangement
            // right tree has i-j unique numbers, thus numtrees[i-j] ways
                numtrees[i] += numtrees[j-1] * numtrees[i-j];
            }
        }
        return numtrees[n];
    }
}
