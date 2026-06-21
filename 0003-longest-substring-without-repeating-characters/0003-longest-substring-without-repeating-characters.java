class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        Map<Character, Integer> mp = new HashMap<>();

        int l = 0, r = 0, ans = 0;

        while(r < n){
            // expand
            char chr = s.charAt(r);
            mp.put(chr, mp.getOrDefault(chr, 0) + 1);

            // shrink 
            while(mp.containsKey(chr) && mp.get(chr) > 1){
                char chl = s.charAt(l);
                mp.put(chl, mp.get(chl) - 1);
                if(mp.get(chl) == 0){
                    mp.remove(chl);
                }
                l += 1;
            }

            ans = Math.max(ans, r - l + 1);

            r += 1;
        }

        return ans;
    }
}