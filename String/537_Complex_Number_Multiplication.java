class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] strA = a.split("\\+");
        String[] strB = b.split("\\+");
        int intA, intB, comA, comB;
        if (strA[0].charAt(0)!='-'){
            intA = Integer.parseInt(strA[0]);
        }
        else{
            intA = Integer.parseInt(strA[0].substring(1,strA[0].length()));
            intA = -intA;
        }
        if (strB[0].charAt(0)!='-'){
            intB = Integer.parseInt(strB[0]);
        }
        else{
            intB = Integer.parseInt(strB[0].substring(1,strB[0].length()));
            intB = -intB;
        }
        if (strA[1].charAt(0)!='-'){
            comA = Integer.parseInt(strA[1].substring(0, strA[1].length()-1));
        }
        else{
            comA = Integer.parseInt(strA[1].substring(1,strA[1].length()-1));
            comA = -comA;
        }
        if (strB[1].charAt(0)!='-'){
            comB = Integer.parseInt(strB[1].substring(0,strB[1].length()-1));
        }
        else{
            comB = Integer.parseInt(strB[1].substring(1,strB[1].length()-1));
            comB = -comB;
        }
        int intSol = intA * intB + (-1) * comA * comB;
        int comSol = intA * comB + intB * comA;
        String sol = String.valueOf(intSol) + "+" + String.valueOf(comSol) + "i";
        return sol;
    }
    
    public String complexNumberMultiply2(String a, String b) {
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(), 
            coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
    }

}
