class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            cnt += decide(i, i, s);
            cnt += decide(i, i + 1, s);
        }

        return cnt;
    }

    private int decide(int l, int r, String s){
        int cnt = 0;
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            cnt += 1;
            l -= 1;
            r += 1;
        }

        return cnt;
    }
}