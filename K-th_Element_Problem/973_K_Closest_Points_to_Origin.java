class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (K>=points.length) return points;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer,List<Integer>> p2d = new HashMap<Integer,List<Integer>>();
        
        for (int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dis = x * x + y * y;
            pq.add(dis);
            if (p2d.containsKey(dis))
                p2d.get(dis).add(i);
            else{
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                p2d.put(dis, tmp);
            }
        }
        int[][] sol = new int[K][2];
        for (int i=0, n=0; i<K && n<K; i++){
            int top = pq.peek();
            pq.poll();
            List<Integer> l = p2d.get(top);
            for (int e:l){
                sol[n] = points[e];
                n++;
            }
        }
        return sol;
    }
}
