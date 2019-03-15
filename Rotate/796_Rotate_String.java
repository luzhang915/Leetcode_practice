class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length()!=B.length()) return false;
        // if both are empty strings return true
        if (A.length()==0 && B.length()==0) return true;
        String s = A + A;
        boolean flag = true;
        for (int j=0; j<A.length(); j++){
            for (int i=0; i<B.length(); i++){
                if (s.charAt(j+i)!=B.charAt(i)){
                    flag = false;
                    break;
                }
                // if char match, flag is true
                flag = true;
            }
            // if all chars match in one round, then return true
            if (flag) return flag;
        }
        
        return flag;
    }
}
