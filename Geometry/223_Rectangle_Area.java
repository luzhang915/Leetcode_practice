class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // compute areas of two rectangles
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
        // compute overlap
        int overlap = 0;
        // overlap? l2<r1 and r2>l1 and b2<t1 and t2>b1 (836. Rectangle Overlap)
        if (E<C && G>A && F<D && H>B){
        // find bounds of overlap
            int ol = Integer.max(A,E);
            int or = Integer.min(C,G);
            int ot = Integer.min(D,H);
            int ob = Integer.max(B,F);
            overlap = (or-ol)*(ot-ob);
        }
        return a1 + a2 - overlap;
    }
}
