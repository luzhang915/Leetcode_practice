class Solution {
    public int[] constructRectangle(int area) {
        // if (area==0) return new int[0];
        // if (area==1) return new int[]{1, 1};
        // int diff = area-1;
        // int[] sol = new int[]{area, 1};
        // for (int l=area; l>=1; l--){
        //     int w = area / l;
        //     if (w > l) break;
        //     if (w * l != area) continue;
        //     if (l-w<diff) {
        //         diff = l - w;
        //         sol[0] = l;
        //         sol[1] = w;
        //     }
        // }
        // return sol;
        
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
}
