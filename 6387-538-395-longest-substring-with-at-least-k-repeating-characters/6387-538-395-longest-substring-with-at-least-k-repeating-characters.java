class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 97] += 1;
        }

        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 97] < k){
                int lp = longestSubstring(s.substring(0, i), k);
                int rp = longestSubstring(s.substring(i + 1), k);
                return Math.max(lp, rp);
            }
        }

        return s.length();
    }
}