class Solution {
    // search common prefix in string, until index of common prefix is 0 for each item in array
    public String longestCommonPrefix(String[] strs) {
        String common = "";
        if (strs.length==0) return common;
        common = strs[0];
        if (strs.length==1) return common;
        for (int i=0; i<strs.length; i++) {
            String curr = strs[i];
            while (curr.indexOf(common)!=0) {
                common = common.substring(0, common.length()-1);
                if (common.length()==0) return common;
            }
        }
        return common;
    }
}
