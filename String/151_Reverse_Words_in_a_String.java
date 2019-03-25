class Solution1 {
    public String reverseWords(String s) {
        String sol = "";
        String word = "";
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' '){
                if (word!="") {
                    if (sol!="") sol = word + ' ' + sol;
                    else sol = word;
                }
                System.out.println(word + ":" + sol);
                word = "";
            }
            else{
                word += s.charAt(i);
            }
        }
        if (word!="") {
            if (sol!="") sol = word + ' ' + sol;
            else sol = word;
        }
        return sol;
    }
}

class Solution2 {
    public String reverseWords(String s) {
    // trim leading and following space, and split by 1 or more than 1 spaces 
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
    // join words by space
        return String.join(" ", words);
    }
}
