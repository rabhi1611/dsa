class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        int i = n - 1;
        StringBuilder t = new StringBuilder();
        while(i >= 0){
            if(s.charAt(i) == ' '){
                while(i >= 0 && s.charAt(i) == ' '){
                    i--;
                }
                if(i < 0)   break;

                if(t.length() > 0){
                    t.reverse();
                    ans.append(t.toString());
                    ans.append(" ");
                    t.setLength(0);
                }
            }

            t.append(s.charAt(i));
            i--;
        }

        if(t.length() > 0){
            t.reverse();
            ans.append(t.toString());
        }

        return ans.toString();
    }
}