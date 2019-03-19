class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        // put all indices available in indices array
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i=0; i<deck.length; i++){
            indices.add(i);
        }
        int[] sol = new int[deck.length];
        int s = 0;
        while (!indices.isEmpty()){
            // pop first index, put next int in deck into the position
            int i = indices.get(0);
            sol[i] = deck[s];
            s++;
            indices.remove(0);
            // if there is position available in sol, put it into the end of the queue
            if (!indices.isEmpty()){
                int temp = indices.get(0);
                indices.remove(0);
                indices.add(temp);
            }
        }
        return sol;
    }
}
