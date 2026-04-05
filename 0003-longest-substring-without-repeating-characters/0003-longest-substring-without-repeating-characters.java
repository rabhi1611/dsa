class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;

        int l = 0, r = 0;
        while(r < n){
            char c = s.charAt(r);
            if(mp.containsKey(c)){
                // already there
                // check if in range?
                if(mp.get(c) >= l){
                    l = mp.get(c) + 1;
                }
            }


            ans = Math.max(ans, r - l + 1);
            mp.put(c, r);
            r += 1;
        }
        return ans;
    }
}