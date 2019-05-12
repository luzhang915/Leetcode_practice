class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length==0) return new int[0];
        int r = 0, c = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] sol = new int[m*n];
        for (int i=0; i<sol.length; i++){
            System.out.println(r + " " + c + " " + i);
            sol[i] = matrix[r][c];
            if ((r+c)%2==0){
                if (c==n-1){
                    r++;
                }
                else if (r==0){
                    c++;
                }
                else{
                    r--;
                    c++;
                }
            }
            else{
                if (r==m-1){
                    c++;
                }
                else if (c==0){
                    r++;
                }
                else {
                    c--;
                    r++;
                }
            }
        }
        return sol;
    }
}
