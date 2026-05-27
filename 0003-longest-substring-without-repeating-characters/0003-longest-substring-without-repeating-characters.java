class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length();

        int ans = 0;
        Map<Character, Boolean> mp = new HashMap<>();

        while(r < n){
            while(mp.containsKey(s.charAt(r))){
                mp.remove(s.charAt(l));
                l += 1;
            }

            mp.put(s.charAt(r), true);
            ans = Math.max(ans, r - l + 1);
            r += 1;
        }

        return ans;
    }
}