class Solution {
    List<String> sol = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return sol;
        lc(digits, "");
        return sol;
    }
    private void lc(String digit, String prev){
        System.out.println(digit + " " + prev);

        char[] cList = match(digit.charAt(0));
        System.out.println(Arrays.toString(cList));
        for (char c: cList){
            String newWord = prev + c;
            if (digit.length()==1){
                sol.add(newWord);
                continue;
            }
            lc(digit.substring(1, digit.length()), newWord);
        }
    }
    private char[] match(char digit){
        switch (digit){
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
        }
        return null;
    }
}
