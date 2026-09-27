class Solution {
    Integer start = 0;
    public String reverseParentheses(String s) {
        int n = s.length();
        return helper(n - 1, s).toString();
    }

    private StringBuilder helper(int end, String s){
        StringBuilder finalAns = new StringBuilder();

        while(start <= end){
        // found bracket
            if(s.charAt(start) == '('){
                start += 1;
                StringBuilder subAns = helper(end, s);
                finalAns.append(subAns);
            }else if(s.charAt(start) == ')'){
                return finalAns.reverse();
            } else{
                finalAns.append(s.charAt(start));
            }
            start = start + 1;
        }

        return finalAns;
    }
}