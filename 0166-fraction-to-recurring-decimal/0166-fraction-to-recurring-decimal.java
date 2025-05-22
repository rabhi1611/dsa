class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        appendSign(numerator, denominator, ans);
        appendDigit(numerator, denominator, ans);

        return ans.toString();
    }

    private void appendSign(int numerator, int denominator, StringBuilder ans){
        if((numerator > 0 &&  denominator > 0) || (numerator < 0 &&  denominator < 0)){
            return;
        }

        ans.append("-");
    }

    private void appendDigit(int numerator, int denominator, StringBuilder ans){

        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);

        ans.append(a / b);

        if(a % b == 0){
            return;
        }

        a = a % b;

        appendDecimal(a, b, ans);
    }

    private void appendDecimal(long a, long b, StringBuilder ans){
        Map<Long, Integer> mp = new HashMap<>();
        ans.append(".");

        while(a != 0){
            a = a * 10;
            ans.append(a / b);
            a = a % b;

            if(mp.containsKey(a)){
                ans.insert(mp.get(a), "(");
                ans.append(")");
                return;
            } else {
                mp.put(a, ans.length());
            }
        }
    }
}